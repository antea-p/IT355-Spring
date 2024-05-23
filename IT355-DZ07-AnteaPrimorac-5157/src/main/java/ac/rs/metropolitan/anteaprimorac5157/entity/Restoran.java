package ac.rs.metropolitan.anteaprimorac5157.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restoran")
public class Restoran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Naziv ne može biti prazan")
    @Column(name = "naziv")
    private String naziv;

    @NotBlank(message = "Adresa ne može biti prazna")
    @Column(name = "adresa")
    private String adresa;

    @NotBlank(message = "Telefon ne može biti prazan")
    @Column(name = "telefon")
    private String telefon;

    @DecimalMin(value = "1.00", message = "Ocena mora biti barem 1")
    @Column(name = "ocena")
    private double ocena;

    @OneToMany(mappedBy = "restoran", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Jelo> jela = new ArrayList<>();

    public Restoran() {
    }

    public Restoran(Long id, String naziv, String adresa, String telefon, double ocena, List<Jelo> jela) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.telefon = telefon;
        this.ocena = ocena;
        this.jela = jela;
    }

    public Long getId() {
        return id;
    }

    public Restoran setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNaziv() {
        return naziv;
    }

    public Restoran setNaziv(String naziv) {
        this.naziv = naziv;
        return this;
    }

    public String getAdresa() {
        return adresa;
    }

    public Restoran setAdresa(String adresa) {
        this.adresa = adresa;
        return this;
    }

    public String getTelefon() {
        return telefon;
    }

    public Restoran setTelefon(String telefon) {
        this.telefon = telefon;
        return this;
    }

    public double getOcena() {
        return ocena;
    }

    public Restoran setOcena(double ocena) {
        this.ocena = ocena;
        return this;
    }

    public List<Jelo> getJela() {
        return jela;
    }

    public Restoran setJela(List<Jelo> jela) {
        this.jela = jela;
        return this;
    }

    @Override
    public String toString() {
        return "Restoran{" +
                "id=" + id +
                ", naziv=" + naziv +
                ", adresa=" + adresa +
                ", telefon=" + telefon +
                ", ocena=" + ocena +
                '}';
    }
}