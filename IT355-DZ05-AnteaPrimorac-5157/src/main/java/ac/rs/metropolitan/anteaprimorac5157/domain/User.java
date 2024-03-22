package ac.rs.metropolitan.anteaprimorac5157.domain;

import java.util.Objects;
import java.util.UUID;

public class User {
    private Long id;
    private String fullName;
    private String email;
    private String licenseNumber;

    public User() {
    }

    public User(Long id, String fullName, String email, String licenseNumber) {
        this.id = Long.valueOf(UUID.randomUUID().toString());
        this.fullName = fullName;
        this.email = email;
        this.licenseNumber = licenseNumber;
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public User setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(fullName, user.fullName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(licenseNumber, user.licenseNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, email, licenseNumber);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName=" + fullName +
                ", email=" + email +
                ", licenseNumber=" + licenseNumber +
                '}';
    }
}

