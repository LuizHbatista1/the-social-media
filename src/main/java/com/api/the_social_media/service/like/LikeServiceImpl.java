package com.api.the_social_media.service.like;

import com.api.the_social_media.DTOS.requests.LikeDTO;
import com.api.the_social_media.domain.like.Like;
import com.api.the_social_media.domain.post.Post;
import com.api.the_social_media.domain.user.User;
import com.api.the_social_media.repositories.LikeRepository;
import com.api.the_social_media.service.post.PostServiceImpl;
import com.api.the_social_media.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;
    private final UserServiceImpl userService;
    private final PostServiceImpl postService;

    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository, UserServiceImpl userService, PostServiceImpl postService) {
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.postService = postService;
    }

    @Override
    public Like createLike(LikeDTO likeDTO) {

        User sender = userService.findUserById(likeDTO.userId());
        Post likePostId = postService.findPostById(likeDTO.postId());
        Like newLike = new Like(likeDTO);
        newLike.setPostId(likePostId);
        newLike.setUserId(sender);
        addLikeAtPost(likePostId);
        this.saveLike(newLike);
        return newLike;

    }

    @Override
    public void saveLike(Like like) {

        this.likeRepository.save(like);

    }

    @Override
    public Post addLikeAtPost(Post post) {
        
        post.setQuantityLike(post.getQuantityLike() + 1);
        return post;

    }
}
