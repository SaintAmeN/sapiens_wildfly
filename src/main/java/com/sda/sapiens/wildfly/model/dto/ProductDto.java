package com.sda.sapiens.wildfly.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String name;
    private double priceNet;
    private double priceGross; // zakładamy podatek 8%
}
