package com.aps.restfulbackend.Services;

import com.aps.restfulbackend.Repositories.AppUserRepository;
import com.aps.restfulbackend.Security.UserAuthService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {
    AppUserRepository appUserRepository;
    PasswordEncoder passwordEncoder;

    public UserService(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User save(User user) {

    }
}
