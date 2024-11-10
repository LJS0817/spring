package com.example.pro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class app {
    @RequestMapping("/")
    public String home(){
        return "index";
    }
}
