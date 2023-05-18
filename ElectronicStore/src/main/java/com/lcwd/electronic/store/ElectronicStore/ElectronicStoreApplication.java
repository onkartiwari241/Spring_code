package com.lcwd.electronic.store.ElectronicStore;

import com.lcwd.electronic.store.ElectronicStore.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ElectronicStoreApplication implements CommandLineRunner {

	public static void main(String[] args){
		SpringApplication.run(ElectronicStoreApplication.class, args);
	}

	@Autowired
	private SecurityConfig securityConfig;

	@Override
	public void run(String... args) throws Exception {

		System.out.println(securityConfig.passwordEncoder().encode("ankur") + "  Encode Pass");
	}
}
