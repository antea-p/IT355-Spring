package ac.rs.metropolitan.anteaprimorac5157.service;

import ac.rs.metropolitan.anteaprimorac5157.domain.Rental;

import java.util.List;

public interface RentalService {
    void registerRental(Rental rental);

    List<Rental> getAllRentals();

    boolean rentalExists(Rental newRental);
}
