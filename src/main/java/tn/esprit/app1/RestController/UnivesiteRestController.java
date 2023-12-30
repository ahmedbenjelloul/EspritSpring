package tn.esprit.app1.RestController;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tn.esprit.app1.Entities.Foyer;
import tn.esprit.app1.Entities.Universite;
import tn.esprit.app1.Repositories.UniversiteRepo;
import tn.esprit.app1.Services.IUniversiteService;
//import tn.esprit.app1.Services.GoogleMapsService;


import java.util.List;

@Service
@AllArgsConstructor
@RestController
@RequestMapping("/Universite")
@CrossOrigin(origins = "*")
public class UnivesiteRestController {

    IUniversiteService iUniversiteService ;
   // private GoogleMapsService googleMapsService ;
    UniversiteRepo universiteRepo ;
    @GetMapping("/afficheruniversites")
    List<Universite> retrieveAllUniversites() {
        return iUniversiteService.retrieveAllUniversites();
    }

    @PostMapping("/ajouteruniversite")
    Universite addUniversite(@RequestBody Universite c){return iUniversiteService.addUniversite(c);}
    @PutMapping("/modifieruniversite/{idUniversite}")
    Universite updateUniversite (@RequestBody Universite c,@PathVariable long idUniversite){
        return iUniversiteService.updateUniversite(c,idUniversite);}
    @DeleteMapping("/deleteUniversite")
        public String deleteUniversite(@RequestParam long idUniversite ) {
        iUniversiteService.deleteUniversite(idUniversite);
        return "universite supprimee";
    }
    @GetMapping("/afficheruniversite/{iduniversite}")
    Universite retrieveUniversite(@PathVariable("iduniversite") long idUniversite){return iUniversiteService.retrieveUniversite(idUniversite);}
    @PutMapping("/affecterfoyerauniversite/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite (@PathVariable("idFoyer")long idFoyer,@PathVariable("nomUniversite") String nomUniversite){
        return iUniversiteService.affecterFoyerAUniversite(idFoyer,nomUniversite);
    } ;
    @PutMapping("/desaffecterfoyerauniversite/{idFoyer}/{idUniversite}")
    public Universite desaffecterFoyerAUniversite (@PathVariable("idFoyer")long idFoyer,@PathVariable("idUniversite") Long idUniversite){
        return iUniversiteService.desaffecterFoyerAUniversite(idFoyer,idUniversite);
    } ;
   // @GetMapping("/coordonnees/{idUniversite}")
   // public String getCoordinates(@PathVariable Long idUniversite) {
     //   Universite universite = universiteRepo.findById(idUniversite).orElse(null);

       // if (universite != null) {
         //   return googleMapsService.getCoordinates(universite.getAdresse());
        //}

     //   return null;
  //  }

}
