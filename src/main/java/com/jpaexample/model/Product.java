package com.jpaexample.model;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private double unitPrice;
    private int avaible;
    @ManyToOne
    @JoinColumn(name = "brandId")
    private Brand brand;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    @Temporal(TemporalType.TIMESTAMP)
    private Date addDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    public Product() {
    }

    public Product(String productName, double unitPrice, int avaible, Brand brand, Category category, Date addDate) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.avaible = avaible;
        this.brand = brand;
        this.category = category;
        this.addDate = addDate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getAvaible() {
        return avaible;
    }

    public void setAvaible(int avaible) {
        this.avaible = avaible;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", unitPrice=" + unitPrice +
                ", avaible=" + avaible +
                ", brand=" + brand +
                ", category=" + category +
                ", addDate=" + addDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
