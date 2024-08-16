package com.api.the_social_media.repositories;

import com.api.the_social_media.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post , Long> {
}
