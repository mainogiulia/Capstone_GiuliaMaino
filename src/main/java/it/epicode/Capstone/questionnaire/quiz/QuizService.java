package it.epicode.Capstone.questionnaire.quiz;

import it.epicode.Capstone.questionnaire.answer.Answer;
import it.epicode.Capstone.questionnaire.answer.AnswerRepository;
import it.epicode.Capstone.questionnaire.answer.AnswerRequest;
import it.epicode.Capstone.questionnaire.drink.Drink;
import it.epicode.Capstone.questionnaire.drink.DrinkRequest;
import it.epicode.Capstone.questionnaire.question.Question;
import it.epicode.Capstone.questionnaire.question.QuestionRepository;
import it.epicode.Capstone.questionnaire.question.QuestionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public QuestionRequest getFirstQuestion() {
        Question question = questionRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Domanda iniziale non trovata"));

        return convertToRequest(question); // convertToRequest CONVERTE ENTITA' IN DTO IN MODO CONTROLLATO
    }

    public Object getNextStep(Long answerId) {
        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> new RuntimeException("Risposta non trovata"));

        if (answer.getNextQuestion() != null) {
            return convertToRequest(answer.getNextQuestion());
        } else {
            return convertToDrinkRequest(answer.getFinalDrink());
        }
    }

    private QuestionRequest convertToRequest(Question question) {
        List<AnswerRequest> answerRequests = question.getAnswers().stream()
                .map(a -> new AnswerRequest(a.getId(), a.getText())) // MAP TRASFORMA OGNI OGGETTO DELLO STREAM. POI PER OGNI OGGETTO Answer(A) VIENE CREATO UN NUOVO AnswerRequest CHE CONTIENE SOLO IL TESTO DELLA RISPOSTA
                .collect(Collectors.toList()); // CONVERTE LO Stream<AnswerRequest> IN UNA List<AnswerRequest>.

        return new QuestionRequest(question.getText(), answerRequests); // CREIAMO UN OGGETTO QuestionRequest PASSANDO IL TESTO DELLA DOMANDA E LA LISTA DI RISPOSTE CONVERTITE
    }

    private DrinkRequest convertToDrinkRequest(Drink drink) {
        return new DrinkRequest(drink.getName(), drink.getDescription());
    }
}