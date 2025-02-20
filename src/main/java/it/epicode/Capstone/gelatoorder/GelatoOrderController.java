package it.epicode.Capstone.gelatoorder;

import it.epicode.Capstone.exceptions.ResourceNotFoundException;
import it.epicode.Capstone.paypal.OrderStatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class GelatoOrderController {
    private final GelatoOrderService gelatoOrderService;
    private GelatoOrderRepository gelatoOrderRepository;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<GelatoOrder>> getAllOrders() {
        List<GelatoOrder> gelatoOrders = gelatoOrderService.getAllOrders();
        return ResponseEntity.ok(gelatoOrders);
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody GelatoOrderRequest gelatoOrderRequest) {
        try {
            GelatoOrder createdGelatoOrder = gelatoOrderService.createOrder(gelatoOrderRequest, OrderStatusEnum.PENDING);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdGelatoOrder);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "Errore interno"));
        }
    }

    @PatchMapping("/{orderId}/status")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateOrderStatus(@PathVariable Long orderId, @RequestParam OrderStatusEnum status) {
        try {
            GelatoOrder updatedOrder = gelatoOrderService.updateOrderStatus(orderId, status);
            return ResponseEntity.ok(updatedOrder);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "Errore interno"));
        }
    }
}
