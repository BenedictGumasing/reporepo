package models;

public class ItemInfoPrinter {
    
    public void printItemInfo(Product product) {
        System.out.println("\n===== ITEM INFORMATION =====");
        product.displayProduct();
        System.out.println("=============================\n");
    }
}
