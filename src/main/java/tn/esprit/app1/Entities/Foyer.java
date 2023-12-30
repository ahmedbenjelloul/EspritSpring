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
public class Foyer {

@GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    private Long idFoyer;  ;
    String nomFoyer;
    Long capacite ;
//foyer bloc (one to many )
@OneToMany(cascade = CascadeType.ALL, mappedBy = "foyer")
Set<Bloc> blocs;


    @OneToOne (cascade = CascadeType.ALL)
   Universite univer ;


}
