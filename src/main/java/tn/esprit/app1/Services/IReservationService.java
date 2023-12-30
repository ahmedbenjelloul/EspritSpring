package tn.esprit.app1.Services;

import tn.esprit.app1.Entities.Reservation;

public interface IReservationService {
    public Reservation ajouterReservation (Reservation reservation, long idChambre, long cin) ;


}
