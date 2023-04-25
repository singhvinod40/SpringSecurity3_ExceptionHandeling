package com.webSecurity.com.java.websecurity.exceptionHandeling.exceptionInStreams;

import ch.qos.logback.core.encoder.EchoEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaException {

    public static void main(String[] args) {

        List<String> li = Arrays.asList("546","232","as");

        li.stream().forEach(handelGenericException(s -> System.out.println(Integer.parseInt(s)),NumberFormatException.class));
    }

    public static void intParser(String s ){

        try {
            System.out.println(Integer.parseInt(s));
        }catch (Exception e){
            System.out.println("Exception Occoured " +e);
        }
    }

    //generic unchecked Exception
    static <Target,ExObj extends Exception> Consumer<Target>
    handelGenericException(Consumer<Target> targetConsumer, Class<ExObj> exObjClass){

        return obj -> {

            try {
                targetConsumer.accept(obj);
            }catch (Exception e){

                try {
                    ExObj exObj = exObjClass.cast(e);
                }catch (ClassCastException ce){
                    System.out.println("Can not cast the exception class " + ce.getMessage());
                    throw ce;
                }
                System.out.println("exception : " + e.getMessage());
            }
        };

    }

    //generic Unchecked Exception



    static Consumer <String> handelExceptionIfAny(Consumer<String> payload){

        return obj -> {

            try {
                payload.accept(obj);
            }catch (Exception e){

                System.out.println("exception : " + e.getMessage());
            }
        };
    }




}
