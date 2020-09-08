package com.internet.shop.services;

import com.internet.shop.models.Product;
import java.util.List;

public interface ProductService {

    Product create(Product product);

    Product get(Long id);

    List<Product> getAll();

    Product update(Product product);

    boolean delete(Long id);
}
