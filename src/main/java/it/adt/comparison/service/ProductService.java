package it.adt.comparison.service;

import it.adt.comparison.dto.ProductDto;

public interface ProductService {
    void create(ProductDto productDto);
    void getAllProducts();
}
