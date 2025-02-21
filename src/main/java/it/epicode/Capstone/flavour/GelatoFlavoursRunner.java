package it.epicode.Capstone.flavour;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
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
            whiteChocolate.setDescription("Dolce e cremoso, con un gusto delicato di cioccolato bianco.");
            whiteChocolate.setImagePath("flavours/cioccolatobianco.webp");

            Flavour darkChocolate = new Flavour();
            darkChocolate.setName("Fondente e torba");
            darkChocolate.setType(FlavourType.CREMA);
            darkChocolate.setDescription("Intenso e affumicato, un mix unico di cioccolato fondente e note torbate.");
            darkChocolate.setImagePath("flavours/cioccolato.webp");

            Flavour creamVanilla = new Flavour();
            creamVanilla.setName("Crema vaniglia");
            creamVanilla.setType(FlavourType.CREMA);
            creamVanilla.setDescription("Morbida e vellutata, con il classico aroma della vaniglia del Madagascar.");
            creamVanilla.setImagePath("flavours/cremavaniglia.webp");

            Flavour saltPepper = new Flavour();
            saltPepper.setName("Sale e pepe");
            saltPepper.setType(FlavourType.CREMA);
            saltPepper.setDescription("Insolito e intrigante, un perfetto equilibrio tra dolcezza e note speziate.");
            saltPepper.setImagePath("flavours/salepepe.webp");

            Flavour stracciatella = new Flavour();
            stracciatella.setName("Stracciatella");
            stracciatella.setType(FlavourType.CREMA);
            stracciatella.setDescription("Crema di latte arricchita da croccanti scaglie di cioccolato fondente.");
            stracciatella.setImagePath("flavours/stracciatella.webp");

            Flavour hazelnut = new Flavour();
            hazelnut.setName("Nocciola");
            hazelnut.setType(FlavourType.CREMA);
            hazelnut.setDescription("Ricco e avvolgente, con il gusto autentico delle nocciole tostate.");
            hazelnut.setImagePath("flavours/nocciola.webp");

            Flavour almond = new Flavour();
            almond.setName("Mandorla");
            almond.setType(FlavourType.CREMA);
            almond.setDescription("Delicato e raffinato, con il sapore inconfondibile delle mandorle siciliane.");
            almond.setImagePath("flavours/mandorla.webp");

            Flavour pistachio = new Flavour();
            pistachio.setName("Pistacchio");
            pistachio.setType(FlavourType.CREMA);
            pistachio.setDescription("Cremoso e aromatico, realizzato con pistacchi di alta qualità.");
            pistachio.setImagePath("flavours/pistacchio.webp");

            Flavour chocolate = new Flavour();
            chocolate.setName("Cioccolato");
            chocolate.setType(FlavourType.CREMA);
            chocolate.setDescription("Deciso e goloso, con il sapore intenso del miglior cacao.");
            chocolate.setImagePath("flavours/cioccolato.webp");

            Flavour coconut = new Flavour();
            coconut.setName("Cocco");
            coconut.setType(FlavourType.FRUTTA);
            coconut.setDescription("Esotico e rinfrescante, con la dolcezza naturale del cocco fresco.");
            coconut.setImagePath("flavours/cocco.webp");

            Flavour lemon = new Flavour();
            lemon.setName("Limone");
            lemon.setType(FlavourType.FRUTTA);
            lemon.setDescription("Fresco e agrumato, con il gusto autentico dei limoni di Sicilia.");
            lemon.setImagePath("flavours/limone.webp");

            Flavour raspberry = new Flavour();
            raspberry.setName("Lampone");
            raspberry.setType(FlavourType.FRUTTA);
            raspberry.setDescription("Dolce e fruttato, preparato con fragole mature e succose.");
            raspberry.setImagePath("flavours/lampone.webp");

            Flavour strawberry = new Flavour();
            strawberry.setName("Fragola");
            strawberry.setType(FlavourType.FRUTTA);
            strawberry.setDescription("Acidulo e rinfrescante, con il sapore intenso dei lamponi freschi.");
            strawberry.setImagePath("flavours/fragola.webp");

            Flavour apple = new Flavour();
            apple.setName("Mela");
            apple.setType(FlavourType.FRUTTA);
            apple.setDescription("Morbido e leggermente acidulo, con il gusto naturale della mela.");
            apple.setImagePath("flavours/mela.webp");

            Flavour orange = new Flavour();
            orange.setName("Arancia");
            orange.setType(FlavourType.FRUTTA);
            orange.setDescription("Profumato e vivace, con la freschezza delle arance appena raccolte.");
            orange.setImagePath("flavours/arancia.webp");

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
