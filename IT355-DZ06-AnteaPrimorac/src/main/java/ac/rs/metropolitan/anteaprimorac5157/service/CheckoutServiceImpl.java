package ac.rs.metropolitan.anteaprimorac5157.service;

import ac.rs.metropolitan.anteaprimorac5157.entity.Order;
import ac.rs.metropolitan.anteaprimorac5157.entity.OrderProduct;
import ac.rs.metropolitan.anteaprimorac5157.entity.Product;
import ac.rs.metropolitan.anteaprimorac5157.repository.OrderProductRepository;
import ac.rs.metropolitan.anteaprimorac5157.repository.OrderRepository;
import ac.rs.metropolitan.anteaprimorac5157.service.CheckoutService;
import ac.rs.metropolitan.anteaprimorac5157.validator.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import jakarta.servlet.http.HttpSession;
import java.util.Map;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;
    private final OrderValidator orderValidator;

    @Autowired
    public CheckoutServiceImpl(OrderRepository orderRepository, OrderProductRepository orderProductRepository, OrderValidator orderValidator) {
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
        this.orderValidator = orderValidator;
    }

    @Override
    public boolean validateAndProcessCheckout(Order order, BindingResult result, HttpSession session) {
        orderValidator.validate(order, result);
        if (result.hasErrors()) {
            return false;
        }

        Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
        if (cart == null || cart.isEmpty()) {
            return false;
        }

        cart.forEach((product, quantity) -> {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setOrder(order);
            orderProduct.setProduct(product);
            orderProduct.setQuantity(quantity);
            order.addProduct(orderProduct.getProduct(), orderProduct.getQuantity());
        });

        orderRepository.save(order);
        session.removeAttribute("cart");
        return true;
    }
}