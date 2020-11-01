package com.example.springboot.web.controller;

import com.example.springboot.web.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class Controllers {

    @GetMapping("/user")
    public String userInfo() {
        return "userData";
    }

    @GetMapping("/admin")
    public String adminInfo() {
        return "admin";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}