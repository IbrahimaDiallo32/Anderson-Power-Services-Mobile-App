package com.aps.restfulbackend.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AppUserController {

//    @Autowired
//    AppUserService appUserService;
//
//    @PostMapping("/api/v1/users")
//    public User createUser(@RequestBody User user) {
//        return this.appUserService.save(user);
//    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "Test is successful";
    }
}
