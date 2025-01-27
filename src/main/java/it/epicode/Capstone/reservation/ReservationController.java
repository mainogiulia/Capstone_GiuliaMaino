package it.epicode.Capstone.reservation;

import it.epicode.Capstone.dto.ReservationRequest;
import it.epicode.Capstone.entities.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping("/my-reservations")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Reservation>> getUserReservations() {
        List<Reservation> reservations = reservationService.getUserReservations();
        return ResponseEntity.ok(reservations);
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationRequest reservationRequest) {
        return new ResponseEntity<>(reservationService.createReservation(reservationRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
