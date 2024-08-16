package com.api.the_social_media.repositories;

import com.api.the_social_media.domain.like.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like , Long> {
}
