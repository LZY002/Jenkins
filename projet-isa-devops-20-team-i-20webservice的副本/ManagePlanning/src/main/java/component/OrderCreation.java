package component;


import entities.Pack;

import javax.ejb.Local;
import java.util.List;

@Local

public interface OrderCreation {

    void creatOrder(List<Pack> packageList, int providerId);
}
