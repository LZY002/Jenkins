package fr.unice;

public class PaymentObject {

    int id;
    double price;

    public PaymentObject(int id, double price){
        this.id = id ;
        this.price =price;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
