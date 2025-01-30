package it.epicode.Capstone.questionnaire.quiz;

import it.epicode.Capstone.questionnaire.question.QuestionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/start")
    public ResponseEntity<QuestionRequest> startQuiz() {
        return ResponseEntity.ok(quizService.getFirstQuestion());
    }

    @GetMapping("/next/{answerId}")
    public ResponseEntity<Object> nextStep(@PathVariable Long answerId) {
        return ResponseEntity.ok(quizService.getNextStep(answerId));
    }
}