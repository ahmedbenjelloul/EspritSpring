package tn.esprit.app1.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Universite {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idUniversite;
    String nomUniversite ;
    String adresse ;
    @JsonIgnore
    @OneToOne (mappedBy = "univer")
      Foyer foyer ;

}
