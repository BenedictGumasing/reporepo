package tui;

import models.*;
import java.util.Scanner;

public class TUI {

    Scanner scanner = new Scanner(System.in);

    Customer customer = new Customer("emma", "books123");
    Cart cart = new Cart();
    BookstoreService bookstoreService = new BookstoreService(cart, new PaymentProcessor());
    ItemInfoPrinter itemInfoPrinter = new ItemInfoPrinter();

    Product[] products = {
        new Book(101,"The Secret Garden","Frances Hodgson Burnett",550.00,5),
        new PrintedBook(102,"Cooking Around The World",250,1250.00,3),
        new Magazine(103,"Travel Explorer","Adventure",450.00,10)
    };

    public void start() {

        while(true) {

            System.out.println("\n===== ONLINE BOOKSTORE =====");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();

            if(choice == 1) {
                login();
            }
            else if(choice == 2) {
                System.out.println("Thank you for visiting.");
                break;
            }
            else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private void login() {

        System.out.print("Username: ");
        String username = scanner.next();

        System.out.print("Password: ");
        String password = scanner.next();

        if(customer.login(username,password)) {
            bookstoreMenu();
        }
    }

    private void bookstoreMenu() {

        while(customer.isLoggedIn()) {

            System.out.println("\n===== BOOKSTORE MENU =====");
            System.out.println("1. View Products");
            System.out.println("2. Add Product To Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Remove Product From Cart");
            System.out.println("5. View Item Details");
            System.out.println("6. Checkout");
            System.out.println("7. Logout");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();

            switch(choice) {

                case 1:
                    viewProducts();
                    break;

                case 2:
                    addProduct();
                    break;

                case 3:
                    cart.viewCart();
                    break;

                case 4:
                    removeProduct();
                    break;

                case 5:
                    viewItemDetails();
                    break;

                case 6:
                    checkout();
                    break;

                case 7:
                    customer.logout();
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void viewProducts() {

        System.out.println("\n===== PRODUCTS =====");

        for(Product product : products) {

            product.displayProduct();
            System.out.println("----------------");

        }
    }

    private void addProduct() {

        viewProducts();

        System.out.print("Enter Product ID: ");
        int productID = scanner.nextInt();

        for(Product product : products) {

            if(product.productID == productID) {

                cart.addProduct(product);
                return;

            }
        }

        System.out.println("Product not found.");
    }

    private void removeProduct() {

        cart.viewCart();

        System.out.print("Enter cart number to remove: ");
        int cartNumber = scanner.nextInt();

        cart.removeProduct(cartNumber - 1);
    }

    private void viewItemDetails() {

        System.out.println("\n===== SELECT ITEM =====");
        
        for(int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i].getProductName());
        }
        
        System.out.print("Enter item number: ");
        int itemNumber = scanner.nextInt();
        
        if(itemNumber > 0 && itemNumber <= products.length) {
            itemInfoPrinter.printItemInfo(products[itemNumber - 1]);
        } else {
            System.out.println("Invalid item number.");
        }
    }

    private void checkout() {

        System.out.println("Payment Method:");
        System.out.println("1. Cash");
        System.out.println("2. Credit Card");
        System.out.println("3. GCash");

        System.out.print("Choose payment: ");

        int paymentChoice = scanner.nextInt();

        PaymentMethod paymentMethod;

        switch(paymentChoice) {

            case 1:
                paymentMethod = new CashPayment();
                break;

            case 2:
                paymentMethod = new CreditCardPayment();
                break;

            case 3:
                paymentMethod = new GCashPayment();
                break;

            default:
                System.out.println("Invalid payment method.");
                return;
        }

        bookstoreService.checkout(paymentMethod);
    }
}
