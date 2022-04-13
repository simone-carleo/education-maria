package it.adt.comparison;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String productName;
    private double productPrice;

    @Column(name = "purchase_price",nullable = false)
    private double purchasePrice;
    @Column(name = "purchase_date",nullable = false)
    private Date purchaseDate;
    @Column(name = "receipt_code", nullable = false)
    private String receiptCode;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    public Purchase(){}

    public Purchase(int id, String firstName, String lastName, String productName, double productPrice) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

}
