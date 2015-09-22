package com.marsanvi.crypto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application  implements CommandLineRunner {

	@Autowired
	CaesarService caesarService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Override
	public void run(String... strings) throws Exception {
		String ressult = caesarService.encode("hello", 1);
		System.out.println(ressult);
	}
}
