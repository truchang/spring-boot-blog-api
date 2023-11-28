package com.springboot.blog.controller;

import com.springboot.blog.entity.Comment;
import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @Operation(summary = "Create new comment API")
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") long postId,
                                                    @Valid @RequestBody CommentDto commentDto) {
       return new ResponseEntity<CommentDto>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Get all comments on post by post id API")
    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable(value = "postId") long postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @Operation(summary = "Get comment by id API")
    @GetMapping("/posts/{postId}/comments/{commentId}")
    public  ResponseEntity<CommentDto>  getCommentById(@PathVariable(value = "postId") long postId, @PathVariable(value = "commentId") long commentId) {
        return ResponseEntity.ok(commentService.getCommentById(postId, commentId));
    }

    @Operation(summary = "Update comment by id API")
    @PutMapping("/posts/{postId}/comments/{commentId}")
    public  ResponseEntity<CommentDto>  updateComment(@PathVariable(value = "postId") long postId, @PathVariable(value = "commentId") long commentId,
                                                       @Valid @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(commentService.updateCommentById(postId, commentId, commentDto), HttpStatus.OK);
    }

    @Operation(summary = "Delete comment by id API")
    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public  ResponseEntity<String> deleteComment(@PathVariable(value = "postId") long postId, @PathVariable(value = "commentId") long commentId) {
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<String>("Comment deleted successfully", HttpStatus.OK);
    }
}
