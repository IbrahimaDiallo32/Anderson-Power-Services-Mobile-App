package com.aps.restfulbackend.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String homeTest() {
        return "Hello!:) (Home page)";
    }
}
