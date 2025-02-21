package it.epicode.Capstone.gelatoorder;

import it.epicode.Capstone.orderdetail.GelatoOrderDetailRequest;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class GelatoOrderRequest {

    @NotEmpty(message = "L'ordine deve contenere almeno un dettaglio")
    private List<GelatoOrderDetailRequest> details;

    @PositiveOrZero(message = "L'importo deve essere un numero positivo")
    private int totalPrice;

    @FutureOrPresent(message = "La data dell'ordine non può essere nel passato")
    private LocalDateTime orderDate;

    @NotBlank(message = "Il nome del cliente non può essere vuoto")
    private String costumerName;

    @NotBlank(message = "L'email non può essere vuota")
    @Email(message = "Inserire un indirizzo email valido")
    private String email;
}
