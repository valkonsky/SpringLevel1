package ru.gb.savilin.entity;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();
    private AtomicLong identity = new AtomicLong(0);
    @Override
    public List<Product> findAll(){
        return new ArrayList<>(productMap.values());
    }
    @Override
    public Product getById(long id){
        return productMap.get(id);
    }
    @Override
    public void insert(Product product){
        long id = identity.incrementAndGet();
        product.setId(id);
        productMap.put(id,product);
    }
    @Override
    public void update(Product product){
        productMap.put(product.getId(),product);
    }
    @Override
    public void delete(long id){
        productMap.remove(id);
    }
}
