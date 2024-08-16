package com.api.the_social_media.DTOS;

import java.time.LocalDateTime;

public record PostDTO(Long userId , String content , Integer quantityLike , LocalDateTime dateTime) {
}
