package tn.esprit.app1.Repositories;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tn.esprit.app1.Entities.Foyer;
@Service

@Repository
public interface FoyerRepo  extends JpaRepository <Foyer , Long >  {
    Foyer findFoyerByNomFoyer(String nomFoyer);
}
