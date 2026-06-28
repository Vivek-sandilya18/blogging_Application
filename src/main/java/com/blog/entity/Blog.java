package com.blog.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name="blogs")
public class Blog {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String title;
private String imageUrl;

@Column(columnDefinition = "TEXT")
private String content;

public String getImageUrl() {
	return imageUrl;
}


public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}

private LocalDateTime createdAt;

@ManyToOne

@JoinColumn(name = "user_id")

@JsonIgnoreProperties({
"password"
})

private User user;


// Constructor
public Blog(){

}


// Getter Setter

public Long getId() {
return id;
}

public void setId(Long id) {
this.id = id;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public String getContent() {
return content;
}

public void setContent(String content) {
this.content = content;
}

public LocalDateTime getCreatedAt() {
return createdAt;
}

public void setCreatedAt(
LocalDateTime createdAt
) {
this.createdAt = createdAt;
}

public User getUser() {
return user;
}

public void setUser(
User user
) {
this.user = user;
}

}