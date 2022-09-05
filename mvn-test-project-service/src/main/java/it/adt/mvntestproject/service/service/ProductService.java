package it.adt.mvntestproject.service.service;

import it.adt.mvntestproject.dao.entity.Product;
import it.adt.mvntestproject.dto.ProductDto;

import java.util.List;

public interface ProductService {
    Product create(ProductDto productDto);
    List<Product> getAllProducts();
}
