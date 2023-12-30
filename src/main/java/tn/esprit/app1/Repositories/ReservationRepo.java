package tn.esprit.app1.Repositories;

import org.hibernate.sql.ast.tree.predicate.BetweenPredicate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import tn.esprit.app1.Entities.Reservation;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepo extends JpaRepository <Reservation , String>  {
    //chercher les reservations effectuées durant l'année universitaire 23-24
    List<Reservation> findReservationsByAnneeUniversitaireBetween(Date debut , Date fin ) ;
     long countReservationsByAnneeUniversitaireBetween ( Date debut , Date fin );
}
