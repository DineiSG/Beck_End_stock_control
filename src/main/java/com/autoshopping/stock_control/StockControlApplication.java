package com.autoshopping.stock_control;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableJpaRepositories
@EnableWebMvc
@SpringBootApplication
public class StockControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockControlApplication.class, args);
	}

}


