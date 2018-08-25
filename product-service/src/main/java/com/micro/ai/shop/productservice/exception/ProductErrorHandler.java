package com.micro.ai.shop.productservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProductErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ProductNotFoundException.class}) 
    public ResponseEntity<ErrorResponse> productNotFoundException(final ProductNotFoundException e) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.toString(), e.toString()), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler({ProductStatusChangeException.class}) 
    public ResponseEntity<ErrorResponse> productStatusChangeException(final ProductStatusChangeException e) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.toString(), e.toString()), HttpStatus.NOT_FOUND);
    }
}
