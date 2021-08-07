package com.sda.sapiens.wildfly.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Klasa reprezentuje wpis w koszyku produktów. Zawiera produkt który mamy w koszyku
 * oraz ilość tego produktu (+ jednostka).
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CartEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Product product;

    @ManyToOne()
    private Cart cart;

    private double amount;

    @Enumerated(EnumType.STRING)
    private MeasureUnit unit;
}
