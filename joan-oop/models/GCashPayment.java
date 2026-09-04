package models;

public class GCashPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Payment successful via GCash: ₱" + amount);
    }
}
