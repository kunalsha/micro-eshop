package com.micro.ai.shop.productservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity 
@Table(name="Product")
@Getter @Setter
public class Product {

    public Product() {
		super();
	}
    
	public Product(String name, String desc, double price, int quantity) {
    	this.name = name;
    	this.description = desc;
    	this.price = price;
    	this.quantity = quantity;
	}
    
	@Id @GeneratedValue
    private Long id;

    @NotBlank private String name;
    @NotBlank private String description;
    @Positive private double price;
    @Positive private long quantity;

}
