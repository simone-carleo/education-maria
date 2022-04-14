package it.adt.comparison;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_brand;
    @Column(name = "brand_name", nullable = false)
    private String brandName;
    @Column(name = "brand_description", nullable = false)
    private String brandDescription;

    @OneToMany(mappedBy = "brand")
    @JsonManagedReference
    private List<Product> products;

    public Brand(){}

    public Brand(int id_brand, String brandName, String brandDescription){
        this.id_brand = id_brand;
        this.brandName = brandName;
        this.brandDescription = brandDescription;
    }

    public int getId_brand() {
        return id_brand;
    }

    public void setId_brand(int id_brand) {
        this.id_brand = id_brand;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandDescription() {
        return brandDescription;
    }

    public void setBrandDescription(String brandDescription) {
        this.brandDescription = brandDescription;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
