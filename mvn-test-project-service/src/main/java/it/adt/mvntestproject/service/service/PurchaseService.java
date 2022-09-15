package it.adt.mvntestproject.service.service;

import it.adt.mvntestproject.common.exception.EntityNotFoundException;
import it.adt.mvntestproject.dto.PurchaseDto;
import it.adt.mvntestproject.dto.PurchaseSave;

import java.util.List;

public interface PurchaseService {
    PurchaseDto create(PurchaseSave purchaseSave) throws EntityNotFoundException;
    List<PurchaseDto> getPurchases();
    List<PurchaseDto> getFilteredList(String firstName, String lastName, String productName, Double productPrice);
}
