package it.epicode.Capstone.gelatoorder;

import it.epicode.Capstone.auth.AppUser;
import it.epicode.Capstone.orderdetail.GelatoOrderDetail;
import it.epicode.Capstone.paypal.OrderStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
@DynamicUpdate
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatusEnum status;

    @OneToMany(mappedBy = "gelatoOrder", cascade = CascadeType.ALL)
    private List<GelatoOrderDetail> details = new ArrayList<>();
}
