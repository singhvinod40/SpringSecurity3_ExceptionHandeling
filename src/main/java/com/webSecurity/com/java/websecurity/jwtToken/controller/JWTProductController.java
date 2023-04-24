package com.webSecurity.com.java.websecurity.jwtToken.controller;


import com.webSecurity.com.java.websecurity.BasicAuth.dto.Products;
import com.webSecurity.com.java.websecurity.BasicAuth.entity.UserInfo;
import com.webSecurity.com.java.websecurity.BasicAuth.service.ProductServices;
import com.webSecurity.com.java.websecurity.jwtToken.dto.AuthRequestDTO;
import com.webSecurity.com.java.websecurity.jwtToken.service.JwtProductServices;
import com.webSecurity.com.java.websecurity.jwtToken.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Jwtproducts")
public class JWTProductController {

    @Autowired
    private JwtProductServices jwtProductServices;

    @Autowired
    private JwtService jwtService;



    @GetMapping("/welcome")
    public String welcome() {

        return "this end point is not secured";
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Products> getAllProducst() {

        return jwtProductServices.getProducts();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER,Role_ADMIN')")
    public Products getProductsById(@PathVariable int id) {

        return jwtProductServices.getProductById(id);

    }


    @PostMapping("/addUser")
    public String addUser(@RequestBody UserInfo userInfo) {
        return jwtProductServices.addUser(userInfo);
    }


    @PostMapping("/authenticate")
    public String GenerateauthenticationToken(@RequestBody AuthRequestDTO authRequestDTO) {

        return jwtService.generateJwtToken(authRequestDTO.getUsername());
    }

}
