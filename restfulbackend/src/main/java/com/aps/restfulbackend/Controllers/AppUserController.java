package com.aps.restfulbackend.Controllers;

import com.aps.restfulbackend.Services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @PostMapping("/api/v1/users")
    public User createUser(@RequestBody User user) {
        return this.appUserService.save(user);
    }
}
