package integrationTest;

import component.ManagePlanningComponent;
import entities.Order;
import entities.Pack;
import org.apache.openejb.api.EjbDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import webservice.ClientWebService;

import javax.ejb.EJB;
import javax.validation.constraints.AssertTrue;


@RunWith(Arquillian.class)
@Transactional(TransactionMode.COMMIT)

public class ChangeTheTimeIntegrationTest {


    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class).addClass(ManagePlanningComponent.class).addClass(ClientWebService.class).addClass(Pack.class).addClass(Order.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    ManagePlanningComponent managePlanningComponent;
    @EJB
    ClientWebService clientWebService;

    @Test
    public void changeTheTimeSuccessfully(){

        Assert.assertTrue(clientWebService.changeTheTimeOfThePackage(1,"2016-11-11 11:12:12"));

    }
}
