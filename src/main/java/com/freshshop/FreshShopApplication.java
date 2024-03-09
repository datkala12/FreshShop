package com.freshshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.freshshop.repository")
@EntityScan("com.freshshop.model")
@EnableJpaAuditing (auditorAwareRef = "auditAwareImpl")
public class FreshShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreshShopApplication.class, args);
	}

}
