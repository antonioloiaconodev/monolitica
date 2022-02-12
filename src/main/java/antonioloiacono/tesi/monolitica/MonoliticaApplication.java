package antonioloiacono.tesi.monolitica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("antonioloiacono.tesi.monolitica.repository")
@EntityScan(basePackages = {"antonioloiacono.tesi.monolitica.entity"})
public class MonoliticaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonoliticaApplication.class, args);
    }

}
