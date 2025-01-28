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

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToMany(mappedBy = "flavours")
    @JsonIgnore //se no va in loop con OrderDetail
    private List<OrderDetail> orderDetails = new ArrayList<>();
}
