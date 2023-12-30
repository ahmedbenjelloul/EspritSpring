package tn.esprit.app1.RestController;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tn.esprit.app1.Entities.Bloc;
import tn.esprit.app1.Services.IBlocService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController // Use @RestController instead of @Service for a controller class
@RequestMapping("/Bloc")
public class BlocRestController {
  IBlocService iBlocService;

    @GetMapping("/AllBlocs")
    public List<Bloc> retrieveBlocs() {
        return iBlocService.retrieveBlocs();
    }

    @PutMapping("/updateBloc")
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return iBlocService.updateBloc(bloc);
    }

    @PostMapping("/addBloc")
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return iBlocService.addBloc(bloc);
    }

    @GetMapping("/getBloc")
    public Optional<Bloc> retrieveBloc(@RequestParam long idBloc) {
        return iBlocService.retrieveBloc(idBloc);
    }

    @DeleteMapping("/removeBloc")
    public void removeBloc(@RequestParam long idBloc) {
        iBlocService.removeBloc(idBloc);
    }

    @PutMapping("/affecterChambresABloc")
    public Bloc affecterChambresABloc(@RequestParam List<Long> numChambre, @RequestParam String nomBloc) {
        // Votre logique pour affecter les chambres à un bloc ici
        return iBlocService.affecterChambresABloc(numChambre, nomBloc);
    }
}
