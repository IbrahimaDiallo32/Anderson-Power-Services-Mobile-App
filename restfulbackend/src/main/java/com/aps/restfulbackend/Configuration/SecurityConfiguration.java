package com.aps.restfulbackend.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/**", "/test").permitAll() // No authorization needed for accessing these paths
                        .anyRequest().authenticated()); // Any other request the use will need to be authenticated

        return httpSecurity.build();
    }

}
// END OF SECURITY CONFIG CLASS