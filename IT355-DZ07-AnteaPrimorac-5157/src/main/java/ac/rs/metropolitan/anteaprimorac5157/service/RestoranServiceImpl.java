package ac.rs.metropolitan.anteaprimorac5157.service;

import ac.rs.metropolitan.anteaprimorac5157.entity.Restoran;
import ac.rs.metropolitan.anteaprimorac5157.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RestoranServiceImpl implements RestoranService {

    private final RestoranRepository restoranRepository;

    @Autowired
    public RestoranServiceImpl(RestoranRepository restoranRepository) {
        this.restoranRepository = restoranRepository;
    }

    @Override
    public List<Restoran> list() {
        return restoranRepository.findAll();
    }

    @Override
    public Long count() { return restoranRepository.count(); }

    @Override
    public Optional<Restoran> get(Long id) {
        return restoranRepository.findById(id);
    }

    @Override
    public Restoran save(Restoran restoran) {
        return restoranRepository.save(restoran);
    }

    @Override
    public void delete(Long id) {
        restoranRepository.deleteById(id);
    }
}
