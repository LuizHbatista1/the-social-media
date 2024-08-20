package com.api.the_social_media.controller;

import com.api.the_social_media.DTOS.responses.CommentResponseDTO;
import com.api.the_social_media.DTOS.responses.PostResponseDTO;
import com.api.the_social_media.domain.post.Post;
import com.api.the_social_media.service.comment.CommentServiceImpl;
import com.api.the_social_media.service.post.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping

public class ProfileController {

    private final PostServiceImpl postService;
    private final CommentServiceImpl commentService;

    @Autowired
    public ProfileController(PostServiceImpl postService, CommentServiceImpl commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping("/apiV1/{userId}/post")
    public ResponseEntity<List<PostResponseDTO>>getAllPostsByUser(@PathVariable Long userId){

        List<Post> posts = postService.getPostByUser(userId);

        List<PostResponseDTO> responseDTOS = posts.stream().map(post -> {

            String firstName  = post.getUserId().getFirstName();
            String content = post.getContent();
            int quantityLike = post.getQuantityLike();

            List<CommentResponseDTO> commentDTOs = commentService.findCommentsByPostId(post.getId()).stream()
                    .map(comment -> {
                        String message = comment.getMessage();
                        return new CommentResponseDTO(message);
                    }).collect(Collectors.toList());


                return new PostResponseDTO(firstName , content , quantityLike , commentDTOs);
            }).collect(Collectors.toList());

            return new ResponseEntity<>(responseDTOS , HttpStatus.OK);

    }

}
