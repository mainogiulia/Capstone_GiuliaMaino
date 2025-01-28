package it.epicode.Capstone.order;

import it.epicode.Capstone.auth.AppUser;
import it.epicode.Capstone.auth.AppUserRepository;
import it.epicode.Capstone.auth.Role;
import it.epicode.Capstone.exceptions.ResourceNotFoundException;
import it.epicode.Capstone.exceptions.UnauthorizedException;
import it.epicode.Capstone.exceptions.UserNotFoundException;
import it.epicode.Capstone.flavour.Flavour;
import it.epicode.Capstone.flavour.FlavourRepository;
import it.epicode.Capstone.orderdetail.OrderDetail;
import it.epicode.Capstone.orderdetail.OrderDetailRequest;
import it.epicode.Capstone.scoopquantity.ScoopQuantity;
import it.epicode.Capstone.scoopquantity.ScoopQuantityRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
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
                .orElseThrow(() -> new UserNotFoundException("Utente non trovato"));
    }

    //CREO UN NUOVO ORDINE
    public Order createOrder(OrderRequest orderRequest) {

        AppUser appUser = appUserRepository.findById(orderRequest.getAppUserId())
                .orElseThrow(() -> new UserNotFoundException("Utente non trovato"));

        Order order = new Order();
        order.setAppUser(appUser);
        order.setOrderDate(orderRequest.getOrderDate());

        List<OrderDetail> orderDetails = new ArrayList<>();
        int totalScoops = 0;

        for (OrderDetailRequest detailRequest : orderRequest.getDetails()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setTotalScoops(detailRequest.getTotalScoops());

            List<ScoopQuantity> scoopQuantities = new ArrayList<>();
            for (ScoopQuantityRequest scoopRequest : detailRequest.getScoopQuantities()) {
                ScoopQuantity scoopQuantity = new ScoopQuantity();
                scoopQuantity.setNumberOfScoops(scoopRequest.getNumberOfScoops());

                Flavour flavour = flavourRepository.findById(scoopRequest.getFlavourId())
                        .orElseThrow(() -> new ResourceNotFoundException("Gusto non trovato con ID: " + scoopRequest.getFlavourId()));
                scoopQuantity.setFlavour(flavour);

                scoopQuantity.setOrderDetail(orderDetail);
                scoopQuantities.add(scoopQuantity);

                totalScoops += scoopRequest.getNumberOfScoops();
            }
            orderDetail.setScoopQuantities(scoopQuantities);
            orderDetail.setOrder(order);
            orderDetails.add(orderDetail);
        }

        order.setDetails(orderDetails);

        int totalPrice = totalScoops * 2;
        order.setTotalPrice(totalPrice);

        return orderRepository.save(order);
    }

    // RECUPERO GLI ORDINI (SOLO QUELLI DELL'UTENTE O TUTTI SE ADMIN)
    public List<Order> getAllOrders() {
        AppUser currentUser = getCurrentUser();

        if (isAdmin(currentUser)) {
            return orderRepository.findAll();
        } else {
            return orderRepository.findByAppUserId(currentUser.getId());
        }
    }

    //MODIFICO UN ORDINE
    public Order updateOrder(Long orderId, OrderRequest orderRequest) {
        Order existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Ordine con ID " + orderId + " non trovato"));

        AppUser appUser = appUserRepository.findById(orderRequest.getAppUserId())
                .orElseThrow(() -> new UserNotFoundException("Utente non trovato"));

        existingOrder.setAppUser(appUser);
        existingOrder.setOrderDate(orderRequest.getOrderDate());
        existingOrder.setTotalPrice(orderRequest.getTotalPrice());

        existingOrder.getDetails().clear();

        List<OrderDetail> updatedDetails = new ArrayList<>();
        for (OrderDetailRequest detailRequest : orderRequest.getDetails()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setTotalScoops(detailRequest.getTotalScoops());
            orderDetail.setOrder(existingOrder);

            List<ScoopQuantity> updatedScoopQuantities = new ArrayList<>();
            for (ScoopQuantityRequest scoopRequest : detailRequest.getScoopQuantities()) {
                ScoopQuantity scoopQuantity = new ScoopQuantity();
                scoopQuantity.setNumberOfScoops(scoopRequest.getNumberOfScoops());

                Flavour flavour = flavourRepository.findById(scoopRequest.getFlavourId())
                        .orElseThrow(() -> new ResourceNotFoundException("Gusto non trovato con ID: " + scoopRequest.getFlavourId()));
                scoopQuantity.setFlavour(flavour);

                scoopQuantity.setOrderDetail(orderDetail);
                updatedScoopQuantities.add(scoopQuantity);
            }

            orderDetail.setScoopQuantities(updatedScoopQuantities);
            updatedDetails.add(orderDetail);
        }

        existingOrder.setDetails(updatedDetails);

        return orderRepository.save(existingOrder);
    }

    //ELIMINO UN ORDINE
    public void deleteOrder(Long orderId) {
        AppUser loggedInUser = getCurrentUser();

        if (!isAdmin(loggedInUser)) {
            throw new UnauthorizedException("Non sei autorizzato ad eseguire questa operazione");
        }

        if (!orderRepository.existsById(orderId)) {
            throw new ResourceNotFoundException("Ordine con ID " + orderId + " non trovato");
        }

        orderRepository.deleteById(orderId);
    }
}
