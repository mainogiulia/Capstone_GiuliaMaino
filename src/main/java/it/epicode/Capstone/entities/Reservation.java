package it.epicode.Capstone.entities;

import it.epicode.Capstone.auth.AppUser;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime reservationDate;

    @Column(nullable = false)
    private int numberOfGuests;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user;
}
