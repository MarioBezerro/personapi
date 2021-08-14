package one.digitalinnovationpersonapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class PersonapiApplication {

	public static void main(String[] args) {

		SpringApplication.run(PersonapiApplication.class, args);
	}

}
