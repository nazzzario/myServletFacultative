package com.krasn.facultative.dao;

public class Query {

    private Query() {
    }

    //user
    public static final String SELECT_USER_BY_ID = "SELECT * FROM usr WHERE usr_id = ?";
    public static final String SELECT_USER_BY_LOGIN = "SELECT * FROM usr WHERE login = ?";
    public static final String INSERT_USER = "INSERT INTO usr (login, password, role, first_name, last_name) VALUES (?, ?, ?, ?, ?)";
    public static final String SELECT_LAST_INSERT_USER = "SELECT * FROM usr WHERE usr_id = LAST_INSERT_ID()";

}
