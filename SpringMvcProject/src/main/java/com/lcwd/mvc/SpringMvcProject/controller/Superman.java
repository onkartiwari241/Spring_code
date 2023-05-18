package com.lcwd.mvc.SpringMvcProject.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Controller

//@Component
//@RestController
public class Superman {

//    @Value("${name}")
//    private String name;
@RequestMapping("/about")
public String aboutRequestHandler() {
    System.out.println("Processing about request");
    return "about";
}

@RequestMapping("/service")
public String aboutServicehandler()
    {
        System.out.println("Service page is called...");
        return "service";
    }
}
