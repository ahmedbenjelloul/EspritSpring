package tn.esprit.app1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.app1.Entities.Chambre;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ChambreRepo extends JpaRepository <Chambre , Long> {
    // recupere les chambres dont elle ont ete erserve duarnt une annnee universitaire bien ndonnée
     List <Chambre>findChambresByBlocs_NomBloc(String nom) ;
Chambre findChambreByNumeroChambre(long num) ;
@Query("select  chambre from Chambre  chambre join chambre.reservation reservation where  reservation.anneeUniversitaire>: debut and reservation.anneeUniversitaire<: fin")
List <Chambre> findChambreByReservation(@Param("debut")LocalDate debut , @Param("fin") LocalDate fin) ;
List <Chambre> findChambresByBlocs_Foyer_Univer_NomUniversite(String nomUniversite) ;
    @Query("select chambre from Chambre chambre " +
            "join chambre.blocs bloc " +
            "join bloc.foyer foyer " +
            "join foyer.univer univer " +
            "where univer.nomUniversite = :nom")
    List<Chambre> getByNomUniversite(@Param("nom") String nomUniversite);


}
