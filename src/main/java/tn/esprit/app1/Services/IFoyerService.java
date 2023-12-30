package tn.esprit.app1.Services;

import tn.esprit.app1.Entities.Bloc;
import tn.esprit.app1.Entities.Foyer;

import java.util.List;

public interface IFoyerService {
    List<Foyer> retrieveAllFoyers();
    Foyer addFoyer(Foyer b);
    Foyer updateFoyer (Foyer b);
    Foyer retrieveFoyer (long idFoyer);

    public Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer) ;
    Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);
}
