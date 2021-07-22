package ru.vasilyevVA.geekbrains.repository;

import org.hibernate.Session;
import ru.vasilyevVA.geekbrains.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product findByID(Long id);
    List<Product> findAll();
    void deleteByID(Long id);
    Product saveOrUpdate(Product product);
}