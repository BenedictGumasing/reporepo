package models;

public class Payment {

    public void pay(double amount, String method) {

        System.out.println("\n===== PAYMENT =====");
        System.out.println("Amount: $" + amount);
        System.out.println("Payment Method: " + method);
        System.out.println("Payment successful.");

    }
}
