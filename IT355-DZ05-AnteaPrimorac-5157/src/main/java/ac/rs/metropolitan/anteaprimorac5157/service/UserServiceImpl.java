package ac.rs.metropolitan.anteaprimorac5157.service;

import ac.rs.metropolitan.anteaprimorac5157.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserServiceImpl implements UserService {
    private final List<User> users = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    // Pojednostavljeno dodavanje korisnika, s obzirom na činjenicu da aplikacija ne podržava registraciju u pravom smislu riječi.
    // Smatra se da korisnik već postoji u slučaju da forma sadrži identično ime i prezime, email i registarske tablice.
    public User addUser(User user) {
        Optional<User> existingUser = users.stream()
                .filter(u -> u.equals(user))
                .findFirst();

        if (existingUser.isPresent()) {
            return existingUser.get(); // Vrati postojećeg korisnika
        } else {
            user.setId(idCounter.incrementAndGet());
            users.add(user);
            return user;
        }
    }
}
