package tn.esprit.app1.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Bloc {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idBloc;
 String nomBloc ;
 Long capaciteBloc ;

@OneToMany(cascade = CascadeType.ALL , mappedBy = "blocs" , fetch = FetchType.EAGER)
Set<Chambre> chambres ;

@ManyToOne()
    Foyer foyer ;

}


















