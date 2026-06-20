package com.blog.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.Blog;
import com.blog.entity.User;
import com.blog.repository.BlogRepository;
import com.blog.repository.UserRepository;

@Service
public class BlogService {

@Autowired
private BlogRepository repo;

@Autowired
private UserRepository userRepo;

public List<Blog>
getMyBlogs(

Long userId

){

return repo
.findByUserId(
userId
);

}


// CREATE WITH USER
public Blog createWithUser(

Blog blog,

Long userId

){

User user =

userRepo
.findById(
userId
)

.orElseThrow();

blog.setUser(
user
);

blog.setCreatedAt(
LocalDateTime.now()
);

return repo.save(
blog
);

}


// GET ALL
public List<Blog> getAll(){

return repo.findAll();

}


// GET BY ID
public Blog getById(
Long id
){

return repo
.findById(id)
.orElseThrow();

}


// UPDATE
public Blog update(

Long id,

Blog updated

){

Blog blog=

repo
.findById(id)
.orElseThrow();

blog.setTitle(
updated.getTitle()
);

blog.setContent(
updated.getContent()
);

return repo.save(
blog
);

}


// DELETE
public void delete(
Long id
){

repo.deleteById(
id
);

}

}