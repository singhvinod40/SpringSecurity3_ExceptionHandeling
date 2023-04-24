package com.webSecurity.com.java.websecurity.util;

import com.webSecurity.com.java.websecurity.BasicAuth.dto.Products;
import com.webSecurity.com.java.websecurity.BasicAuth.entity.UserInfo;
import com.webSecurity.com.java.websecurity.BasicAuth.repo.UserInfoRepos;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class UtilClass {


    @Autowired
    private UserInfoRepos userInfoRepos;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public  List<Products> getALlproduct(){

        return IntStream.range(1,101)
                .mapToObj(p -> new Products(p,"Customer :" +p))
                .collect(Collectors.toList());


    }

    public  Products getproductById(int id) {
        return getALlproduct().stream()
                .filter(i ->  i.getId() == id)
                .findFirst().get();
    }

    public  String adduser(UserInfo userInfo){
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepos.save(userInfo);
        return "userAddedSuccessfully";

    }
}
