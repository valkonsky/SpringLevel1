package ru.gb.savilin;

import org.springframework.stereotype.Service;
import ru.gb.savilin.entity.Product;
import ru.gb.savilin.entity.ProductRepository;

import javax.annotation.PostConstruct;

@Service
public class ProductService {
    private ProductRepository productRepository;

    ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @PostConstruct
    void init(){
        productRepository.insert(new Product("cap",400));
        productRepository.insert(new Product("tape",200));
        productRepository.insert(new Product("spoon",100));
        productRepository.insert(new Product("jacket",4000));
        productRepository.insert(new Product("shoes",9000));
    }

}
