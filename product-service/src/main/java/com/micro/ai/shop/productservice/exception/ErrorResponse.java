package com.micro.ai.shop.productservice.exception;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter 
public class ErrorResponse {
	
    public ErrorResponse() {
		super();
	}
    
	public ErrorResponse(String code, String message) {
    	this.code = code;
    	this.message = message;
	}

    @NotBlank private String code;
    @NotBlank private String message;
}
