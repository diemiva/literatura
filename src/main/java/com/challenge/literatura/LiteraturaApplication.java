package com.challenge.literatura;

import com.challenge.literatura.major.Major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraturaApplication implements CommandLineRunner {

	private final Major major;

	@Autowired
	public LiteraturaApplication(Major major) {
		this.major = major;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		major.menuConsulta();
	}
}
