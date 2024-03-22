package ac.rs.metropolitan.anteaprimorac5157.service;

import ac.rs.metropolitan.anteaprimorac5157.domain.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    private final List<Car> cars = new ArrayList<>();

    public CarServiceImpl() {
        cars.add(new Car(1L, "Ford", "Mustang", 2020));
        cars.add(new Car(2L, "Toyota", "Corolla", 2021));
        cars.add(new Car(3L, "Honda", "Civic", 2022));
    }

    @Override
    public List<Car> listAllCars() {
        return cars;
    }

    @Override
    public Optional<Car> findCarById(Long id) {
        return cars.stream()
                .filter(car -> car.getId().equals(id))
                .findFirst();
    }
}
