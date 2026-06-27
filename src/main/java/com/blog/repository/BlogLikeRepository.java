package com.blog.repository;

import com.blog.entity.Blog;
import com.blog.entity.BlogLike;
import com.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BlogLikeRepository extends JpaRepository<BlogLike, Long> {

    Optional<BlogLike> findByUserAndBlog(User user, Blog blog);

    int countByBlogAndType(Blog blog, String type);
}