package it.adt.mvntestproject.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_product;
    @Column(name = "product_name", nullable = false)
    private String name;
    @Column(name = "product_description", nullable = false)
    private String description;
    @Column(name = "product_price", nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "id_brand", nullable = false, referencedColumnName = "id_brand")
    @JsonBackReference
    private Brand brand;

    public Product(){}

    public Product(int id_product, String name, String description, double price) {
        this.id_product = id_product;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
