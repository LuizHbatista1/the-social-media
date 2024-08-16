package com.api.the_social_media.DTOS.responses;

import java.util.List;

public record PostResponseDTO (String firstName , String content , Integer quantityLike , List<CommentResponseDTO> comments){
}
