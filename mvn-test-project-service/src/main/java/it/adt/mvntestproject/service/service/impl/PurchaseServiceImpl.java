package it.adt.mvntestproject.service.service.impl;

import it.adt.mvntestproject.common.exception.EntityNotFoundException;
import it.adt.mvntestproject.dao.entity.Purchase;
import it.adt.mvntestproject.dto.PurchaseDto;
import it.adt.mvntestproject.dao.filter.PurchaseRecordFilter;
import it.adt.mvntestproject.dao.repository.PurchaseRepository;
import it.adt.mvntestproject.dto.PurchaseSave;
import it.adt.mvntestproject.service.mappers.PurchaseEntityMapper;
import it.adt.mvntestproject.service.service.IUserService;
import it.adt.mvntestproject.service.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private IUserService userService;

    @Autowired
    private PurchaseEntityMapper purchaseEntityMapper;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public PurchaseDto create(PurchaseSave purchaseSave) throws EntityNotFoundException {
//        Purchase purchase = new Purchase();
//        purchase.setFirstName(purchaseDto.getFirstNameUser());
//        purchase.setLastName(purchaseDto.getLastNameUser());
//        purchase.setProductName(purchaseDto.getProductName());
//        purchase.setProductPrice(purchaseDto.getProductPrice());
//        purchase.setPurchaseDate(purchaseDto.getPurchaseDate());
//        purchase.setPurchasePrice(purchaseDto.getPurchasePrice());
//        purchase.setReceiptCode(purchaseDto.getReceiptCode());
//        purchase.setUser(userRepository.findById(purchaseDto.getIdUser()));

        Purchase purchase = purchaseEntityMapper.mapPurchaseSaveToPurchaseEntity(purchaseSave);
        purchase.setUser(userService.findByUserId(purchaseSave.getIdUser()));
        Purchase savedEntity = purchaseRepository.save(purchase);
        return purchaseEntityMapper.mapPurchaseEntityToPurchaseDto(savedEntity);

    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<PurchaseDto> getPurchases(){
        List<Purchase> purchaseList = purchaseRepository.findAll();
        return purchaseEntityMapper.mapPurchaseListToPurchaseDtoList(purchaseList);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<PurchaseDto> getFilteredList(String firstName, String lastName, String productName, Double productPrice){
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

//        return purchases;
        return purchaseEntityMapper.mapPurchaseListToPurchaseDtoList(purchases);
    }

}
