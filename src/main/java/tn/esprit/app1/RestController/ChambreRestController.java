package tn.esprit.app1.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.app1.Entities.Chambre;
import tn.esprit.app1.Services.IChambreService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("chambre")
public class ChambreRestController {
    IChambreService iChambreService ;

@GetMapping("/afficherchambres")
    List<Chambre> retrieveAllChambres(){

    return iChambreService.retrieveAllChambres() ;
    }

@PostMapping ("/ajouterchambres")
    Chambre  addChambre(@RequestBody Chambre c)
    { return iChambreService.addChambre(c) ;

    }

@PutMapping("/modifierchambres")
    Chambre updateChambre (@RequestBody  Chambre  c){
        return  iChambreService.updateChambre(c) ;

    }
@GetMapping("/afficherchambre/{idchambre}")
    Chambre retrieveChambre ( @PathVariable ("idchambre") long idChambre){
        return iChambreService.retrieveChambre(idChambre) ;

    }
    @GetMapping("/getbynombloc/{nom}")
    public List<Chambre> getChambreByNomBloc(@PathVariable("nom") String nom) {
        return iChambreService.getChambreByNomBloc(nom);
    }
@GetMapping("/getChambreparnomUnivesite/{nom}")
    public List<Chambre> getChambresParNomUniversite(@PathVariable("nom") String nomUniversite) {
    return iChambreService.getChambresParNomUniversite(nomUniversite) ;
}

}
