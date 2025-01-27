package it.epicode.Capstone.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderItemRequest {
    @Min(value = 1, message = "La quantità deve essere almeno 1")
    private int quantity;

    @Positive(message = "Il subtotale deve essere un valore positivo")
    private double subtotal;

    @NotNull(message = "L'id della posizione nel menu non può essere vuoto")
    private Long menuItemId;
}
