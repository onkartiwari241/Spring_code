package com.onkar.OneToOne.JPA_Mapping.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="product_mapping")
public class ProductEntity {

    @Id
    private String productId;
    private String productName;

    public List<CategoryEntity> getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(List<CategoryEntity> categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    @ManyToMany(mappedBy = "productEntity",fetch = FetchType.EAGER)
    private List<CategoryEntity> categoryEntity=new ArrayList<>();

    public ProductEntity(){}

    public ProductEntity(String productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
