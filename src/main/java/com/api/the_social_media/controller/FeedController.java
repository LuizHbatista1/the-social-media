package com.api.the_social_media.controller;

import com.api.the_social_media.DTOS.requests.CommentDTO;
import com.api.the_social_media.DTOS.requests.PostDTO;
import com.api.the_social_media.DTOS.responses.CommentResponseDTO;
import com.api.the_social_media.DTOS.responses.PostResponseDTO;
import com.api.the_social_media.domain.comment.Comment;
import com.api.the_social_media.domain.post.Post;
import com.api.the_social_media.service.comment.CommentServiceImpl;
import com.api.the_social_media.service.feed.FeedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class FeedController {

    private final FeedServiceImpl feedService;
    private final CommentServiceImpl commentService;

    @Autowired
    public FeedController(FeedServiceImpl feedService , CommentServiceImpl commentService) {
        this.feedService = feedService;
        this.commentService = commentService;
    }

    @GetMapping("/apiV1/feed")
    public ResponseEntity<List<PostResponseDTO>> getAllPosts(@RequestBody PostDTO postDTO){

        List<Post>posts = feedService.findAllPosts();

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
