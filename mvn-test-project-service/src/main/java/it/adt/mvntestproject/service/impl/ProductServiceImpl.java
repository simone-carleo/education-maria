package it.adt.mvntestproject.service.impl;

import it.adt.mvntestproject.dao.entity.Product;
import it.adt.mvntestproject.dto.ProductDto;
import it.adt.mvntestproject.dao.repository.BrandRepository;
import it.adt.mvntestproject.dao.repository.ProductRepository;
import it.adt.mvntestproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
