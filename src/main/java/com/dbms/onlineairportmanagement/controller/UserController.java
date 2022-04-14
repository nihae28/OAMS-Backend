package com.dbms.onlineairportmanagement.controller;

import com.dbms.onlineairportmanagement.model.User;
import com.dbms.onlineairportmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add/{name}")
    public ResponseEntity<HttpStatus> saveUser(@PathVariable String name){
        User u = new User(name);
        userRepository.save(u);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
