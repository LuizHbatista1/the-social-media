package com.api.the_social_media.service.like;

import com.api.the_social_media.DTOS.requests.LikeDTO;
import com.api.the_social_media.domain.like.Like;
import com.api.the_social_media.domain.post.Post;

public interface LikeService {

    Like createLike(LikeDTO likeDTO);

    void saveLike(Like like);

    Post addLikeAtPost(Post post);

}
