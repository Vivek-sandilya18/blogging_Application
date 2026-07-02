package com.blog.controller;

import com.blog.dto.CommentRequestDto;
import com.blog.dto.CommentResponseDto;
import com.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs/{blogId}/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public CommentResponseDto addComment(
            @PathVariable Long blogId,
            @RequestParam Long userId,
            @RequestBody CommentRequestDto request
    ) {
        return commentService.addComment(blogId, userId, request.getContent());
    }

    @GetMapping
    public List<CommentResponseDto> getComments(@PathVariable Long blogId) {
        return commentService.getCommentsByBlog(blogId);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(
            @PathVariable Long commentId,
            @RequestParam Long userId
    ) {
        commentService.deleteComment(commentId, userId);
    }
}