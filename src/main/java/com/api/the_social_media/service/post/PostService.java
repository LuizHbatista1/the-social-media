package com.api.the_social_media.service.post;

import com.api.the_social_media.DTOS.PostDTO;
import com.api.the_social_media.domain.post.Post;

import java.util.List;

public interface PostService {

    Post findPostById(Long id);

    Post createPost(PostDTO postDTO);

    void savePost(Post post);

    List<Post>getPostByUser(Long id);

}
