package it.epicode.Capstone.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "costumers")
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;
}
