package com.micro.ai.shop.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.ai.shop.productservice.entity.Product;
import com.micro.ai.shop.productservice.exception.ProductStatusChangeException;
import com.micro.ai.shop.productservice.exception.ProductNotFoundException;
import com.micro.ai.shop.productservice.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/product")
@Api(value = "Product-Service", description = "Endpoint for Product management")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@ApiOperation(value = "Get All Products", notes = "Get all products", response = ResponseEntity.class)
	@GetMapping(value="/all", produces="application/json",  consumes="application/json")
	public ResponseEntity<Iterable<Product>> getProducts() throws ProductNotFoundException {
		return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Product", notes = "Get product with given name", response = ResponseEntity.class)
	@GetMapping(value="/{productName}", produces="application/json",  consumes="application/json")
	public ResponseEntity<Product> getProductByName(@PathVariable String productName) throws ProductNotFoundException {
		return new ResponseEntity<>(service.findProduct(productName),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Save Product", notes = "Save product", response = ResponseEntity.class)
	@PostMapping(value="/", produces="application/json",  consumes="application/json")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws ProductStatusChangeException {
		return new ResponseEntity<>(service.addProduct(product),HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Update Product", notes = "Update product with given name", response = ResponseEntity.class)
	@PutMapping(value="/{productName}", produces="application/json",  consumes="application/json")
	public ResponseEntity<Product> addProduct(@PathVariable String productName, @RequestBody Product product) throws ProductStatusChangeException, ProductNotFoundException {
		return new ResponseEntity<>(service.updateProduct(productName, product),HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Delete Product", notes = "Delete product with given name", response = ResponseEntity.class)
	@DeleteMapping(value="/{productName}", produces="application/json",  consumes="application/json")
	public ResponseEntity<?> deleteProductByName(@PathVariable String productName) throws ProductNotFoundException {
		service.deleteProduct(productName);
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
}
