package ac.rs.metropolitan.anteaprimorac5157.service;

import ac.rs.metropolitan.anteaprimorac5157.entity.Jelo;

import java.util.List;

public interface JeloService {
    Jelo get(Long id);

    List<Jelo> list();

    Long count();

    void delete(Long id);

    Jelo save(Jelo jelo);

    List<Jelo> filterByNaziv(String naziv);
}
