package rs.ac.metropolitan.anteaprimorac5157;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class MyFirstRepository {
    public String getAppName() {
        return "Prvi Spring primer";
    }

    public Date getSystemDateTime() {
        return new Date();
    }
}
