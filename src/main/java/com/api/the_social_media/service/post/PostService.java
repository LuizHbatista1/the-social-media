package com.api.the_social_media.service.post;

import com.api.the_social_media.DTOS.requests.PostDTO;
import com.api.the_social_media.domain.post.Post;

import java.time.LocalDateTime;
import java.util.List;

public interface PostService {

    Post findPostById(Long id);

    Post createPost(PostDTO postDTO);

    void savePost(Post post);

    LocalDateTime getLocalDateTime();

    List<Post>getPostByUser(Long id);



}
