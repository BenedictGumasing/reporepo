package models;

public class PrintedBook extends Product {

    private int pages;

    public PrintedBook(int productID, String productName, int pages, double price, int stock) {
        super(productID, productName, price, stock);
        this.pages = pages;
    }

    @Override
    public void displayProduct() {
        System.out.println("\nPRINTED BOOK");
        super.displayProduct();
        System.out.println("Pages: " + pages);
    }
}
