package tn.esprit.app1.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reservation {

    @Id

    private String idReservation;
    @Temporal(TemporalType.DATE)
    LocalDate anneeUniversitaire ;
   boolean estValide ;

    @ManyToMany (mappedBy = "reservations")
    Set<Etudiant> etudiants;

}
