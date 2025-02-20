package it.epicode.Capstone.reservation;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
public class ReservationRequest {
    @NotNull(message = "La data della prenotazione non può essere vuota")
    @FutureOrPresent(message = "La data della prenotazione non può essere nel passato")
    private LocalDate reservationDate;

    @NotNull(message = "L'orario della prenotazione non può essere vuoto")
    @FutureOrPresent(message = "L'orario' della prenotazione non può essere nel passato")
    private LocalTime reservationTime;

    @Min(value = 1, message = "Il numero di ospiti deve essere almeno 1")
    private int numberOfGuests;

    @NotBlank(message = "Il nome del cliente non può essere vuoto")
    private String customerName;

    @NotBlank(message = "L'email non può essere vuota")
    @Email(message = "Inserire un indirizzo email valido")
    private String email;

    @NotBlank(message = "Il codice di cancellazione non può essere vuoto")
    private String cancellationCode;
}
