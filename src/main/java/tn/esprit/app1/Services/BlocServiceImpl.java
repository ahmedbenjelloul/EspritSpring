package tn.esprit.app1.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.app1.Entities.Bloc;
import tn.esprit.app1.Entities.Chambre;
import tn.esprit.app1.Entities.Foyer;
import tn.esprit.app1.Repositories.BlocRepo;
import tn.esprit.app1.Repositories.ChambreRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
@Slf4j

public class BlocServiceImpl  implements  IBlocService  {
BlocRepo blocRepo ;
ChambreRepo chambreRepo ;

    @Override
    public List<Bloc> retrieveBlocs() {
        return  blocRepo.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return  blocRepo.save(bloc) ;
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return  blocRepo.save(bloc) ;
    }

    @Override
    public Optional<Bloc> retrieveBloc(long idBloc) {
       return  blocRepo.findById ( idBloc ) ;
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepo.deleteById(idBloc);

    }
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) {
        Bloc bloc = blocRepo.findBlocByNomBloc(nomBloc);
        List<Chambre> chambres = new ArrayList<>();  // Initialiser la liste

        for (long num : numChambre) {
            Chambre chambre = chambreRepo.findChambreByNumeroChambre(num);
            chambre.setBlocs(bloc);
            chambres.add(chambre);
        }

        chambreRepo.saveAll(chambres);
        return bloc;
    }



}