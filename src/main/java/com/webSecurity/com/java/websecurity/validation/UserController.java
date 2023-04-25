package com.webSecurity.com.java.websecurity.validation;

import com.webSecurity.com.java.websecurity.exceptionHandeling.customException.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/saveUser")
    public ResponseEntity<UserEntity> saveUser(@RequestBody  @Valid  UserDTO user) {
        return ResponseEntity.status(201).body(userService.saveUser(user));
    }


    @GetMapping("/fetchAll")
    public ResponseEntity<List<UserEntity>> saveUser() {
        return ResponseEntity.ok().body(userService.getAllUser());
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> fetchById(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok().body(userService.findByUserId(id));
    }


}
