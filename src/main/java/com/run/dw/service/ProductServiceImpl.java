package com.run.dw.service;

import com.run.dw.exception.ProductNotfoundException;
import com.run.dw.support.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/**
 * @author liqinghua
 */
@Service
public class ProductServiceImpl implements ProductService {
    private static Map<String, Product> productRepo = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);

        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }
    @Override
    public void createProduct(Product product) {
        productRepo.put(product.getId(), product);
    }

    @Override
    public void updateProduct(String id, Product product) {
        if(!productRepo.containsKey(id)) {
            throw new ProductNotfoundException();
        }
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
    }

    @Override
    public void deleteProduct(String id) {
        if(!productRepo.containsKey(id)) {
            throw new ProductNotfoundException();
        }
        logger.info(String.format("%s %s %s", "productRepo is delete",productRepo.get(id).getName(),productRepo.get(id).getId()));
        productRepo.remove(id);

    }

    @Override
    public Collection<Product> getProducts() {
        return productRepo.values();

    }
}

