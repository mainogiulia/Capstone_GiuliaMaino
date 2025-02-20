package it.epicode.Capstone.flavour;

import com.fasterxml.jackson.annotation.JsonBackReference;
import it.epicode.Capstone.scoopquantity.ScoopQuantity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "flavours")
public class Flavour {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated (EnumType.STRING)
    private FlavourType type;

    private String description;

    private String imagePath;

    @OneToMany(mappedBy = "flavour")
    @JsonBackReference
    private List<ScoopQuantity> scoopQuantities;
}
