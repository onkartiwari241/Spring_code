package com.lcwd.first.TodoApplication.controllers;

import com.lcwd.first.TodoApplication.config.LCWDConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class HomeControler {

    @Value("${name}")
    private String name;
    @Value("${address}")
    private String address;
    @Value("${empId}")
    private String id;
    @Value("${company}")
    private String company;

    @Value("${contact}")
    private String contact;

    @Autowired
    private LCWDConfig lcwdConfig;

@RequestMapping("/todos")
    public List<String> justTest(){
        List<String> todo = Arrays.asList("Learn Java","Learn Spring","Learn Springboot Framework","Then develop a project","Learn React JS","Learn Node JS","Hello");

        return todo;
    }

    @RequestMapping("/searchName")
    public String getName()
    {
        return "<h1>Emp Id : "+this.id+"<br>Name : "+" "+this.name+"<br>Company : "+this.company+"<br>Contact : "+this.contact+"<br>Address : "+this.address+"</h1>";
    }

    @RequestMapping("/lcwdConfig")
    public LCWDConfig getLcwdConfig()
    {
        System.out.println(this.lcwdConfig);
        return this.lcwdConfig;
    }
}
