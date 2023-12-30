package tn.esprit.app1.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Etudiant {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idEtudiant;

  String nomEt ;
  String  prenomEt ;
   Long  cin ;
   String ecole ;
   @Temporal(TemporalType.DATE)
   Date dateNaissance ;

   //cardinalité

    @ManyToMany
   Set<Reservation> reservations;
}
