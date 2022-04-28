package it.adt.mvntestproject.dto;

public class ProductDto {
    private String name;
    private String description;
    private double price;
    private int id_brand;

    public ProductDto(String name, String description, double price, int id_brand) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.id_brand = id_brand;
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

    public int getId_brand() {
        return id_brand;
    }

    public void setId_brand(int id_brand) {
        this.id_brand = id_brand;
    }
}
