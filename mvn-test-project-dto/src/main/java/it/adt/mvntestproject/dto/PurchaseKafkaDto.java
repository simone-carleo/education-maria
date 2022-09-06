package it.adt.mvntestproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

public class PurchaseKafkaDto {

    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("purchase_date")
    private Date purchaseDate;
    @JsonProperty("purchase_price")
    private double purchasePrice;
    @JsonProperty("receipt_code")
    private String receiptCode;

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

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PurchaseKafkaDto purchaseKafkaDto = (PurchaseKafkaDto) o;
        return Objects.equals(this.purchasePrice, purchaseKafkaDto.purchasePrice) &&
                Objects.equals(this.firstName, purchaseKafkaDto.firstName) &&
                Objects.equals(this.lastName, purchaseKafkaDto.lastName) &&
                Objects.equals(this.purchaseDate, purchaseKafkaDto.purchaseDate) &&
                Objects.equals(this.receiptCode, purchaseKafkaDto.receiptCode);
    }

    @Override public int hashCode() {
        return Objects.hash(firstName, lastName, purchaseDate, purchasePrice, receiptCode);
    }

    @Override public String toString() {
        return "PurchaseKafkaDto{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", purchaseDate=" + purchaseDate + ", purchasePrice=" + purchasePrice
                + ", receiptCode='" + receiptCode + '\'' + '}';
    }
}
