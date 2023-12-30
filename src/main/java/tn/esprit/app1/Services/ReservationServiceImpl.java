package tn.esprit.app1.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.app1.Entities.Reservation;
import tn.esprit.app1.Repositories.ReservationRepo;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService{
    ReservationRepo reservationRepo ;


    @Override
    public Reservation ajouterReservation(Reservation reservation, long idChambre, long cin) {

        return null;
    }
}
