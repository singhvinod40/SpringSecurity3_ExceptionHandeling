package com.webSecurity.com.java.websecurity.BasicAuth.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableConfigurationProperties
@EnableMethodSecurity
public class SecurityConfig {


    @Bean
    public UserDetailsService userDetailsService() {

//        UserDetails admin = User.withUsername("Vinod")
//                .password(passwordEncoder.encode("pwd"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user = User.withUsername("singh")
//                .password(passwordEncoder.encode("pwd2"))
//                .roles("USER")
//                .build();

        // return new UserInfoUserDetailService(admin,user);

        return new UserInfoUserDetailService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/products/welcome", "/products/addUser").permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers("/products/**").authenticated()
                .and().formLogin()
                .and().build();
    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
}
