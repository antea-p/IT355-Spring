package ac.rs.metropolitan.anteaprimorac5157.controller;

import ac.rs.metropolitan.anteaprimorac5157.entity.Order;
import ac.rs.metropolitan.anteaprimorac5157.service.CheckoutService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @GetMapping
    public String showCheckoutForm(Model model, HttpSession session) {
        if (session.getAttribute("cart") == null || ((Map<?, ?>) session.getAttribute("cart")).isEmpty()) {
            return "redirect:/cart";
        }

        model.addAttribute("order", new Order());
        return "checkout_form";
    }

    @PostMapping
    public String processCheckout(@ModelAttribute("order") Order order, BindingResult result, HttpSession session, Model model) {
        if (!checkoutService.validateAndProcessCheckout(order, result, session)) {
            if (result.hasErrors()) {
                return "checkout_form";
            }
            return "redirect:/cart";
        }

        model.addAttribute("order", order);
        return "confirmation";
    }

    @GetMapping("/confirmation")
    public String showConfirmation(@ModelAttribute("order") Order order) {
        return "confirmation";
    }

}
