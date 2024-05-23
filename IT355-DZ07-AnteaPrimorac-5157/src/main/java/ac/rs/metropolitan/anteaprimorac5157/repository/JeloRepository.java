package ac.rs.metropolitan.anteaprimorac5157.repository;

import ac.rs.metropolitan.anteaprimorac5157.entity.Jelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JeloRepository extends JpaRepository<Jelo, Long>  {

    List<Jelo> findByNazivContainingIgnoreCase(String naziv);

}
