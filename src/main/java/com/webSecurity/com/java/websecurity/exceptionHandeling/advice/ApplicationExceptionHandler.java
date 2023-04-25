package com.webSecurity.com.java.websecurity.exceptionHandeling.advice;

import com.webSecurity.com.java.websecurity.exceptionHandeling.customException.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    // this tell spring that this method is executed when we get this particular exception
    public Map<String,String > handelInvalidArgument(MethodArgumentNotValidException ex){

        Map<String,String> toReturn = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(
                e-> toReturn.put(e.getField(),e.getDefaultMessage()));

        return toReturn;
    }



    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR    )
    // this tell spring that this method is executed when we get this particular exception
    public Map<String,String > handelUserNotFound(UserNotFoundException ex){

        Map<String,String> toReturn = new HashMap<>();

        toReturn.put("errorMessae",ex.getMessage());

        return toReturn;
    }
}
