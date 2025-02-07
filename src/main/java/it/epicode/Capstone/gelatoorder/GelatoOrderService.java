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

    private static final int pricePerScoop = 2;

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
    public GelatoOrder createOrder(GelatoOrderRequest gelatoOrderRequest) {

        GelatoOrder gelatoOrder = new GelatoOrder();
        gelatoOrder.setCustomerName(gelatoOrderRequest.getCostumerName()); // IMPOSTA IL NOME INSERITO DALL'UTENTE
        gelatoOrder.setEmail(gelatoOrderRequest.getEmail()); // IMPOSTA L'EMAIL INSERITA DALL'UTENTE
        gelatoOrder.setOrderDate(gelatoOrderRequest.getOrderDate());
        gelatoOrder.setDeliveryAddress(gelatoOrderRequest.getDeliveryAddress());

        List<GelatoOrderDetail> gelatoOrderDetails = new ArrayList<>();
        int totalScoops = 0;

        for (GelatoOrderDetailRequest detailRequest : gelatoOrderRequest.getDetails()) {
            GelatoOrderDetail gelatoOrderDetail = new GelatoOrderDetail();
            gelatoOrderDetail.setTotalScoops(detailRequest.getTotalScoops());

            List<ScoopQuantity> scoopQuantities = new ArrayList<>();
            for (ScoopQuantityRequest scoopRequest : detailRequest.getScoopQuantities()) {
                ScoopQuantity scoopQuantity = new ScoopQuantity();
                scoopQuantity.setNumberOfScoops(scoopRequest.getNumberOfScoops());

                Flavour flavour = flavourRepository.findById(scoopRequest.getFlavourId())
                        .orElseThrow(() -> new ResourceNotFoundException("Gusto non trovato con ID: " + scoopRequest.getFlavourId()));
                scoopQuantity.setFlavour(flavour);

                scoopQuantity.setGelatoOrderDetail(gelatoOrderDetail);
                scoopQuantities.add(scoopQuantity);

                totalScoops += scoopRequest.getNumberOfScoops();
            }
            gelatoOrderDetail.setScoopQuantities(scoopQuantities);
            gelatoOrderDetail.setGelatoOrder(gelatoOrder);
            gelatoOrderDetails.add(gelatoOrderDetail);
        }

        gelatoOrder.setDetails(gelatoOrderDetails);

        int totalPrice = totalScoops * 2;
        gelatoOrder.setTotalPrice(totalPrice);

        sendConfirmationEmail(gelatoOrderRequest.getCostumerName(), gelatoOrderRequest.getEmail(), gelatoOrderRequest.getDeliveryAddress());

        return gelatoOrderRepository.save(gelatoOrder);
    }

    private void sendConfirmationEmail(String customerName, String email, String deliveryAddress){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Conferma Ordine");
        message.setText("Gentile " + customerName + ",\n"
                + "La informiamo che il suo ordine è stato confermato e sarà recapitato all'indirizzo seguente: " + deliveryAddress + ".\n"
                + "Le ricordiamo che, qualora decidesse di cancellare l'ordine, potrà farlo entro il termine indicato nei nostri termini e condizioni.\n"
                + "Per qualsiasi ulteriore richiesta o chiarimento, non esiti a contattarci. Saremo felici di assisterla.\n"
                + "La ringraziamo per aver scelto il nostro servizio e restiamo a sua disposizione.\n" +
                "\n" +
                "Cordiali saluti,\n" +
                "PUB\n" + //DEVI SCEGLIERE IL NOMEEEEEEE
                "numero di telefono, indirizzo, ecc.."); //E COMPILA I CONTATTI

        mailSender.send(message);
    }

    // RECUPERO GLI ORDINI (SOLO SE ADMIN)
    public List<GelatoOrder> getAllOrders() {
        AppUser currentUser = getCurrentUser();

        if (!isAdmin(currentUser)) {
            throw new UnauthorizedException("Accesso negato: solo gli amministratori possono visualizzare tutti gli ordini.");
        }

        return gelatoOrderRepository.findAll();
    }
}
