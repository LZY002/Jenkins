package component;




import entities.Order;
import entities.Pack;


import javax.ejb.Local;
import javax.ejb.Stateless;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;





@Stateless
@Local
public class ManagePlanningComponent implements OrderToday, PackageModification, OrderCreation {

    List<Order> ordersToday;
    List<Pack> packagesToday;
    List<Pack> packagesHistoryToay;

    public List<Pack> getPackagesToday() {
        return packagesToday;
    }

    public ManagePlanningComponent(){
        ordersToday = new ArrayList<Order>();
        packagesToday = new ArrayList<Pack>();
        Pack pack = new Pack("Nice",20,null,1,2,1);
        packagesToday.add(pack);
        List<Pack> packs = new ArrayList<Pack>();
        packs.add(pack);
        Order order = new Order(packs,1);
        ordersToday.add(order);
        packagesHistoryToay = new ArrayList<Pack>();
    }
    @Override
    public List<Order> getTodayOrder() {
        System.out.print("ManagePlanning give the today's orders to MakeThefacture\n");
        return ordersToday;
    }

    @Override
    public boolean changeTheDateOfThePackage(int id , Calendar timechanged) {

        for(Pack packages: packagesToday){
            if(packages.getId() == id){
                packages.setDeliveryDate(timechanged);
                return true;
            }
        }
        return  false;
    }

    @Override
    public void creatOrder(List<Pack> packageList, int provideId) {
        Order order = new Order(packageList,provideId);
        ordersToday.add(order);
        packagesToday.addAll(order.getPackList());

    }


}
