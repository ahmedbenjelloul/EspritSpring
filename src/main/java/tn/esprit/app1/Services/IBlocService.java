package tn.esprit.app1.Services;

import tn.esprit.app1.Entities.Bloc;
import tn.esprit.app1.Entities.Foyer;

import java.util.List;
import java.util.Optional;

public interface IBlocService {

    List<Bloc> retrieveBlocs();

    Bloc updateBloc(Bloc bloc);

    Bloc addBloc(Bloc bloc);

    Optional<Bloc> retrieveBloc(long idBloc);

    void removeBloc(long idBloc);

    Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) ;



}

