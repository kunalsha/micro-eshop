package com.micro.ai.shop.productservice;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.micro.ai.shop.productservice.entity.Product;
import com.micro.ai.shop.productservice.repository.ProductRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ProductServiceApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repo.saveAll(Arrays.asList(new Product("Product-A", "Product-A is a nice item", 349.00, 23),
				new Product("Product-B", "Product-B is a cheap item", 3493.00, 223),
				new Product("Product-C", "Product-C is a fake item", 393.00, 237),
				new Product("Product-D", "Product-D is a raw item", 34493.00, 233),
				new Product("Product-E", "Product-E is a great item", 493.00, 239)));
	}
}
