package com.api.the_social_media.controller;

import com.api.the_social_media.DTOS.requests.PostDTO;
import com.api.the_social_media.domain.post.Post;
import com.api.the_social_media.service.post.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PostController {

    private final PostServiceImpl postService;

    @Autowired
    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @PostMapping("/apiV1/post")
    public ResponseEntity<Post>createPost(@RequestBody PostDTO postDTO){

        Post newPost = postService.createPost(postDTO);
        return new ResponseEntity<>(newPost , HttpStatus.CREATED);

    }


}
