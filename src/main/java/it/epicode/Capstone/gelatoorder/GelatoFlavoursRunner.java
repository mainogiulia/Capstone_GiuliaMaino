package it.epicode.Capstone.gelatoorder;

import it.epicode.Capstone.flavour.Flavour;
import it.epicode.Capstone.flavour.FlavourRepository;
import it.epicode.Capstone.flavour.FlavourType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GelatoFlavoursRunner implements CommandLineRunner {
    private final FlavourRepository flavourRepository;

    public GelatoFlavoursRunner(FlavourRepository flavourRepository) {
        this.flavourRepository = flavourRepository;
    }

    public void run(String... args) throws Exception {
        if (flavourRepository.count() == 0) {
            Flavour whiteChocolate = new Flavour();
            whiteChocolate.setName("Cioccolato bianco");
            whiteChocolate.setType(FlavourType.CREMA);
            whiteChocolate.setDescription("Dolce e cremoso, con un gusto delicato e burroso di cioccolato bianco.");

            Flavour darkChocolate = new Flavour();
            darkChocolate.setName("Fondente e torba");
            darkChocolate.setType(FlavourType.CREMA);
            darkChocolate.setDescription("Intenso e affumicato, un mix unico di cioccolato fondente e note torbate.");

            Flavour creamVanilla = new Flavour();
            creamVanilla.setName("Crema vaniglia");
            creamVanilla.setType(FlavourType.CREMA);
            creamVanilla.setDescription("Morbida e vellutata, con il classico aroma della vaniglia del Madagascar.");

            Flavour saltPepper = new Flavour();
            saltPepper.setName("Sale e pepe");
            saltPepper.setType(FlavourType.CREMA);
            saltPepper.setDescription("Insolito e intrigante, un perfetto equilibrio tra dolcezza e note speziate.");

            Flavour stracciatella = new Flavour();
            stracciatella.setName("Stracciatella");
            stracciatella.setType(FlavourType.CREMA);
            stracciatella.setDescription("Crema di latte arricchita da croccanti scaglie di cioccolato fondente.");

            Flavour hazelnut = new Flavour();
            hazelnut.setName("Nocciola");
            hazelnut.setType(FlavourType.CREMA);
            hazelnut.setDescription("Ricco e avvolgente, con il gusto autentico delle nocciole tostate.");

            Flavour almond = new Flavour();
            almond.setName("Mandorla");
            almond.setType(FlavourType.CREMA);
            almond.setDescription("Delicato e raffinato, con il sapore inconfondibile delle mandorle siciliane.");

            Flavour pistachio = new Flavour();
            pistachio.setName("Pistacchio");
            pistachio.setType(FlavourType.CREMA);
            pistachio.setDescription("Cremoso e aromatico, realizzato con pistacchi di alta qualità.");

            Flavour chocolate = new Flavour();
            chocolate.setName("Cioccolato");
            chocolate.setType(FlavourType.CREMA);
            chocolate.setDescription("Deciso e goloso, con il sapore intenso del miglior cacao.");

            Flavour coconut = new Flavour();
            coconut.setName("Cocco");
            coconut.setType(FlavourType.FRUTTA);
            coconut.setDescription("Esotico e rinfrescante, con la dolcezza naturale del cocco fresco.");

            Flavour lemon = new Flavour();
            lemon.setName("Limone");
            lemon.setType(FlavourType.FRUTTA);
            lemon.setDescription("Fresco e agrumato, con il gusto autentico dei limoni di Sicilia.");

            Flavour raspberry = new Flavour();
            raspberry.setName("Lampone");
            raspberry.setType(FlavourType.FRUTTA);
            raspberry.setDescription("Dolce e fruttato, preparato con fragole mature e succose.");

            Flavour strawberry = new Flavour();
            strawberry.setName("Fragola");
            strawberry.setType(FlavourType.FRUTTA);
            strawberry.setDescription("Acidulo e rinfrescante, con il sapore intenso dei lamponi freschi.");

            Flavour apple = new Flavour();
            apple.setName("Mela");
            apple.setType(FlavourType.FRUTTA);
            apple.setDescription("Morbido e leggermente acidulo, con il gusto naturale della mela.");

            Flavour orange = new Flavour();
            orange.setName("Arancia");
            orange.setType(FlavourType.FRUTTA);
            orange.setDescription("Profumato e vivace, con la freschezza delle arance appena raccolte.");

            flavourRepository.save(whiteChocolate);
            flavourRepository.save(darkChocolate);
            flavourRepository.save(creamVanilla);
            flavourRepository.save(saltPepper);
            flavourRepository.save(stracciatella);
            flavourRepository.save(hazelnut);
            flavourRepository.save(almond);
            flavourRepository.save(pistachio);
            flavourRepository.save(chocolate);
            flavourRepository.save(coconut);
            flavourRepository.save(lemon);
            flavourRepository.save(raspberry);
            flavourRepository.save(strawberry);
            flavourRepository.save(apple);
            flavourRepository.save(orange);
        }
    }
}
