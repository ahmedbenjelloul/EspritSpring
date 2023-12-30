package tn.esprit.app1.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.app1.Entities.Etudiant;
import tn.esprit.app1.Repositories.EtudiantRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {
    EtudiantRepo etudiantRepo ;
    @Override
    public List <Etudiant>  retrieveAllEtudiants() {
      return etudiantRepo.findAll() ;
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiant) {
        return  etudiantRepo.saveAll (etudiant);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return  etudiantRepo.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return null;
    }

    @Override
    public void removeEtudiant(long idEtudiant) {

       etudiantRepo.deleteById( idEtudiant);
    }
}
