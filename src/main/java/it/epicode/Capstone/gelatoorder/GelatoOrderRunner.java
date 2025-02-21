package it.epicode.Capstone.gelatoorder;

import com.github.javafaker.Faker;
import it.epicode.Capstone.exceptions.ResourceNotFoundException;
import it.epicode.Capstone.flavour.Flavour;
import it.epicode.Capstone.flavour.FlavourRepository;
import it.epicode.Capstone.orderdetail.GelatoOrderDetail;
import it.epicode.Capstone.orderdetail.GelatoOrderDetailRepository;
import it.epicode.Capstone.paypal.OrderStatusEnum;
import it.epicode.Capstone.scoopquantity.ScoopQuantity;
import it.epicode.Capstone.scoopquantity.ScoopQuantityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
@Order(3)
public class GelatoOrderRunner implements CommandLineRunner {
    private final GelatoOrderRepository gelatoOrderRepository;
    private final FlavourRepository flavourRepository;
    private final GelatoOrderDetailRepository gelatoOrderDetailRepository;
    private final ScoopQuantityRepository scoopQuantityRepository;

    public GelatoOrderRunner(GelatoOrderRepository gelatoOrderRepository, FlavourRepository flavourRepository, GelatoOrderDetailRepository gelatoOrderDetailRepository, ScoopQuantityRepository scoopQuantityRepository) {
        this.gelatoOrderRepository = gelatoOrderRepository;
        this.flavourRepository = flavourRepository;
        this.gelatoOrderDetailRepository = gelatoOrderDetailRepository;
        this.scoopQuantityRepository = scoopQuantityRepository;
    }

    Faker faker = new Faker(new Locale("it"));
    private final Random random = new Random();

    public void run(String... args) throws Exception {
        if (gelatoOrderRepository.count() == 0) {
            for (int i = 0; i < 7; i++) {
                GelatoOrder order = new GelatoOrder();

                order.setCostumerName(faker.name().fullName());
                order.setEmail(faker.internet().emailAddress());
                order.setStatus(OrderStatusEnum.COMPLETED);

                LocalDateTime orderDate = random.nextBoolean() ?
                        LocalDateTime.now() :
                        LocalDateTime.now().minusDays(1);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy 'ore' HH:mm");
                String formattedDate = orderDate.format(formatter);

                order.setOrderDate(orderDate);

                GelatoOrderDetail detail = new GelatoOrderDetail();
                detail.setGelatoOrder(order);

                List<ScoopQuantity> scoopList = new ArrayList<>();
                List<Flavour> flavours = flavourRepository.findAll();
                if (flavours.isEmpty()) {
                    throw new ResourceNotFoundException("No flavours found in DB");
                }

                // SCELGO CASUALMENTE QUANTI GUSTI INSERIRE (TRA 1 E 15)
                int numberOfFlavours = random.nextInt(1, Math.min(16, flavours.size() + 1));
                List<Flavour> selectedFlavours = new ArrayList<>(flavours);
                Collections.shuffle(selectedFlavours);
                selectedFlavours = selectedFlavours.subList(0, numberOfFlavours);

                int remainingScoops = 12; // MASSIMO PER OGNI ORDINE
                int actualTotalScoops = 0;

                // DISTRIBUISCO LE PALLINE TRA I GUSTI SELEZIONATI
                for (int flavorIndex = 0; flavorIndex < selectedFlavours.size(); flavorIndex++) {
                    Flavour flavour = selectedFlavours.get(flavorIndex);

                    // PER L'ULTIMO GUSTO MI ASSICURO PRIMA CHE CI SIANO PALLINE RIMANENTI
                    if (flavorIndex == selectedFlavours.size() - 1 && remainingScoops > 0) {

                        int scoopCount = Math.min(remainingScoops, random.nextInt(1, 3)); //3 E' ESCLUSO

                        ScoopQuantity scoop = new ScoopQuantity();
                        scoop.setNumberOfScoops(scoopCount);
                        scoop.setFlavour(flavour);
                        scoop.setGelatoOrderDetail(detail);
                        scoopList.add(scoop);

                        actualTotalScoops += scoopCount;
                        remainingScoops -= scoopCount;
                    } else if (remainingScoops > 0) {

                        int maxPossible = Math.min(2, remainingScoops);
                        if (maxPossible > 0) {
                            int scoopCount = random.nextInt(1, maxPossible + 1);

                            ScoopQuantity scoop = new ScoopQuantity();
                            scoop.setNumberOfScoops(scoopCount);
                            scoop.setFlavour(flavour);
                            scoop.setGelatoOrderDetail(detail);
                            scoopList.add(scoop);

                            actualTotalScoops += scoopCount;
                            remainingScoops -= scoopCount;
                        }
                    }
                }


                detail.setTotalScoops(actualTotalScoops);
                detail.setScoopQuantities(scoopList);


                int totalPrice = actualTotalScoops * 2;
                order.setTotalPrice(totalPrice);

                List<GelatoOrderDetail> details = new ArrayList<>();
                details.add(detail);
                order.setDetails(details);


                gelatoOrderRepository.save(order);
                gelatoOrderDetailRepository.save(detail);
                scoopQuantityRepository.saveAll(scoopList);
            }
        }
    }
}
