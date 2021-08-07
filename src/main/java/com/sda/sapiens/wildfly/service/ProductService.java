package com.sda.sapiens.wildfly.service;

import com.sda.sapiens.wildfly.model.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    ProductDto findByName(String name);

    List<ProductDto> findProductsByName(String searchedPhrase);
}
