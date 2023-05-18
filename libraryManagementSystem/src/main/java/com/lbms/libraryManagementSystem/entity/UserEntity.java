package com.lbms.libraryManagementSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Table(name = "userManagement")
public class UserEntity{
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String contact;
    private String password;
    private String address;

    public UserEntity() {}

    public UserEntity(int id, String name, String email, String contact, String password, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.password = password;
        this.address = address;
    }
    public UserEntity(String name, String email, String contact, String password, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.password = password;
        this.address = address;
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

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
