package tn.esprit.app1.Services;


import tn.esprit.app1.Entities.Foyer;
import tn.esprit.app1.Entities.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();
    Universite addUniversite(Universite b);
    //Universite updateUniversite (Universite b , idUniversite);

    // @Override
   // public Universite updateUniversite(Universite u,long idUniversite) {
   //     return universiteRepo.save(u,idUniversite);
   // }
    Universite updateUniversite(Universite u, long idUniversite);

    String deleteUniversite (long idUniversite);

    Universite retrieveUniversite (long idUniversite);

    public Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite) ;
    public Universite desaffecterFoyerAUniversite (long idFoyer, long idUniversite) ;

    Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);


}
