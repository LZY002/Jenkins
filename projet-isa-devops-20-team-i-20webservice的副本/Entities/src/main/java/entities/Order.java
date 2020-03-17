package entities;

import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.List;

@Stateless
public class Order implements Serializable {

    static int totalid = 0;
    int id;
    List<Pack> packList;
    int providerId;
    public Order(){

    }
    public Order(List<Pack> packList, int providerId ){
        this.packList = packList;
        this.providerId = providerId;
        id = totalid;
        totalid++;
    }

    public static void setTotalid(int totalid) {
        Order.totalid = totalid;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public static int getTotalid() {
        return totalid;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<Pack> getPackList() {
        return packList;
    }

    public void setPackList(List<Pack> packList) {
        this.packList = packList;
    }
    public double getThePrice(){
       double total = 0;
        for(Pack pack: packList){
            total+= pack.getPrice();
        }
        return total;
    }
}
