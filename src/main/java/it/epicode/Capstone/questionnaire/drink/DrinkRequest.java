package it.epicode.Capstone.questionnaire.drink;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrinkRequest {
    @NotEmpty(message = "Il nome non può essere vuoto")
    private String name;
    private String description;
}
