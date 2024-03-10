package rs.ac.metropolitan.anteaprimorac5157;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rs.ac.metropolitan.anteaprimorac5157.interfaces.Oblik;
import rs.ac.metropolitan.anteaprimorac5157.interfaces.impl.Krug;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        OblikService oblikService = context.getBean(OblikService.class);

        oblikService.ispisiObim();
        System.out.println("----------");
        oblikService.ispisiPovrsinu();
    }

}