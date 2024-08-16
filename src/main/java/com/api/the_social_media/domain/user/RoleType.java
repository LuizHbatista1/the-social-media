package com.api.the_social_media.domain.user;

public enum RoleType {

    ADMIN("admin"),
    COMMON("common");

    private String role;

    RoleType(String role){

        this.role = role;

    }

    public String getValue(){

        return role;

    }


}
