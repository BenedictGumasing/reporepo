package models;

public class Book extends Product {

    private String author;

    public Book(int productID, String productName, String author, double price, int stock) {
        super(productID, productName, price, stock);
        this.author = author;
    }

    @Override
    public void displayProduct() {
        System.out.println("\nBOOK");
        super.displayProduct();
        System.out.println("Author: " + author);
    }
}
