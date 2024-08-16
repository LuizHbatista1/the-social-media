package com.api.the_social_media.domain.post;

import com.api.the_social_media.DTOS.requests.PostDTO;
import com.api.the_social_media.domain.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "post")
@Table(name = "tb_posts")

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @JoinColumn(name = "user_id")
    @ManyToOne
    private User userId;
    private String content;
    private Integer quantityLike;
    private LocalDateTime dateTime;

    public Post(){

    }

    public Post(PostDTO data){

        this.userId = getUserId();
        this.content = data.content();
        this.quantityLike = data.quantityLike();
        this.dateTime = data.dateTime();
    }


    public Post(Long id, User userId, String content, Integer quantityLike, LocalDateTime dateTime) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.quantityLike = quantityLike;
        this.dateTime = dateTime;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getQuantityLike() {
        return quantityLike;
    }

    public void setQuantityLike(Integer quantityLike) {
        this.quantityLike = quantityLike;
    }
}
