package com.aps.restfulbackend.Dto.Responses;

import com.aps.restfulbackend.Services.Auth.CustomUserDetails;

import java.util.UUID;

public class AuthResponse {

    private String token;
    private CustomUserDetails customUserDetails;

    public AuthResponse(String token, CustomUserDetails customUserDetails) {
        this.token = token;
        this.customUserDetails = customUserDetails;
    }

    public String getToken() {
        return token;
    }

    public UUID getUserId() {
        return customUserDetails.getUserId();
    }

    public String getUsername() {
        return customUserDetails.getUsername();
    }

    public String getFirstName() {
        return customUserDetails.getFirstName();
    }

    public String getLastName() {
        return customUserDetails.getLastName();
    }
}
