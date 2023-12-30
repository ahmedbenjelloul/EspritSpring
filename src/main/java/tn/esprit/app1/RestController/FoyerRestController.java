package tn.esprit.app1.RestController;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;
import tn.esprit.app1.Entities.Bloc;
import tn.esprit.app1.Entities.Foyer;
import tn.esprit.app1.Services.IFoyerService;
import tn.esprit.app1.Services.IUniversiteService;

import java.util.List;

@RestController

@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerRestController {
    IFoyerService iFoyerService ;
    IUniversiteService iUniversiteService ;

    @GetMapping("/afficherfoyers")
    List<Foyer> retrieveAllFoyers(){
        return iFoyerService.retrieveAllFoyers();
    }
    @PostMapping("/ajouterfoyer")
    Foyer addFoyer(@RequestBody Foyer c){return iFoyerService.addFoyer(c);}
    @PutMapping("/modifierfoyer")
    Foyer updateFoyer (@RequestBody Foyer c){return iFoyerService.updateFoyer(c);}
    @GetMapping("/afficherfoyer/{idfoyer}")
    Foyer retrieveFoyer(@PathVariable("idfoyer") long idFoyer){return iFoyerService.retrieveFoyer(idFoyer);}

    @PutMapping("/affecterBlocAFoyer/{nomBloc}/{nomFoyer}")
    Bloc affecterBlocAFoyer(@PathVariable("nomBloc")String nomBloc, @PathVariable("nomFoyer") String nomFoyer) {
        return iFoyerService.affecterBlocAFoyer(nomBloc , nomFoyer) ;
    };

    @PostMapping("/ajouterFoyerEtAffecterAUnivesrsite/{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, @PathVariable("idUniversite")long idUniversite) {
        return  iFoyerService.ajouterFoyerEtAffecterAUniversite (foyer , idUniversite) ;
    }
}
