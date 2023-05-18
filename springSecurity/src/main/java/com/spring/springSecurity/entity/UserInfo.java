package com.spring.springSecurity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userData")
public class UserInfo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String id;
        private String name;
        private String email;
        private String password;
        private String roles;
}
