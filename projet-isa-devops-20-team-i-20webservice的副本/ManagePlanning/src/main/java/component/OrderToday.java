package component;


import entities.Order;

import javax.ejb.Local;
import java.util.List;

@Local

public interface OrderToday {

    List<Order> getTodayOrder();
}
