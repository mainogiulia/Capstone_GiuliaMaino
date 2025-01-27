package it.epicode.Capstone.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "gelatos")
public class Gelato {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String gusto;

    private String descrizione;

    @Column(nullable = false)
    private Double prezzo;
}
