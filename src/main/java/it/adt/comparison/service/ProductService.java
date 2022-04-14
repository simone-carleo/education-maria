package it.adt.comparison.service;

import it.adt.comparison.Product;
import it.adt.comparison.dto.ProductDto;

import java.util.List;

public interface ProductService {
    Product create(ProductDto productDto);
    List<Product> getAllProducts();
}
