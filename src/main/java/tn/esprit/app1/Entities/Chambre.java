package tn.esprit.app1.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Chambre {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;

    Long numeroChambre ;
    @Enumerated
    TypeChambre  typeC ;
   // long capacite ;

    //relation reservation-chambre
    @OneToMany (fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    Set<Reservation> reservation ;

    @ManyToOne (cascade = CascadeType.PERSIST) //jsonignore (persist pour enregistrer )  CascadeType.All -> elle compporte le persist , fetch etc
    Bloc blocs  ;
}
