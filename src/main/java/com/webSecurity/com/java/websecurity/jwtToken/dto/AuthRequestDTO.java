package com.webSecurity.com.java.websecurity.jwtToken.dto;

import lombok.Data;

@Data
public class AuthRequestDTO {

    private String username;
    private String password;
}
