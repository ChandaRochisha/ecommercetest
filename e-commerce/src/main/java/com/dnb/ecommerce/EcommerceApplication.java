package com.dnb.ecommerce;

import java.time.LocalDate;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dnb.ecommerce.dto.Product;
import com.dnb.ecommerce.service.ProductService;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		//application context is  responsible for instantiating, wiring, configuring, and managing the entire life cycle of objects.
		ApplicationContext applicationContext= SpringApplication.run(EcommerceApplication.class, args);
	System.out.println("hello");

		
		
	}

}
