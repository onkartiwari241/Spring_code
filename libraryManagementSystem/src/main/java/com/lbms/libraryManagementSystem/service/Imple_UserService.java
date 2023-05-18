package com.lbms.libraryManagementSystem.service;

import com.lbms.libraryManagementSystem.entity.UserEntity;
import com.lbms.libraryManagementSystem.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Imple_UserService implements UserService{

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserEntity createUser(UserEntity userData) {
        UserEntity savedUser = userRepo.save(userData);
        return savedUser;
    }

    @Override
    public List<UserEntity> viewAllUsers() {

        List<UserEntity> allUsers = userRepo.findAll();
        return allUsers;
    }

    @Override
    public void deleteUserById(int id)
    {
        userRepo.deleteById(id);
    }

    @Override
    public UserEntity userEditDetails(int id)
    {
        UserEntity userEntity = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found of id : " + id));
        return userEntity;
    }

    @Override
    public UserEntity updateUserById(UserEntity userEntity, int id)
    {
        UserEntity oldDetaiils = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found of id : " + id));

        oldDetaiils.setName(userEntity.getName());
        oldDetaiils.setPassword(userEntity.getPassword());
        oldDetaiils.setContact(userEntity.getContact());
        oldDetaiils.setEmail(userEntity.getEmail());
        oldDetaiils.setAddress(userEntity.getAddress());

        UserEntity updatedDetails = userRepo.save(oldDetaiils);
        return updatedDetails;
    }
}
