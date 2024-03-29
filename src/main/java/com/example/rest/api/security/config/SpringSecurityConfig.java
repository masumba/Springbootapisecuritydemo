package com.example.rest.api.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /*Create 2 users (user and admin)*/
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("USER","ADMIN");
    }

    /*Secure endpoints with http authentication*/
    @Override
    protected void configure(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/books/**").hasRole("USER")
                .antMatchers(HttpMethod.POST,"/books/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/books/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH,"/books/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/books/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
