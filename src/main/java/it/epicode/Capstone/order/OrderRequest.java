package it.epicode.Capstone.order;

import it.epicode.Capstone.orderdetail.OrderDetailRequest;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderRequest {
    @NotNull(message = "L'ID dell'utente non può essere nullo")
    private Long appUserId;

    @NotEmpty(message = "L'ordine deve contenere almeno un dettaglio")
    private List<OrderDetailRequest> details;

    @PositiveOrZero(message = "L'importo deve essere un numero positivo")
    private int totalPrice;

    @FutureOrPresent(message = "La data dell'ordine non può essere nel passato")
    private LocalDate orderDate;
}
