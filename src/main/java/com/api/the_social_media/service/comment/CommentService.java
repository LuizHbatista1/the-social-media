package com.api.the_social_media.service.comment;

import com.api.the_social_media.DTOS.requests.CommentDTO;
import com.api.the_social_media.domain.comment.Comment;
import com.api.the_social_media.domain.post.Post;

import java.util.List;

public interface CommentService {

    Comment createComment(CommentDTO commentDTO);

    void saveComment(Comment comment);

    List<Comment> findCommentsByPostId(Long postId);


}
