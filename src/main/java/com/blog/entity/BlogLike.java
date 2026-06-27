package com.blog.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "blog_likes",
       uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "blog_id"}))
public class BlogLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;

    private String type; // "LIKE" ya "DISLIKE"

    public BlogLike() {}

    public BlogLike(User user, Blog blog, String type) {
        this.user = user;
        this.blog = blog;
        this.type = type;
    }

    public Long getId() { return id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Blog getBlog() { return blog; }
    public void setBlog(Blog blog) { this.blog = blog; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}