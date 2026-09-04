package models;

public class BookstoreService {
    
    private Cart cart;
    private PaymentProcessor paymentProcessor;
    
    public BookstoreService(Cart cart, PaymentProcessor paymentProcessor) {
        this.cart = cart;
        this.paymentProcessor = paymentProcessor;
    }
    
    public void checkout(PaymentMethod paymentMethod) {
        if(cart.empty()) {
            System.out.println("Cart is empty.");
            return;
        }
        
        double totalAmount = cart.getTotal();
        System.out.println("Total Amount: ₱" + totalAmount);
        
        paymentProcessor.processPayment(totalAmount, paymentMethod);
        cart.clear();
    }
}
