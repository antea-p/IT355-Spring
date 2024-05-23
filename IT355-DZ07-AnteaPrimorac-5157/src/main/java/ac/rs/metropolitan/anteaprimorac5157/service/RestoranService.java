package ac.rs.metropolitan.anteaprimorac5157.service;

import ac.rs.metropolitan.anteaprimorac5157.entity.Restoran;
import java.util.List;
import java.util.Optional;

public interface RestoranService {

    Optional<Restoran> get(Long id);

    List<Restoran> list();

    Long count();

    Restoran save(Restoran restoran);

    void delete(Long id);
}
