import fr.unice.BankAPI;
import fr.unice.ExternalPartnerException;
import fr.unice.PaymentObject;
import javafx.util.Pair;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BankAPITest {

    BankAPI bankAPI = new BankAPI();

    @Test
    public void testCommunication() throws ExternalPartnerException {
        boolean status = bankAPI.performPayment(new PaymentObject(1,12.00));
        assertTrue(status);
    }
}


