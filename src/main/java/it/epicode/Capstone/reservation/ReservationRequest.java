package it.epicode.Capstone.reservation;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ReservationRequest {
    @NotNull(message = "La data della prenotazione non può essere vuota")
    @FutureOrPresent(message = "La data della prenotazione non può essere nel passato")
    private LocalDateTime reservationDate;

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
