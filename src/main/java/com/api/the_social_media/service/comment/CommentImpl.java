package com.api.the_social_media.service.comment;

import com.api.the_social_media.DTOS.CommentDTO;
import com.api.the_social_media.domain.comment.Comment;
import com.api.the_social_media.domain.post.Post;
import com.api.the_social_media.domain.user.User;
import com.api.the_social_media.repositories.CommentRepository;
import com.api.the_social_media.service.post.PostServiceImpl;
import com.api.the_social_media.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserServiceImpl userService;
    private final PostServiceImpl postService;

    @Autowired
    public CommentImpl(CommentRepository commentRepository, UserServiceImpl userService, PostServiceImpl postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    @Override
    public Comment createComment(CommentDTO commentDTO) {

        User sender = userService.findUserById(commentDTO.userId());
        Post post = postService.findPostById(commentDTO.postId());
        Comment newComment = new Comment(commentDTO);
        newComment.setUserId(sender);
        newComment.setPostId(post);
        newComment.setMessage(newComment.getMessage());
        this.saveComment(newComment);
        return newComment;
    }

    @Override
    public void saveComment(Comment comment) {

        this.commentRepository.save(comment);

    }
}
