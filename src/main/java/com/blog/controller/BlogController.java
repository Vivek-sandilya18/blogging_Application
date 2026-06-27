package com.blog.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.blog.entity.Blog;
import com.blog.service.BlogService;
import java.util.Map;

@RestController
@RequestMapping("/blogs")
public class BlogController {

@Autowired
private BlogService service;

@PostMapping
public Blog create(

@RequestBody Blog blog,

@RequestParam Long userId

){

return service.createWithUser(

blog,

userId

);

}


// GET ALL
@GetMapping
public List<Blog> getAll(){

return service.getAll();

}

@GetMapping(
"/my"
)

public List<Blog>
myBlogs(

@RequestParam
Long userId

){

return service
.getMyBlogs(
userId
);

}


// GET BY ID
@GetMapping("/{id}")
public Blog getOne(

@PathVariable Long id

){

return service.getById(
id
);

}


// UPDATE
@PutMapping("/{id}")
public Blog update(

@PathVariable Long id,

@RequestBody Blog blog

){

return service.update(

id,

blog

);

}


// DELETE
@DeleteMapping("/{id}")
public void delete(

@PathVariable Long id

){

service.delete(
id
);

}
//LIKE / DISLIKE
@PutMapping("/{id}/react")
public Map<String, Object> react(

 @PathVariable Long id,

 @RequestParam Long userId,

 @RequestParam String type

) {

 return service.reactToBlog(id, userId, type);

}
@GetMapping("/{id}/counts")
public Map<String, Object> getCounts(@PathVariable Long id) {
    return service.getCounts(id);
}

}
