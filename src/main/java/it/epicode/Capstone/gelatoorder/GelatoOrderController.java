package it.epicode.Capstone.gelatoorder;

import it.epicode.Capstone.exceptions.ResourceNotFoundException;
import it.epicode.Capstone.exceptions.UserNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class GelatoOrderController {
    private final GelatoOrderService gelatoOrderService;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<GelatoOrder>> getAllOrders() {
        List<GelatoOrder> gelatoOrders = gelatoOrderService.getAllOrders();
        return ResponseEntity.ok(gelatoOrders);
    }

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<GelatoOrder> createOrder(@RequestBody GelatoOrderRequest gelatoOrderRequest) {
        try {
            GelatoOrder createdGelatoOrder = gelatoOrderService.createOrder(gelatoOrderRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdGelatoOrder);
        } catch (UserNotFoundException | ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<GelatoOrder> updateOrder(@PathVariable Long id, @Valid @RequestBody GelatoOrderRequest gelatoOrderRequest) {
        GelatoOrder updatedGelatoOrder = gelatoOrderService.updateOrder(id, gelatoOrderRequest);
        return ResponseEntity.ok(updatedGelatoOrder);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        gelatoOrderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

}