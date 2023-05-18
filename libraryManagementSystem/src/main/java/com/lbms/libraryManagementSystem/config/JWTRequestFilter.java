package com.lbms.libraryManagementSystem.config;

import com.lbms.libraryManagementSystem.tokenUtil.TokenVerifier;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
public class JWTRequestFilter extends OncePerRequestFilter {

    @Autowired
    private TokenVerifier tokenVerifier;

    private UserDetailsService userDetailsService;

    private Logger logger = LoggerFactory.getLogger(JWTRequestFilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        String jwtToken = null;
        String userName = null;

        if(authorization != null && authorization.startsWith("Basic")){
            jwtToken = authorization.substring(6);
            userName = tokenVerifier.getUsernameFromToken(jwtToken);
        }else{
            logger.warn("invalid Header");
        }

        if(userName != null && SecurityContextHolder.getContext() !=null){

            UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        }
    }
}
