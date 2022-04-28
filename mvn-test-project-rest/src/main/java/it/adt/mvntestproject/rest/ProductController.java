package it.adt.mvntestproject.rest;

import it.adt.mvntestproject.dao.entity.Brand;
import it.adt.mvntestproject.dao.entity.Product;
import it.adt.mvntestproject.dto.BrandDto;
import it.adt.mvntestproject.dto.ProductDto;
import it.adt.mvntestproject.service.BrandService;
import it.adt.mvntestproject.service.ProductService;
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

    @PostMapping(value = "/brand", produces = { MediaType.APPLICATION_JSON_VALUE})
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
