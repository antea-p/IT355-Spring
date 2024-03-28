package ac.rs.metropolitan.anteaprimorac5157.controller;

import ac.rs.metropolitan.anteaprimorac5157.entity.Product;
import ac.rs.metropolitan.anteaprimorac5157.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @ModelAttribute("cart")
    public Map<Product, Integer> initCart() {
        return cartService.initializeCart();
    }

    @GetMapping
    public String viewCart(@ModelAttribute("cart") Map<Product, Integer> cart, Model model) {
        double totalPrice = cartService.calculateTotalPrice(cart);
        model.addAttribute("cart", cart);
        model.addAttribute("totalPrice", totalPrice);
        return "cart_view";
    }

    @GetMapping("/add/{productId}")
    public String addToCart(@PathVariable Long productId, @ModelAttribute("cart") Map<Product, Integer> cart) {
        cartService.addToCart(productId, cart);
        return "redirect:/";
    }

    @GetMapping("/remove/{productId}")
    public String removeFromCart(@PathVariable Long productId, @ModelAttribute("cart") Map<Product, Integer> cart) {
        cartService.removeFromCart(productId, cart);
        return "redirect:/cart";
    }

    @PostMapping("/set/{productId}")
    public String setQuantity(@PathVariable Long productId, @RequestParam("quantity") int quantity, @ModelAttribute("cart") Map<Product, Integer> cart) {
        cartService.setQuantity(productId, quantity, cart);
        return "redirect:/cart";
    }

    @GetMapping("/increment/{productId}")
    public String incrementQuantity(@PathVariable Long productId, @ModelAttribute("cart") Map<Product, Integer> cart) {
        cartService.addToCart(productId, cart);
        return "redirect:/cart";
    }

    @GetMapping("/decrement/{productId}")
    public String decrementQuantity(@PathVariable Long productId, @ModelAttribute("cart") Map<Product, Integer> cart) {
        cartService.decrementQuantity(productId, cart);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout() {
        return "redirect:/checkout";
    }


}
