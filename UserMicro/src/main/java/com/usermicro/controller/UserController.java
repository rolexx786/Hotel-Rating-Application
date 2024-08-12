package com.usermicro.controller;

import com.usermicro.entity.User;
import com.usermicro.services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    //Create

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userServices.createUser(user);


        return new ResponseEntity<>(user1, HttpStatus.CREATED);


    }


    //list
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userServices.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }



    //single user
    @GetMapping("/{uid}")
    public ResponseEntity<User> getUserById(@PathVariable String uid){
        User userById = userServices.getUserById(uid);
        return new ResponseEntity<>(userById,HttpStatus.OK);
    }


}
