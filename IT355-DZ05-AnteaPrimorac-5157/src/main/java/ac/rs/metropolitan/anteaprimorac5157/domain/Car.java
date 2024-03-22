package ac.rs.metropolitan.anteaprimorac5157.domain;

public class Car {
    private Long id;
    private String make;
    private String model;
    private int year;

    public Car() {
    }

    public Car(Long id, String make, String model, int year) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public Car setId(Long id) {
        this.id = id;
        return this;
    }

    public String getMake() {
        return make;
    }

    public Car setMake(String make) {
        this.make = make;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public int getYear() {
        return year;
    }

    public Car setYear(int year) {
        this.year = year;
        return this;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make=" + make +
                ", model=" + model +
                ", year=" + year +
                '}';
    }
}
