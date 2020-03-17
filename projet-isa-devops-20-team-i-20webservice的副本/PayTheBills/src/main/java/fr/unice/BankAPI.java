package fr.unice;


import org.apache.cxf.jaxrs.client.WebClient;
import org.json.JSONObject;



import javax.ws.rs.core.MediaType;

public class BankAPI{

    private String url;

    public BankAPI(String host, String port) { this.url = "http://" + host + ":" + port; }

    public BankAPI() { this("localhost", "9090"); }

    public boolean performPayment(PaymentObject payment ) throws ExternalPartnerException {
        JSONObject request = new JSONObject().put("CreditCard", "0000").put("Amount",payment.getPrice());
        Integer id;

        try {
            String str;
            str = WebClient.create(url).path("/mailbox")
                    .accept(MediaType.APPLICATION_JSON_TYPE).header("Content-Type", MediaType.APPLICATION_JSON)
                    .post(request.toString(), String.class);
            id = Integer.parseInt(str);
        } catch (Error e ) {
            throw new ExternalPartnerException(url+"/mailbox", e);
        }

        JSONObject payments;
        try {
            String response = WebClient.create(url).path("/payments/" + id).get(String.class);
            payments = new JSONObject(response);
        } catch (Exception e) {
            throw new ExternalPartnerException(url + "payments/" + id, e);
        }
        // Assessing the payment status
        return (payments.getInt("Status") == 0);
    }
}