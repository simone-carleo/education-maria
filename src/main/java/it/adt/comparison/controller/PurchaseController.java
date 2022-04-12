package it.adt.comparison.controller;

import it.adt.comparison.Purchase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value= "api/v1")
public class PurchaseController {


    @GetMapping(value = "/purchase", produces = { MediaType.APPLICATION_JSON_VALUE})
    public void filteredList(@RequestParam(value = "firstName", required = false) String firstName,
                            @RequestParam(value = "lastName", required = false) String lastName,
                            @RequestParam(value = "productName", required = false) String productName,
                            @RequestParam(value = "productPrice", required = false) String productPrice){

            List<Purchase> purchases = new ArrayList();
            System.out.println(purchases);

    }
}
