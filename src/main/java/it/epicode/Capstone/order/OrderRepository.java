package it.epicode.Capstone.order;

import it.epicode.Capstone.auth.AppUser;
import it.epicode.Capstone.entities.Order;
import it.epicode.Capstone.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByAppUserId(Long appUserId);
}
