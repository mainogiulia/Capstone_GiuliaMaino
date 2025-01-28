package it.epicode.Capstone.orderdetail;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.epicode.Capstone.flavour.Flavour;
import it.epicode.Capstone.order.Order;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private int numberOfScoops;

    @Column(nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @JsonIgnore //se no va in loop con Flavour
    private Order order;

    @ManyToMany
    @JoinTable(
            name = "orderdetail_flavours",
            joinColumns = @JoinColumn(name = "orderdetail_id"),
            inverseJoinColumns = @JoinColumn(name = "flavour_id")
    )
    private List<Flavour> flavours = new ArrayList<>();
}
