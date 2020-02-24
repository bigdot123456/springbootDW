package com.run.dw.controller;

import com.run.dw.DwApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.run.dw.support.Product;
import com.run.dw.service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liqinghua
 */
@RestController
public class ProductServiceController {
    private static final Logger logger = LoggerFactory.getLogger(DwApplication.class);
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {

        productService.updateProduct(id, product);
        return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
    }


    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

        @RequestMapping(value = "/products")
     public ResponseEntity<Object> getProduct() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }
}

