//package com.aps.restfulbackend;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        // Disabling security for all requests (not recommended for production)
//        http.csrf().disable()
//                .authorizeHttpRequests()
//                .anyRequest().permitAll();
//
//        return http.build();
//    }
//}
