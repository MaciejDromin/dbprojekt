package pl.mlisowski.dbprojekt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbprojektApplication {

	public static void main(String[] args) {
		SpringApplication sa = new SpringApplication(DbprojektApplication.class);
		sa.run(args);
	}

}
