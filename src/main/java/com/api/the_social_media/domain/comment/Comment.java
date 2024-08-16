package com.api.the_social_media.domain.comment;

import com.api.the_social_media.DTOS.requests.CommentDTO;
import com.api.the_social_media.domain.post.Post;
import com.api.the_social_media.domain.user.User;
import jakarta.persistence.*;

@Entity(name = "comment")
@Table(name = "tb_comments")

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @JoinColumn(name  = "user_id")
    @ManyToOne
    private User userId;
    @JoinColumn( name = "post_id")
    @ManyToOne
    private Post postId;
    private String message;

    public Comment(){

    }

    public Comment(CommentDTO data){

        this.userId = getUserId();
        this.postId = getPostId();
        this.message = data.message();
    }

    public Comment(Long id, User userId, Post postId, String message) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Post getPostId() {
        return postId;
    }

    public void setPostId(Post postId) {
        this.postId = postId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
