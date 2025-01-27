package it.epicode.Capstone.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "menuItems")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private double price;

    private String description;
}
