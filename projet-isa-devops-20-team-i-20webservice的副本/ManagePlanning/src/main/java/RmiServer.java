import component.ManagePlanningComponent;
import component.PackageModification;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class RmiServer {

//    public static void main(String[] args) throws AlreadyBoundException {
//        try {
//            PackageModification remoteObj = new ManagePlanningComponent();
//            LocateRegistry.createRegistry(8891);
//            Naming.rebind("rmi://localhost:8891/ManagePlanning", remoteObj);
//            System.out.println(">>>>>INFO: Successfully");
//        } catch (RemoteException var2) {
//            System.out.println("create object unsuccessflly");
//            var2.printStackTrace();
//        } catch (MalformedURLException var3) {
//            System.out.println("URL error");
//            var3.printStackTrace();
//        }
//
//    }
}
