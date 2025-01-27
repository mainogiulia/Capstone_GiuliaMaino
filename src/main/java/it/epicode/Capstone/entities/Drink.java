package it.epicode.Capstone.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "drinks")
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descrizione;

    @Column(nullable = false)
    private Double prezzo;
}
