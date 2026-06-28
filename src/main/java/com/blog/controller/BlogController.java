package com.blog.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.blog.entity.Blog;
import com.blog.service.BlogService;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@RestController
@RequestMapping("/blogs")
public class BlogController {

@Autowired
private BlogService service;

@PostMapping(consumes = "multipart/form-data")
public Blog create(
    @RequestPart("blog") String blogJson,
    @RequestPart(value = "image", required = false) MultipartFile image,
    @RequestParam Long userId
) throws Exception {

    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    Blog blog = mapper.readValue(blogJson, Blog.class);

    return service.createWithUser(blog, userId, image);
}

// GET ALL
@GetMapping
public List<Blog> getAll(){
    return service.getAll();
}

@GetMapping("/my")
public List<Blog> myBlogs(@RequestParam Long userId){
    return service.getMyBlogs(userId);
}

// GET BY ID
@GetMapping("/{id}")
public Blog getOne(@PathVariable Long id){
    return service.getById(id);
}

// UPDATE
@PutMapping("/{id}")
public Blog update(@PathVariable Long id, @RequestBody Blog blog){
    return service.update(id, blog);
}

// DELETE
@DeleteMapping("/{id}")
public void delete(@PathVariable Long id){
    service.delete(id);
}

// LIKE / DISLIKE
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