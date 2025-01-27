package it.epicode.Capstone.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class MenuItemRequest {
    @NotBlank(message = "Il nome non può essere vuoto")
    private String name;

    @NotBlank(message = "La categoria non può essere vuota")
    private String category;

    @Positive(message = "Il prezzo deve essere un valore positivo")
    private double price;

    private String description;
}
