package tn.esprit.app1.Services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.app1.Entities.Bloc;
import tn.esprit.app1.Entities.Foyer;
import tn.esprit.app1.Entities.Universite;
import tn.esprit.app1.Repositories.BlocRepo;
import tn.esprit.app1.Repositories.FoyerRepo;
import tn.esprit.app1.Repositories.UniversiteRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImp implements IUniversiteService {
    UniversiteRepo universiteRepo;
    FoyerRepo foyerRepo;
    BlocRepo blocRepo;

    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepo.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepo.save(u);
    }




    // @Override
   // public Universite updateUniversite(Universite u,long idUniversite) {
   //     return universiteRepo.save(u,idUniversite);
   // }
    @Override
    public Universite updateUniversite(Universite u, long idUniversite) {
        Universite existingU = universiteRepo.findById(idUniversite).orElse(null);

        existingU.setNomUniversite(u.getNomUniversite());
        existingU.setAdresse(u.getAdresse());

        return universiteRepo.save(existingU);
    }



    @Override
    public String deleteUniversite(long idUniversite) {
        universiteRepo.deleteById(idUniversite);
        return "universiteSupprimee";
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepo.findById(idUniversite).orElse(null);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepo.findById(idFoyer).orElse(null);
        Universite universities = universiteRepo.findUniversiteByNomUniversite(nomUniversite);

        //  if (universities.size() == 1) {
        // Universite universite = universities.get(0);
        foyer.setUniver(universities);
        return universiteRepo.save(universities);
        // } else if (universities.isEmpty()) {
        // Handle the case where no university with the specified name is found
        // You may throw an exception or handle it according to your requirements
        //  throw new RuntimeException("No university found with the name: " + nomUniversite);
        //  } else {
        // Handle the case where multiple universities with the same name are found
        // You may throw an exception or handle it according to your requirements
        //  throw new RuntimeException("Multiple universities found with the name: " + nomUniversite);
        //   }
    }


    @Override
    public Universite desaffecterFoyerAUniversite(long idFoyer, long idUniversite) {
        Foyer foyer= foyerRepo.findById(idFoyer).orElse(null);
        Universite universite = universiteRepo.findUniversiteByIdUniversite(idUniversite);
        universite.setFoyer(null);
        //universiteRepo.save(universite); not required with java 8
        return universiteRepo.save(universite);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {

        Universite universite = universiteRepo.findUniversiteByIdUniversite(idUniversite);
        ;
        foyer.setUniver(universite);
        Foyer foyerEnregistre = foyerRepo.save(foyer);

        if (foyer.getBlocs() != null && !foyer.getBlocs().isEmpty()) {
            for (Bloc bloc : foyer.getBlocs()) {
                bloc.setFoyer(foyerEnregistre);
                blocRepo.save(bloc);
            }
        }
        foyerEnregistre = foyerRepo.save(foyerEnregistre);

        return foyerEnregistre;
    }
    }



