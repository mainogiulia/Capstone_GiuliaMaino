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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GelatoOrderService {
    private final GelatoOrderRepository gelatoOrderRepository;
    private final FlavourRepository flavourRepository;
    private final AppUserRepository appUserRepository;

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

        AppUser appUser = appUserRepository.findById(gelatoOrderRequest.getAppUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Utente non trovato"));

        GelatoOrder gelatoOrder = new GelatoOrder();
        gelatoOrder.setAppUser(appUser);
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

        return gelatoOrderRepository.save(gelatoOrder);
    }

    // RECUPERO GLI ORDINI (SOLO QUELLI DELL'UTENTE O TUTTI SE ADMIN)
    public List<GelatoOrder> getAllOrders() {
        AppUser currentUser = getCurrentUser();

        if (isAdmin(currentUser)) {
            return gelatoOrderRepository.findAll();
        } else {
            return gelatoOrderRepository.findByAppUserId(currentUser.getId());
        }
    }

    //MODIFICO UN ORDINE
    public GelatoOrder updateOrder(Long orderId, GelatoOrderRequest gelatoOrderRequest) {
        GelatoOrder existingGelatoOrder = gelatoOrderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Ordine con ID " + orderId + " non trovato"));

        AppUser appUser = appUserRepository.findById(gelatoOrderRequest.getAppUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Utente non trovato"));

        existingGelatoOrder.setAppUser(appUser);
        existingGelatoOrder.setOrderDate(gelatoOrderRequest.getOrderDate());
        existingGelatoOrder.setTotalPrice(gelatoOrderRequest.getTotalPrice());
        existingGelatoOrder.setDeliveryAddress(gelatoOrderRequest.getDeliveryAddress());

        existingGelatoOrder.getDetails().clear();

        List<GelatoOrderDetail> updatedDetails = new ArrayList<>();
        for (GelatoOrderDetailRequest detailRequest : gelatoOrderRequest.getDetails()) {
            GelatoOrderDetail gelatoOrderDetail = new GelatoOrderDetail();
            gelatoOrderDetail.setTotalScoops(detailRequest.getTotalScoops());
            gelatoOrderDetail.setGelatoOrder(existingGelatoOrder);

            List<ScoopQuantity> updatedScoopQuantities = new ArrayList<>();
            for (ScoopQuantityRequest scoopRequest : detailRequest.getScoopQuantities()) {
                ScoopQuantity scoopQuantity = new ScoopQuantity();
                scoopQuantity.setNumberOfScoops(scoopRequest.getNumberOfScoops());

                Flavour flavour = flavourRepository.findById(scoopRequest.getFlavourId())
                        .orElseThrow(() -> new ResourceNotFoundException("Gusto non trovato con ID: " + scoopRequest.getFlavourId()));
                scoopQuantity.setFlavour(flavour);

                scoopQuantity.setGelatoOrderDetail(gelatoOrderDetail);
                updatedScoopQuantities.add(scoopQuantity);
            }

            gelatoOrderDetail.setScoopQuantities(updatedScoopQuantities);
            updatedDetails.add(gelatoOrderDetail);
        }

        existingGelatoOrder.setDetails(updatedDetails);

        return gelatoOrderRepository.save(existingGelatoOrder);
    }

    //ELIMINO UN ORDINE
    public void deleteOrder(Long orderId) {
        AppUser loggedInUser = getCurrentUser();

        if (!isAdmin(loggedInUser)) {
            throw new UnauthorizedException("Non sei autorizzato ad eseguire questa operazione");
        }

        if (!gelatoOrderRepository.existsById(orderId)) {
            throw new ResourceNotFoundException("Ordine con ID " + orderId + " non trovato");
        }

        gelatoOrderRepository.deleteById(orderId);
    }
}
