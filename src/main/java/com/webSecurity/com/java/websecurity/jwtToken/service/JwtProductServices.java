package com.webSecurity.com.java.websecurity.jwtToken.service;

import com.webSecurity.com.java.websecurity.BasicAuth.dto.Products;
import com.webSecurity.com.java.websecurity.BasicAuth.entity.UserInfo;
import com.webSecurity.com.java.websecurity.util.UtilClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JwtProductServices {

    @Autowired
    private UtilClass utilCLass;

    public List<Products> getProducts() {
        return utilCLass.getALlproduct();
    }


    public Products getProductById(int id) {

        return utilCLass.getproductById(id);
    }

    public String addUser(UserInfo userInfo){
        return utilCLass.adduser(userInfo);
    }
}
