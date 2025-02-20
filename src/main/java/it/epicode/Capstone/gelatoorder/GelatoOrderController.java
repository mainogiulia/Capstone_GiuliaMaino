package it.epicode.Capstone.gelatoorder;

import it.epicode.Capstone.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<GelatoOrder> createOrder(@RequestBody GelatoOrderRequest gelatoOrderRequest) {
        try {
            // Creiamo l'ordine usando il servizio
            GelatoOrder createdGelatoOrder = gelatoOrderService.createOrder(gelatoOrderRequest);

            // Restituiamo una risposta con stato CREATED e l'ordine creato
            return ResponseEntity.status(HttpStatus.CREATED).body(createdGelatoOrder);
        } catch (ResourceNotFoundException ex) {
            // Gestiamo l'errore nel caso in cui qualcosa non vada a buon fine
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}