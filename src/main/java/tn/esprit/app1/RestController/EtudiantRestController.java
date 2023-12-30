package tn.esprit.app1.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.app1.Entities.Chambre;
import tn.esprit.app1.Entities.Etudiant;
import tn.esprit.app1.Services.IEtudiantService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("etudiant")
public class EtudiantRestController {
    IEtudiantService iEtudiantService;

    @GetMapping("/afficherEtudiants")
    List<Etudiant> retrieveAllEtudiants() {

        return iEtudiantService.retrieveAllEtudiants();
    }

    @PostMapping("/ajouteretudiants")
    List<Etudiant> addEtudiant(@RequestBody List<Etudiant> etudiant) {
        return iEtudiantService.addEtudiants(etudiant);
    }

    @PutMapping("/modifieretudiants")
    Etudiant updateEtudiant(@RequestBody Etudiant e) {
        return iEtudiantService.updateEtudiant(e);

    }

    @GetMapping("/afficheretudiant/{idetudiant}")
    Etudiant retrieveEtudiant(@PathVariable("idetudiant") long idEtudiant) {
        return iEtudiantService.retrieveEtudiant(idEtudiant);

    }

    @DeleteMapping("/supprimeretudiant")
    void removeEtudiant(long idEtudiant) {
        iEtudiantService.removeEtudiant(idEtudiant);
    }
}
