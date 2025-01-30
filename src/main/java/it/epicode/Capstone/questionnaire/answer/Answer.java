package it.epicode.Capstone.questionnaire.answer;

import it.epicode.Capstone.questionnaire.drink.Drink;
import it.epicode.Capstone.questionnaire.question.Question;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    private Question question;

    @ManyToOne
    private Question nextQuestion;

    @ManyToOne
    private Drink finalDrink;
}