package rs.ac.metropolitan.anteaprimorac5157;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import rs.ac.metropolitan.anteaprimorac5157.interfaces.Oblik;
import rs.ac.metropolitan.anteaprimorac5157.interfaces.impl.JednakostranicniTrougao;
import rs.ac.metropolitan.anteaprimorac5157.interfaces.impl.Krug;
import rs.ac.metropolitan.anteaprimorac5157.interfaces.impl.Kvadrat;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "rs.ac.metropolitan.anteaprimorac5157")
public class AppConfiguration {

    @Bean(name = "oblik")
    public Oblik getOblik() {
        return new Krug(4);
    }

    @Bean(name = "krugOblik")
    public Oblik getKrug() {
        return new Krug(4);
    }

    @Bean(name = "kvadratOblik")
    public Oblik getKvadrat() {
        return new Kvadrat(3);
    }

    @Bean(name = "jednakostranicniTrougaoOblik")
    public Oblik getJednakostranicniTrougao() {
        return new JednakostranicniTrougao(7.2);
    }

    @Bean(name = "oblikService")
    public OblikService oblikService() {
        return new OblikService();
    }

    @Bean
    public OblikLoggingAspect oblikLoggingAspect() {
        return new OblikLoggingAspect();
    }
}
