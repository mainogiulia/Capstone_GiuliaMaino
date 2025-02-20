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
        q1.setText("Preferisci:");
        questionRepository.save(q1);

        // Domanda q2A (CALDO)
        Question q2A = new Question();
        q2A.setText("Alcolico o analcolico?");
        questionRepository.save(q2A);

        // Domanda q2B (FREDDO)
        Question q2B = new Question();
        q2B.setText("Possiamo scegliere tra quattro livelli:");
        questionRepository.save(q2B);

        // Domanda q3A (ALCOLICO)
        Question q3A = new Question();
        q3A.setText("Ottimo, preferisci:");
        questionRepository.save(q3A);

        // Domanda q3B (ANALCOLICO)
        Question q3B = new Question();
        q3B.setText("Perfetto, preferisci:");
        questionRepository.save(q3B);

        // Domanda q3C (MOLTO ALCOLICO)
        Question q3C = new Question();
        q3C.setText("Perfetto, scegliamo la base:");
        questionRepository.save(q3C);

        // Domanda q3D (MEDIAMENTE ALCOLICO)
        Question q3D = new Question();
        q3D.setText("Bene, che gusto preferisci?");
        questionRepository.save(q3D);

        // Domanda q3E (POCO ALCOLICO)
        Question q3E = new Question();
        q3E.setText("Ottimo, ecco le opzioni:");
        questionRepository.save(q3E);

        // Domanda q3F (ANALCOLICO)
        Question q3F = new Question();
        q3F.setText("Perfetto, preferisci:");
        questionRepository.save(q3F);

        // Drink finali
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

        // Risposte alla domanda q2A (CALDO)
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

        // Risposte alla domanda q2B (FREDDO)
        Answer a2C = new Answer();
        a2C.setText("Molto alcolico");
        a2C.setQuestion(q2B);
        a2C.setNextQuestion(q3C);
        answerRepository.save(a2C);

        Answer a2D = new Answer();
        a2D.setText("Mediamente alcolico");
        a2D.setQuestion(q2B);
        a2D.setNextQuestion(q3D);
        answerRepository.save(a2D);

        Answer a2E = new Answer();
        a2E.setText("Poco alcolico");
        a2E.setQuestion(q2B);
        a2E.setNextQuestion(q3E);
        answerRepository.save(a2E);

        Answer a2F = new Answer();
        a2F.setText("Analcolico");
        a2F.setQuestion(q2B);
        a2F.setNextQuestion(q3F);
        answerRepository.save(a2F);

        // Risposte alla domanda q3A (ALCOLICO)
        Answer a3T = new Answer();
        a3T.setText("Grog");
        a3T.setQuestion(q3A);
        a3T.setNextQuestion(q4T);
        answerRepository.save(a3T);

        Answer a3U = new Answer();
        a3U.setText("Hot Cream");
        a3U.setQuestion(q3A);
        a3U.setNextQuestion(q4U);
        answerRepository.save(a3U);

        Answer a3V = new Answer();
        a3V.setText("Hot Fruit");
        a3V.setQuestion(q3A);
        a3V.setNextQuestion(q4V);
        answerRepository.save(a3V);

        Answer a3W = new Answer();
        a3W.setText("Hot Coffee");
        a3W.setQuestion(q3A);
        a3W.setNextQuestion(q4W);
        answerRepository.save(a3W);

        Answer a3X = new Answer();
        a3X.setText("Brulè");
        a3X.setQuestion(q3A);
        a3X.setNextQuestion(q4X);
        answerRepository.save(a3X);

        // Risposte alla domanda q3B (ANALCOLICO)
        Answer a3Y = new Answer();
        a3Y.setText("Decotto");
        a3Y.setQuestion(q3B);
        a3Y.setNextQuestion(q4Y);
        answerRepository.save(a3Y);

        Answer a3Z = new Answer();
        a3Z.setText("Infusi");
        a3Z.setQuestion(q3B);
        a3Z.setNextQuestion(q4Z);
        answerRepository.save(a3Z);

        Answer a3aa = new Answer();
        a3aa.setText("Sapore di latte");
        a3aa.setQuestion(q3B);
        a3aa.setNextQuestion(q4aa);
        answerRepository.save(a3aa);

        Answer a3bb = new Answer();
        a3bb.setText("Cacao Cult");
        a3bb.setQuestion(q3B);
        a3bb.setNextQuestion(q4bb);
        answerRepository.save(a3bb);

        // Risposte alla domanda q3C (MOLTO ALCOLICO)
        Answer a3A = new Answer();
        a3A.setText("Bourbon");
        a3A.setQuestion(q3C);
        a3A.setNextQuestion(q4A);
        answerRepository.save(a3A);

        Answer a3B = new Answer();
        a3B.setText("Brandy");
        a3B.setQuestion(q3C);
        a3B.setNextQuestion(q4B);
        answerRepository.save(a3B);

        Answer a3C = new Answer();
        a3C.setText("Gin");
        a3C.setQuestion(q3C);
        a3C.setNextQuestion(q4C);
        answerRepository.save(a3C);

        Answer a3D = new Answer();
        a3D.setText("Rum");
        a3D.setQuestion(q3C);
        a3D.setNextQuestion(q4D);
        answerRepository.save(a3D);

        Answer a3E = new Answer();
        a3E.setText("Scotch");
        a3E.setQuestion(q3C);
        a3E.setNextQuestion(q4E);
        answerRepository.save(a3E);

        Answer a3F = new Answer();
        a3F.setText("Tequila");
        a3F.setQuestion(q3C);
        a3F.setNextQuestion(q4F);
        answerRepository.save(a3F);

        Answer a3G = new Answer();
        a3G.setText("Vodka");
        a3G.setQuestion(q3C);
        a3G.setNextQuestion(q4G);
        answerRepository.save(a3G);

        Answer a3H = new Answer();
        a3H.setText("Long Island");
        a3H.setQuestion(q3C);
        a3H.setNextQuestion(q4H);
        answerRepository.save(a3H);

        // Risposte alla domanda q3D (MEDIAMENTE ALCOLICO)
        Answer a3I = new Answer();
        a3I.setText("Aspro");
        a3I.setQuestion(q3D);
        a3I.setNextQuestion(q4I);
        answerRepository.save(a3I);

        Answer a3J = new Answer();
        a3J.setText("Dolce acidulo");
        a3J.setQuestion(q3D);
        a3J.setNextQuestion(q4J);
        answerRepository.save(a3J);

        Answer a3K = new Answer();
        a3K.setText("Fruttato");
        a3K.setQuestion(q3D);
        a3K.setNextQuestion(q4K);
        answerRepository.save(a3K);

        Answer a3L = new Answer();
        a3L.setText("Cremoso");
        a3L.setQuestion(q3D);
        a3L.setNextQuestion(q4L);
        answerRepository.save(a3L);

        Answer a3M = new Answer();
        a3M.setText("Caffè");
        a3M.setQuestion(q3D);
        a3M.setNextQuestion(q4M);
        answerRepository.save(a3M);

        Answer a3N = new Answer();
        a3N.setText("Riduzione alcolica");
        a3N.setQuestion(q3D);
        a3N.setNextQuestion(q4N);
        answerRepository.save(a3N);

        // Risposte alla domanda q3E (POCO ALCOLICO)
        Answer a3O = new Answer();
        a3O.setText("Frutta");
        a3O.setQuestion(q3E);
        a3O.setNextQuestion(q4O);
        answerRepository.save(a3O);

        Answer a3P = new Answer();
        a3P.setText("Soda");
        a3P.setQuestion(q3E);
        a3P.setNextQuestion(q4P);
        answerRepository.save(a3P);

        // Risposte alla domanda q3F (ANALCOLICO)
        Answer a3Q = new Answer();
        a3Q.setText("Frutta");
        a3Q.setQuestion(q3F);
        a3Q.setNextQuestion(q4Q);
        answerRepository.save(a3Q);

        Answer a3R = new Answer();
        a3R.setText("Soda");
        a3R.setQuestion(q3F);
        a3R.setNextQuestion(q4R);
        answerRepository.save(a3R);

        Answer a3S = new Answer();
        a3S.setText("Gelato");
        a3S.setQuestion(q3F);
        a3S.setNextQuestion(q4S);
        answerRepository.save(a3S);
    }
}