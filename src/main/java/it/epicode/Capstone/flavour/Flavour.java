package it.epicode.Capstone.flavour;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.epicode.Capstone.orderdetail.OrderDetail;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
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

    private String description;
}
