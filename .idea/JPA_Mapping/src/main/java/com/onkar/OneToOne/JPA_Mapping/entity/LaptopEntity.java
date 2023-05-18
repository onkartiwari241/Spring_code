package com.onkar.OneToOne.JPA_Mapping.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Laptop_Mapping")
public class LaptopEntity {
    @Id
    private int laptop_id;
    private String laptop_name;
    private String brand;

    @OneToOne
    @JoinColumn(name="student_Id")
    private StudentEntity studentEntity;

    public LaptopEntity() {
    }

    public LaptopEntity(int laptop_id, String laptop_name, String brand, StudentEntity studentEntity) {
        this.laptop_id = laptop_id;
        this.laptop_name = laptop_name;
        this.brand = brand;
        this.studentEntity = studentEntity;
    }

    public int getLaptop_id() {
        return laptop_id;
    }

    public void setLaptop_id(int laptop_id) {
        this.laptop_id = laptop_id;
    }

    public String getLaptop_name() {
        return laptop_name;
    }

    public void setLaptop_name(String laptop_name) {
        this.laptop_name = laptop_name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }
}
