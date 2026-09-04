package models;

public class PaymentProcessor {
    
    public void processPayment(double amount, PaymentMethod paymentMethod) {
        System.out.println("\n===== PAYMENT =====");
        System.out.println("Amount: ₱" + amount);
        paymentMethod.pay(amount);
    }
}
