package com.lbms.libraryManagementSystem.controller;

import com.lbms.libraryManagementSystem.entity.UserEntity;
import com.lbms.libraryManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public void  createUser(@RequestBody UserEntity userData)
    {
        service.createUser(userData);
    }

    @GetMapping("/allusers")
    public List<UserEntity> viewAllUsers()
    {
        List<UserEntity> userEntities = service.viewAllUsers();
        return userEntities;
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUserById(@PathVariable int id)
    {
        service.deleteUserById(id);
    }

    @GetMapping("/editUserDetails/{id}")
    public UserEntity editUserDetails(@PathVariable int id)
    {
        System.out.println("id : "+id);

        UserEntity userEntity = service.userEditDetails(id);
        System.out.println("id : "+userEntity.getId()+" "+userEntity.getName());
        return userEntity;
    }

    @PutMapping("/updateUserDetails/{id}")
    public void  updateUserDetails(@PathVariable int id,@RequestBody UserEntity updatedUserEntity)
    {
        System.out.println("========================");
        System.out.println("id => "+id);

        service.updateUserById(updatedUserEntity,id);
    }
}
