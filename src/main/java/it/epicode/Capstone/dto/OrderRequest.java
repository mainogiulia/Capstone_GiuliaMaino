package it.epicode.Capstone.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderRequest {
    @Positive(message = "L'importo totale deve essere positivo")
    private double totalAmount;

    @NotNull(message = "La data dell'ordine non può essere vuota")
    @FutureOrPresent(message = "La data dell'ordine non può essere nel passato")
    private LocalDateTime orderDate;

    @NotBlank(message = "L'indirizzo di consegna non può essere vuoto")
    private String deliveryAddress;

    @NotNull(message = "L'ID del cliente non può essere vuoto")
    private Long costumerId;

    @NotEmpty(message = "L'ordine deve contenere almeno un elemento")
    private List<OrderItemRequest> items;
}
