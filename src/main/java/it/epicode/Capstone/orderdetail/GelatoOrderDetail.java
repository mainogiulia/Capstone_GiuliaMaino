package it.epicode.Capstone.orderdetail;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.epicode.Capstone.gelatoorder.GelatoOrder;
import it.epicode.Capstone.scoopquantity.ScoopQuantity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Order_details")
public class GelatoOrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private int totalScoops;

    @ManyToOne
    @JsonIgnore //per evitare il loop con GelatoOrder
    private GelatoOrder gelatoOrder;

    @OneToMany(mappedBy = "gelatoOrderDetail", cascade = CascadeType.ALL)
    private List<ScoopQuantity> scoopQuantities = new ArrayList<>();
}
