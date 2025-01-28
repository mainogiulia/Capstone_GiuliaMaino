package it.epicode.Capstone.orderdetail;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.epicode.Capstone.flavour.Flavour;
import it.epicode.Capstone.order.Order;
import it.epicode.Capstone.scoopquantity.ScoopQuantity;
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

    private int totalScoops;

    @ManyToOne
    @JsonIgnore //per evitare il loop con Order
    private Order order;

    @OneToMany(mappedBy = "orderDetail", cascade = CascadeType.ALL)
    private List<ScoopQuantity> scoopQuantities = new ArrayList<>();
}
