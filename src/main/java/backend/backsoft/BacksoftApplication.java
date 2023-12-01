package backend.backsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "backend.backsoft") // Asegúrate de que esto incluye el paquete de la configuración

public class BacksoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(BacksoftApplication.class, args);
	}

}
