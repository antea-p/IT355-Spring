package ac.rs.metropolitan.anteaprimorac5157.service;

import ac.rs.metropolitan.anteaprimorac5157.entity.Product;
import ac.rs.metropolitan.anteaprimorac5157.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    private final ProductRepository productRepository;

    @Autowired
    public CartServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Map<Product, Integer> initializeCart() {
        return new HashMap<>();
    }

    @Override
    public void addToCart(Long productId, Map<Product, Integer> cart) {
        productRepository.findById(productId).ifPresent(product ->
                // dodaj na postojeću količinu tog proizvoda u korpi
                cart.merge(product, 1, Integer::sum)
        );
    }

    @Override
    public void removeFromCart(Long productId, Map<Product, Integer> cart) {
        productRepository.findById(productId).ifPresent(cart::remove);
    }

    @Override
    public void setQuantity(Long productId, int quantity, Map<Product, Integer> cart) {
        productRepository.findById(productId).ifPresent(product -> {
            if (quantity > 0) {
                cart.put(product, quantity);
            } else {
                cart.remove(product);
            }
        });
    }

    @Override
    public void decrementQuantity(Long productId, Map<Product, Integer> cart) {
        productRepository.findById(productId).ifPresent(product ->
                // ako je proizvod prisutan u korpi, primjenjuje dekrementiranje
                cart.computeIfPresent(product, (key, quantity) ->
                        quantity > 1 ? quantity - 1 : null
                ));

    }

    @Override
    public double calculateTotalPrice(Map<Product, Integer> cart) {
        return cart.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

}
