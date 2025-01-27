package it.epicode.Capstone.reservation;

import it.epicode.Capstone.auth.AppUser;
import it.epicode.Capstone.auth.AppUserRepository;
import it.epicode.Capstone.auth.Role;
import it.epicode.Capstone.dto.ReservationRequest;
import it.epicode.Capstone.entities.Reservation;
import it.epicode.Capstone.exceptions.ReservationNotFoundException;
import it.epicode.Capstone.exceptions.UnauthorizedException;
import it.epicode.Capstone.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final AppUserRepository appUserRepository;

    private boolean isAdmin(AppUser user) {
        return user.getRoles().contains(Role.ROLE_ADMIN); // Controlla se l'utente ha il ruolo ADMIN
    }

    private AppUser getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return appUserRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("Utente non trovato"));
    }

    public Reservation createReservation(ReservationRequest reservationRequest) {
        AppUser currentUser = getCurrentUser();

        if (reservationRequest.getCostumerId() != null && !reservationRequest.getCostumerId().equals(currentUser.getId())) {
            throw new UnauthorizedException("Non puoi prenotare con questo id");
        }

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

        if (!reservation.getUser().getId().equals(loggedInUser.getId()) && !isAdmin(loggedInUser)) {
            throw new UnauthorizedException("Non sei autorizzato a cancellare questa prenotazione");
        }

        reservationRepository.delete(reservation);
    }

    public List<Reservation> getUserReservations() {
        AppUser loggedInUser = getCurrentUser();
        return reservationRepository.findByUserId(loggedInUser.getId());
    }

    public List<Reservation> getAllReservations() {
        AppUser loggedInUser = getCurrentUser();

        if (!isAdmin(loggedInUser)) {
            throw new UnauthorizedException("Non sei autorizzato a visualizzare tutte le prenotazioni");
        }

        return reservationRepository.findAll();
    }
}
