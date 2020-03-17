package component;




import javax.ejb.Local;
import java.util.Calendar;



@Local

public interface PackageModification {

   boolean changeTheDateOfThePackage(int id, Calendar timechanged) ;
}
