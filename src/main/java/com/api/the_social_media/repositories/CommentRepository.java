package com.api.the_social_media.repositories;

import com.api.the_social_media.domain.comment.Comment;
import com.api.the_social_media.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {


    List<Comment> findByPostId(Post id);

}
