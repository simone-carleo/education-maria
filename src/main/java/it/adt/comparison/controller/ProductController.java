package it.adt.comparison.controller;

import it.adt.comparison.Brand;
import it.adt.comparison.Product;
import it.adt.comparison.dto.BrandDto;
import it.adt.comparison.dto.ProductDto;
import it.adt.comparison.service.BrandService;
import it.adt.comparison.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private BrandService brandService;

    @PostMapping(value = "/brand", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Brand create(@RequestBody BrandDto brandDto){
        return this.brandService.create(brandDto);
    }

    @PostMapping(value = "/product", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Product create(@RequestBody ProductDto productDto){
        return this.productService.create(productDto);
    }

    @GetMapping(value = "/product/find-all-products", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> getAllProducts(){
        return (List<Product>) productService.getAllProducts();
    }
}
