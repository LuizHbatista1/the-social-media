package com.api.the_social_media.controller;

import com.api.the_social_media.DTOS.requests.CommentDTO;
import com.api.the_social_media.domain.comment.Comment;
import com.api.the_social_media.service.comment.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CommentController {

    private final CommentServiceImpl commentService;

    @Autowired
    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/apiV1/comment")
    public ResponseEntity<Comment>createComment(@RequestBody CommentDTO commentDTO){

        Comment newComment = commentService.createComment(commentDTO);
        return new ResponseEntity<>(newComment , HttpStatus.CREATED);

    }
}
