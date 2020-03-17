package webservice;


import component.PackageModification;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@WebService
@Stateless
public class ClientWebService implements Communicatoin {



    @EJB
    PackageModification managePlanningComponent;
    @WebMethod
    @WebResult(name = "TheTimeChangedOrNot")
    public boolean changeTheTimeOfThePackage(@WebParam(name = "packageId") int id, @WebParam(name = "TheTimeChanged") String date) {
        System.out.print("Receive the request\n");
        System.out.print("The time the client want to change is "+ date+"\n");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d H:m:s");
        Date date1 = null;
        try {
           date1 = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();

            return false;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date1);
        if(managePlanningComponent.changeTheDateOfThePackage(id,c)){
            System.out.print("chang  time successfully\n");
            return true;
        }
        else {
            System.out.print("chang time unsuccessfully\n");
            return false;
        }


    }



//    @WebMethod
//    public boolean changeTheTimeOfThePackage(int id, Calendar date) {
//        try {
//            PackageModification managePlanning = (PackageModification) Naming
//                    .lookup("rmi://localhost:8891/ManagePlanning");
//            return managePlanning.changeTheDateOfThePackage(id,date);
//        } catch (NotBoundException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//        return false;
//
//    }
}
