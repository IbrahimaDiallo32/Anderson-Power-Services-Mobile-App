package com.aps.restfulbackend.Services.Auth;

import com.aps.restfulbackend.Models.AppUser;
import com.aps.restfulbackend.Repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    public AppUser getUserByEmail(String email) {
        return appUserRepository.getUserByEmail(email);
    }

    public int registerUser(String first_name, String last_name, String email, String password, String phone) {
        return appUserRepository.registerUser(first_name, last_name, email, password, phone);
    }

}
