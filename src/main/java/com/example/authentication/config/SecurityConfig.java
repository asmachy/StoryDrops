package com.example.authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.antMatcher("/user/**")
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/user/**")
                .permitAll()
                .and()
                .antMatcher("/posts/**")
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/posts/**")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/posts/**")
                .authenticated()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.PUT,"/posts/**")
                .authenticated()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.DELETE,"/posts/**")
                .authenticated();

    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
