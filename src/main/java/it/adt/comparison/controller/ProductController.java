package it.adt.comparison.controller;

import it.adt.comparison.Product;
import it.adt.comparison.dto.ProductDto;
import it.adt.comparison.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value= "api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/product", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void create(@RequestBody ProductDto productDto){
        System.out.println("null");
    }

    @GetMapping(value = "/product/find-all-products", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void getAllProducts(){
        List<Product> products = new ArrayList();
        System.out.println(products);
    }
}
