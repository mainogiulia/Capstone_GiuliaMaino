package it.epicode.Capstone.flavour;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "flavours")
public class Flavour {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;
}
