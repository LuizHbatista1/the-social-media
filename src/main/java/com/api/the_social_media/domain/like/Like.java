package com.api.the_social_media.domain.like;

import com.api.the_social_media.DTOS.LikeDTO;
import com.api.the_social_media.domain.post.Post;
import com.api.the_social_media.domain.user.User;
import jakarta.persistence.*;

@Entity(name = "like")
@Table(name = "tb_likes")

public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @JoinColumn(name = "user_id")
    @ManyToOne
    private User userId;
    @JoinColumn(name = "post_id")
    @ManyToOne
    private Post postId;

    public Like(){

    }

    public Like(LikeDTO data){

        this.postId = getPostId();
        this.userId = getUserId();
    }

    public Like(Long id, User userId, Post postId) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
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
}
