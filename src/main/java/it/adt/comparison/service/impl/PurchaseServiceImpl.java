package it.adt.comparison.service.impl;


import it.adt.comparison.Purchase;
import it.adt.comparison.dto.PurchaseDto;
import it.adt.comparison.filter.PurchaseRecordFilter;
import it.adt.comparison.repository.PurchaseRepository;
import it.adt.comparison.repository.UserRepository;
import it.adt.comparison.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public List<Purchase> getFilteredList(String firstName, String lastName, String productName, Double productPrice){
   /*     JPAQuery<Purchase> jpaQuery = new JPAQuery<>(em);

        if(firstName == null && lastName == null && productName == null && productPrice == null){
            return (List<Purchase>) purchaseRepository.findAll();
        }
        else if((firstName == null || lastName == null) && (productName != null && productPrice != 0)){
            return jpaQuery
                    .from(qPurchase)
                    .where((qPurchase.productName.eq(productName)).and(qPurchase.productPrice.eq(productPrice)))
                    .fetch();
        }
        else if((productName == null || productPrice == 0) && (firstName != null && lastName != null)){
            return jpaQuery
                    .from(qPurchase)
                    .where(qPurchase.firstName.eq(firstName).and(qPurchase.lastName.eq(lastName)))
                    .fetch();
        }
        else if(productPrice != 0 && productName == null && firstName == null && lastName == null){
            return jpaQuery
                    .from(qPurchase)
                    .where(qPurchase.productPrice.gt(1.00))
                    .fetch();
        }
        else
        return jpaQuery
                .from(qPurchase)
                .where(qPurchase.firstName.eq(firstName).and(qPurchase.lastName.eq(lastName))
                        .and(qPurchase.productName.eq(productName)).and(qPurchase.productPrice.eq(productPrice)))
                .fetch();
        */
        PurchaseRecordFilter purchaseRecordFilter = new PurchaseRecordFilter();

        if(firstName != null && !firstName.isEmpty())
            purchaseRecordFilter.setFirstName(firstName);
        if(lastName != null && !lastName.isEmpty())
            purchaseRecordFilter.setLastName(lastName);
        if(productName != null && !productName.isEmpty())
            purchaseRecordFilter.setProductName(productName);
        if(productPrice != null && !productPrice.isNaN())
            purchaseRecordFilter.setProductPrice(productPrice);

        List<Purchase> purchases = (List<Purchase>) purchaseRepository.findAll(purchaseRecordFilter.buildQuery());

        return purchases;
    }

}
