package com.spring.springSecurity.service;

import com.spring.springSecurity.entity.UserInfo;
import com.spring.springSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String addUser(UserInfo userInfo){
//       String uId= UUID.randomUUID().toString();
//        userInfo.setId(uId);
//        String username = userInfo.getName();
        String password = userInfo.getPassword();

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePass  = passwordEncoder.encode(password);

        userInfo.setPassword(encodePass);
        userInfo.setRoles("ROLE_"+userInfo.getRoles());
        userRepository.save(userInfo);
        return "user added successfully...";
    }

    public UserInfo getUserById(String id){
        UserInfo userInfo = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found by given id + " + id));
        return userInfo;
    }

    public List<UserInfo> getAllUsers(){
        return userRepository.findAll();
    }

    public UserInfo loginUserByIdAndPassword(String username,String password){
        List<UserInfo> all = userRepository.findAll();
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePass = encoder.encode(password);
        return all.stream().filter(e -> e.getName().equals(username) && e.getPassword().equals(encodePass)).findFirst().orElseThrow();
    }
}
