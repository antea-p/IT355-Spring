package ac.rs.metropolitan.anteaprimorac5157.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Rental {
    private Long id;
    private User user;
    private Car car;
    private LocalDateTime rentalDate;

    public Rental() {
        this.rentalDate = LocalDateTime.now();
    }

    public Rental(Long id, User user, Car car) {
        this.id = id;
        this.user = user;
        this.car = car;
        this.rentalDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Rental setId(Long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Rental setUser(User user) {
        this.user = user;
        return this;
    }

    public Car getCar() {
        return car;
    }

    public Rental setCar(Car car) {
        this.car = car;
        return this;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public Rental setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return Objects.equals(user, rental.user) &&
                Objects.equals(car, rental.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, car);
    }


    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", user=" + user +
                ", car=" + car +
                ", rentalDate=" + rentalDate +
                '}';
    }
}
