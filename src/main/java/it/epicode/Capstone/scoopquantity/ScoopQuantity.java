package it.epicode.Capstone.scoopquantity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import it.epicode.Capstone.flavour.Flavour;
import it.epicode.Capstone.orderdetail.GelatoOrderDetail;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ScoopQuantity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private int numberOfScoops;

    @ManyToOne
    @JoinColumn(name = "flavour_id", nullable = false)
    @JsonManagedReference
    private Flavour flavour;

    @ManyToOne
    @JsonIgnore //per evitare il loop con OrderDetail
    private GelatoOrderDetail gelatoOrderDetail;
}