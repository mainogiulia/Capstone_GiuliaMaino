package it.epicode.Capstone.order;

import it.epicode.Capstone.auth.AppUser;
import it.epicode.Capstone.auth.AppUserRepository;
import it.epicode.Capstone.dto.OrderItemRequest;
import it.epicode.Capstone.dto.OrderRequest;
import it.epicode.Capstone.entities.MenuItem;
import it.epicode.Capstone.entities.Order;
import it.epicode.Capstone.entities.OrderItem;
import it.epicode.Capstone.exceptions.OrderNotFoundException;
import it.epicode.Capstone.exceptions.UnauthorizedException;
import it.epicode.Capstone.exceptions.UserNotFoundException;
import it.epicode.Capstone.menu.MenuItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final AppUserRepository appUserRepository;
    private final MenuItemRepository menuItemRepository;
    private final OrderRepository orderRepository;

    public Order createOrder(OrderRequest orderRequest) {
        AppUser customer = appUserRepository.findById(orderRequest.getCostumerId())
                .orElseThrow(() -> new UserNotFoundException("Cliente non trovato con ID: " + orderRequest.getCostumerId()));

        List<OrderItem> orderItems = new ArrayList<>();
        double calculatedTotalAmount = 0;

        for (OrderItemRequest itemRequest : orderRequest.getItems()) {
            MenuItem menuItem = menuItemRepository.findById(itemRequest.getMenuItemId())
                    .orElseThrow(() -> new RuntimeException("Menu item non trovato con ID: " + itemRequest.getMenuItemId()));

            OrderItem orderItem = new OrderItem();
            orderItem.setMenuItem(menuItem);
            orderItem.setQuantity(itemRequest.getQuantity());
            orderItem.setSubtotal(menuItem.getPrice() * itemRequest.getQuantity());

            calculatedTotalAmount += orderItem.getSubtotal();

            orderItems.add(orderItem);
        }

        if (calculatedTotalAmount != orderRequest.getTotalAmount()) {
            throw new IllegalArgumentException("Il totale calcolato (" + calculatedTotalAmount + ") non corrisponde al totale fornito (" + orderRequest.getTotalAmount() + ")");
        }

        Order order = new Order();
        order.setAppUser(customer);
        order.setOrderDate(orderRequest.getOrderDate());
        order.setDeliveryAddress(orderRequest.getDeliveryAddress());
        order.setTotalAmount(calculatedTotalAmount);
        order.setItems(orderItems);

        return orderRepository.save(order);
    }

    public List<Order> getUserOrders() {
        // Recupera l'utente autenticato
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        AppUser user = appUserRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("Utente non trovato"));

        return orderRepository.findByAppUserId(user.getId());
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Ordine non trovato con ID: " + orderId));
    }

    public void deleteOrder(Long orderId) {
        Order order = getOrderById(orderId);

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!order.getAppUser().getUsername().equals(username)) {
            throw new UnauthorizedException("Non sei autorizzato a cancellare questo ordine");
        }

        orderRepository.delete(order);
    }
}