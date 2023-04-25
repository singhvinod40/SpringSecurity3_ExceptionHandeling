package com.webSecurity.com.java.websecurity.validation;

import com.webSecurity.com.java.websecurity.exceptionHandeling.customException.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepo userRepo;


    public UserEntity  saveUser( UserDTO userDTO){

        UserEntity ue = UserEntity.build(0,userDTO.getName(), userDTO.getEmail(), userDTO.getMobile(),userDTO.getGender(), userDTO.getAge(),userDTO.getNationality());

        return userRepo.save(ue);

    }

    public List<UserEntity> getAllUser(){
        return userRepo.findAll();
    }

    public UserEntity findByUserId(int id) throws UserNotFoundException{
        Optional<UserEntity> user = userRepo.findById(id);

        if(user.isPresent())
            return user.get();
        else
            throw new UserNotFoundException("User is Not present");

    }


}
