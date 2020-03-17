package fr.unice;

public class PaymentException extends Throwable {

    private double amount;

    public PaymentException( double amount) {
        this.amount = amount;
    }

    public PaymentException(double amount, Exception source) {
        super(source);
        this.amount = amount;
    }

    public PaymentException(double price, ExternalPartnerException e) {}

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
