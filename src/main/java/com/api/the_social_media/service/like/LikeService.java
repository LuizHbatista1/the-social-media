package com.api.the_social_media.service.like;

import com.api.the_social_media.DTOS.LikeDTO;
import com.api.the_social_media.domain.like.Like;

public interface LikeService {

    Like createLike(LikeDTO likeDTO);

    void saveLike(Like like);

}
