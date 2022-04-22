package it.adt.comparison.service;

import it.adt.comparison.Purchase;
import it.adt.comparison.dto.PurchaseDto;

import java.util.List;

public interface PurchaseService {
    Purchase create(PurchaseDto purchaseDto);
    List<Purchase> getFilteredList(String firstName, String lastName, String productName, Double productPrice);
}
