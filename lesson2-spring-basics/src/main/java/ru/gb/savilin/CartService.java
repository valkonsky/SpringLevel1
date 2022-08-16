package ru.gb.savilin;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.gb.savilin.entity.Cart;
import ru.gb.savilin.entity.Product;
import ru.gb.savilin.entity.ProductRepository;

import java.util.List;

@Service
@Scope("prototype")
public class CartService {
    private Cart cart;
    private ProductRepository productRepository;

    public CartService(Cart cart, ProductRepository productRepository) {
        this.cart = cart;
        this.productRepository = productRepository;
    }

    public void addProduct(Long id) {
        Product product = productRepository.getById(id);
        cart.add(product);
    }

    public void removeProduct(Long id) {
        Product product = productRepository.getById(id);
        cart.remove(product);
    }

    public List<Product> getAllProducts() {
        return cart.getAllProducts();
    }
}
