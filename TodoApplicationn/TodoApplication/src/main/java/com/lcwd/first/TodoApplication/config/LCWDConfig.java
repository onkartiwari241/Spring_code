package com.lcwd.first.TodoApplication.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@ConfigurationProperties(prefix = "lcwd.config")
@Component
public class LCWDConfig {
//    @Value("${lcwd.config.name}")
    private String name;
//    @Value("${lcwd.config.password}")
    private String password;
//    @Value("${lcwd.config.email}")
    private String email;
//    @Value("${lcwd.config.name}")
    private int emailEmpTime;

//    ArrayList al = new ArrayList();
//
//    @RequestMapping("/userData")
//    public ArrayList userData()
//    {
//        al.add(name);
//        al.add(password);
//        al.add(email);
//        al.add(emailEmpTime);
//        return al;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmailEmpTime(int emailEmpTime) {
        this.emailEmpTime = emailEmpTime;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getEmailEmpTime() {
        return emailEmpTime;
    }

    @Override
    public String toString() {
        return "LCWDConfig{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", emailEmpTime=" + emailEmpTime +
                '}';
    }
}
