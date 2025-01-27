package it.epicode.Capstone.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ReservationRequest {

    @NotNull(message = "La data della prenotazione non può essere vuota")
    @FutureOrPresent(message = "La data della prenotazione non può essere nel passato")
    private LocalDateTime reservationDate;

    @Min(value = 1, message = "Il numero di ospiti deve essere almeno 1")
    private int numberOfGuests;

    @NotNull(message = "L'Id del cliente non può essere vuoto")
    private Long costumerId;
}
