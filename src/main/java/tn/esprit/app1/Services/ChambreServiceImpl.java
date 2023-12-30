package tn.esprit.app1.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.app1.Entities.Chambre;
import tn.esprit.app1.Entities.Reservation;
import tn.esprit.app1.Repositories.ChambreRepo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class ChambreServiceImpl implements IChambreService {
 ChambreRepo chambreRepo ;
    @Override
    public List<Chambre> retrieveAllChambres() {


        return chambreRepo.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        log.info("on a ajoute bune chambre"+c.toString()); //nouvelle notion qui vient de lombok
        return chambreRepo.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {

        return  chambreRepo.save(c);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {

        return null  ;
    }

    @Override
    public List<Chambre> getChambreByNomBloc(String nom) {
        return chambreRepo.findChambresByBlocs_NomBloc(nom);
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        return  chambreRepo.getByNomUniversite( nomUniversite);
    }

    List <Chambre> getChambreByReservationByAnneeUniversitaire (LocalDate debut , Date  fin ) {
        List <Chambre>  chambres=null ;
        for (Chambre c : chambreRepo.findAll() )
            for (Reservation r : c.getReservation())
                if (r.getAnneeUniversitaire().isAfter(debut)&& r.getAnneeUniversitaire().isBefore(debut))
                    chambres.add (c) ;
        return  chambres ;
    }

    List <Chambre>findChambresByBlocs_NomBloc(String nom) {

        return chambreRepo.findChambresByBlocs_NomBloc(nom) ;
    }

    //recupere les chambres dont ils ont ete reserve durant une annee universitaire donner au clavier

    List<Chambre> getChambreByReservationAnneeUniversitaire(LocalDate debut, LocalDate fin){
       // List<Chambre> chambres=null;

        //for (Chambre c :chambreRepo.findAll())
          //  for (Reservation r : c.getReservation())
              //  if (r.getAnneeUniversitaire().isAfter(debut)&& r.getAnneeUniversitaire().isBefore(fin) )
                  //  chambres.add(c);
       // return chambres;
return  chambreRepo.findChambreByReservation(debut , fin) ;
    }
}
