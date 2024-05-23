package ac.rs.metropolitan.anteaprimorac5157.service;

import ac.rs.metropolitan.anteaprimorac5157.entity.Jelo;
import ac.rs.metropolitan.anteaprimorac5157.repository.JeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JeloServiceImpl implements JeloService {

    private final JeloRepository jeloRepository;

    public JeloServiceImpl(JeloRepository jeloRepository) {
        this.jeloRepository = jeloRepository;
    }

    @Override
    public Jelo get(Long id) {
        return jeloRepository.findById(id).orElse(null);
    }

    @Override
    public List<Jelo> list() {
        return jeloRepository.findAll();
    }

    @Override
    public Long count() {
        return jeloRepository.count();
    }

    @Override
    public void delete(Long id) {
        jeloRepository.deleteById(id);
    }

    @Override
    public Jelo save(Jelo jelo) {
        return jeloRepository.save(jelo);
    }

    @Override
    public List<Jelo> filterByNaziv(String naziv) {
        return jeloRepository.findByNazivContainingIgnoreCase(naziv);
    }
}
