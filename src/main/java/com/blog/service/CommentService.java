package com.blog.service;

import com.blog.dto.CommentResponseDto;
import com.blog.entity.Blog;
import com.blog.entity.Comment;
import com.blog.entity.User;
import com.blog.exception.ResourceNotFoundException; // apne exception package ke hisaab se adjust karo
import com.blog.repository.BlogRepository;
import com.blog.repository.CommentRepository;
import com.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;

    public CommentResponseDto addComment(Long blogId, Long userId, String content) {
        Blog blog = blogRepository.findById(blogId)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found with id: " + blogId));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        Comment comment = new Comment(content, blog, user);
        Comment saved = commentRepository.save(comment);

        return mapToDto(saved);
    }

    public List<CommentResponseDto> getCommentsByBlog(Long blogId) {
        return commentRepository.findByBlogIdOrderByCreatedAtDesc(blogId)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public long getCommentCount(Long blogId) {
        return commentRepository.countByBlogId(blogId);
    }

    public void deleteComment(Long commentId, Long userId) {
        commentRepository.deleteByIdAndUserId(commentId, userId);
    }

    private CommentResponseDto mapToDto(Comment comment) {
        return new CommentResponseDto(
                comment.getId(),
                comment.getContent(),
                comment.getUser().getName(), // apne User.java me field ka naam check kar lena (username/name)
                comment.getCreatedAt()
        );
    }
}