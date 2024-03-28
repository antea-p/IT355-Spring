package ac.rs.metropolitan.anteaprimorac5157.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String address;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderProduct> orderProducts = new ArrayList<>();

    public Order() {
    }

    public Order(Long id, String name, String surname, String address, LocalDate date, List<OrderProduct> orderProducts) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.orderProducts = orderProducts;
    }

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Order setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Order setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Order setAddress(String address) {
        this.address = address;
        return this;
    }

    public Double getTotalPrice() {
        return orderProducts.stream().mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity()).sum();
    }


    public void addProduct(Product product, int quantity) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setOrder(this);
        orderProduct.setProduct(product);
        orderProduct.setQuantity(quantity);
        orderProducts.add(orderProduct);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name=" + name +
                ", surname=" + surname +
                ", address=" + address +
                ", orderProducts=" + orderProducts +
                '}';
    }
}
