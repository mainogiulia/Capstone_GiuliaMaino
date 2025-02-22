package it.epicode.Capstone.reservation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findByCustomerNameAndCancellationCode(String customerName, String cancellationCode);
    List<Reservation> findAllByOrderByReservationDateAscReservationTimeAsc();
}