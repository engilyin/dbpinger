package asl.dbpinger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DbPingerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbPingerApplication.class, args);
	}
}
