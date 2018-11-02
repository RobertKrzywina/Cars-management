package pl.robert.springrestproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"controller", "repository"})
@EntityScan(basePackages = "model")
@EnableJpaRepositories(basePackages = "repository")
public class SpringrestProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringrestProjectApplication.class, args);
	}
}
