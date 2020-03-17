package webservice;


import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Calendar;
import java.util.Date;

@WebService
public interface Communicatoin {

    @WebMethod
    boolean changeTheTimeOfThePackage(int id , String date);
}
