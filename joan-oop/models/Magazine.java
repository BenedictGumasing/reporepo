package models;

public class Magazine extends Product {

    private String category;

    public Magazine(int productID, String productName, String category, double price, int stock) {
        super(productID, productName, price, stock);
        this.category = category;
    }

    @Override
    public void displayProduct() {
        System.out.println("\nMAGAZINE");
        super.displayProduct();
        System.out.println("Category: " + category);
    }
}
