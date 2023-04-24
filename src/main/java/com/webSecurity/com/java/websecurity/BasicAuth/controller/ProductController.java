package com.webSecurity.com.java.websecurity.BasicAuth.controller;


import com.webSecurity.com.java.websecurity.BasicAuth.dto.Products;
import com.webSecurity.com.java.websecurity.BasicAuth.entity.UserInfo;
import com.webSecurity.com.java.websecurity.BasicAuth.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

        @Autowired
        private ProductServices productServices;



    @GetMapping("/welcome")
    public String welcome(){

        return "this end point is not secured";
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Products> getAllProducst(){

        return productServices.getProducts();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER,Role_ADMIN')")
        public Products getProductsById(@PathVariable int id){

        return productServices.getProductById(id);

    }


    @PostMapping("/addUser")
    public String addUser(@RequestBody UserInfo userInfo){
        return productServices.addUser(userInfo);
    }



}
