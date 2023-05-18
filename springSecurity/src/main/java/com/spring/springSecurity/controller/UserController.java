package com.spring.springSecurity.controller;

import com.spring.springSecurity.entity.UserInfo;
import com.spring.springSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registeruser(@RequestBody UserInfo userInfo){
        return userService.addUser(userInfo);
    }

    @GetMapping("/userById/{id}")
    public UserInfo getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @GetMapping("/allUsers")
    public List<UserInfo> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/login")
    public ResponseEntity<UserInfo> userLogin(@RequestBody UserInfo userInfo){
        return ResponseEntity.ok(userService.loginUserByIdAndPassword(userInfo.getName(),userInfo.getPassword()));
    }
}
