package com.springsecurityapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;



@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //add out users for in memory authentication
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication().withUser(users.username("batuhan").password("123").roles("EMPLOYEE"));
        auth.inMemoryAuthentication().withUser(users.username("hasan").password("123").roles("MANAGER"));
        auth.inMemoryAuthentication().withUser(users.username("halil").password("123").roles("ADMIN"));

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/showLoginPage")
                .loginProcessingUrl("/authenticateUser")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf()
                .disable();



    }
}
