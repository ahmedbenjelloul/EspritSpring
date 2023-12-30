package tn.esprit.app1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.app1.Entities.Etudiant;

@Repository
public interface EtudiantRepo extends JpaRepository <Etudiant, Long>  {

}
