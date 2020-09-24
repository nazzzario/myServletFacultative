package com.krasn.facultative.models.entity;

import com.krasn.facultative.models.enumeration.Status;

import javax.management.relation.Role;
import java.util.Objects;

public class User extends AbstractEntity<Integer> {
    private Status status;
    private String email;
    private String login;
    private String firstName;
    private String lastName;
    private String password;
    private Role role;
    private String pathToPhoto;

    public User(Status status, String email, String login, String firstName,
                String lastName, String password, Role role, String pathToPhoto) {
        this.status = status;
        this.email = email;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
        this.pathToPhoto = pathToPhoto;
    }

    public User() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPathToPhoto() {
        return pathToPhoto;
    }

    public void setPathToPhoto(String pathToPhoto) {
        this.pathToPhoto = pathToPhoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return status == user.status &&
                Objects.equals(email, user.email) &&
                Objects.equals(login, user.login) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(role, user.role) &&
                Objects.equals(pathToPhoto, user.pathToPhoto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, email, login, firstName, lastName, password, role, pathToPhoto);
    }

    @Override
    public String toString() {
        return "User{" +
                "status=" + status +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", pathToPhoto='" + pathToPhoto + '\'' +
                '}';
    }
}
