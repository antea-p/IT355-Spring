package ac.rs.metropolitan.anteaprimorac5157.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "jelo")
public class Jelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Naziv ne može biti prazan")
    @Column(name = "naziv")
    private String naziv;

    @NotBlank(message = "Opis ne može biti prazan")
    @Column(name = "opis")
    private String opis;

    @DecimalMin(value = "0.01", message = "Cena mora biti veća od 0")
    @Column(name = "cena")
    private double cena;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "restoran_id")
    private Restoran restoran;

    public Jelo() {
    }

    public Jelo(String naziv, String opis, double cena, Restoran restoran) {
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
        this.restoran = restoran;
    }

    public Long getId() {
        return id;
    }

    public Jelo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNaziv() {
        return naziv;
    }

    public Jelo setNaziv(String naziv) {
        this.naziv = naziv;
        return this;
    }

    public String getOpis() {
        return opis;
    }

    public Jelo setOpis(String opis) {
        this.opis = opis;
        return this;
    }

    public double getCena() {
        return cena;
    }

    public Jelo setCena(double cena) {
        this.cena = cena;
        return this;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public Jelo setRestoran(Restoran restoran) {
        this.restoran = restoran;
        return this;
    }

    @Override
    public String toString() {
        return "Jelo{" +
                "id=" + id +
                ", naziv=" + naziv +
                ", opis=" + opis +
                ", cena=" + cena +
                ", restoran=" + restoran +
                '}';
    }
}