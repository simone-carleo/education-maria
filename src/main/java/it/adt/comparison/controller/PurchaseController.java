package it.adt.comparison.controller;

import it.adt.comparison.Purchase;
import it.adt.comparison.dto.PurchaseDto;
import it.adt.comparison.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value= "api/v1")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping(value = "/purchase", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Purchase create(@RequestBody PurchaseDto purchaseDto){
        return this.purchaseService.create(purchaseDto);
    }

    @GetMapping(value = "/purchase", produces = { MediaType.APPLICATION_JSON_VALUE})
    public void filteredList(@RequestParam(value = "firstName", required = false) String firstName,
                            @RequestParam(value = "lastName", required = false) String lastName,
                            @RequestParam(value = "productName", required = false) String productName,
                            @RequestParam(value = "productPrice", required = false) String productPrice){

            List<Purchase> purchases = new ArrayList();
            System.out.println(purchases);

    }
}
