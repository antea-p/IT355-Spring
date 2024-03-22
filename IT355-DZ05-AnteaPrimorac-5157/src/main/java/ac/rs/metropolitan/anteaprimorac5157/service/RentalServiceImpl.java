package ac.rs.metropolitan.anteaprimorac5157.service;

import ac.rs.metropolitan.anteaprimorac5157.domain.Rental;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class RentalServiceImpl implements RentalService {

    private final List<Rental> rentals = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @Override
    public void registerRental(Rental rental) {
        System.out.println(counter.get());
        rental.setId(counter.incrementAndGet());
        rentals.add(rental);
    }

    @Override
    public List<Rental> getAllRentals() {
        System.out.println(rentals);
        return rentals;
    }

    public boolean rentalExists(Rental newRental) {
        return rentals.stream().anyMatch(existingRental -> existingRental.equals(newRental));
    }

}
