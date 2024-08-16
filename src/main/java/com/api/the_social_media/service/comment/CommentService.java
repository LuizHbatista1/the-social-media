package com.api.the_social_media.service.comment;

import com.api.the_social_media.DTOS.CommentDTO;
import com.api.the_social_media.domain.comment.Comment;

public interface CommentService {

    Comment createComment(CommentDTO commentDTO);

    void saveComment(Comment comment);


}
