package rs.ac.metropolitan.anteaprimorac5157;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyFirstComponent {
    @Autowired
    private MyFirstRepository repository;

    public void showAppInfo() {
        System.out.println("Trenutno vreme: " + repository.getSystemDateTime());
        System.out.println("Naziv aplikacije: " + repository.getAppName());
    }
}
