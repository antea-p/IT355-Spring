package ac.rs.metropolitan.anteaprimorac5157.service;

import ac.rs.metropolitan.anteaprimorac5157.entity.Product;

import java.util.Map;

public interface CartService {

    Map<Product, Integer> initializeCart();

    void addToCart(Long productId, Map<Product, Integer> cart);

    void removeFromCart(Long productId, Map<Product, Integer> cart);

    void setQuantity(Long productId, int quantity, Map<Product, Integer> cart);

    void decrementQuantity(Long productId, Map<Product, Integer> cart);

    double calculateTotalPrice(Map<Product, Integer> cart);
}
