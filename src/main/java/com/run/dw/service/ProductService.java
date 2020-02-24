package com.run.dw.service;
import java.util.Collection;
import com.run.dw.support.Product;

/**
 * @author liqinghua
 */
public interface ProductService {
    public abstract void createProduct(Product product);
    public abstract void updateProduct(String id, Product product);
    public abstract void deleteProduct(String id);
    public abstract Collection<Product> getProducts();
}