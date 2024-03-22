package ac.rs.metropolitan.anteaprimorac5157.controller;

import ac.rs.metropolitan.anteaprimorac5157.domain.Car;
import ac.rs.metropolitan.anteaprimorac5157.domain.User;
import ac.rs.metropolitan.anteaprimorac5157.domain.Rental;
import ac.rs.metropolitan.anteaprimorac5157.domain.RentalValidator;
import ac.rs.metropolitan.anteaprimorac5157.service.CarService;
import ac.rs.metropolitan.anteaprimorac5157.service.UserService;
import ac.rs.metropolitan.anteaprimorac5157.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import java.util.List;
import java.util.Optional;

@Controller
public class RentalController {

    private final CarService carService;
    private final UserService userService;
    private final RentalService rentalService;
    private final RentalValidator rentalValidator;

    @Autowired
    public RentalController(CarService carService, UserService userService, RentalService rentalService, RentalValidator rentalValidator) {
        this.carService = carService;
        this.userService = userService;
        this.rentalService = rentalService;
        this.rentalValidator = rentalValidator;
    }

    @ModelAttribute("cars")
    public List<Car> populateCars() {
        return carService.listAllCars();
    }

    @GetMapping("/")
    public String showForm(Model model) {
        if (!model.containsAttribute("rental")) {
            model.addAttribute("rental", new Rental());
        }
        return "selectCar";
    }

    @PostMapping("/rent")
    public String submitForm(@ModelAttribute("rental") @Validated Rental rental, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "selectCar";
        } else {

            User user = userService.addUser(rental.getUser());
            rental.setUser(user);

            Optional<Car> carOptional = carService.findCarById(rental.getCar().getId());
            if (carOptional.isPresent()) {
                rental.setCar(carOptional.get());
            } else {
                result.rejectValue("car", "error.carNotFound", "The selected car could not be found.");
                return "selectCar";
            }

            if (rentalService.rentalExists(rental)) {
                result.rejectValue("car", "error.duplicateRental", "You have already rented this car.");
                return "selectCar";
            }

            System.out.println(rental.getCar());
            rentalService.registerRental(rental);
            status.setComplete();
            return "redirect:/rentals";
        }
    }

    @GetMapping("/rentals")
    public String showRentals(Model model) {
        model.addAttribute("rentals", rentalService.getAllRentals());
        return "listOfRentals";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(rentalValidator);
    }
}