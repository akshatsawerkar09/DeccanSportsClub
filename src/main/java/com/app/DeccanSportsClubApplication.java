package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.app")
@EnableJpaRepositories(basePackages = "com.app.dao")
@EntityScan(basePackages = "com.app.model")
public class DeccanSportsClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeccanSportsClubApplication.class, args);
	}

}
