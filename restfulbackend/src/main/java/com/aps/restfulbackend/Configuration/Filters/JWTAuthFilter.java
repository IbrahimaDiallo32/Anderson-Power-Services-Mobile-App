package com.aps.restfulbackend.Configuration.Filters;

import com.aps.restfulbackend.Services.Auth.CustomUserDetailsService;
import com.aps.restfulbackend.Services.JwtTokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Get a hold of authentication header
        String authHeader = request.getHeader("Authorization");
        // Get jwt property
        String jwtToken = null;
        // Set username property
        String userEmail = null;

        // Validate authorization header
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Get jwt value
        jwtToken = authHeader.substring(7);

        // Extract username from token
        userEmail = jwtTokenService.extractUsername(jwtToken);

        // Check if user is not null and authenticated
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails  = customUserDetailsService.loadUserByUsername(userEmail);

            // If token is validated
            if (jwtTokenService.validateToken(jwtToken, userDetails)) {

                UsernamePasswordAuthenticationToken userAuthToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                        null,
                        userDetails
                        .getAuthorities());
                userAuthToken.setDetails( new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(userAuthToken);
            }
        }
        filterChain.doFilter(request, response);
    }


}
