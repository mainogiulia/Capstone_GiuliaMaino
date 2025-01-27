package it.epicode.Capstone.reservation;

import it.epicode.Capstone.auth.AppUser;
import it.epicode.Capstone.auth.AppUserRepository;
import it.epicode.Capstone.dto.ReservationRequest;
import it.epicode.Capstone.entities.Reservation;
import it.epicode.Capstone.exceptions.ReservationNotFoundException;
import it.epicode.Capstone.exceptions.UnauthorizedException;
import it.epicode.Capstone.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final AppUserRepository appUserRepository;

    private AppUser getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return appUserRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("Utente non trovato"));
    }

    public Reservation createReservation(ReservationRequest reservationRequest) {
        AppUser currentUser = getCurrentUser();

        Reservation reservation = new Reservation();
        reservation.setUser(currentUser); // Imposta l'utente collegato
        reservation.setReservationDate(reservationRequest.getReservationDate());
        reservation.setNumberOfGuests(reservationRequest.getNumberOfGuests());

        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException("Prenotazione non trovata"));

        AppUser loggedInUser = getCurrentUser();

        if (!reservation.getUser().getId().equals(loggedInUser.getId())) {
            throw new UnauthorizedException("Non sei autorizzato ad eseguire questa operazione");
        }

        reservationRepository.delete(reservation);
    }

    public List<Reservation> getUserReservations() {
        AppUser loggedInUser = getCurrentUser();
        return reservationRepository.findByUserId(loggedInUser.getId());
    }
}
