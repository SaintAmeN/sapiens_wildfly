package com.sda.sapiens.wildfly.model;

import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne
    private Product product;

    @ManyToOne()
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Cart cart;

    private double amount;

    @Enumerated(EnumType.STRING)
    private MeasureUnit unit;
}
