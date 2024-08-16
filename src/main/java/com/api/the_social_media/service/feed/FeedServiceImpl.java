package com.api.the_social_media.service.feed;

import com.api.the_social_media.domain.post.Post;
import com.api.the_social_media.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedServiceImpl implements FeedService{

    private final PostRepository postRepository;

    @Autowired
    public FeedServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }
}
