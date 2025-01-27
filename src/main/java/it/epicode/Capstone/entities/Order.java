package it.epicode.Capstone.entities;

import it.epicode.Capstone.auth.AppUser;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double totalAmount;

    private LocalDateTime orderDate;

    private String deliveryAddress;

    @ManyToOne
    @JoinColumn(name = "costumer_id", nullable = false)
    private AppUser appUser;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items;
}
