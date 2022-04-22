package it.adt.comparison.dto;

import java.util.Date;

public class PurchaseDto {

    private String firstNameUser;
    private String lastNameUser;
    private String productName;
    private double productPrice;
    private Date purchaseDate;
    private double purchasePrice;
    private String receiptCode;
    private int idUser;

    public PurchaseDto(String firstNameUser, String lastNameUser, String productName, double productPrice,
            Date purchaseDate, double purchasePrice, String receiptCode, int idUser) {
        this.firstNameUser = firstNameUser;
        this.lastNameUser = lastNameUser;
        this.productName = productName;
        this.productPrice = productPrice;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.receiptCode = receiptCode;
        this.idUser = idUser;
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
