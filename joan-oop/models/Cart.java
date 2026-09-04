package models;

import java.util.ArrayList;

public class Cart {

    private ArrayList<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {

        if(product.getStock() > 0) {

            products.add(product);
            product.reduceStock();

            System.out.println(product.getProductName() + " added to cart.");

        } else {
            System.out.println("Product is out of stock.");
        }
    }

    public void removeProduct(int index) {

        if(index >= 0 && index < products.size()) {

            Product product = products.get(index);

            product.increaseStock();
            products.remove(index);

            System.out.println("Product removed.");

        } else {
            System.out.println("Invalid product.");
        }
    }

    public void viewCart() {

        System.out.println("\n===== CART =====");

        for(int i = 0; i < products.size(); i++) {

            System.out.println((i + 1) + ". " 
            + products.get(i).getProductName()
            + " ₱" + products.get(i).getPrice());

        }

        System.out.println("Total: ₱" + getTotal());
    }

    public double getTotal() {

        double total = 0;

        for(Product product : products) {
            total += product.getPrice();
        }

        return total;
    }

    public boolean empty() {
        return products.isEmpty();
    }

    public void clear() {
        products.clear();
    }
}
