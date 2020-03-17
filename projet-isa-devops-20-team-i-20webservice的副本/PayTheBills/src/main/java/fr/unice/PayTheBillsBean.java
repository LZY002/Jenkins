package fr.unice;

import entities.Facture;

import entities.FactureState;

import javax.ejb.Local;


@Local
public class PayTheBillsBean implements Payment {

    private BankAPI bank;

    @Override
    public  PaymentObject payOrder(Facture facture) throws ExternalPartnerException {
        double price = facture.getPrice();
        int id = facture.getIdProvider();
        PaymentObject payment = new PaymentObject(id,price);
        boolean status = bank.performPayment(payment);
        if (!status) {

        }
        facture.setFactureState(FactureState.PAYED);
        System.out.print("Payment successfully\n");
        return payment;
    }


}

