package it.prom.itprom;

import org.apache.catalina.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class ItpromApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItpromApplication.class, args);
	}



}
