package it.adt.mvntestproject.service;

import it.adt.mvntestproject.dao.entity.Purchase;
import it.adt.mvntestproject.dto.PurchaseDto;

import java.util.List;

public interface PurchaseService {
    Purchase create(PurchaseDto purchaseDto);
    List<Purchase> getFilteredList(String firstName, String lastName, String productName, Double productPrice);
}
