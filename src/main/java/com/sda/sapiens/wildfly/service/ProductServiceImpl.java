package com.sda.sapiens.wildfly.service;

import com.sda.sapiens.wildfly.model.dto.ProductDto;
import com.sda.sapiens.wildfly.repository.ProductRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Inject
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductDto(
                        product.getName(),
                        product.getPrice(),
                        product.getPrice() * 1.08))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto findByName(String name) {
        return null;
    }

    @Override
    public List<ProductDto> findProductsByName(String searchedPhrase) {
        return productRepository.findProductsByName(searchedPhrase)
                .stream()
                .map(product -> new ProductDto(
                        product.getName(),
                        product.getPrice(),
                        product.getPrice() * 1.08))
                .collect(Collectors.toList());
    }
}
