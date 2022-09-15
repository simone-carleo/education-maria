package it.adt.mvntestproject.rest;

import it.adt.mvntestproject.common.exception.EntityNotFoundException;
import it.adt.mvntestproject.dto.PurchaseDto;
import it.adt.mvntestproject.dto.PurchaseSave;
import it.adt.mvntestproject.service.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "api/v1")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;


    @PostMapping(value = "/purchase", produces = { MediaType.APPLICATION_JSON_VALUE})
    public PurchaseDto create(@RequestBody PurchaseSave purchaseSave) throws EntityNotFoundException {
        return this.purchaseService.create(purchaseSave);
    }

    @GetMapping(value = "/purchase/find-all-purchases", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<PurchaseDto> getPurchase(){
        return purchaseService.getPurchases();
    }

    @GetMapping(value = "/purchase/filtered-list", produces = { MediaType.APPLICATION_JSON_VALUE})
    public List<PurchaseDto> filteredList(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName,
            @RequestParam(value = "productName", required = false) String productName,
            @RequestParam(value = "productPrice", required = false) Double productPrice){


        return purchaseService.getFilteredList(firstName, lastName, productName, productPrice);
    }

}
