package it.adt.comparison.filter;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import it.adt.comparison.QPurchase;

public class PurchaseRecordFilter implements PurchaseFilter{

    private static final QPurchase qPurchase = QPurchase.purchase;

    private String firstName;
    private String lastName;
    private String productName;
    private double productPrice;

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

    @Override
    public Predicate buildQuery(){
        BooleanBuilder builder = new BooleanBuilder();

        if(firstName != null)
            builder.and(qPurchase.firstName.eq(firstName));
        if(lastName != null)
            builder.and(qPurchase.lastName.eq(lastName));
        if(productName != null)
            builder.and(qPurchase.productName.eq(productName));
        if(productPrice != 0)
            builder.and(qPurchase.productPrice.goe(productPrice));

        return builder;
    }

}
