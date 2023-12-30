package tn.esprit.app1.Services;

import tn.esprit.app1.Entities.Chambre;

import java.util.List;

public interface IChambreService  {

    List<Chambre> retrieveAllChambres();
    Chambre addChambre(Chambre c);
    Chambre updateChambre (Chambre c);
    Chambre retrieveChambre (long idChambre);
    List<Chambre> getChambreByNomBloc(String nom);
    public List<Chambre>  getChambresParNomUniversite( String nomUniversite) ;







}
