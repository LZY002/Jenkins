package entities;



import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.Calendar;


@Stateless
public class Pack implements Serializable {

    String address;
    double timeOfFlight = 22.5;
    Calendar deliveryDate;
    Calendar effectiveDeliveryDate;
    int clientId;
    int droneId;
    int id;
    double price;
    public Pack(){

    }

    public Pack(String address, double timeOfFlight, Calendar deliveryDate, int clientId , double price,int id){
        this.address = address;
        this.deliveryDate = deliveryDate;
        this.deliveryDate = deliveryDate;
        this.clientId = clientId;
        this.timeOfFlight = timeOfFlight;
        this.price = price;
        this.id = id;

    }
    public String getAddress() {
        return address;
    }

    public double getTimeOfFlight() {
        return timeOfFlight;
    }

    public void setDeliveryDate(Calendar deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setEffectiveDeliveryDate(Calendar effectiveDeliveryDate) {
        this.effectiveDeliveryDate = effectiveDeliveryDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Calendar getDeliveryDate() {
        return deliveryDate;
    }

    public Calendar getEffectiveDeliveryDate() {
        return effectiveDeliveryDate;
    }

    public int getClientId() {
        return clientId;
    }

    public int getDroneId() {
        return droneId;
    }

    public int getId() {
        return id;
    }
}
