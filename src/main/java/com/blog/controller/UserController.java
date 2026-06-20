package com.blog.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blog.entity.User;
import com.blog.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {

@Autowired
private UserService service;


// REGISTER
@PostMapping("/register")
public User register(

@RequestBody User user

){

return service.register(
user
);

}


// LOGIN
@PostMapping("/login")
public User login(

@RequestBody Map<String,String>
data

){

return service.login(

data.get("email"),

data.get("password")

);

}

}