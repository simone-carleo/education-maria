package it.adt.comparison.service.impl;


import it.adt.comparison.Product;
import it.adt.comparison.dto.ProductDto;
import it.adt.comparison.repository.BrandRepository;
import it.adt.comparison.repository.ProductRepository;
import it.adt.comparison.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    public Product create(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setBrand(brandRepository.findById(productDto.getId_brand()));
        return this.productRepository.save(product);

    }
    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }
}
