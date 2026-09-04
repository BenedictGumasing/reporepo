package models;

public class CashPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Payment successful via Cash: ₱" + amount);
    }
}
