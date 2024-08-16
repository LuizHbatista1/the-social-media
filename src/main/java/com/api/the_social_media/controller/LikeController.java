package com.api.the_social_media.controller;

import com.api.the_social_media.DTOS.requests.LikeDTO;
import com.api.the_social_media.domain.like.Like;
import com.api.the_social_media.service.like.LikeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LikeController {

    private final LikeServiceImpl likeService;

    @Autowired
    public LikeController(LikeServiceImpl likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/apiV1/like")
    public ResponseEntity<Like>createLike(@RequestBody LikeDTO likeDTO){

        Like newLike = likeService.createLike(likeDTO);
        return new ResponseEntity<>(newLike , HttpStatus.CREATED);

    }

}
