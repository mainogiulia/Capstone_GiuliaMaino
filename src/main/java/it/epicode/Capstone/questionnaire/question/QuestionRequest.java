package it.epicode.Capstone.questionnaire.question;

import it.epicode.Capstone.questionnaire.answer.AnswerRequest;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequest {
    @NotEmpty(message = "La domanda non può essere vuota")
    private String text;
    @NotEmpty(message = "La domanda deve contenere almeno una risposta")
    private List<AnswerRequest> answers;
}
