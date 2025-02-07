package it.epicode.Capstone.reservation;

import it.epicode.Capstone.auth.AppUser;
import it.epicode.Capstone.auth.AppUserRepository;
import it.epicode.Capstone.auth.Role;
import it.epicode.Capstone.exceptions.ResourceNotFoundException;
import it.epicode.Capstone.exceptions.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final AppUserRepository appUserRepository;
    private final JavaMailSender mailSender; // SERVE PER INVIARE L'EMAIL

    //DEFINISCO ADMIN E CURRENT USER
    private boolean isAdmin(AppUser user) {
        return user.getRoles().contains(Role.ROLE_ADMIN); // CONTROLLA SE L'UTENTE HA IL RUOLO ADMIN
    }

    private AppUser getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return appUserRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Utente non trovato"));
    }

    //CREO UNA NUOVA PRENOTAZIONE E MI ARRIVA IL CODICE PER L'EVENTUALE CANCELLAZIONE
    public Reservation createReservation(ReservationRequest reservationRequest) {

        String cancellationCode = UUID.randomUUID().toString(); //GENERA IL CODICE UNIVOCO PER LA CANCELLAZIONE

        Reservation reservation = new Reservation();
        reservation.setCustomerName(reservationRequest.getCostumerName()); // IMPOSTA IL NOME INSERITO DALL'UTENTE
        reservation.setEmail(reservationRequest.getEmail()); // IMPOSTA L'EMAIL INSERITA DALL'UTENTE
        reservation.setReservationDate(reservationRequest.getReservationDate());
        reservation.setNumberOfGuests(reservationRequest.getNumberOfGuests());
        reservation.setCancellationCode(cancellationCode);

        reservation = reservationRepository.save(reservation);

        //INVIA L'EMAIL CON IL CODICE
        sendCancellationCodeEmail(reservationRequest.getCostumerName(), reservationRequest.getEmail(), cancellationCode, reservationRequest.getReservationDate());

        return reservation;
    }

    private void sendCancellationCodeEmail(String customerName, String email, String cancellationCode, LocalDateTime reservationDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");//TRASFORMA LA DATA NEL FORMATO GG/MM/AAAA e HH:MM
        String formattedDate = reservationDate.format(formatter);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Conferma Prenotazione");
        message.setText("Gentile " + customerName + ",\n"
                + "La informiamo che la sua prenotazione è stata confermata per il giorno " + formattedDate.replace(" ", " alle ore ") + ".\n"
                + "Per eventuali cancellazioni, può utilizzare il seguente codice: " + cancellationCode + "\n"
                + "Le ricordiamo che, qualora decidesse di cancellare la prenotazione, potrà farlo entro il termine indicato nei nostri termini e condizioni.\n"
                + "Per qualsiasi ulteriore richiesta o chiarimento, non esiti a contattarci. Saremo felici di assisterla.\n"
                + "La ringraziamo per aver scelto il nostro servizio e restiamo a sua disposizione.\n" +
                "\n" +
                "Cordiali saluti,\n" +
                "PUB\n" + //DEVI SCEGLIERE IL NOMEEEEEEE
                "numero di telefono, indirizzo, ecc.."); //E COMPILA I CONTATTI

        mailSender.send(message);
    }

    //ELIMINO UNA PRENOTAZIONE DA ADMIN
    public void deleteReservation(Long id) {
        AppUser currentUser = getCurrentUser();

        if (!isAdmin(currentUser)) {
            throw new UnauthorizedException("Accesso negato: solo gli amministratori possono eliminare le prenotazioni.");
        }

        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prenotazione non trovata"));

        reservationRepository.delete(reservation);
    }

    //DISDICO UNA PRENOTAZIONE DA CLIENTE CON CODICE
    public void cancelReservation(ReservationRequest reservationRequest) {
        Reservation reservation = reservationRepository.findByCustomerNameAndCancellationCode(
                reservationRequest.getCostumerName(), reservationRequest.getCancellationCode()
        ).orElseThrow(() -> new ResourceNotFoundException("Prenotazione non trovata o codice errato"));

        reservationRepository.delete(reservation);
    }

    // RECUPERO LE PRENOTAZIONI (SOLO SE ADMIN)
    public List<Reservation> getReservations() {
        AppUser currentUser = getCurrentUser();

        if (!isAdmin(currentUser)) {
            throw new UnauthorizedException("Accesso negato: solo gli amministratori possono visualizzare tutte le prenotazioni.");
        }

        return reservationRepository.findAll();
    }
}
