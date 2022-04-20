package it.adt.comparison.service;

import it.adt.comparison.Purchase;
import it.adt.comparison.dto.PurchaseDto;

public interface PurchaseService {
    Purchase create(PurchaseDto purchaseDto);
    void getFilteredList(String firstName, String lastName, String productName, String productPrice);
}
