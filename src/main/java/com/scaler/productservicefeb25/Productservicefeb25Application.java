package com.scaler.productservicefeb25;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Productservicefeb25Application {

	public static void main(String[] args) {
		SpringApplication.run(Productservicefeb25Application.class, args);
	}

}
