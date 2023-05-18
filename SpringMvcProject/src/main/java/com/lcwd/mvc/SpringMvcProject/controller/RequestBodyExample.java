package com.lcwd.mvc.SpringMvcProject.controller;

import com.lcwd.mvc.SpringMvcProject.model.Employee;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emp")
public class RequestBodyExample {

    @PostMapping("/create")
    public List<Employee> getData(@RequestBody List<Employee> employee) //@RequestBody Map<String,Object> data
    {
        System.out.println("Employee array size is : "+employee.size());

        for (int i=0;i<employee.size();i++)
        {
            System.out.println(employee.get(i));
        }

       // System.out.println(employee);
//        System.out.println("Emp Id : "+employee.getId());
//        System.out.println("Name : "+employee.getName());
//        System.out.println("Company : "+employee.getCompany());
//        System.out.println("Address : "+employee.getAddress());

//        System.out.println("Created");
//        //System.out.println(data);
//        Object name = data.get("name");
//        Object id = data.get("id");
//        Object address = data.get("address");
//        Object pincode = data.get("pincode");
//
//        System.out.println(name);
//        System.out.println(id);
//        System.out.println(address);
//        System.out.println(pincode);
        return employee;
    }
}
