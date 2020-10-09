package com.krasn.facultative.domain.entity;

import com.krasn.facultative.domain.Identified;
import com.krasn.facultative.domain.enums.UserRole;

import java.io.Serializable;

public class User implements Identified<Long>, Serializable {
    private Long id;
    private String login;
    private String password;
    private UserRole userRole;
    private String firstName;
    private String lastName;
    private boolean blocked;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", blocked=" + blocked +
                '}';
    }
}
