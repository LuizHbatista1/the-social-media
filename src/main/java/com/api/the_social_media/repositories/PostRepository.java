package com.api.the_social_media.repositories;

import com.api.the_social_media.domain.post.Post;
import com.api.the_social_media.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post , Long> {

   List<Post> findAllByUserId(User userId);
}
