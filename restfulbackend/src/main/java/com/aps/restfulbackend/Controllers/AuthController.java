package com.aps.restfulbackend.Controllers;

import com.aps.restfulbackend.Dto.Requests.LoginRequest;
import com.aps.restfulbackend.Dto.Responses.AuthResponse;
import com.aps.restfulbackend.Services.Auth.AppUserService;
import com.aps.restfulbackend.Services.Auth.CustomUserDetails;
import com.aps.restfulbackend.Services.Auth.CustomUserDetailsService;
import com.aps.restfulbackend.Services.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtTokenService jwtTokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest) {

        // Set authentication
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(), loginRequest.getPassword()
                )
        );

        // Set user object
        CustomUserDetails customUserDetails =
                (CustomUserDetails) customUserDetailsService.loadUserByUsername(loginRequest.getEmail());

        // Set security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Generate token
        String token = jwtTokenService.generateToken(customUserDetails);

        // Set response
        AuthResponse response = new AuthResponse(token, customUserDetails);

        return new ResponseEntity(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestParam("first_name") String firstName,
                                   @RequestParam("last_name") String lastName,
                                   @RequestParam("email") String email,
                                   @RequestParam("password") String password,
                                   @RequestParam("phone") String phone) {

        int result = appUserService.registerUser(firstName, lastName, email, password, phone);

        if (result != 1) {
            return new ResponseEntity(
                    "Uh oh, sometihng went wrong with user registration... :P",
                    HttpStatus.BAD_REQUEST
            );
        }

        return new ResponseEntity(
                "User registration succesful! :)",
                HttpStatus.CREATED
        );
    }

}
