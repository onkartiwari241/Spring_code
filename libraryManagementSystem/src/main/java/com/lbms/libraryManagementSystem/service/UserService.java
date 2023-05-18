package com.lbms.libraryManagementSystem.service;

import com.lbms.libraryManagementSystem.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity createUser(UserEntity userData);

    List<UserEntity> viewAllUsers();

    void deleteUserById(int id);

    UserEntity userEditDetails(int id);

    UserEntity updateUserById(UserEntity userEntity,int id);
}
