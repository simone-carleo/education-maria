package it.adt.mvntestproject.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

public class PurchaseDto {

    @JsonProperty("id_purchase")
    private String idPurchase;
    @JsonProperty("first_name")
    private String firstNameUser;
    @JsonProperty("last_name")
    private String lastNameUser;
    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("product_price")
    private double productPrice;
    @JsonProperty("purchase_date")
    private Date purchaseDate;
    @JsonProperty("purchase_price")
    private double purchasePrice;
    @JsonProperty("receipt_code")
    private String receiptCode;
    @JsonProperty("user")
    private UserDto userDto;

    public String getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(String idPurchase) {
        this.idPurchase = idPurchase;
    }

    public String getFirstNameUser() {
        return firstNameUser;
    }

    public void setFirstNameUser(String firstNameUser) {
        this.firstNameUser = firstNameUser;
    }

    public String getLastNameUser() {
        return lastNameUser;
    }

    public void setLastNameUser(String lastNameUser) {
        this.lastNameUser = lastNameUser;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PurchaseDto purchaseDto = (PurchaseDto) o;
        return Objects.equals(this.productPrice, purchaseDto.productPrice)
                && Objects.equals(this.purchasePrice, purchaseDto.purchasePrice)  &&
                Objects.equals(this.idPurchase, purchaseDto.idPurchase)
                && Objects.equals(this.firstNameUser, purchaseDto.firstNameUser) &&
                Objects.equals(this.lastNameUser, purchaseDto.lastNameUser) &&
                Objects.equals(this.productName, purchaseDto.productName) &&
                Objects.equals(this.purchaseDate, purchaseDto.purchaseDate) &&
                Objects.equals(this.receiptCode, purchaseDto.receiptCode) &&
                Objects.equals(this.userDto, purchaseDto.userDto);
    }

    @Override public int hashCode() {
        return Objects.hash(idPurchase, firstNameUser, lastNameUser, productName, productPrice, purchaseDate, purchasePrice, receiptCode, userDto);
    }

    @Override public String toString() {
        return "PurchaseDto{" + "idPurchase='" + idPurchase + '\'' + ", firstNameUser='" + firstNameUser + '\'' + ", lastNameUser='" + lastNameUser + '\'' + ", productName='"
                + productName + '\'' + ", productPrice=" + productPrice + ", purchaseDate=" + purchaseDate + ", purchasePrice=" + purchasePrice + ", receiptCode='" + receiptCode
                + '\'' + ", userDto='" + userDto + '\'' + '}';
    }
}
