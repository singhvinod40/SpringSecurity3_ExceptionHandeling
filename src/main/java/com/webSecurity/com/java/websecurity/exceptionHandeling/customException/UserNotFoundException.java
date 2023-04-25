package com.webSecurity.com.java.websecurity.exceptionHandeling.customException;

public class UserNotFoundException extends RuntimeException{



    public UserNotFoundException(String message){
        super(message);
    }
}
