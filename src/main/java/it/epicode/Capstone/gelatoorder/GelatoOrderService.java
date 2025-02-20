package it.epicode.Capstone.gelatoorder;

import it.epicode.Capstone.auth.AppUser;
import it.epicode.Capstone.auth.AppUserRepository;
import it.epicode.Capstone.auth.Role;
import it.epicode.Capstone.exceptions.ResourceNotFoundException;
import it.epicode.Capstone.exceptions.UnauthorizedException;
import it.epicode.Capstone.flavour.Flavour;
import it.epicode.Capstone.flavour.FlavourRepository;
import it.epicode.Capstone.orderdetail.GelatoOrderDetail;
import it.epicode.Capstone.orderdetail.GelatoOrderDetailRequest;
import it.epicode.Capstone.paypal.OrderStatusEnum;
import it.epicode.Capstone.scoopquantity.ScoopQuantity;
import it.epicode.Capstone.scoopquantity.ScoopQuantityRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GelatoOrderService {
    private final GelatoOrderRepository gelatoOrderRepository;
    private final FlavourRepository flavourRepository;
    private final AppUserRepository appUserRepository;
    private final JavaMailSender mailSender; // SERVE PER INVIARE L'EMAIL

    private static final int PRICE_PER_SCOOP = 2;

    //DEFINISCO ADMIN E CURRENT USER
    private boolean isAdmin(AppUser user) {
        return user.getRoles().contains(Role.ROLE_ADMIN); // Controlla se l'utente ha il ruolo ADMIN
    }

    private AppUser getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return appUserRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Utente non trovato"));
    }

    //CREO UN NUOVO ORDINE
    public GelatoOrder createOrder(GelatoOrderRequest gelatoOrderRequest, OrderStatusEnum status) {

        GelatoOrder gelatoOrder = new GelatoOrder();
        gelatoOrder.setCostumerName(gelatoOrderRequest.getCostumerName()); // IMPOSTA IL NOME INSERITO DALL'UTENTE
        gelatoOrder.setEmail(gelatoOrderRequest.getEmail()); // IMPOSTA L'EMAIL INSERITA DALL'UTENTE
        gelatoOrder.setOrderDate(gelatoOrderRequest.getOrderDate());
        gelatoOrder.setDeliveryAddress(gelatoOrderRequest.getDeliveryAddress());
        gelatoOrder.setStatus(status);

        List<GelatoOrderDetail> gelatoOrderDetails = new ArrayList<>();
        int totalScoops = 0;

        for (GelatoOrderDetailRequest detailRequest : gelatoOrderRequest.getDetails()) {
            GelatoOrderDetail gelatoOrderDetail = new GelatoOrderDetail();
            gelatoOrderDetail.setTotalScoops(detailRequest.getTotalScoops());

            List<ScoopQuantity> scoopQuantities = new ArrayList<>();
            for (ScoopQuantityRequest scoopRequest : detailRequest.getScoopQuantities()) {
                Flavour flavour = flavourRepository.findById(scoopRequest.getFlavourId())
                        .orElseThrow(() -> new ResourceNotFoundException("Gusto non trovato con ID: " + scoopRequest.getFlavourId()));

                boolean flavourExists = scoopQuantities.stream()
                        .anyMatch(scoop -> scoop.getFlavour().getId().equals(flavour.getId()));

                if (!flavourExists) {
                    ScoopQuantity scoopQuantity = new ScoopQuantity();
                    scoopQuantity.setNumberOfScoops(scoopRequest.getNumberOfScoops());
                    scoopQuantity.setFlavour(flavour);
                    scoopQuantity.setGelatoOrderDetail(gelatoOrderDetail);
                    scoopQuantities.add(scoopQuantity);
                } else {
                    ScoopQuantity existingScoop = scoopQuantities.stream()
                            .filter(scoop -> scoop.getFlavour().getId().equals(flavour.getId()))
                            .findFirst()
                            .orElseThrow(() -> new RuntimeException("Flavour not found in scoop quantities"));

                    existingScoop.setNumberOfScoops(existingScoop.getNumberOfScoops() + scoopRequest.getNumberOfScoops());
                }
                totalScoops += scoopRequest.getNumberOfScoops();
            }
            gelatoOrderDetail.setScoopQuantities(scoopQuantities);
            gelatoOrderDetail.setGelatoOrder(gelatoOrder);
            gelatoOrderDetails.add(gelatoOrderDetail);
        }
        gelatoOrder.setDetails(gelatoOrderDetails);
        gelatoOrder.setTotalPrice(totalScoops * PRICE_PER_SCOOP);

        // Salva l'ordine
        GelatoOrder savedOrder = gelatoOrderRepository.save(gelatoOrder);

        // Invia email solo se lo stato è COMPLETED
        if (OrderStatusEnum.COMPLETED.equals(status)) {
            sendConfirmationEmail(savedOrder.getCostumerName(), savedOrder.getEmail(), savedOrder.getDeliveryAddress());
        }

        return savedOrder;
    }

    // Aggiungi questo metodo per aggiornare lo stato dell'ordine
    public GelatoOrder updateOrderStatus(Long orderId, OrderStatusEnum status) {
        GelatoOrder order = gelatoOrderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Ordine non trovato con ID: " + orderId));

        order.setStatus(status);

        // Invia l'email solo quando lo stato diventa "completed"
        if (OrderStatusEnum.COMPLETED.equals(status)) {
            sendConfirmationEmail(order.getCostumerName(), order.getEmail(), order.getDeliveryAddress());
        }

        return gelatoOrderRepository.save(order);
    }

    private void sendConfirmationEmail(String customerName, String email, String deliveryAddress) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Conferma Ordine");
        message.setText("Ciao " + customerName + ",\n"
                + "abbiamo preso in carico il tuo ordine, programmato per le ore: " + deliveryAddress + ".\n"
                + "Ti ringraziamo per averci scelto e restiamo a tua disposizione.\n" +
                "\n" +
                "A presto,\n" +
                "Pertilia\n" +
                "\n" +
                "345/7168481\n" +
                "Via Astichello, 58, Montecchio Precalcino");

        mailSender.send(message);
    }

    // RECUPERO GLI ORDINI (SOLO SE ADMIN)
    public List<GelatoOrder> getAllOrders() {
        AppUser currentUser = getCurrentUser();

        if (!isAdmin(currentUser)) {
            throw new UnauthorizedException("Accesso negato: solo gli amministratori possono visualizzare tutti gli ordini.");
        }

        return gelatoOrderRepository.findAllByOrderByOrderDateAsc();
    }
}
