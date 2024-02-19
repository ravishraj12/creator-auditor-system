package com.wibmo.mce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@ComponentScan("com.wibmo.*")
@EnableJdbcRepositories
public class MCEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(MCEngineApplication.class, args);
	}

}
