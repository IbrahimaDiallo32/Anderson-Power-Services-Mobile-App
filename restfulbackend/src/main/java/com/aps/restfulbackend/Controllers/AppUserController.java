package com.aps.restfulbackend.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AppUserController {

    @GetMapping("/test")
    public String testEndpoint() {
        return "Test is successful";
    }
}
