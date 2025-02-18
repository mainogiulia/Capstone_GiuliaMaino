package it.epicode.Capstone.questionnaire;

import it.epicode.Capstone.questionnaire.answer.Answer;
import it.epicode.Capstone.questionnaire.answer.AnswerRepository;
import it.epicode.Capstone.questionnaire.drink.Drink;
import it.epicode.Capstone.questionnaire.drink.DrinkRepository;
import it.epicode.Capstone.questionnaire.question.Question;
import it.epicode.Capstone.questionnaire.question.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final DrinkRepository drinkRepository;

    @Override
    public void run(String... args) throws Exception {
        // Domanda q1 (iniziale)
        Question q1 = new Question();
        q1.setText("Caldo o freddo?");
        questionRepository.save(q1);

// Domanda q2A (se l'utente sceglie CALDO alla domanda q1)
        Question q2A = new Question();
        q2A.setText("Alcolico o analcolico??");
        questionRepository.save(q2A);

// Domanda q2B (se l'utente sceglie FREDDO alla domanda q1)
        Question q2B = new Question();
        q2B.setText("Tanto alcool, medio, poco o niente?");
        questionRepository.save(q2B);


/*// Drink finali
        Drink drink1 = new Drink();
        drink1.setName("Hot Toddy");
        drink1.setDescription("Un cocktail caldo con whiskey e spezie.");
        drinkRepository.save(drink1);

// Risposte alla domanda q1
        Answer a1A = new Answer();
        a1A.setText("Caldo");
        a1A.setQuestion(q1);
        a1A.setNextQuestion(q2A);
        answerRepository.save(a1A);

        Answer a1B = new Answer();
        a1B.setText("Freddo");
        a1B.setQuestion(q1);
        a1B.setNextQuestion(q2B);
        answerRepository.save(a1B);

// Risposte alla domanda q2A (percorso CALDO)
        Answer a2A = new Answer();
        a2A.setText("Alcolico");
        a2A.setQuestion(q2A);
        a2A.setNextQuestion(q3A);
        answerRepository.save(a2A);

        Answer a2B = new Answer();
        a2B.setText("Analcolico");
        a2B.setQuestion(q2A);
        a2B.setNextQuestion(q3B);
        answerRepository.save(a2B);

// Risposte alla domanda q2B (percorso FREDDO)
        Answer a2C = new Answer();
        a2C.setText("Tanto");
        a2C.setQuestion(q2B);
        a2C.setNextQuestion(q3C);
        answerRepository.save(a2C);

        Answer a2D = new Answer();
        a2D.setText("Poco");
        a2D.setQuestion(q2B);
        a2D.setNextQuestion(q3D);
        answerRepository.save(a2D);

        Answer a2E = new Answer();
        a2E.setText("Medio");
        a2E.setQuestion(q2B);
        a2E.setNextQuestion(q3E);
        answerRepository.save(a2E);

        Answer a2F = new Answer();
        a2F.setText("No alcool");
        a2F.setQuestion(q2B);
        a2F.setNextQuestion(q3F);
        answerRepository.save(a2F);
    }*/
    }
}