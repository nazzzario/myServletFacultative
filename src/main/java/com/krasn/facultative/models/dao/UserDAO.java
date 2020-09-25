package com.krasn.facultative.models.dao;

public class UserDAO {
    public static final String INSERT_USER =
            "INSERT INTO usr (active, email, login, first_name, last_name, password, path_to_photo) VALUES (?, ?, ?, ?, ?, ?, ?)";
}
