package ru.gb.savilin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.gb.savilin.entity.Cart;
import ru.gb.savilin.entity.ProductRepository;
import ru.gb.savilin.entity.ProductRepositoryImpl;

@Configuration
@ComponentScan("ru.gb.savilin")
public class ApplicationConfig {
    @Bean(name = "productRepository")
    public ProductRepository productRepository(){
        ProductRepository productRepository = new ProductRepositoryImpl();
        return productRepository;
    }

 @Bean(name = "cart")
 @Scope("prototype")
 public Cart cart(){
     return new Cart();
 }
}
