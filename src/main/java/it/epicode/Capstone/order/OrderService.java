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
        AppUser loggedInUser = getCurrentUser();

        Order order = new Order();
        order.setAppUser(loggedInUser);
        order.setOrderDate(orderRequest.getOrderDate());

        int total = 0;
        List<OrderDetail> orderDetails = new ArrayList<>();
        for (OrderDetailRequest detailRequest : orderRequest.getDetails()) {
            OrderDetail detail = new OrderDetail();
            detail.setNumberOfScoops(detailRequest.getNumberOfScoops());

            List<Flavour> flavours = flavourRepository.findAllById(detailRequest.getFlavourIds());
            if (flavours.isEmpty()) {
                throw new IllegalArgumentException("Flavours not found for IDs: " + detailRequest.getFlavourIds());
            }
            detail.setFlavours(flavours);

            int price = detailRequest.getNumberOfScoops() * pricePerScoop;
            detail.setPrice(price);
            total += price;

            detail.setOrder(order);
            orderDetails.add(detail);
        }

        order.setTotalPrice(total);
        order.setDetails(orderDetails);

        return orderRepository.save(order);
    }

    //RECUPERO TUTTI GLI ORDINI
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    //MODIFICO UN ORDINE
    public Order updateOrder(Long orderId, OrderRequest orderRequest) {
        AppUser loggedInUser = getCurrentUser();

        // Controllo se l'utente è autorizzato (admin)
        if (!isAdmin(loggedInUser)) {
            throw new UnauthorizedException("Non sei autorizzato ad eseguire questa operazione");
        }

        // Recupera l'ordine esistente o lancia un'eccezione se non trovato
        Order existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Ordine con ID " + orderId + " non trovato"));

        int total = 0;
        List<OrderDetail> orderDetails = new ArrayList<>();

        for (OrderDetailRequest detailRequest : orderRequest.getDetails()) {
            OrderDetail detail = new OrderDetail();
            detail.setNumberOfScoops(detailRequest.getNumberOfScoops());

            List<Flavour> flavours = flavourRepository.findAllById(detailRequest.getFlavourIds());
            if (flavours.isEmpty()) {
                throw new IllegalArgumentException("Flavours not found for IDs: " + detailRequest.getFlavourIds());
            }
            detail.setFlavours(flavours);

            int price = detailRequest.getNumberOfScoops() * pricePerScoop;
            detail.setPrice(price);
            total += price;

            detail.setOrder(existingOrder);
            orderDetails.add(detail);
        }

        existingOrder.setDetails(orderDetails);

        existingOrder.setTotalPrice(total);
        existingOrder.setOrderDate(orderRequest.getOrderDate());

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
