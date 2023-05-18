package com.lcwd.mvc.SpringMvcProject.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class Morning {
//    @RequestMapping(value = "/morning" , method = RequestMethod.GET)
    @GetMapping("/morning")
    public String morning(){
        return "Good Morning...";
    }

    @GetMapping("/userData")
    public List<String> users(){
        return Arrays.asList("Onkar","Ankur","Arpit");
    }
}
