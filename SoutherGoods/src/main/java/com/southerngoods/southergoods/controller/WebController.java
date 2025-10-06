package com.southerngoods.southergoods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {


    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/")
    public String dashboard() {
        return "dashboard"; // This will look for 'dashboard.html'
    }

}