package com.sda.sapiens.wildfly.repository;

import com.sda.sapiens.wildfly.model.Product;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Stateless
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        return entityManager
                .createQuery("SELECT p FROM Product p", Product.class)
                .getResultList();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Product.class, id));
    }

    @Override
    public List<Product> findProductsByName(String searchedPhrase) {
        return entityManager
                .createQuery("SELECT p FROM Product p WHERE p.name LIKE CONCAT('%',:phrase,'%')", Product.class)
                .setParameter("phrase", searchedPhrase)
                .getResultList();
    }
}
