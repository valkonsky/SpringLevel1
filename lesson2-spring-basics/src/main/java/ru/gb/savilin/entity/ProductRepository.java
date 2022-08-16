package ru.gb.savilin.entity;

import ru.gb.savilin.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product getById(long id);
    void insert(Product product);
    void update(Product product);
    void delete(long id);


}
