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
        // Domanda 1 (iniziale)
        Question q1 = new Question();
        q1.setText("Preferisci caldo o freddo?");
        questionRepository.save(q1);

// Domanda 2A (se l'utente sceglie CALDO)
        Question q2A = new Question();
        q2A.setText("Preferisci un drink speziato o erbaceo?");
        questionRepository.save(q2A);

// Domanda 3A (se l'utente sceglie SPEZIATO da CALDO)
        Question q3A = new Question();
        q3A.setText("Preferisci alcolico o analcolico?");
        questionRepository.save(q3A);

// Domanda 2B (se l'utente sceglie FREDDO)
        Question q2B = new Question();
        q2B.setText("Preferisci dolce o amaro?");
        questionRepository.save(q2B);

// Domanda 3B (se l'utente sceglie DOLCE da FREDDO)
        Question q3B = new Question();
        q3B.setText("Preferisci un cocktail fruttato o cremoso?");
        questionRepository.save(q3B);

// Drink finali
        Drink drink1 = new Drink();
        drink1.setName("Hot Toddy");
        drink1.setDescription("Un cocktail caldo con whiskey e spezie.");
        drinkRepository.save(drink1);

        Drink drink2 = new Drink();
        drink2.setName("Vin Brulé");
        drink2.setDescription("Vino caldo speziato con cannella e agrumi.");
        drinkRepository.save(drink2);

        Drink drink3 = new Drink();
        drink3.setName("Mojito");
        drink3.setDescription("Un cocktail rinfrescante a base di rum e menta.");
        drinkRepository.save(drink3);

        Drink drink4 = new Drink();
        drink4.setName("Piña Colada");
        drink4.setDescription("Un cocktail tropicale cremoso con ananas e cocco.");
        drinkRepository.save(drink4);

        Drink drink5 = new Drink();
        drink5.setName("Spritz");
        drink5.setDescription("Un cocktail amaro e rinfrescante con Aperol e prosecco.");
        drinkRepository.save(drink5);

        Drink drink6 = new Drink();
        drink6.setName("Tisana Zen");
        drink6.setDescription("Un infuso caldo di erbe rilassanti.");
        drinkRepository.save(drink6);

        Drink drink7 = new Drink();
        drink7.setName("Smoothie Tropicale");
        drink7.setDescription("Un frullato analcolico con mango, ananas e latte di cocco.");
        drinkRepository.save(drink7);

// Risposte alla domanda 1
        Answer a1 = new Answer();
        a1.setText("Caldo");
        a1.setQuestion(q1);
        a1.setNextQuestion(q2A);
        answerRepository.save(a1);

        Answer a2 = new Answer();
        a2.setText("Freddo");
        a2.setQuestion(q1);
        a2.setNextQuestion(q2B);
        answerRepository.save(a2);

// Risposte alla domanda 2A (percorso CALDO)
        Answer a3 = new Answer();
        a3.setText("Speziato");
        a3.setQuestion(q2A);
        a3.setNextQuestion(q3A);
        answerRepository.save(a3);

        Answer a4 = new Answer();
        a4.setText("Erbaceo");
        a4.setQuestion(q2A);
        a4.setFinalDrink(drink6);
        answerRepository.save(a4);

// Risposte alla domanda 3A (percorso SPEZIATO da CALDO)
        Answer a5 = new Answer();
        a5.setText("Alcolico");
        a5.setQuestion(q3A);
        a5.setFinalDrink(drink2);
        answerRepository.save(a5);

        Answer a6 = new Answer();
        a6.setText("Analcolico");
        a6.setQuestion(q3A);
        a6.setFinalDrink(drink7);
        answerRepository.save(a6);

// Risposte alla domanda 2B (percorso FREDDO)
        Answer a7 = new Answer();
        a7.setText("Dolce");
        a7.setQuestion(q2B);
        a7.setNextQuestion(q3B);
        answerRepository.save(a7);

        Answer a8 = new Answer();
        a8.setText("Amaro");
        a8.setQuestion(q2B);
        a8.setFinalDrink(drink5);
        answerRepository.save(a8);

// Risposte alla domanda 3B (percorso DOLCE da FREDDO)
        Answer a9 = new Answer();
        a9.setText("Fruttato");
        a9.setQuestion(q3B);
        a9.setFinalDrink(drink3);
        answerRepository.save(a9);

        Answer a10 = new Answer();
        a10.setText("Cremoso");
        a10.setQuestion(q3B);
        a10.setFinalDrink(drink4);
        answerRepository.save(a10);
    }
}