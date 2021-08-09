package com.example.authentication.filter;

import com.example.authentication.model.LoginUserDetails;
import com.example.authentication.service.UserService;
import com.example.authentication.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("authorization");
        String token, email = null;

        try {
            LoginUserDetails userDetails = null;
            token = extractTokenFromHeader(authorizationHeader);
            email = jwtUtil.extractEmail(token);
            userDetails = extractUserDetailsFromEmail(email);
            validateAuthentication(token, userDetails, request);
        }
        catch (Exception e){

        }
        finally {
            filterChain.doFilter(request,response);
        }
    }

    private void validateAuthentication(String token, LoginUserDetails userDetails, HttpServletRequest request){
        if(jwtUtil.validateToken(token, userDetails)){
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,
                    null, userDetails.getAuthorities());
            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
    }

    private LoginUserDetails extractUserDetailsFromEmail(String email){
        try {
            if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                return this.userService.loadUserByUsername(email);
            }
            return null;
        } catch(Exception e) {
            return null;
        }
    }

    private String extractTokenFromHeader(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7);
        }
        return null;
    }
}