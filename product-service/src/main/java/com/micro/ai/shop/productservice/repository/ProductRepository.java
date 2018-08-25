package com.micro.ai.shop.productservice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.micro.ai.shop.productservice.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	public Iterable<Product> findAll();
	public Optional<Product> findByName(String name);
	public Product save(Product p);
	public void deleteByName(String name);
}
