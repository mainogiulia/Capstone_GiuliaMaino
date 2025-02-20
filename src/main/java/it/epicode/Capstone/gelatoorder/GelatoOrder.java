package it.epicode.Capstone.gelatoorder;

import it.epicode.Capstone.auth.AppUser;
import it.epicode.Capstone.orderdetail.GelatoOrderDetail;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class GelatoOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @PositiveOrZero(message = "Il totale deve essere un numero positivo")
    private int totalPrice;

    private LocalDate orderDate;

    private String deliveryAddress;

    @Column(nullable = false)
    private String costumerName;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "gelatoOrder", cascade = CascadeType.ALL)
    private List<GelatoOrderDetail> details = new ArrayList<>();
}
