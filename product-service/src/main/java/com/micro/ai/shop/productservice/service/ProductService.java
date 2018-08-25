package com.micro.ai.shop.productservice.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.ai.shop.productservice.entity.Product;
import com.micro.ai.shop.productservice.exception.ProductNotFoundException;
import com.micro.ai.shop.productservice.exception.ProductStatusChangeException;
import com.micro.ai.shop.productservice.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repo;
	
	public Iterable<Product> findAll() throws ProductNotFoundException {
		Iterable<Product> products =  repo.findAll();
		
		if(products==null) throw new ProductNotFoundException("No Product Found");
		
		return products;
	}
	
	public Product findProduct(String productName) throws ProductNotFoundException {
		return repo.findByName(productName).orElseThrow(() -> new ProductNotFoundException("No Product Found"));		
	}
	
	public Product addProduct(Product product) throws ProductStatusChangeException {
		Product createdProduct = repo.save(product);
		
		if(createdProduct==null) throw new ProductStatusChangeException("Error in creation of new Product");
		
		return createdProduct;
	}

	public Product updateProduct(String productName, Product product) throws ProductStatusChangeException, ProductNotFoundException {
		Optional<Product> currentProduct = repo.findByName(productName);
		
		if(!currentProduct.isPresent()) throw new ProductNotFoundException("No Product Found");
		
		product.setId(currentProduct.get().getId());
		
		Product createdProduct = repo.save(product);
		
		if(createdProduct==null) throw new ProductStatusChangeException("Error in updation of new Product");
		
		return createdProduct;	
	}
	
	@Transactional(rollbackOn= {ProductNotFoundException.class})
	public void deleteProduct(String productName) throws ProductNotFoundException {
		repo.deleteByName(productName);
		
		if(repo.findByName(productName).isPresent()) throw new ProductNotFoundException("No Product Found");		
			
	}
}
