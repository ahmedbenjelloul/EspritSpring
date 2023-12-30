package tn.esprit.app1.Services;

import tn.esprit.app1.Entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();

    List<Etudiant> addEtudiants (List<Etudiant> etudiants);

    Etudiant updateEtudiant (Etudiant e);

    Etudiant retrieveEtudiant(long  idEtudiant);

    void removeEtudiant(long idEtudiant);

}
