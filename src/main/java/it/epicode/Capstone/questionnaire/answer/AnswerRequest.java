package it.epicode.Capstone.questionnaire.answer;

import it.epicode.Capstone.questionnaire.drink.Drink;
import it.epicode.Capstone.questionnaire.question.Question;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerRequest {
    private String text;
}
