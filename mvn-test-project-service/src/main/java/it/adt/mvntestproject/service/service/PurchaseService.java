package it.adt.mvntestproject.service.service;

import it.adt.mvntestproject.dao.entity.Purchase;
import it.adt.mvntestproject.dto.PurchaseDto;
import it.adt.mvntestproject.dto.PurchaseSave;

import java.util.List;

public interface PurchaseService {
    PurchaseDto create(PurchaseSave purchaseSave);
    List<PurchaseDto> getPurchases();
    List<Purchase> getFilteredList(String firstName, String lastName, String productName, Double productPrice);
}
