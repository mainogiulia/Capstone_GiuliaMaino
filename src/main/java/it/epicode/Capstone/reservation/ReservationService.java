package it.epicode.Capstone.reservation;

import it.epicode.Capstone.auth.AppUser;
import it.epicode.Capstone.auth.AppUserRepository;
import it.epicode.Capstone.auth.Role;
import it.epicode.Capstone.exceptions.ResourceNotFoundException;
import it.epicode.Capstone.exceptions.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final AppUserRepository appUserRepository;

    //DEFINISCO ADMIN E CURRENT USER
    private boolean isAdmin(AppUser user) {
        return user.getRoles().contains(Role.ROLE_ADMIN); // CONTROLLA SE L'UTENTE HA IL RUOLO ADMIN
    }

    private AppUser getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return appUserRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Utente non trovato"));
    }

    //CREO UNA NUOVA PRENOTAZIONE
    public Reservation createReservation(ReservationRequest reservationRequest) {
        AppUser currentUser = getCurrentUser();

        if (reservationRequest.getCostumerId() != null && !reservationRequest.getCostumerId().equals(currentUser.getId())) {
            throw new UnauthorizedException("Non puoi prenotare con questo id");
        }

        Reservation reservation = new Reservation();
        reservation.setUser(currentUser); // IMPOSTA L'UTENTE COLLEGATO
        reservation.setReservationDate(reservationRequest.getReservationDate());
        reservation.setNumberOfGuests(reservationRequest.getNumberOfGuests());

        return reservationRepository.save(reservation);
    }

    //ELIMINO UNA PRENOTAZIONE
    public void deleteReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prenotazione non trovata"));

        AppUser loggedInUser = getCurrentUser();

        if (!reservation.getUser().getId().equals(loggedInUser.getId()) && !isAdmin(loggedInUser)) {
            throw new UnauthorizedException("Non sei autorizzato a cancellare questa prenotazione");
        }

        reservationRepository.delete(reservation);
    }

    // RECUPERO LE PRENOTAZIONI (SOLO QUELLE DELL'UTENTE O TUTTE SE ADMIN)
    public List<Reservation> getReservations() {
        AppUser loggedInUser = getCurrentUser();

        if (isAdmin(loggedInUser)) {
            return reservationRepository.findAll();
        } else {
            return reservationRepository.findByUserId(loggedInUser.getId());
        }
    }
}
