package com.run.dw.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author liqinghua
 */
@ControllerAdvice
public class ProductExceptionController {
    @ExceptionHandler(value = ProductNotfoundException.class)
    public ResponseEntity<Object> exception(ProductNotfoundException exception) {
        System.out.print("capture the exception\n");
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }
}
