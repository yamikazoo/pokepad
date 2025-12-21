package com.github.yamikazoo.pokepad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class PokePadApplication {

	public static void main(String[] args) {
		Dotenv.configure().ignoreIfMissing().load();
		SpringApplication.run(PokePadApplication.class, args);
	}

}
