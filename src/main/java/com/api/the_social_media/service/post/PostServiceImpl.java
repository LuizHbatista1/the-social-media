package com.api.the_social_media.service.post;

import com.api.the_social_media.DTOS.requests.PostDTO;
import com.api.the_social_media.domain.post.Post;
import com.api.the_social_media.domain.user.User;
import com.api.the_social_media.repositories.PostRepository;
import com.api.the_social_media.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserServiceImpl userService;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserServiceImpl userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Override
    public Post findPostById(Long id) {
        return this.postRepository.findById(id).orElseThrow(()-> new RuntimeException());
    }

    @Override
    public LocalDateTime getLocalDateTime() {
       return LocalDateTime.now();
    }

    @Override
    public Post createPost(PostDTO postDTO) {

        User sender = userService.findUserById(postDTO.userId());
        Post newPost = new Post(postDTO);
        newPost.setUserId(sender);
        newPost.setContent(newPost.getContent());
        newPost.setQuantityLike(newPost.getQuantityLike());
        newPost.setDateTime(getLocalDateTime());
        this.savePost(newPost);
        return newPost;

    }

    @Override
    public void savePost(Post post) {

        this.postRepository.save(post);

    }

    @Override
    public List<Post> getPostByUser(Long id) {
        return List.of();
    }
}
