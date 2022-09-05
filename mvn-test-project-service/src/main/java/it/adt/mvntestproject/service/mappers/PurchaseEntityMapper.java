package it.adt.mvntestproject.service.mappers;

import it.adt.mvntestproject.dao.entity.Purchase;
import it.adt.mvntestproject.dto.PurchaseDto;
import it.adt.mvntestproject.dto.PurchaseSave;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseEntityMapper {

    @Mapping(source = "firstName", target = "firstNameUser")
    @Mapping(source = "lastName", target = "lastNameUser")
    @Mapping(source = "user.id_user", target = "userDto.id_user")
    PurchaseDto mapPurchaseEntityToPurchaseDto(Purchase purchase);

    @Mapping(target = "idPurchase", expression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(source = "idUser", target = "user.id_user", ignore = true)
    Purchase mapPurchaseSaveToPurchaseEntity(PurchaseSave purchaseSave);

    List<PurchaseDto> mapPurchaseListToPurchaseDtoList(List<Purchase> purchaseList);

}
