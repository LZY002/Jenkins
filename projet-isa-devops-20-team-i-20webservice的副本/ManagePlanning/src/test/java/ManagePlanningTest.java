import component.ManagePlanningComponent;
import entities.Pack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ManagePlanningTest {

    ManagePlanningComponent managePlanningComponent;
    @Before
    public void init(){
        managePlanningComponent = new ManagePlanningComponent();
    }

    @Test
    public void changTheDateOfPackageSuccessfullyTest() throws ParseException {
        Pack pack1 = new Pack("Nice",22.5,null,1,2,2);
        managePlanningComponent.getPackagesToday().add(pack1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d H:m:s");
        Date date = dateFormat.parse("2016-6-1 13:24:16");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        managePlanningComponent.changeTheDateOfThePackage(pack1.getId(),c);
        Assert.assertEquals(0,c.compareTo(pack1.getDeliveryDate()));
    }

    @Test
    public void changTheDateOfPackageUnsuccessfullyTest() throws ParseException {
        Pack pack1 = new Pack("Nice",22.5,null,1,2,2);
        managePlanningComponent.getPackagesToday().add(pack1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d H:m:s");
        Date date = dateFormat.parse("2016-6-1 13:24:16");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        Assert.assertFalse(managePlanningComponent.changeTheDateOfThePackage(pack1.getId()+1,c));
    }
    @Test
    public void creatOrderTest(){
        Pack pack1 = new Pack("Nice",22.5,null,1,2,2);
        List<Pack> packs = new ArrayList<Pack>();
        packs.add(pack1);
        managePlanningComponent.creatOrder(packs,1);
        Assert.assertEquals(pack1,managePlanningComponent.getPackagesToday().get(1));
    }



}
