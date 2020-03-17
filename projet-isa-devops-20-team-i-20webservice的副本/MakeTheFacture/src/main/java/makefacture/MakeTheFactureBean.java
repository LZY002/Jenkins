package makefacture;


import component.OrderToday;
import entities.Facture;
import entities.Order;


import javax.ejb.EJB;
import javax.ejb.Local;
import java.util.*;

@Local

public class MakeTheFactureBean implements TodayFacture {

    private List<Order> todayOrders;
    @EJB
    private OrderToday managePlanningComponent;

    public MakeTheFactureBean(){
        todayOrders = new ArrayList<Order>();

    }

    public void getTheTodayOrders(){
        todayOrders.clear();
        todayOrders.addAll(managePlanningComponent.getTodayOrder());
        System.out.print("MakeTheFacture gets the today's orders\n");
    }

    @Override
    public List<Facture> getTheTodayFacture() {
        System.out.print("MakeTheFacture gives today's factures to ManageOrder\n");
        List<Facture> factureList = new ArrayList<Facture>();
        Map<Integer,List<Order>> orderMap = new HashMap<Integer, List<Order>>();
        for(Order order: todayOrders){
            if(orderMap.containsKey(order.getProviderId())){
                orderMap.get(order.getProviderId()).add(order);
            }
            else {
                orderMap.put(order.getProviderId(),new ArrayList<Order>());
                orderMap.get(order.getProviderId()).add(order);
            }

        }
        for(int provideId: orderMap.keySet()){
            Facture facture = new Facture();
            facture.setIdProvider(provideId);
            facture.setOrdersList(orderMap.get(provideId));
            facture.setTimeBeforeExpiration(Calendar.getInstance());
            factureList.add(facture);
        }
        return factureList; 
    }

}
