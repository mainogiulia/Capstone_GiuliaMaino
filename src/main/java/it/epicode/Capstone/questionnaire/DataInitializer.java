package it.epicode.Capstone.questionnaire;

import it.epicode.Capstone.questionnaire.answer.Answer;
import it.epicode.Capstone.questionnaire.answer.AnswerRepository;
import it.epicode.Capstone.questionnaire.drink.Drink;
import it.epicode.Capstone.questionnaire.drink.DrinkRepository;
import it.epicode.Capstone.questionnaire.question.Question;
import it.epicode.Capstone.questionnaire.question.QuestionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Transactional
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

        // Domanda q4A (BOURBON)
        Question q4A = new Question();
        q4A.setText("Ottimo, ecco le opzioni:");
        questionRepository.save(q4A);

        // Domanda q4B (BRANDY)
        Question q4B = new Question();
        q4B.setText("Ottimo, ecco le opzioni:");
        questionRepository.save(q4B);

        // Domanda q4C (GIN)
        Question q4C = new Question();
        q4C.setText("Ottimo, ecco le opzioni:");
        questionRepository.save(q4C);

        // Domanda q4D (RUM)
        Question q4D = new Question();
        q4D.setText("Ottimo, che tipo di rum?");
        questionRepository.save(q4D);

        // Domanda q4E (SCOTCH)
        Question q4E = new Question();
        q4E.setText("Ottimo, ecco le opzioni:");
        questionRepository.save(q4E);

        // Domanda q4F (TEQUILA)
        Question q4F = new Question();
        q4F.setText("Ottimo, ecco le opzioni:");
        questionRepository.save(q4F);

        // Domanda q4G (VODKA)
        Question q4G = new Question();
        q4G.setText("Ottimo, ecco le opzioni:");
        questionRepository.save(q4G);

        // Domanda q4H (LONG ISLAND)
        Question q4H = new Question();
        q4H.setText("Ottimo, ecco le opzioni:");
        questionRepository.save(q4H);

        // Domanda q4I (ASPRO)
        Question q4I = new Question();
        q4I.setText("Ti proponiamo un sour:");
        questionRepository.save(q4I);

        // Domanda q4J (DOLCE ACIDULO)
        Question q4J = new Question();
        q4J.setText("Ti proponiamo un pestato al lime, al sapore di:");
        questionRepository.save(q4J);

        // Domanda q4K (FRUTTATO)
        Question q4K = new Question();
        q4K.setText("Ti proponiamo:");
        questionRepository.save(q4K);

        // Domanda q4L (CREMOSO)
        Question q4L = new Question();
        q4L.setText("Ti proponiamo:");
        questionRepository.save(q4L);

        // Domanda q4M (CAFFE')
        Question q4M = new Question();
        q4M.setText("Ti proponiamo:");
        questionRepository.save(q4M);

        // Domanda q4N (RIDUZIONE ALCOLICA)
        Question q4N = new Question();
        q4N.setText("Molto bene, scegliamo la base:");
        questionRepository.save(q4N);

        // Domanda q4O (FRUTTA)
        Question q4O = new Question();
        q4O.setText("Molto bene, ecco le opzioni:");
        questionRepository.save(q4O);

        // Domanda q4P (SODA)
        Question q4P = new Question();
        q4P.setText("Molto bene, ecco le opzioni:");
        questionRepository.save(q4P);

        // Domanda q4Q (FRUTTA)
        Question q4Q = new Question();
        q4Q.setText("Molto bene, ecco le opzioni:");
        questionRepository.save(q4Q);

        // Domanda q4R (SODA)
        Question q4R = new Question();
        q4R.setText("Molto bene, ecco le opzioni:");
        questionRepository.save(q4R);

        // Domanda q4S (GELATO)
        Question q4S = new Question();
        q4S.setText("Molto bene, ti proponiamo:");
        questionRepository.save(q4S);

        // Domanda q4T (GROG)
        Question q4T = new Question();
        q4T.setText("Molto bene, eccole opzioni:");
        questionRepository.save(q4T);

        // Domanda q4U (HOT CREAM)
        Question q4U = new Question();
        q4U.setText("Molto bene, eccole opzioni:");
        questionRepository.save(q4U);

        // Domanda q4V (HOT FRUIT)
        Question q4V = new Question();
        q4V.setText("Molto bene, eccole opzioni:");
        questionRepository.save(q4V);

        // Domanda q4W (HOT COFFEE)
        Question q4W = new Question();
        q4W.setText("Molto bene, eccole opzioni:");
        questionRepository.save(q4W);

        // Domanda q4X (BRULE')
        Question q4X = new Question();
        q4X.setText("Molto bene, eccole opzioni:");
        questionRepository.save(q4X);

        // Domanda q4Y (DECOTTO)
        Question q4Y = new Question();
        q4Y.setText("Molto bene, eccole opzioni:");
        questionRepository.save(q4Y);

        // Domanda q4Z (INFUSI)
        Question q4Z = new Question();
        q4Z.setText("Molto bene, eccole opzioni:");
        questionRepository.save(q4Z);

        // Domanda q4aa (SAPORE DI LATTE)
        Question q4aa = new Question();
        q4aa.setText("Molto bene, eccole opzioni:");
        questionRepository.save(q4aa);

        // Domanda q4bb (CACAO CULT)
        Question q4bb = new Question();
        q4bb.setText("Molto bene, eccole opzioni:");
        questionRepository.save(q4bb);

        // Domanda q5A (COCKTAIL MARTINI)
        Question q5A = new Question();
        q5A.setText("Classico o variazione?");
        questionRepository.save(q5A);

        // Domanda q5B (NEGRONI)
        Question q5B = new Question();
        q5B.setText("Classico o variazione?");
        questionRepository.save(q5B);

        // Domanda q5E (BOURBON SOUR)
        Question q5E = new Question();
        q5E.setText("Al naturale o con profumo di:");
        questionRepository.save(q5E);

        // Domanda q5C (BOURBON SOUR)
        Question q5C = new Question();
        q5C.setText("Al naturale o con profumo di:");
        questionRepository.save(q5C);

        // Domanda q5D (BOURBON SOUR)
        Question q5D = new Question();
        q5D.setText("Con profumo di:");
        questionRepository.save(q5D);

        // Domanda q5F (BOURBON SOUR)
        Question q5F = new Question();
        q5F.setText("Con profumo di:");
        questionRepository.save(q5F);

        // Domanda q5G (BOURBON SOUR)
        Question q5G = new Question();
        q5G.setText("Al naturale o con profumo di:");
        questionRepository.save(q5G);

        // Domanda q5H (MOSCOW MULE)
        Question q5H = new Question();
        q5H.setText("Classico o variazione?");
        questionRepository.save(q5H);

        // Domanda q5I (MANGO)
        Question q5I = new Question();
        q5I.setText("Con profumo di:");
        questionRepository.save(q5I);

        // Domanda q5J (FRAGOLA)
        Question q5J = new Question();
        q5J.setText("Con profumo di:");
        questionRepository.save(q5J);

        // Domanda q5K (LAMPONE)
        Question q5K = new Question();
        q5K.setText("Con profumo di:");
        questionRepository.save(q5K);

        // Domanda q5L (POMPELMO)
        Question q5L = new Question();
        q5L.setText("Con profumo di:");
        questionRepository.save(q5L);

        // Domanda q5N (FRUTTA FRESCA)
        Question q5N = new Question();
        q5N.setText("Ottimo, ora scegliamo il gelato:");
        questionRepository.save(q5N);

        // Domanda q5O (LATTE DI MANDORLA)
        Question q5O = new Question();
        q5O.setText("Ottimo, ora scegliamo il gelato:");
        questionRepository.save(q5O);

        // Domanda q5M (WHISKEY)
        Question q5M = new Question();
        q5M.setText("Con profumo di:");
        questionRepository.save(q5M);

        // Drink alla domanda q4A
        Drink dA1 = new Drink();
        dA1.setName("Old Fashion");
        drinkRepository.save(dA1);

        Drink dA2 = new Drink();
        dA2.setName("Old Pal");
        drinkRepository.save(dA2);

        Drink dA3 = new Drink();
        dA3.setName("Boulevardier");
        drinkRepository.save(dA3);

        Drink dA4 = new Drink();
        dA4.setName("Manhattan");
        drinkRepository.save(dA4);

        Drink dA5 = new Drink();
        dA5.setName("Bobby Burns");
        drinkRepository.save(dA5);

        // Drink alla domanda q4B (BRANDY)
        Drink dB1 = new Drink();
        dB1.setName("Stinger");
        drinkRepository.save(dB1);

        // Drink alla domanda q4C
        Drink dC1 = new Drink();
        dC1.setName("Brumble");
        drinkRepository.save(dC1);

        Drink dC2 = new Drink();
        dC2.setName("Bee's Knees");
        drinkRepository.save(dC2);

        Drink dC3 = new Drink();
        dC3.setName("Tom Collins");
        drinkRepository.save(dC3);

        // Drink alla domanda q5A
        Drink d5A1 = new Drink();
        d5A1.setName("Cocktail Martini");
        drinkRepository.save(d5A1);

        Drink d5A2 = new Drink();
        d5A2.setName("Dirty Martini");
        drinkRepository.save(d5A2);

        // Drink alla domanda q5B
        Drink d5B1 = new Drink();
        d5B1.setName("Negroni");
        drinkRepository.save(d5B1);

        Drink d5B2 = new Drink();
        d5B2.setName("Negroni Sbagliato");
        drinkRepository.save(d5B2);

        // Drink alla domanda q4D
        Drink d5D1 = new Drink();
        d5D1.setName("Daiquiri (con rum chiaro)");
        drinkRepository.save(d5D1);

        Drink d5D2 = new Drink();
        d5D2.setName("Daiquiri (con rum scuro)");

        drinkRepository.save(d5D2);

        // Drink alla domanda q4E
        Drink dE1 = new Drink();
        dE1.setName("God Father");

        drinkRepository.save(dE1);

        Drink dE2 = new Drink();
        dE2.setName("Rusting Ale");

        drinkRepository.save(dE2);

        Drink dE3 = new Drink();
        dE3.setName("Pennicillin");

        drinkRepository.save(dE3);

        // Drink alla domanda q4F
        Drink dF1 = new Drink();
        dF1.setName("Margarita");

        drinkRepository.save(dF1);

        Drink dF2 = new Drink();
        dF2.setName("Tommy's Margarita");

        drinkRepository.save(dF2);

        // Drink alla domanda q4G
        Drink dG1 = new Drink();
        dG1.setName("Black Russian");

        drinkRepository.save(dG1);

        Drink dG2 = new Drink();
        dG2.setName("White Russian");
        drinkRepository.save(dG2);

        Drink dG3 = new Drink();
        dG3.setName("God Mother");
        drinkRepository.save(dG3);

        Drink dG4 = new Drink();
        dG4.setName("Blue Lagoon");
        drinkRepository.save(dG4);

        // Drink alla domanda q4I
        Drink dI2 = new Drink();
        dI2.setName("Pisco Sour");
        drinkRepository.save(dI2);

        Drink dI3 = new Drink();
        dI3.setName("Midori Sour");
        drinkRepository.save(dI3);

        Drink dI4 = new Drink();
        dI4.setName("Clover Club");
        drinkRepository.save(dI4);

        Drink dI5 = new Drink();
        dI5.setName("Gin Sour");
        drinkRepository.save(dI5);

        Drink dI6 = new Drink();
        dI6.setName("Vodka Sour");
        drinkRepository.save(dI6);

        // Drink alla domanda q5E
        Drink d5E1 = new Drink();
        d5E1.setName("Bourbon Sour con profumo di cannella");
        drinkRepository.save(d5E1);

        Drink d5E2 = new Drink();
        d5E2.setName("Bourbon Sour con profumo di basilico");
        drinkRepository.save(d5E2);

        Drink d5E3 = new Drink();
        d5E3.setName("Bourbon Club");
        drinkRepository.save(d5E3);

        // Drink alla domanda q4H
        Drink dH1 = new Drink();
        dH1.setName("Long Island Ice Tea");
        drinkRepository.save(dH1);

        Drink dH2 = new Drink();
        dH2.setName("Tokyo Ice Tea");
        drinkRepository.save(dH2);

        Drink dH3 = new Drink();
        dH3.setName("Texas Ice Tea");
        drinkRepository.save(dH3);

        Drink dH4 = new Drink();
        dH4.setName("Quattro Bianchi");
        drinkRepository.save(dH4);

        // Drink alla domanda q4J
        Drink dJ1 = new Drink();
        dJ1.setName("Pestato al lime con sapore di liquirizia");
        drinkRepository.save(dJ1);

        Drink dJ2 = new Drink();
        dJ2.setName("Pestato al lime con sapore di cannella");
        drinkRepository.save(dJ2);

        Drink dJ3 = new Drink();
        dJ3.setName("Pestato al lime con sapore di anice");
        drinkRepository.save(dJ3);

        Drink dJ4 = new Drink();
        dJ4.setName("Pestato al lime con sapore di sanbuco");
        drinkRepository.save(dJ4);

        Drink dJ5 = new Drink();
        dJ5.setName("Pestato al lime con sapore di passion fruit");
        drinkRepository.save(dJ5);

        Drink dJ6 = new Drink();
        dJ6.setName("Pestato al lime con sapore di mela verde");
        drinkRepository.save(dJ6);

        Drink dJ7 = new Drink();
        dJ7.setName("Pestato al lime con sapore di pesca");
        drinkRepository.save(dJ7);

        Drink dJ8 = new Drink();
        dJ8.setName("Pestato al lime con sapore di kiwi");
        drinkRepository.save(dJ8);

        Drink dJ9 = new Drink();
        dJ9.setName("Pestato al lime con sapore di lampone");
        drinkRepository.save(dJ9);

        Drink dJ10 = new Drink();
        dJ10.setName("Pestato al lime con sapore di fragola");
        drinkRepository.save(dJ10);

        Drink dJ11 = new Drink();
        dJ11.setName("Pestato al lime con sapore di kaipiroska");
        drinkRepository.save(dJ11);

        Drink dJ12 = new Drink();
        dJ12.setName("Pestato al lime con sapore di kaipirina");
        drinkRepository.save(dJ12);

        Drink dJ13 = new Drink();
        dJ13.setName("Pestato al lime con sapore di zenzero");
        drinkRepository.save(dJ13);

        // Drink alla domanda q4K
        Drink dK1 = new Drink();
        dK1.setName("Double Drink al passion fruit");
        drinkRepository.save(dK1);

        Drink dK2 = new Drink();
        dK2.setName("Double Drink al mirtillo");
        drinkRepository.save(dK2);

        Drink dK3 = new Drink();
        dK3.setName("Double Drink alla melagrana");
        drinkRepository.save(dK3);

        // Drink alla domanda q5C
        Drink d5C1 = new Drink();
        d5C1.setName("Double Drink all'ananas-passion");
        drinkRepository.save(d5C1);

        Drink d5C2 = new Drink();
        d5C2.setName("Double Drink all'ananas-cocco");
        drinkRepository.save(d5C2);

        Drink d5C3 = new Drink();
        d5C3.setName("Double Drink all'ananas");
        drinkRepository.save(d5C3);

        // Drink alla domanda q5D
        Drink d5D11 = new Drink();
        d5D11.setName("Double Drink al lampone-cocco");
        drinkRepository.save(d5D11);

        Drink d5D22 = new Drink();
        d5D22.setName("Double Drink al lampone-vaniglia");
        drinkRepository.save(d5D22);

        Drink d5D3 = new Drink();
        d5D3.setName("Double Drink al lampone-arancia");
        drinkRepository.save(d5D3);

        // Drink alla domanda q5F
        Drink d5F1 = new Drink();
        d5F1.setName("Double Drink al pompelmo-bitter");
        drinkRepository.save(d5F1);

        Drink d5F2 = new Drink();
        d5F2.setName("Double Drink al pompelmo-zenzero");
        drinkRepository.save(d5F2);

        // Drink alla domanda q5G
        Drink d5G1 = new Drink();
        d5G1.setName("Double Drink al cocco-menta");
        drinkRepository.save(d5G1);

        Drink d5G2 = new Drink();
        d5G2.setName("Double Drink al cocco");
        drinkRepository.save(d5G2);

        // Drink alla domanda q4L
        Drink dL1 = new Drink();
        dL1.setName("Double Drink alla vaniglia-mou");
        drinkRepository.save(dL1);

        Drink dL2 = new Drink();
        dL2.setName("Double Drink al cocco e lampone");
        drinkRepository.save(dL2);

        Drink dL3 = new Drink();
        dL3.setName("Alexander");
        drinkRepository.save(dL3);

        Drink dL4 = new Drink();
        dL4.setName("Grasshopper");
        drinkRepository.save(dL4);

        Drink dL5 = new Drink();
        dL5.setName("Double Drink all'anice e liquirizia");
        drinkRepository.save(dL5);

        Drink dL6 = new Drink();
        dL6.setName("Double Drink alla nocciola e caffè");
        drinkRepository.save(dL6);

        Drink dL7 = new Drink();
        dL7.setName("Double Drink alla nocciola e cacao");
        drinkRepository.save(dL7);

        Drink dL8 = new Drink();
        dL8.setName("Double Drink al caffè");
        drinkRepository.save(dL8);

        // Drink alla domanda q4M
        Drink dM1 = new Drink();
        dM1.setName("Double Drink al caffè-Disaronno");
        drinkRepository.save(dM1);

        Drink dM2 = new Drink();
        dM2.setName("Double Drink al caffè-vaniglia");
        drinkRepository.save(dM2);

        Drink dM3 = new Drink();
        dM3.setName("Espresso Martini");
        drinkRepository.save(dM3);

        // Drink alla domanda q4P
        Drink dP1 = new Drink();
        dP1.setName("Mojito");
        drinkRepository.save(dP1);

        Drink dP3 = new Drink();
        dP3.setName("Dark and Stormy");
        drinkRepository.save(dP3);

        Drink dP4 = new Drink();
        dP4.setName("Mint Julep");
        drinkRepository.save(dP4);

        Drink dP5 = new Drink();
        dP5.setName("Gin Fizz");
        drinkRepository.save(dP5);

        // Drink alla domanda q5H
        Drink d5H1 = new Drink();
        d5H1.setName("Moscow Mule");
        drinkRepository.save(d5H1);

        Drink d5H2 = new Drink();
        d5H2.setName("London Mule");
        drinkRepository.save(d5H2);

        Drink d5H3 = new Drink();
        d5H3.setName("Jamaican Mule");
        drinkRepository.save(d5H3);

        // Drink alla domanda q4O
        Drink dO1 = new Drink();
        dO1.setName("Pina Colada");
        drinkRepository.save(dO1);

        Drink dO2 = new Drink();
        dO2.setName("Long Drink all'ananas-passion");
        drinkRepository.save(dO2);

        Drink dO3 = new Drink();
        dO3.setName("Long Drink all'arancia");
        drinkRepository.save(dO3);

        Drink dO4 = new Drink();
        dO4.setName("Tequila Sunrise");
        drinkRepository.save(dO4);

        Drink dO5 = new Drink();
        dO5.setName("Sex on the Beach");
        drinkRepository.save(dO5);

        // Drink alla domanda q5I
        Drink d5I1 = new Drink();
        d5I1.setName("Long Drink al mango-pesca");
        drinkRepository.save(d5I1);

        Drink d5I2 = new Drink();
        d5I2.setName("Long Drink al mango-passion");
        drinkRepository.save(d5I2);

        // Drink alla domanda q5J
        Drink d5J1 = new Drink();
        d5J1.setName("Long Drink alla fragola-banana");
        drinkRepository.save(d5J1);

        Drink d5J2 = new Drink();
        d5J2.setName("Long Drink alla fragola-lampone");
        drinkRepository.save(d5J2);

        // Drink alla domanda q5K
        Drink d5K1 = new Drink();
        d5K1.setName("Long Drink al lampone-arancia");
        drinkRepository.save(d5K1);

        Drink d5K2 = new Drink();
        d5K2.setName("Long Drink al lampone-fragola");
        drinkRepository.save(d5K2);

        // Drink alla domanda q5L
        Drink d5L1 = new Drink();
        d5L1.setName("Long Drink al pompelmo-bitter");
        drinkRepository.save(d5L1);

        Drink d5L2 = new Drink();
        d5L2.setName("Long Drink al pompelmo-zenzero");
        drinkRepository.save(d5L2);

        // Drink alla domanda q4N
        Drink dN1 = new Drink();
        dN1.setName("Gimlet");
        drinkRepository.save(dN1);

        Drink dN2 = new Drink();
        dN2.setName("Erbaceo amaro");
        drinkRepository.save(dN2);

        Drink dN3 = new Drink();
        dN3.setName("Rum e menta");
        drinkRepository.save(dN3);

        // Drink alla domanda q5M
        Drink d5M1 = new Drink();
        d5M1.setName("Whiskey Vermouth");
        drinkRepository.save(d5M1);

        Drink d5M2 = new Drink();
        d5M2.setName("Whiskey Bitter");
        drinkRepository.save(d5M2);

        Drink d5M3 = new Drink();
        d5M3.setName("Whiskey Menta");
        drinkRepository.save(d5M3);

        Drink d5M4 = new Drink();
        d5M4.setName("Whiskey Agrumi");
        drinkRepository.save(d5M4);

        Drink d5M5 = new Drink();
        d5M5.setName("Whiskey Spezie");
        drinkRepository.save(d5M5);

        // Drink alla domanda q4Q
        Drink dQ1 = new Drink();
        dQ1.setName("Drink analcolico alla fragola-lime");
        drinkRepository.save(dQ1);

        Drink dQ2 = new Drink();
        dQ2.setName("Drink analcolico alla fragola-lampone");
        drinkRepository.save(dQ2);

        Drink dQ3 = new Drink();
        dQ3.setName("Drink analcolico al lampone-mirtillo");
        drinkRepository.save(dQ3);

        Drink dQ4 = new Drink();
        dQ4.setName("Drink analcolico al mango-lampone-lime");
        drinkRepository.save(dQ4);

        Drink dQ5 = new Drink();
        dQ5.setName("Drink analcolico al mango-passion");
        drinkRepository.save(dQ5);

        Drink dQ6 = new Drink();
        dQ6.setName("Drink analcolico all'ananas-cocco-lampone");
        drinkRepository.save(dQ6);

        Drink dQ7 = new Drink();
        dQ7.setName("Drink analcolico all'arancia-sorbetto alla mela-zenzero");
        drinkRepository.save(dQ7);

        Drink dQ8 = new Drink();
        dQ8.setName("Drink analcolico all'arancia-sorbetto alla mela-lime");
        drinkRepository.save(dQ8);

        Drink dQ9 = new Drink();
        dQ9.setName("Drink analcolico al pompelmo-sorbetto all'arancia-zenzero");
        drinkRepository.save(dQ9);

        Drink dQ10 = new Drink();
        dQ10.setName("Drink analcolico alla fragola-banana");
        drinkRepository.save(dQ10);

        Drink dQ11 = new Drink();
        dQ11.setName("Drink analcolico al lampone-banana");
        drinkRepository.save(dQ11);

        // Drink alla domanda q4R
        Drink dR1 = new Drink();
        dR1.setName("Virgin Mojito");
        drinkRepository.save(dR1);

        Drink dR2 = new Drink();
        dR2.setName("Zenzerata");
        drinkRepository.save(dR2);

        Drink dR3 = new Drink();
        dR3.setName("Bacco e Venere");
        drinkRepository.save(dR3);

        Drink dR4 = new Drink();
        dR4.setName("Maso Antico");
        drinkRepository.save(dR4);

        Drink dR5 = new Drink();
        dR5.setName("Sapore Delicato");
        drinkRepository.save(dR5);

        Drink dR6 = new Drink();
        dR6.setName("Disseta");
        drinkRepository.save(dR6);

        // Drink alla domanda q5N
        Drink d5N1 = new Drink();
        d5N1.setName("Marzapane al cocco");
        drinkRepository.save(d5N1);

        Drink d5N2 = new Drink();
        d5N2.setName("Marzapane al limone");
        drinkRepository.save(d5N2);

        Drink d5N3 = new Drink();
        d5N3.setName("Marzapane alla fragola");
        drinkRepository.save(d5N3);

        Drink d5N4 = new Drink();
        d5N4.setName("Marzapane al lampone");
        drinkRepository.save(d5N4);

        Drink d5N5 = new Drink();
        d5N5.setName("Marzapane alla mela");
        drinkRepository.save(d5N5);

        Drink d5N6 = new Drink();
        d5N6.setName("Marzapane all'arancia");
        drinkRepository.save(d5N6);

        // Drink alla domanda q5O
        Drink d5O1 = new Drink();
        d5O1.setName("Marzapane al cioccolato bianco");
        drinkRepository.save(d5O1);

        Drink d5O2 = new Drink();
        d5O2.setName("Marzapane al fondente e torba");
        drinkRepository.save(d5O2);

        Drink d5O3 = new Drink();
        d5O3.setName("Marzapane alla crema vaniglia");
        drinkRepository.save(d5O3);

        Drink d5O4 = new Drink();
        d5O4.setName("Marzapane al sale e pepe");
        drinkRepository.save(d5O4);

        Drink d5O5 = new Drink();
        d5O5.setName("Marzapane alla stracciatella");
        drinkRepository.save(d5O5);

        Drink d5O6 = new Drink();
        d5O6.setName("Marzapane alla nocciola");
        drinkRepository.save(d5O6);

        Drink d5O7 = new Drink();
        d5O7.setName("Marzapane alla mandorla");
        drinkRepository.save(d5O7);

        Drink d5O8 = new Drink();
        d5O8.setName("Marzapane al pistacchio");
        drinkRepository.save(d5O8);

        Drink d5O9 = new Drink();
        d5O9.setName("Marzapane al cioccolato");
        drinkRepository.save(d5O9);

        // Drink alla domanda q4T
        Drink dT1 = new Drink();
        dT1.setName("Grog alle spezie");
        drinkRepository.save(dT1);

        Drink dT2 = new Drink();
        dT2.setName("Grog ai fiori");
        drinkRepository.save(dT2);

        Drink dT3 = new Drink();
        dT3.setName("Grog alla frutta");
        drinkRepository.save(dT3);

        // Drink alla domanda q4U
        Drink dU1 = new Drink();
        dU1.setName("Hot Cream al pistacchio");
        drinkRepository.save(dU1);

        Drink dU2 = new Drink();
        dU2.setName("Hot Cream alla nocciola");
        drinkRepository.save(dU2);

        Drink dU3 = new Drink();
        dU3.setName("Hot Cream alla mandorla");
        drinkRepository.save(dU3);

        Drink dU4 = new Drink();
        dU4.setName("Hot Cream al mou");
        drinkRepository.save(dU4);

        Drink dU5 = new Drink();
        dU5.setName("Hot Cream al cioccolato");
        drinkRepository.save(dU5);

        // Drink alla domanda q4V
        Drink dV1 = new Drink();
        dV1.setName("Hot Fruit al mirtillo");
        drinkRepository.save(dV1);

        Drink dV2 = new Drink();
        dV2.setName("Hot Fruit all'arancia");
        drinkRepository.save(dV2);

        Drink dV3 = new Drink();
        dV3.setName("Hot Fruit alla mela");
        drinkRepository.save(dV3);

        // Drink alla domanda q4W
        Drink dW1 = new Drink();
        dW1.setName("Irish coffee");
        drinkRepository.save(dW1);

        // Drink alla domanda q4X
        Drink dX1 = new Drink();
        dX1.setName("Brulè con vino bianco");
        drinkRepository.save(dX1);

        Drink dX2 = new Drink();
        dX2.setName("Brulè con vino rosso");
        drinkRepository.save(dX2);

        // Drink alla domanda q4Y
        Drink dY1 = new Drink();
        dY1.setName("Decotto al cedro");
        drinkRepository.save(dY1);

        Drink dY2 = new Drink();
        dY2.setName("Decotto alla menta");
        drinkRepository.save(dY2);

        Drink dY3 = new Drink();
        dY3.setName("Decotto alla mela");
        drinkRepository.save(dY3);

        Drink dY4 = new Drink();
        dY4.setName("Decotto al mirtillo");
        drinkRepository.save(dY4);

        Drink dY5 = new Drink();
        dY5.setName("Decotto allo zenzero");
        drinkRepository.save(dY5);

        // Drink alla domanda q4Z
        Drink dZ1 = new Drink();
        dZ1.setName("Infuso digestivo");
        drinkRepository.save(dZ1);

        Drink dZ2 = new Drink();
        dZ2.setName("Infuso tropicale");
        drinkRepository.save(dZ2);

        Drink dZ3 = new Drink();
        dZ3.setName("Infuso alla frutta mista");
        drinkRepository.save(dZ3);

        Drink dZ4 = new Drink();
        dZ4.setName("Infuso al mango-pesca");
        drinkRepository.save(dZ4);

        Drink dZ5 = new Drink();
        dZ5.setName("Infuso ai fiori");
        drinkRepository.save(dZ5);

        Drink dZ6 = new Drink();
        dZ6.setName("Infuso speziato");
        drinkRepository.save(dZ6);

        Drink dZ7 = new Drink();
        dZ7.setName("Infuso erbaceo");

        drinkRepository.save(dZ7);

        // Drink alla domanda q4aa
        Drink daa1 = new Drink();
        daa1.setName("Sapore di latte al pistacchio");
        drinkRepository.save(daa1);

        Drink daa2 = new Drink();
        daa2.setName("Sapore di latte alla nocciola");
        drinkRepository.save(daa2);

        Drink daa3 = new Drink();
        daa3.setName("Sapore di latte alla mandorla");
        drinkRepository.save(daa3);

        Drink daa4 = new Drink();
        daa4.setName("Sapore di latte al mou");
        drinkRepository.save(daa4);

        Drink daa5 = new Drink();
        daa5.setName("Sapore di latte al cioccolato");
        drinkRepository.save(daa5);

        // Drink alla domanda q4bb
        Drink dbb1 = new Drink();
        dbb1.setName("Cacao Cult con gelato");
        drinkRepository.save(dbb1);

        Drink dbb2 = new Drink();
        dbb2.setName("Cacao Cult con frutta fresca");
        drinkRepository.save(dbb2);

        Drink dbb3 = new Drink();
        dbb3.setName("Cacao Cult con frutta secca");
        drinkRepository.save(dbb3);

        Drink dbb4 = new Drink();
        dbb4.setName("Cacao Cult con fave di cacao");
        drinkRepository.save(dbb4);

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
        a3T.setText("Grog (infuso)");
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
        a3bb.setText("Cacao Cult (mousse di cacao)");
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
        a3B.setFinalDrink(dB1);
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
        a3S.setText("Marzapane (sorbetto)");
        a3S.setQuestion(q3F);
        a3S.setNextQuestion(q4S);
        answerRepository.save(a3S);

        // Risposte alla domanda q4A (BOURBON)
        Answer a4A1 = new Answer();
        a4A1.setText("Old Fashion");
        a4A1.setQuestion(q4A);
        a4A1.setFinalDrink(dA1);
        answerRepository.save(a4A1);

        Answer a4A2 = new Answer();
        a4A2.setText("Old Pal");
        a4A2.setQuestion(q4A);
        a4A2.setFinalDrink(dA2);
        answerRepository.save(a4A2);

        Answer a4A3 = new Answer();
        a4A3.setText("Boulevardier");
        a4A3.setQuestion(q4A);
        a4A3.setFinalDrink(dA3);
        answerRepository.save(a4A3);

        Answer a4A4 = new Answer();
        a4A4.setText("Manhattan");
        a4A4.setQuestion(q4A);
        a4A4.setFinalDrink(dA4);
        answerRepository.save(a4A4);

        Answer a4A5 = new Answer();
        a4A5.setText("Bobby Burns");
        a4A5.setQuestion(q4A);
        a4A5.setFinalDrink(dA5);
        answerRepository.save(a4A5);

        // Risposte alla domanda q4C (GIN)
        Answer a4C1 = new Answer();
        a4C1.setText("Brumble");
        a4C1.setQuestion(q4C);
        a4C1.setFinalDrink(dC1);
        answerRepository.save(a4C1);

        Answer a4C2 = new Answer();
        a4C2.setText("Bee's Knees");
        a4C2.setQuestion(q4C);
        a4C2.setFinalDrink(dC2);
        answerRepository.save(a4C2);

        Answer a4C3 = new Answer();
        a4C3.setText("Cocktail Martini");
        a4C3.setQuestion(q4C);
        a4C3.setNextQuestion(q5A);
        answerRepository.save(a4C3);

        Answer a4C4 = new Answer();
        a4C4.setText("Tom Collins");
        a4C4.setQuestion(q4C);
        a4C4.setFinalDrink(dC3);
        answerRepository.save(a4C4);

        Answer a4C5 = new Answer();
        a4C5.setText("Negroni");
        a4C5.setQuestion(q4C);
        a4C5.setNextQuestion(q5B);
        answerRepository.save(a4C5);

        // Risposte alla domanda q5A (COCKTAIL MARTINI)
        Answer a5A1 = new Answer();
        a5A1.setText("Cocktail Martini");
        a5A1.setQuestion(q5A);
        a5A1.setFinalDrink(d5A1);
        answerRepository.save(a5A1);

        Answer a5A2 = new Answer();
        a5A2.setText("Dirty Martini");
        a5A2.setQuestion(q5A);
        a5A2.setFinalDrink(d5A2);
        answerRepository.save(a5A2);

        // Risposte alla domanda q5B (NEGRONI)
        Answer a5B1 = new Answer();
        a5B1.setText("Negroni");
        a5B1.setQuestion(q5B);
        a5B1.setFinalDrink(d5B1);
        answerRepository.save(a5B1);

        Answer a5B2 = new Answer();
        a5B2.setText("Negroni Sbagliato");
        a5B2.setQuestion(q5B);
        a5B2.setFinalDrink(d5B2);
        answerRepository.save(a5B2);

        // Risposte alla domanda q4D (RUM)
        Answer a5D1 = new Answer();
        a5D1.setText("Rum chiaro");
        a5D1.setQuestion(q4D);
        a5D1.setFinalDrink(d5D1);
        answerRepository.save(a5D1);

        Answer a5D2 = new Answer();
        a5D2.setText("Rum scuro");
        a5D2.setQuestion(q4D);
        a5D2.setFinalDrink(d5D2);
        answerRepository.save(a5D2);

        // Risposte alla domanda q4E (SCOTCH)
        Answer a4E1 = new Answer();
        a4E1.setText("God Father");
        a4E1.setQuestion(q4E);
        a4E1.setFinalDrink(dE1);
        answerRepository.save(a4E1);

        Answer a4E2 = new Answer();
        a4E2.setText("Rusting Ale");
        a4E2.setQuestion(q4E);
        a4E2.setFinalDrink(dE2);
        answerRepository.save(a4E2);

        Answer a4E3 = new Answer();
        a4E3.setText("Pennicillin");
        a4E3.setQuestion(q4E);
        a4E3.setFinalDrink(dE3);
        answerRepository.save(a4E3);

        // Risposte alla domanda q4F (TEQUILA)
        Answer a4F1 = new Answer();
        a4F1.setText("Margarita");
        a4F1.setQuestion(q4F);
        a4F1.setFinalDrink(dF1);
        answerRepository.save(a4F1);

        Answer a4F2 = new Answer();
        a4F2.setText("Tommy's Margarita");
        a4F2.setQuestion(q4F);
        a4F2.setFinalDrink(dF2);
        answerRepository.save(a4F2);

        // Risposte alla domanda q4G (VODKA)
        Answer a4G1 = new Answer();
        a4G1.setText("Black Russian");
        a4G1.setQuestion(q4G);
        a4G1.setFinalDrink(dG1);
        answerRepository.save(a4G1);

        Answer a4G2 = new Answer();
        a4G2.setText("White Russian");
        a4G2.setQuestion(q4G);
        a4G2.setFinalDrink(dG2);
        answerRepository.save(a4G2);

        Answer a4G3 = new Answer();
        a4G3.setText("God Mother");
        a4G3.setQuestion(q4G);
        a4G3.setFinalDrink(dG3);
        answerRepository.save(a4G3);

        Answer a4G4 = new Answer();
        a4G4.setText("Blue Lagoon");
        a4G4.setQuestion(q4G);
        a4G4.setFinalDrink(dG4);
        answerRepository.save(a4G4);

        // Risposte alla domanda q4H (LONG ISLAND)
        Answer a4H1 = new Answer();
        a4H1.setText("Long Island Ice Tea");
        a4H1.setQuestion(q4H);
        a4H1.setFinalDrink(dH1);
        answerRepository.save(a4H1);

        Answer a4H2 = new Answer();
        a4H2.setText("Tokyo Ice Tea");
        a4H2.setQuestion(q4H);
        a4H2.setFinalDrink(dH2);
        answerRepository.save(a4H2);

        Answer a4H3 = new Answer();
        a4H3.setText("Texas Ice Tea");
        a4H3.setQuestion(q4H);
        a4H3.setFinalDrink(dH3);
        answerRepository.save(a4H3);

        Answer a4H4 = new Answer();
        a4H4.setText("Quattro Bianchi");
        a4H4.setQuestion(q4H);
        a4H4.setFinalDrink(dH4);
        answerRepository.save(a4H4);

        // Risposte alla domanda q4I (ASPRO)
        Answer a4I1 = new Answer();
        a4I1.setText("Bourbon Sour");
        a4I1.setQuestion(q4I);
        a4I1.setNextQuestion(q5E);
        answerRepository.save(a4I1);

        Answer a4I2 = new Answer();
        a4I2.setText("Pisco Sour");
        a4I2.setQuestion(q4I);
        a4I2.setFinalDrink(dI2);
        answerRepository.save(a4I2);

        Answer a4I3 = new Answer();
        a4I3.setText("Midori Sour");
        a4I3.setQuestion(q4I);
        a4I3.setFinalDrink(dI3);
        answerRepository.save(a4I3);

        Answer a4I4 = new Answer();
        a4I4.setText("Clover Club");
        a4I4.setQuestion(q4I);
        a4I4.setFinalDrink(dI4);
        answerRepository.save(a4I4);

        Answer a4I5 = new Answer();
        a4I5.setText("Gin Sour");
        a4I5.setQuestion(q4I);
        a4I5.setFinalDrink(dI5);
        answerRepository.save(a4I5);

        Answer a4I6 = new Answer();
        a4I6.setText("Vodka Sour");
        a4I6.setQuestion(q4I);
        a4I6.setFinalDrink(dI6);
        answerRepository.save(a4I6);

        // Risposte alla domanda q5E (BOURBON SOUR)
        Answer a5E1 = new Answer();
        a5E1.setText("Cannella");
        a5E1.setQuestion(q5E);
        a5E1.setFinalDrink(d5E1);
        answerRepository.save(a5E1);

        Answer a5E2 = new Answer();
        a5E2.setText("Basilico");
        a5E2.setQuestion(q4I);
        a5E2.setFinalDrink(d5E2);
        answerRepository.save(a5E2);

        Answer a5E3 = new Answer();
        a5E3.setText("Al naturale");
        a5E3.setQuestion(q4I);
        a5E3.setFinalDrink(d5E3);
        answerRepository.save(a5E3);

        // Risposte alla domanda q4J (DOLCE ACIDULO)
        Answer a4J1 = new Answer();
        a4J1.setText("Liquirizia");
        a4J1.setQuestion(q4J);
        a4J1.setFinalDrink(dJ1);
        answerRepository.save(a4J1);

        Answer a4J2 = new Answer();
        a4J2.setText("Cannella");
        a4J2.setQuestion(q4J);
        a4J2.setFinalDrink(dJ2);
        answerRepository.save(a4J2);

        Answer a4J3 = new Answer();
        a4J3.setText("Anice");
        a4J3.setQuestion(q4J);
        a4J3.setFinalDrink(dJ3);
        answerRepository.save(a4J3);

        Answer a4J4 = new Answer();
        a4J4.setText("Sanbuco");
        a4J4.setQuestion(q4J);
        a4J4.setFinalDrink(dJ4);
        answerRepository.save(a4J4);

        Answer a4J5 = new Answer();
        a4J5.setText("Passion Fruit");
        a4J5.setQuestion(q4J);
        a4J5.setFinalDrink(dJ5);
        answerRepository.save(a4J5);

        Answer a4J6 = new Answer();
        a4J6.setText("Mela Verde");
        a4J6.setQuestion(q4J);
        a4J6.setFinalDrink(dJ6);
        answerRepository.save(a4J6);

        Answer a4J7 = new Answer();
        a4J7.setText("Pesca");
        a4J7.setQuestion(q4J);
        a4J7.setFinalDrink(dJ7);
        answerRepository.save(a4J7);

        Answer a4J8 = new Answer();
        a4J8.setText("Kiwi");
        a4J8.setQuestion(q4J);
        a4J8.setFinalDrink(dJ8);
        answerRepository.save(a4J8);

        Answer a4J9 = new Answer();
        a4J9.setText("Lampone");
        a4J9.setQuestion(q4J);
        a4J9.setFinalDrink(dJ9);
        answerRepository.save(a4J9);

        Answer a4J10 = new Answer();
        a4J10.setText("Fragola");
        a4J10.setQuestion(q4J);
        a4J10.setFinalDrink(dJ10);
        answerRepository.save(a4J10);

        Answer a4J11 = new Answer();
        a4J11.setText("Kaipiroska");
        a4J11.setQuestion(q4J);
        a4J11.setFinalDrink(dJ11);
        answerRepository.save(a4J11);

        Answer a4J12 = new Answer();
        a4J12.setText("Kaipirina");
        a4J12.setQuestion(q4J);
        a4J12.setFinalDrink(dJ12);
        answerRepository.save(a4J12);

        Answer a4J13 = new Answer();
        a4J13.setText("Zenzero");
        a4J13.setQuestion(q4J);
        a4J13.setFinalDrink(dJ13);
        answerRepository.save(a4J13);

        // Risposte alla domanda q4K (FRUTTATO)
        Answer a4K1 = new Answer();
        a4K1.setText("Passion Fruit");
        a4K1.setQuestion(q4K);
        a4K1.setFinalDrink(dK1);
        answerRepository.save(a4K1);

        Answer a4K2 = new Answer();
        a4K2.setText("Ananas");
        a4K2.setQuestion(q4K);
        a4K2.setNextQuestion(q5C);
        answerRepository.save(a4K2);

        Answer a4K3 = new Answer();
        a4K3.setText("Lampone");
        a4K3.setQuestion(q4K);
        a4K3.setNextQuestion(q5D);
        answerRepository.save(a4K3);

        Answer a4K4 = new Answer();
        a4K4.setText("Mirtillo");
        a4K4.setQuestion(q4K);
        a4K4.setFinalDrink(dK2);
        answerRepository.save(a4K4);

        Answer a4K5 = new Answer();
        a4K5.setText("Melagrana");
        a4K5.setQuestion(q4K);
        a4K5.setFinalDrink(dK3);
        answerRepository.save(a4K5);

        Answer a4K6 = new Answer();
        a4K6.setText("Pompelmo");
        a4K6.setQuestion(q4K);
        a4K6.setNextQuestion(q5F);
        answerRepository.save(a4K6);

        Answer a4K7 = new Answer();
        a4K7.setText("Cocco");
        a4K7.setQuestion(q4K);
        a4K7.setNextQuestion(q5G);
        answerRepository.save(a4K7);

        // Risposte alla domanda q5C (ANANAS)
        Answer a5C1 = new Answer();
        a5C1.setText("Ananas-Passion");
        a5C1.setQuestion(q5C);
        a5C1.setFinalDrink(d5C1);
        answerRepository.save(a5C1);

        Answer a5C2 = new Answer();
        a5C2.setText("Ananas-Cocco");
        a5C2.setQuestion(q5C);
        a5C2.setFinalDrink(d5C2);
        answerRepository.save(a5C2);

        Answer a5C3 = new Answer();
        a5C3.setText("Al naturale");
        a5C3.setQuestion(q5C);
        a5C3.setFinalDrink(d5C3);
        answerRepository.save(a5C3);

        // Risposte alla domanda q5D (LAMPONE)
        Answer a5D11 = new Answer();
        a5D11.setText("Cocco");
        a5D11.setQuestion(q5D);
        a5D11.setFinalDrink(d5D11);
        answerRepository.save(a5D11);

        Answer a5D22 = new Answer();
        a5D22.setText("Vaniglia");
        a5D22.setQuestion(q5D);
        a5D22.setFinalDrink(d5D22);
        answerRepository.save(a5D22);

        Answer a5D3 = new Answer();
        a5D3.setText("Arancia");
        a5D3.setQuestion(q5D);
        a5D3.setFinalDrink(d5D3);
        answerRepository.save(a5D3);

        // Risposte alla domanda q5F (POMPELMO)
        Answer a5F1 = new Answer();
        a5F1.setText("Bitter");
        a5F1.setQuestion(q5F);
        a5F1.setFinalDrink(d5F1);
        answerRepository.save(a5F1);

        Answer a5F2 = new Answer();
        a5F2.setText("Zenzero");
        a5F2.setQuestion(q5F);
        a5F2.setFinalDrink(d5F2);
        answerRepository.save(a5F2);

        // Risposte alla domanda q5G (COCCO)
        Answer a5G1 = new Answer();
        a5G1.setText("Menta");
        a5G1.setQuestion(q5G);
        a5G1.setFinalDrink(d5G1);
        answerRepository.save(a5G1);

        Answer a5G2 = new Answer();
        a5G2.setText("Al naturale");
        a5G2.setQuestion(q5G);
        a5G2.setFinalDrink(d5G2);
        answerRepository.save(a5G2);

        // Risposte alla domanda q4L (CREMOSO)
        Answer a4L1 = new Answer();
        a4L1.setText("Vaniglia Mou");
        a4L1.setQuestion(q4L);
        a4L1.setFinalDrink(dL1);
        answerRepository.save(a4L1);

        Answer a4L2 = new Answer();
        a4L2.setText("Cocco e Lampone");
        a4L2.setQuestion(q4L);
        a4L2.setFinalDrink(dL2);
        answerRepository.save(a4L2);

        Answer a4L3 = new Answer();
        a4L3.setText("Alexander");
        a4L3.setQuestion(q4L);
        a4L3.setFinalDrink(dL3);
        answerRepository.save(a4L3);

        Answer a4L4 = new Answer();
        a4L4.setText("Grasshopper");
        a4L4.setQuestion(q4L);
        a4L4.setFinalDrink(dL4);
        answerRepository.save(a4L4);

        Answer a4L5 = new Answer();
        a4L5.setText("Anice e Liquirizia");
        a4L5.setQuestion(q4L);
        a4L5.setFinalDrink(dL5);
        answerRepository.save(a4L5);

        Answer a4L6 = new Answer();
        a4L6.setText("Nocciola e Caffè");
        a4L6.setQuestion(q4L);
        a4L6.setFinalDrink(dL6);
        answerRepository.save(a4L6);

        Answer a4L7 = new Answer();
        a4L7.setText("Nocciola e Cacao");
        a4L7.setQuestion(q4L);
        a4L7.setFinalDrink(dL7);
        answerRepository.save(a4L7);

        Answer a4L8 = new Answer();
        a4L8.setText("Caffè");
        a4L8.setQuestion(q4L);
        a4L8.setFinalDrink(dL8);
        answerRepository.save(a4L8);

        // Risposte alla domanda q4M (CREMOSO)
        Answer a4M1 = new Answer();
        a4M1.setText("Caffè-Disaronno");
        a4M1.setQuestion(q4M);
        a4M1.setFinalDrink(dM1);
        answerRepository.save(a4M1);

        Answer a4M2 = new Answer();
        a4M2.setText("Caffè-Vaniglia");
        a4M2.setQuestion(q4M);
        a4M2.setFinalDrink(dM2);
        answerRepository.save(a4M2);

        Answer a4M3 = new Answer();
        a4M3.setText("Espresso Martini");
        a4M3.setQuestion(q4M);
        a4M3.setFinalDrink(dM3);
        answerRepository.save(a4M3);

        // Risposte alla domanda q4N (RIDUZIONE ALCOLICA)
        Answer a4N1 = new Answer();
        a4N1.setText("Whiskey");
        a4N1.setQuestion(q4N);
        a4N1.setQuestion(q5M);
        answerRepository.save(a4N1);

        Answer a4N2 = new Answer();
        a4N2.setText("Gin");
        a4N2.setQuestion(q4N);
        a4N2.setFinalDrink(dN1);
        answerRepository.save(a4N2);

        Answer a4N3 = new Answer();
        a4N3.setText("Brandy");
        a4N3.setQuestion(q4N);
        a4N3.setFinalDrink(dN2);
        answerRepository.save(a4N3);

        Answer a4N4 = new Answer();
        a4N4.setText("Rum");
        a4N4.setQuestion(q4N);
        a4N4.setFinalDrink(dN3);
        answerRepository.save(a4N4);

        // Risposte alla domanda q5M (WHISKEY)
        Answer a5M1 = new Answer();
        a5M1.setText("Vermouth");
        a5M1.setQuestion(q5M);
        a5M1.setFinalDrink(d5M1);
        answerRepository.save(a5M1);

        Answer a5M2 = new Answer();
        a5M2.setText("Bitter");
        a5M2.setQuestion(q5M);
        a5M2.setFinalDrink(d5M2);
        answerRepository.save(a5M2);

        Answer a5M3 = new Answer();
        a5M3.setText("Menta");
        a5M3.setQuestion(q5M);
        a5M3.setFinalDrink(d5M3);
        answerRepository.save(a5M3);

        Answer a5M4 = new Answer();
        a5M4.setText("Agrumi");
        a5M4.setQuestion(q5M);
        a5M4.setFinalDrink(d5M4);
        answerRepository.save(a5M4);

        Answer a5M5 = new Answer();
        a5M5.setText("Spezie");
        a5M5.setQuestion(q5M);
        a5M5.setFinalDrink(d5M5);
        answerRepository.save(a5M5);

        // Risposte alla domanda q4O (FRUTTA)
        Answer a4O1 = new Answer();
        a4O1.setText("Mango");
        a4O1.setQuestion(q4O);
        a4O1.setQuestion(q5I);
        answerRepository.save(a4O1);

        Answer a4O2 = new Answer();
        a4O2.setText("Pina Colada");
        a4O2.setQuestion(q4O);
        a4O2.setFinalDrink(dO1);
        answerRepository.save(a4O2);

        Answer a4O3 = new Answer();
        a4O3.setText("Ananas-Passion");
        a4O3.setQuestion(q4O);
        a4O3.setFinalDrink(dO2);
        answerRepository.save(a4O3);

        Answer a4O4 = new Answer();
        a4O4.setText("Fragola");
        a4O4.setQuestion(q4O);
        a4O4.setQuestion(q5J);
        answerRepository.save(a4O4);

        Answer a4O5 = new Answer();
        a4O5.setText("Lampone");
        a4O5.setQuestion(q4O);
        a4O5.setQuestion(q5K);
        answerRepository.save(a4O5);

        Answer a4O6 = new Answer();
        a4O6.setText("Pompelmo");
        a4O6.setQuestion(q4O);
        a4O6.setQuestion(q5L);
        answerRepository.save(a4O6);

        Answer a4O7 = new Answer();
        a4O7.setText("Arancia");
        a4O7.setQuestion(q4O);
        a4O7.setFinalDrink(dO3);
        answerRepository.save(a4O7);

        Answer a4O8 = new Answer();
        a4O8.setText("Tequila Sunrise");
        a4O8.setQuestion(q4O);
        a4O8.setFinalDrink(dO4);
        answerRepository.save(a4O8);

        Answer a4O9 = new Answer();
        a4O9.setText("Sex on the Beach");
        a4O9.setQuestion(q4O);
        a4O9.setFinalDrink(dO5);
        answerRepository.save(a4O9);

        // Risposte alla domanda q5I (MANGO)
        Answer a5I1 = new Answer();
        a5I1.setText("Pesca");
        a5I1.setQuestion(q5I);
        a5I1.setFinalDrink(d5I1);
        answerRepository.save(a5I1);

        Answer a5I2 = new Answer();
        a5I2.setText("Passion");
        a5I2.setQuestion(q5I);
        a5I2.setFinalDrink(d5I2);
        answerRepository.save(a5I2);

        // Risposte alla domanda q5J (FRAGOLA)
        Answer a5J1 = new Answer();
        a5J1.setText("Banana");
        a5J1.setQuestion(q5J);
        a5J1.setFinalDrink(d5J1);
        answerRepository.save(a5J1);

        Answer a5J2 = new Answer();
        a5J2.setText("Lampone");
        a5J2.setQuestion(q5J);
        a5J2.setFinalDrink(d5J2);
        answerRepository.save(a5J2);

        // Risposte alla domanda q5K (LAMPONE)
        Answer a5K1 = new Answer();
        a5K1.setText("Arancia");
        a5K1.setQuestion(q5K);
        a5K1.setFinalDrink(d5K1);
        answerRepository.save(a5K1);

        Answer a5K2 = new Answer();
        a5K2.setText("Fragola");
        a5K2.setQuestion(q5K);
        a5K2.setFinalDrink(d5K2);
        answerRepository.save(a5K2);

        // Risposte alla domanda q5L (POMPELMO)
        Answer a5L1 = new Answer();
        a5L1.setText("Bitter");
        a5L1.setQuestion(q5L);
        a5L1.setFinalDrink(d5L1);
        answerRepository.save(a5L1);

        Answer a5L2 = new Answer();
        a5L2.setText("Zenzero");
        a5L2.setQuestion(q5L);
        a5L2.setFinalDrink(d5L2);
        answerRepository.save(a5L2);

        // Risposte alla domanda q4P (SODA)
        Answer a4P1 = new Answer();
        a4P1.setText("Mojito");
        a4P1.setQuestion(q4P);
        a4P1.setFinalDrink(dP1);
        answerRepository.save(a4P1);

        Answer a4P2 = new Answer();
        a4P2.setText("Moscow Mule");
        a4P2.setQuestion(q4P);
        a4P2.setQuestion(q5H);
        answerRepository.save(a4P2);

        Answer a4P3 = new Answer();
        a4P3.setText("Dark and Stormy");
        a4P3.setQuestion(q4P);
        a4P3.setFinalDrink(dP3);
        answerRepository.save(a4P3);

        Answer a4P4 = new Answer();
        a4P4.setText("Mint Julep");
        a4P4.setQuestion(q4P);
        a4P4.setFinalDrink(dP4);
        answerRepository.save(a4P4);

        Answer a4P5 = new Answer();
        a4P5.setText("Gin Fizz");
        a4P5.setQuestion(q4P);
        a4P5.setFinalDrink(dP5);
        answerRepository.save(a4P5);

        // Risposte alla domanda q5H (MOSCOW MULE)
        Answer a5H1 = new Answer();
        a5H1.setText("Moscow Mule");
        a5H1.setQuestion(q5H);
        a5H1.setFinalDrink(d5H1);
        answerRepository.save(a5H1);

        Answer a5H2 = new Answer();
        a5H2.setText("London Mule");
        a5H2.setQuestion(q5H);
        a5H2.setFinalDrink(d5H2);
        answerRepository.save(a5H2);

        Answer a5H3 = new Answer();
        a5H3.setText("Jamaican Mule");
        a5H3.setQuestion(q5H);
        a5H3.setFinalDrink(d5H3);
        answerRepository.save(a5H3);

        // Risposte alla domanda q4Q (FRUTTA 0%)
        Answer a4Q1 = new Answer();
        a4Q1.setText("Fragola-Lime");
        a4Q1.setQuestion(q4Q);
        a4Q1.setFinalDrink(dQ1);
        answerRepository.save(a4Q1);

        Answer a4Q2 = new Answer();
        a4Q2.setText("Fragola-Lampone");
        a4Q2.setQuestion(q4Q);
        a4Q2.setFinalDrink(dQ2);
        answerRepository.save(a4Q2);

        Answer a4Q3 = new Answer();
        a4Q3.setText("Lampone-Mirtillo");
        a4Q3.setQuestion(q4Q);
        a4Q3.setFinalDrink(dQ3);
        answerRepository.save(a4Q3);

        Answer a4Q4 = new Answer();
        a4Q4.setText("Mango-Lampone-Lime");
        a4Q4.setQuestion(q4Q);
        a4Q4.setFinalDrink(dQ4);
        answerRepository.save(a4Q4);

        Answer a4Q5 = new Answer();
        a4Q5.setText("Mango-Passion");
        a4Q5.setQuestion(q4Q);
        a4Q5.setFinalDrink(dQ5);
        answerRepository.save(a4Q5);

        Answer a4Q6 = new Answer();
        a4Q6.setText("Ananas-Cocco-Lampone");
        a4Q6.setQuestion(q4Q);
        a4Q6.setFinalDrink(dQ6);
        answerRepository.save(a4Q6);

        Answer a4Q7 = new Answer();
        a4Q7.setText("Arancia-Sorbetto alla mela-Zenzero");
        a4Q7.setQuestion(q4Q);
        a4Q7.setFinalDrink(dQ7);
        answerRepository.save(a4Q7);

        Answer a4Q8 = new Answer();
        a4Q8.setText("Arancia-Sorbetto alla mela-Lime");
        a4Q8.setQuestion(q4Q);
        a4Q8.setFinalDrink(dQ8);
        answerRepository.save(a4Q8);

        Answer a4Q9 = new Answer();
        a4Q9.setText("Pompelmo-Sorbetto all'arancia-Zenzero");
        a4Q9.setQuestion(q4Q);
        a4Q9.setFinalDrink(dQ9);
        answerRepository.save(a4Q9);

        Answer a4Q10 = new Answer();
        a4Q10.setText("Fragola-Banana");
        a4Q10.setQuestion(q4Q);
        a4Q10.setFinalDrink(dQ10);
        answerRepository.save(a4Q10);

        Answer a4Q11 = new Answer();
        a4Q11.setText("Lampone-Banana");
        a4Q11.setQuestion(q4Q);
        a4Q11.setFinalDrink(dQ11);
        answerRepository.save(a4Q11);

        // Risposte alla domanda q4R (SODA)
        Answer a4R1 = new Answer();
        a4R1.setText("Virgin Mojito");
        a4R1.setQuestion(q4R);
        a4R1.setFinalDrink(dR1);
        answerRepository.save(a4R1);

        Answer a4R2 = new Answer();
        a4R2.setText("Zenzerata");
        a4R2.setQuestion(q4R);
        a4R2.setFinalDrink(dR2);
        answerRepository.save(a4R2);

        Answer a4R3 = new Answer();
        a4R3.setText("Bacco e Venere (mirtillo)");
        a4R3.setQuestion(q4R);
        a4R3.setFinalDrink(dR3);
        answerRepository.save(a4R3);

        Answer a4R4 = new Answer();
        a4R4.setText("Maso Antico (mela)");
        a4R4.setQuestion(q4R);
        a4R4.setFinalDrink(dR4);
        answerRepository.save(a4R4);

        Answer a4R5 = new Answer();
        a4R5.setText("Sapore Delicato (sciroppo d'aceto e lime)");
        a4R5.setQuestion(q4R);
        a4R5.setFinalDrink(dR5);
        answerRepository.save(a4R5);

        Answer a4R6 = new Answer();
        a4R6.setText("Disseta (angostura)");
        a4R6.setQuestion(q4R);
        a4R6.setFinalDrink(dR6);
        answerRepository.save(a4R6);

        // Risposte alla domanda q4S (MARZAPANE)
        Answer a4S1 = new Answer();
        a4S1.setText("Montato con frutta fresca");
        a4S1.setQuestion(q4S);
        a4S1.setNextQuestion(q5N);
        answerRepository.save(a4S1);

        Answer a4S2 = new Answer();
        a4S2.setText("Montato con latte di mandorla");
        a4S2.setQuestion(q4S);
        a4S2.setNextQuestion(q5O);
        answerRepository.save(a4S2);

      // Risposte alla domanda q5N (GELATO FRUTTA)
        Answer a5N1 = new Answer();
        a5N1.setText("Cocco");
        a5N1.setQuestion(q5N);
        a5N1.setFinalDrink(d5N1);
        answerRepository.save(a5N1);

        Answer a5N2 = new Answer();
        a5N2.setText("Limone");
        a5N2.setQuestion(q5N);
        a5N2.setFinalDrink(d5N2);
        answerRepository.save(a5N2);

        Answer a5N3 = new Answer();
        a5N3.setText("Fragola");
        a5N3.setQuestion(q5N);
        a5N3.setFinalDrink(d5N3);
        answerRepository.save(a5N3);

        Answer a5N4 = new Answer();
        a5N4.setText("Lampone");
        a5N4.setQuestion(q5N);
        a5N4.setFinalDrink(d5N4);
        answerRepository.save(a5N4);

        Answer a5N5 = new Answer();
        a5N5.setText("Mela");
        a5N5.setQuestion(q5N);
        a5N5.setFinalDrink(d5N5);
        answerRepository.save(a5N5);

        Answer a5N6 = new Answer();
        a5N6.setText("Arancia");
        a5N6.setQuestion(q5N);
        a5N6.setFinalDrink(d5N6);
        answerRepository.save(a5N6);

        // Risposte alla domanda q5O (GELATO CREMA)
        Answer a5O1 = new Answer();
        a5O1.setText("Cioccolato bianco");
        a5O1.setQuestion(q5O);
        a5O1.setFinalDrink(d5O1);
        answerRepository.save(a5O1);

        Answer a5O2 = new Answer();
        a5O2.setText("Fondente e torba");
        a5O2.setQuestion(q5O);
        a5O2.setFinalDrink(d5O2);
        answerRepository.save(a5O2);

        Answer a5O3 = new Answer();
        a5O3.setText("Crema vaniglia");
        a5O3.setQuestion(q5O);
        a5O3.setFinalDrink(d5O3);
        answerRepository.save(a5O3);

        Answer a5O4 = new Answer();
        a5O4.setText("Sale e pepe");
        a5O4.setQuestion(q5O);
        a5O4.setFinalDrink(d5O4);
        answerRepository.save(a5O4);

        Answer a5O5 = new Answer();
        a5O5.setText("Stracciatella");
        a5O5.setQuestion(q5O);
        a5O5.setFinalDrink(d5O5);
        answerRepository.save(a5O5);

        Answer a5O6 = new Answer();
        a5O6.setText("Nocciola");
        a5O6.setQuestion(q5O);
        a5O6.setFinalDrink(d5O6);
        answerRepository.save(a5O6);

        Answer a5O7 = new Answer();
        a5O7.setText("Mandorla");
        a5O7.setQuestion(q5O);
        a5O7.setFinalDrink(d5O7);
        answerRepository.save(a5O7);

        Answer a5O8 = new Answer();
        a5O8.setText("Pistacchio");
        a5O8.setQuestion(q5O);
        a5O8.setFinalDrink(d5O8);
        answerRepository.save(a5O8);

        Answer a5O9 = new Answer();
        a5O9.setText("Cioccolato");
        a5O9.setQuestion(q5O);
        a5O9.setFinalDrink(d5O9);
        answerRepository.save(a5O9);

        // Risposte alla domanda q4T (GROG)
        Answer a4T1 = new Answer();
        a4T1.setText("Spezie");
        a4T1.setQuestion(q4T);
        a4T1.setFinalDrink(dT1);
        answerRepository.save(a4T1);

        Answer a4T2 = new Answer();
        a4T2.setText("Fiori");
        a4T2.setQuestion(q4T);
        a4T2.setFinalDrink(dT2);
        answerRepository.save(a4T2);

        Answer a4T3 = new Answer();
        a4T3.setText("Frutta");
        a4T3.setQuestion(q4T);
        a4T3.setFinalDrink(dT3);
        answerRepository.save(a4T3);

       // Risposte alla domanda q4U (HOT CREAM)
        Answer a4U1 = new Answer();
        a4U1.setText("Pistacchio");
        a4U1.setQuestion(q4U);
        a4U1.setFinalDrink(dU1);
        answerRepository.save(a4U1);

        Answer a4U2 = new Answer();
        a4U2.setText("Nocciola");
        a4U2.setQuestion(q4U);
        a4U2.setFinalDrink(dU2);
        answerRepository.save(a4U2);

        Answer a4U3 = new Answer();
        a4U3.setText("Mandorla");
        a4U3.setQuestion(q4U);
        a4U3.setFinalDrink(dU3);
        answerRepository.save(a4U3);

        Answer a4U4 = new Answer();
        a4U4.setText("Mou");
        a4U4.setQuestion(q4U);
        a4U4.setFinalDrink(dU4);
        answerRepository.save(a4U4);

        Answer a4U5 = new Answer();
        a4U5.setText("Cioccolato");
        a4U5.setQuestion(q4U);
        a4U5.setFinalDrink(dU5);
        answerRepository.save(a4U5);

        // Risposte alla domanda q4V (HOT FRUIT)
        Answer a4V1 = new Answer();
        a4V1.setText("Mirtillo");
        a4V1.setQuestion(q4V);
        a4V1.setFinalDrink(dV1);
        answerRepository.save(a4V1);

        Answer a4V2 = new Answer();
        a4V2.setText("Arancia");
        a4V2.setQuestion(q4V);
        a4V2.setFinalDrink(dV2);
        answerRepository.save(a4V2);

        Answer a4V3 = new Answer();
        a4V3.setText("Mela");
        a4V3.setQuestion(q4V);
        a4V3.setFinalDrink(dV3);
        answerRepository.save(a4V3);

        // Risposte alla domanda q4W (HOT COFFEE)
        Answer a4W1 = new Answer();
        a4W1.setText("Irish Coffee");
        a4W1.setQuestion(q4W);
        a4W1.setFinalDrink(dW1);
        answerRepository.save(a4W1);

        // Risposte alla domanda q4X (BRULE')
        Answer a4X1 = new Answer();
        a4X1.setText("Vino bianco");
        a4X1.setQuestion(q4X);
        a4X1.setFinalDrink(dX1);
        answerRepository.save(a4X1);

        Answer a4X2 = new Answer();
        a4X2.setText("Vino rosso");
        a4X2.setQuestion(q4X);
        a4X2.setFinalDrink(dX2);
        answerRepository.save(a4X2);

        // Risposte alla domanda q4Y (DECOTTO)
        Answer a4Y1 = new Answer();
        a4Y1.setText("Cedro");
        a4Y1.setQuestion(q4Y);
        a4Y1.setFinalDrink(dY1);
        answerRepository.save(a4Y1);

        Answer a4Y2 = new Answer();
        a4Y2.setText("Menta");
        a4Y2.setQuestion(q4Y);
        a4Y2.setFinalDrink(dY2);
        answerRepository.save(a4Y2);

        Answer a4Y3 = new Answer();
        a4Y3.setText("Mela");
        a4Y3.setQuestion(q4Y);
        a4Y3.setFinalDrink(dY3);
        answerRepository.save(a4Y3);

        Answer a4Y4 = new Answer();
        a4Y4.setText("Mirtillo");
        a4Y4.setQuestion(q4Y);
        a4Y4.setFinalDrink(dY4);
        answerRepository.save(a4Y4);

        Answer a4Y5 = new Answer();
        a4Y5.setText("Zenzero");
        a4Y5.setQuestion(q4Y);
        a4Y5.setFinalDrink(dY5);
        answerRepository.save(a4Y5);

        // Risposte alla domanda q4Z (INFUSI)
        Answer a4Z1 = new Answer();
        a4Z1.setText("Digestivo");
        a4Z1.setQuestion(q4Z);
        a4Z1.setFinalDrink(dZ1);
        answerRepository.save(a4Z1);

        Answer a4Z2 = new Answer();
        a4Z2.setText("Tropicale");
        a4Z2.setQuestion(q4Z);
        a4Z2.setFinalDrink(dZ2);
        answerRepository.save(a4Z2);

        Answer a4Z3 = new Answer();
        a4Z3.setText("Frutta mista");
        a4Z3.setQuestion(q4Z);
        a4Z3.setFinalDrink(dZ3);
        answerRepository.save(a4Z3);

        Answer a4Z4 = new Answer();
        a4Z4.setText("Mango-Pesca");
        a4Z4.setQuestion(q4Z);
        a4Z4.setFinalDrink(dZ4);
        answerRepository.save(a4Z4);

        Answer a4Z5 = new Answer();
        a4Z5.setText("Fiori");
        a4Z5.setQuestion(q4Z);
        a4Z5.setFinalDrink(dZ5);
        answerRepository.save(a4Z5);

        Answer a4Z6 = new Answer();
        a4Z6.setText("Speziato");
        a4Z6.setQuestion(q4Z);
        a4Z6.setFinalDrink(dZ6);
        answerRepository.save(a4Z6);

        Answer a4Z7 = new Answer();
        a4Z7.setText("Erbaceo");
        a4Z7.setQuestion(q4Z);
        a4Z7.setFinalDrink(dZ7);
        answerRepository.save(a4Z7);

        // Risposte alla domanda q4aa (SAPORE DI LATTE)
        Answer a4aa1 = new Answer();
        a4aa1.setText("Pistacchio");
        a4aa1.setQuestion(q4aa);
        a4aa1.setFinalDrink(daa1);
        answerRepository.save(a4aa1);

        Answer a4aa2 = new Answer();
        a4aa2.setText("Nocciola");
        a4aa2.setQuestion(q4aa);
        a4aa2.setFinalDrink(daa2);
        answerRepository.save(a4aa2);

        Answer a4aa3 = new Answer();
        a4aa3.setText("Mandorla");
        a4aa3.setQuestion(q4aa);
        a4aa3.setFinalDrink(daa3);
        answerRepository.save(a4aa3);

        Answer a4aa4 = new Answer();
        a4aa4.setText("Mou");
        a4aa4.setQuestion(q4aa);
        a4aa4.setFinalDrink(daa4);
        answerRepository.save(a4aa4);

        Answer a4aa5 = new Answer();
        a4aa5.setText("Cioccolato");
        a4aa5.setQuestion(q4aa);
        a4aa5.setFinalDrink(daa5);
        answerRepository.save(a4aa5);

        // Risposte alla domanda q4bb (CACAO CULT)
        Answer a4bb1 = new Answer();
        a4bb1.setText("Gelato");
        a4bb1.setQuestion(q4bb);
        a4bb1.setFinalDrink(dbb1);
        answerRepository.save(a4bb1);

        Answer a4bb2 = new Answer();
        a4bb2.setText("Frutta fresca");
        a4bb2.setQuestion(q4bb);
        a4bb2.setFinalDrink(dbb2);
        answerRepository.save(a4bb2);

        Answer a4bb3 = new Answer();
        a4bb3.setText("Frutta secca");
        a4bb3.setQuestion(q4bb);
        a4bb3.setFinalDrink(dbb3);
        answerRepository.save(a4bb3);

        Answer a4bb4 = new Answer();
        a4bb4.setText("Fave di cacao");
        a4bb4.setQuestion(q4bb);
        a4bb4.setFinalDrink(dbb4);
        answerRepository.save(a4bb4);
    }
}
