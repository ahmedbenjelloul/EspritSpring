package tn.esprit.app1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.app1.Entities.Bloc;

@Repository
public interface BlocRepo extends JpaRepository<Bloc, Long> { //interface avec parametre

   // Bloc findBlocByNomBloc (String  nom) ; //keywords
    //@Query(value = "select b from Bloc  b where b.nomBloc =: nom") //jpql

   // Bloc findBlocByNomBlocs(@Param("nom") String nom ) ;

 Bloc findBlocByNomBloc(String nom) ;


}
