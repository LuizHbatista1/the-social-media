package com.api.the_social_media.DTOS;

import com.api.the_social_media.domain.user.RoleType;

public record RegisterDTO(String firstName , String email , String password , RoleType role) {
}
