package makefacture;



import entities.Facture;

import javax.ejb.Local;
import java.util.List;

@Local

public interface TodayFacture {
    List<Facture> getTheTodayFacture();
}
