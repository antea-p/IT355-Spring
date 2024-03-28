package ac.rs.metropolitan.anteaprimorac5157.service;

import ac.rs.metropolitan.anteaprimorac5157.entity.Order;

import jakarta.servlet.http.HttpSession;
import org.springframework.validation.BindingResult;

public interface CheckoutService {
    boolean validateAndProcessCheckout(Order order, BindingResult result, HttpSession session);
}