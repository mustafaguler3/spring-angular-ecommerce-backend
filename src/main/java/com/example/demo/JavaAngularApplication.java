package com.example.demo;

import com.example.demo.utils.SeedData;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JavaAngularApplication implements CommandLineRunner {

	@Autowired
	private SeedData seedData;

	public static void main(String[] args) {
		SpringApplication.run(JavaAngularApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		seedData.seedData();
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}



}
