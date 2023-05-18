package com.onkar.OneToOne.JPA_Mapping.entity;

import jakarta.persistence.*;

@Entity
@Table(name="address_mapping")
public class AddressEntity {

    @Id
    private int addressId;
    private String street;
    private String city;
    private String country;

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    @ManyToOne
    @JoinColumn(name="Student_id")
    private StudentEntity studentEntity;

    public AddressEntity(){}

    public AddressEntity(int addressId, String street, String city, String country) {
        this.addressId = addressId;
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
