package com.sda.sapiens.wildfly.repository;

import com.sda.sapiens.wildfly.model.Product;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

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

    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Optional<Product> findByName(String name) {
        try {
            Product product = entityManager
                    .createQuery("SELECT p FROM Product p WHERE p.name = :phrase", Product.class)
                    .setParameter("phrase", name)
                    .getSingleResult();

            // jeśli wszystko jest ok, wykonamy instrukcję zwróć
            return Optional.ofNullable(product);
        }catch (NoResultException nre){

            // zwracam brak wyników jeśli otrzymam exception
            return Optional.empty();
        }
    }
}
