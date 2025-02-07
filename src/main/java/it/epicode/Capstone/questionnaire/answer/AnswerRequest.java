package it.epicode.Capstone.questionnaire.answer;

import it.epicode.Capstone.questionnaire.drink.Drink;
import it.epicode.Capstone.questionnaire.question.Question;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerRequest {
    @NotNull(message = "L'ID della risposta non può essere nullo")
    private Long id;
    @NotEmpty(message = "La risposta non può essere vuota")
    private String text;
}
