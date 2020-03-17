

import component.ManagePlanningComponent;
import component.OrderToday;
import entities.Facture;
import fr.unice.ExternalPartnerException;
import fr.unice.Payment;
import makefacture.MakeTheFactureBean;
import makefacture.TodayFacture;

import javax.ejb.EJB;
import javax.ejb.Local;
import java.util.ArrayList;
import java.util.List;

@Local
public class ManageOrderBean {
    @EJB
           private TodayFacture makeTheFacture;
    @EJB
            private Payment payment;
    List<Facture> factures;



    ManageOrderBean(){

        factures = new ArrayList<Facture>();
    }
    public List<Facture> getFactures() {
        return factures;
    }
    public void getTheTodayFacture(){
        System.out.print("ManageOrder get the today's factures\n");
        factures.addAll(makeTheFacture.getTheTodayFacture());

    }

    public void payThefacture(Facture facture) throws ExternalPartnerException {
        System.out.print("Pay the facture, the price is +"+facture.getPrice()+"\n");
        payment.payOrder(facture);
    }


    public static void main(String[] args) throws ExternalPartnerException {

        MakeTheFactureBean makeTheFactureBean = new MakeTheFactureBean();
        ManageOrderBean manageOrderBean = new ManageOrderBean();
        makeTheFactureBean.getTheTodayOrders();
        manageOrderBean.getTheTodayFacture();
        manageOrderBean.payThefacture(manageOrderBean.getFactures().get(0));
    }



}
