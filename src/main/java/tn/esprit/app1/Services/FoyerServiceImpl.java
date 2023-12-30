package tn.esprit.app1.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.app1.Entities.Bloc;
import tn.esprit.app1.Entities.Foyer;
import tn.esprit.app1.Entities.Universite;
import tn.esprit.app1.Repositories.BlocRepo;
import tn.esprit.app1.Repositories.FoyerRepo;
import tn.esprit.app1.Repositories.UniversiteRepo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class FoyerServiceImpl  implements  IFoyerService{

   FoyerRepo foyerRepo ;
BlocRepo blocRepo ;
UniversiteRepo universiteRepo ;
    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepo.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer b) {
        return foyerRepo.save(b);
    }

    @Override
    public Foyer updateFoyer(Foyer b) {
        return foyerRepo.save(b);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepo.findById(idFoyer).orElse(null);
    }

    @Override
    public Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer) {
        Bloc bloc = blocRepo.findBlocByNomBloc(nomBloc);
        Foyer foyer=foyerRepo.findFoyerByNomFoyer(nomFoyer);
        Set<Bloc> blocs = new HashSet<>();
        blocs.add(bloc);
        foyer.setBlocs(blocs);
        foyerRepo.save(foyer);
        return bloc;
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


        return foyerEnregistre;
    }
    }



