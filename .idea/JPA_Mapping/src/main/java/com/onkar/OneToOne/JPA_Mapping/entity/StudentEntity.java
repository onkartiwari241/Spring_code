package com.onkar.OneToOne.JPA_Mapping.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Student_Mapping")
public class StudentEntity {
    @Id
    private int id;
    private String name;
    private String about;

    @OneToOne(mappedBy = "studentEntity" , cascade = CascadeType.ALL)
    private LaptopEntity laptopEntity;

    @OneToMany(mappedBy = "studentEntity",cascade = CascadeType.ALL)
    private List<AddressEntity> addressEntities = new ArrayList<>();

    public StudentEntity() {
    }

    public List<AddressEntity> getAddressEntities() {
        return addressEntities;
    }

    public void setAddressEntities(List<AddressEntity> addressEntities) {
        this.addressEntities = addressEntities;
    }

    public StudentEntity(int id, String name, String about, LaptopEntity laptopEntity) {
        this.id = id;
        this.name = name;
        this.about = about;
        this.laptopEntity = laptopEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public LaptopEntity getLaptopEntity() {
        return laptopEntity;
    }

    public void setLaptopEntity(LaptopEntity laptopEntity) {
        this.laptopEntity = laptopEntity;
    }
}
