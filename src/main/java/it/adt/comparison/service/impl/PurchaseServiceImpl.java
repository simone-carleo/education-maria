package it.adt.comparison.service.impl;

import it.adt.comparison.Purchase;
import it.adt.comparison.dto.PurchaseDto;
import it.adt.comparison.repository.PurchaseRepository;
import it.adt.comparison.repository.UserRepository;
import it.adt.comparison.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private UserRepository userRepository;

    public Purchase create(PurchaseDto purchaseDto){
        Purchase purchase = new Purchase();
        purchase.setFirstName(purchaseDto.getFirstNameUser());
        purchase.setLastName(purchaseDto.getLastNameUser());
        purchase.setProductName(purchaseDto.getProductName());
        purchase.setProductPrice(purchaseDto.getProductPrice());
        purchase.setPurchaseDate(purchaseDto.getPurchaseDate());
        purchase.setPurchasePrice(purchaseDto.getPurchasePrice());
        purchase.setReceiptCode(purchaseDto.getReceiptCode());
        purchase.setUser(userRepository.findById(purchaseDto.getIdUser()));
        return this.purchaseRepository.save(purchase);
    }


    public void getFilteredList(String firstName, String lastName, String productName, String productPrice){
        //TODO get filtered list of purchases
    }
}
