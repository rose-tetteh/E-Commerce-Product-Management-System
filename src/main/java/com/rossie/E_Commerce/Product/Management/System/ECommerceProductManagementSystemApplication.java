package com.rossie.E_Commerce.Product.Management.System;

import org.springframework.boot.SpringApplication;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;

@SpringBootApplication
public class ECommerceProductManagementSystemApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.load();

		System.setProperty("DATABASE_USERNAME", Objects.requireNonNull(dotenv.get("DATABASE_USERNAME")));
		System.setProperty("DATABASE_PASSWORD", Objects.requireNonNull(dotenv.get("DATABASE_PASSWORD")));

		SpringApplication.run(ECommerceProductManagementSystemApplication.class, args);
	}

}
