package models;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Payment successful via Credit Card: ₱" + amount);
    }
}
