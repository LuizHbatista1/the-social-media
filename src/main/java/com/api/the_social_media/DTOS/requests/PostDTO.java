package com.api.the_social_media.DTOS.requests;

import java.time.LocalDateTime;

public record PostDTO(Long userId , String content , Integer quantityLike , LocalDateTime dateTime) {
}
