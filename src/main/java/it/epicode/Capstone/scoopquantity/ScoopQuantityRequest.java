package it.epicode.Capstone.scoopquantity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ScoopQuantityRequest {
    @Min(value = 1, message = "Il numero di palline non può essere minore di 1")
    private int numberOfScoops;

    @NotNull(message = "Deve contenere almeno un gusto")
    private Long flavourId;
}
