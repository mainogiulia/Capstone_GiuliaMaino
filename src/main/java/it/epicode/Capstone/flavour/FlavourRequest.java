package it.epicode.Capstone.flavour;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FlavourRequest {
    @NotNull(message = "L'ID del gusto non può essere nullo")
    private Long id;

    @NotBlank(message = "Il nome del gusto non può essere vuoto")
    private String name;

    private String description;
}
