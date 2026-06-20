package com.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.User;
import com.blog.repository.UserRepository;

@Service
public class UserService {

@Autowired
private UserRepository repo;


// REGISTER
public User register(
User user
){

return repo.save(
user
);

}


// LOGIN
public User login(

String email,

String password

){

User user=
repo.findByEmail(email)
.orElseThrow();

if(
!user
.getPassword()
.equals(password)
){

throw new RuntimeException(
"Wrong Password"
);

}

return user;

}

}