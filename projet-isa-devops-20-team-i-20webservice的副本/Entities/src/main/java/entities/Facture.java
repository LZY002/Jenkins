package entities;



import javax.ejb.Stateless;
import java.util.Calendar;
import java.util.List;

@Stateless
public class Facture {

    int idProvider;
    double price;
    Calendar TimeBeforeExpiration;
    List<Order> ordersList;

    public void setFactureState(FactureState factureState) {
        this.factureState = factureState;
    }

    FactureState factureState = FactureState.WAITING_FOR_PAYEMENT;
    public void setIdProvider(int idProvider) {
        this.idProvider = idProvider;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTimeBeforeExpiration(Calendar timeBeforeExpiration) {
        TimeBeforeExpiration = timeBeforeExpiration;
    }

    public void setOrdersList(List<Order> ordersList) {
        this.ordersList = ordersList;
    }




    public int getIdProvider() {
        return idProvider;
    }

    public Calendar getTimeBeforeExpiration() {
        return TimeBeforeExpiration;
    }

    public List<Order> getOrdersList() {
        return ordersList;
    }



    public double getPrice() {

        for(Order order: ordersList){
            price+=order.getThePrice();
        }
        return price;
    }
}
