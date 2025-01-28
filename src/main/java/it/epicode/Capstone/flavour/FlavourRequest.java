package it.epicode.Capstone.flavour;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FlavourRequest {
    @NotBlank(message = "Il nome del gusto non può essere vuoto")
    private String name;

    private String description;
}
