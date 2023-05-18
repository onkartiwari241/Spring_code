package com.onkar.OneToOne.JPA_Mapping.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="category_mapping")
public class CategoryEntity {
    @Id
    private String id;
    private String tittle;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<ProductEntity> productEntity = new ArrayList<>();

    public CategoryEntity(){}

    public CategoryEntity(String id, String tittle) {
        this.id = id;
        this.tittle = tittle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public List<ProductEntity> getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(List<ProductEntity> productEntity) {
        this.productEntity = productEntity;
    }
}
