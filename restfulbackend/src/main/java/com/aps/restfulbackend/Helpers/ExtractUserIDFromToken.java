package com.aps.restfulbackend.Helpers;

import com.aps.restfulbackend.Services.Auth.CustomUserDetails;
import com.aps.restfulbackend.Services.Auth.CustomUserDetailsService;
import com.aps.restfulbackend.Services.JwtTokenService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ExtractUserIDFromToken {

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    private CustomUserDetails customUserDetails;

    public UUID getUserIdFromToken(HttpServletRequest request) {

        UUID user_id = null;
        // Get a hold of authentication header
        String authHeader = request.getHeader("Authorization");
        // Get jwt property
        String jwtToken = null;
        // Set username property
        String userEmail = null;

        // Validate authorization header
        if (authHeader != null || authHeader.startsWith("Bearer ")) {

            // Set jwt value
            jwtToken = authHeader.substring(7);

            // Get username from token
            userEmail = jwtTokenService.extractUsername(jwtToken);
        }

        if (userEmail != null) {
            customUserDetails = (CustomUserDetails) customUserDetailsService.loadUserByUsername(userEmail);

            user_id = customUserDetails.getUserId();
        }

        return user_id;
    }
}
