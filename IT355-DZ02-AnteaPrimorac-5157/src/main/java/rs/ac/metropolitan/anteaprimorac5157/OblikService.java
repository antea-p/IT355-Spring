package rs.ac.metropolitan.anteaprimorac5157;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import rs.ac.metropolitan.anteaprimorac5157.interfaces.Oblik;

@Service
public class OblikService {
    @Qualifier("krugOblik")
    @Autowired
    private Oblik oblik;

    public OblikService() {
    }

    public void ispisiObim() {
        System.out.printf("Obim oblika: %.3f \n", oblik.obim());
    }

    public void ispisiPovrsinu() {
        System.out.printf("Površina oblika: %.3f \n", oblik.povrsina());
    }
}