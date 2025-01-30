package it.epicode.Capstone.questionnaire.drink;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrinkRequest {
    private String name;
    private String description;
}
