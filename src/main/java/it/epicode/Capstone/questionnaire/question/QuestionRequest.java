package it.epicode.Capstone.questionnaire.question;

import it.epicode.Capstone.questionnaire.answer.AnswerRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequest {
    private String text;
    private List<AnswerRequest> answers;
}
