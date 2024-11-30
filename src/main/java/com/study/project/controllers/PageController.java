package com.study.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/cars")
    public String carPage() {
        return "index";
    }

}
