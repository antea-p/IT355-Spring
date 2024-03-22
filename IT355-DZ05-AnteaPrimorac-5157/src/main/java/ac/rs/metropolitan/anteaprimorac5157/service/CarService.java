package ac.rs.metropolitan.anteaprimorac5157.service;

import ac.rs.metropolitan.anteaprimorac5157.domain.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> listAllCars();

    Optional<Car> findCarById(Long id);
}
