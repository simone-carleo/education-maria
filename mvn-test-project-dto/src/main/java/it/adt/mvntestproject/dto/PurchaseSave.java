package it.adt.mvntestproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

public class PurchaseSave {

    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
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
    @JsonProperty("id_user")
    private String idUser;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PurchaseSave purchaseSave = (PurchaseSave) o;
        return Objects.equals(this.productPrice, purchaseSave.productPrice) &&
                Objects.equals(this.purchasePrice, purchaseSave.productPrice) &&
                Objects.equals(this.firstName, purchaseSave.firstName) &&
                Objects.equals(this.lastName, purchaseSave.lastName) &&
                Objects.equals(this.productName, purchaseSave.productName) &&
                Objects.equals(this.purchaseDate, purchaseSave.purchaseDate) &&
                Objects.equals(this.receiptCode, purchaseSave.receiptCode) &&
                Objects.equals(this.idUser, purchaseSave.idUser);
    }

    @Override public int hashCode() {
        return Objects.hash(firstName, lastName, productName, productPrice, purchaseDate, purchasePrice, receiptCode, idUser);
    }

    @Override public String toString() {
        return "PurchaseSave{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", productName='" + productName + '\'' + ", productPrice="
                + productPrice + ", purchaseDate=" + purchaseDate + ", purchasePrice=" + purchasePrice + ", receiptCode='" + receiptCode + '\'' + "idUser='" + idUser + '\'' + '}';
    }
}
