package com.blog.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.Blog;
import com.blog.entity.Comment;
import com.blog.entity.User;
import com.blog.repository.BlogRepository;
import com.blog.repository.CommentRepository;
import com.blog.repository.UserRepository;
import com.blog.entity.BlogLike;
import com.blog.repository.BlogLikeRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class BlogService {

    @Autowired
    private BlogRepository repo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BlogLikeRepository blogLikeRepo;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    private CommentRepository commentRepo;

    public List<Blog> getMyBlogs(Long userId) {
        return repo.findByUserId(userId);
    }

    // CREATE WITH USER
    public Blog createWithUser(Blog blog, Long userId, MultipartFile image) throws IOException {

        User user = userRepo.findById(userId).orElseThrow();

        blog.setUser(user);
        blog.setCreatedAt(LocalDateTime.now());

        if (image != null && !image.isEmpty()) {
            String imageUrl = cloudinaryService.uploadFile(image);
            blog.setImageUrl(imageUrl);
        }

        return repo.save(blog);
    }

    // GET ALL
    public List<Blog> getAll() {
        return repo.findAll();
    }

    // GET BY ID
    public Blog getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    // UPDATE
    public Blog update(Long id, Blog updated) {

        Blog blog = repo.findById(id).orElseThrow();

        blog.setTitle(updated.getTitle());
        blog.setContent(updated.getContent());

        return repo.save(blog);
    }

    // DELETE
    public void delete(Long id) {

        Blog blog = repo.findById(id).orElseThrow();

        // Pehle is blog ke saare comments delete karo
        List<Comment> comments = commentRepo.findByBlogIdOrderByCreatedAtDesc(id);
        commentRepo.deleteAll(comments);

        // Fir is blog ke saare likes/dislikes delete karo
        List<BlogLike> likes = blogLikeRepo.findByBlog(blog);
        blogLikeRepo.deleteAll(likes);

        // Ab blog delete karo
        repo.deleteById(id);
    }

    // LIKE / DISLIKE
    public Map<String, Object> reactToBlog(Long blogId, Long userId, String type) {

        Blog blog = repo.findById(blogId).orElseThrow();

        User user = userRepo.findById(userId).orElseThrow();

        Optional<BlogLike> existing = blogLikeRepo.findByUserAndBlog(user, blog);

        if (existing.isPresent()) {
            BlogLike existingReaction = existing.get();

            if (existingReaction.getType().equals(type)) {
                blogLikeRepo.delete(existingReaction);
            } else {
                existingReaction.setType(type);
                blogLikeRepo.save(existingReaction);
            }
        } else {
            blogLikeRepo.save(new BlogLike(user, blog, type));
        }

        int likes = blogLikeRepo.countByBlogAndType(blog, "LIKE");
        int dislikes = blogLikeRepo.countByBlogAndType(blog, "DISLIKE");

        Map<String, Object> result = new HashMap<>();
        result.put("likeCount", likes);
        result.put("dislikeCount", dislikes);
        return result;
    }

    public Map<String, Object> getCounts(Long blogId) {
        Blog blog = repo.findById(blogId).orElseThrow();
        int likes = blogLikeRepo.countByBlogAndType(blog, "LIKE");
        int dislikes = blogLikeRepo.countByBlogAndType(blog, "DISLIKE");
        Map<String, Object> result = new HashMap<>();
        result.put("likeCount", likes);
        result.put("dislikeCount", dislikes);
        return result;
    }

}