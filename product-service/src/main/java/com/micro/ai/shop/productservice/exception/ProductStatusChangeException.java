package com.micro.ai.shop.productservice.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ProductStatusChangeException extends Throwable {

	private static final long serialVersionUID = 9100940879559328337L;

	public ProductStatusChangeException(String message) {
		super(message);
	}

}
