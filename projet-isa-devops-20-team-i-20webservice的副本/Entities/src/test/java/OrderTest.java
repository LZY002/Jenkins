import entities.Order;
import entities.Pack;
import gherkin.lexer.Pa;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

public class OrderTest {

    Order order;
    List<Pack> packs;
    @Before
    public void init(){
        packs= new ArrayList<Pack>();
        packs.add(new Pack("Nice",22.5,null,1,2,1));
        packs.add(new Pack("Nice",22.5,null,1,2,2));
        packs.add(new Pack("Nice",22.5,null,1,2,3));
        order = new Order(packs,1);
    }

    @Test
    public void testTotalid(){
        List<Pack> packs2 = new ArrayList<Pack>();
        packs2.addAll(packs);
        packs2.add(new Pack("Antibes",10,null,2,3,4));
        Order order2 = new Order(packs2,10);
        Assert.assertTrue(order2.getId()>order.getId());
        Assert.assertTrue(order2.getId()>0);
    }

    @Test
    public void getThePriceTest(){

        Assert.assertEquals(6,order.getThePrice(),0.1);
    }

}
