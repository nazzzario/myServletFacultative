package com.krasn.facultative.domain.enums;

public enum UserRole {
    TEACHER, STUDENT, ADMIN;

    public static UserRole getRole(String userRole) {
//        UserRole role = UserRole.valueOf(userRole);
        return UserRole.valueOf(userRole);
    }

    public String getName() {
        return name().toLowerCase();
    }
}
