package com.aps.restfulbackend.Services.Auth;

import com.aps.restfulbackend.Models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserService appUserService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = appUserService.getUserByEmail(email);

        // Check if user object is null
        if (appUser == null) {
            throw new UsernameNotFoundException("Unable to load user...");
        }

        return new CustomUserDetails(appUser);
    }
}
