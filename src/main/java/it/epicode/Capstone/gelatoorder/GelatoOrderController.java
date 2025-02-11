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

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<GelatoOrder>> getAllOrders() {
        List<GelatoOrder> gelatoOrders = gelatoOrderService.getAllOrders();
        return ResponseEntity.ok(gelatoOrders);
    }

    @PostMapping
    public ResponseEntity<GelatoOrder> createOrder(@RequestBody GelatoOrderRequest gelatoOrderRequest) {
        try {
            GelatoOrder createdGelatoOrder = gelatoOrderService.createOrder(gelatoOrderRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdGelatoOrder);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}