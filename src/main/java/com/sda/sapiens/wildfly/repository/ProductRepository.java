package com.sda.sapiens.wildfly.repository;

import com.sda.sapiens.wildfly.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(Long id);

    List<Product> findProductsByName(String searchedPhrase);

    void save(Product product);

    Optional<Product> findByName(String name);
}
