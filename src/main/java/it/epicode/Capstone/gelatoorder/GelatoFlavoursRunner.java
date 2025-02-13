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
            Flavour vanilla = new Flavour();
            vanilla.setName("Vaniglia");
            vanilla.setType(FlavourType.CREMA);
            vanilla.setDescription("Gusto classico e cremoso.");

            Flavour chocolate = new Flavour();
            chocolate.setName("Cioccolato");
            chocolate.setType(FlavourType.CREMA);
            chocolate.setDescription("Delizioso cioccolato fondente.");

            Flavour strawberry = new Flavour();
            strawberry.setName("Fragola");
            strawberry.setType(FlavourType.FRUTTA);
            strawberry.setDescription("Gusto fresco e fruttato.");

            Flavour pistachio = new Flavour();
            pistachio.setName("Pistacchio");
            pistachio.setType(FlavourType.CREMA);
            pistachio.setDescription("Un sapore intenso di pistacchio.");

            Flavour lemon = new Flavour();
            lemon.setName("Limone");
            lemon.setType(FlavourType.FRUTTA);
            lemon.setDescription("Fresco e leggero, perfetto per l'estate.");

            Flavour mint = new Flavour();
            mint.setName("Menta");
            mint.setDescription("Un fresco sapore di menta.");

            Flavour caramel = new Flavour();
            caramel.setName("Caramello");
            caramel.setDescription("Ricco e dolce gusto al caramello.");

            Flavour coconut = new Flavour();
            coconut.setName("Cocco");
            coconut.setDescription("Un gusto esotico di cocco fresco.");

            Flavour hazelnut = new Flavour();
            hazelnut.setName("Nocciola");
            hazelnut.setDescription("Gusto ricco e cremoso di nocciola.");

            Flavour coffee = new Flavour();
            coffee.setName("Caffè");
            coffee.setDescription("Sapore intenso di caffè espresso.");

            Flavour tiramisu = new Flavour();
            tiramisu.setName("Tiramisù");
            tiramisu.setDescription("Gusto ispirato al famoso dolce italiano.");

            Flavour raspberry = new Flavour();
            raspberry.setName("Lampone");
            raspberry.setDescription("Dolce e perfetto per l'estate.");

            Flavour blueberry = new Flavour();
            blueberry.setName("Mirtillo");
            blueberry.setDescription("Un delizioso sapore di mirtillo fresco.");

            Flavour banana = new Flavour();
            banana.setName("Banana");
            banana.setDescription("Sapore dolce e cremoso di banana.");

            Flavour pistachioChocolate = new Flavour();
            pistachioChocolate.setName("Pistacchio e Cioccolato");
            pistachioChocolate.setDescription("L'incontro tra pistacchio e cioccolato.");

            flavourRepository.save(vanilla);
            flavourRepository.save(chocolate);
            flavourRepository.save(strawberry);
            flavourRepository.save(pistachio);
            flavourRepository.save(lemon);
            flavourRepository.save(mint);
            flavourRepository.save(caramel);
            flavourRepository.save(coconut);
            flavourRepository.save(hazelnut);
            flavourRepository.save(coffee);
            flavourRepository.save(tiramisu);
            flavourRepository.save(raspberry);
            flavourRepository.save(blueberry);
            flavourRepository.save(banana);
            flavourRepository.save(pistachioChocolate);
        }
    }
}
