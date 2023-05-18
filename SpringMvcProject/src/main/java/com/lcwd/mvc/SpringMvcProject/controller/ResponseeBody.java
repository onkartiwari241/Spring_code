package com.lcwd.mvc.SpringMvcProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

//@Controller
@RestController
public class ResponseeBody {

    @RequestMapping("/message")
//    @ResponseBody
    public String message(){
        return "Hello Good Morning......<br> How are you?";
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
//    @ResponseBody
    public List<String> getUser(){
        return Arrays.asList("Ankur","Arpit","Onkar","Chandan");
    }
}
