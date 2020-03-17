package fr.unice;


import entities.Facture;


import javax.ejb.Local;

@Local
public interface Payment {

    PaymentObject payOrder(Facture facture) throws ExternalPartnerException;

}
