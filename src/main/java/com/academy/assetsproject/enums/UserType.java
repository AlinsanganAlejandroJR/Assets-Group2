package com.academy.assetsproject.enums;


import org.springframework.security.core.GrantedAuthority;

public enum UserType {
    //ROLE_ADMIN,ROLE_USER
    ROLE_ADMIN(Constants.ADMIN_VALUE), ROLE_USER(Constants.USER_VALUE);
    UserType(String userType){

    }

    public static class Constants {
        public static final String ADMIN_VALUE = "ROLE_ADMIN";
        public static final String USER_VALUE = "ROLE_USER";
    }
}
