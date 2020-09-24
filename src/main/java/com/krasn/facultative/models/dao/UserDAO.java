package com.krasn.facultative.models.dao;

public class UserDAO {
    private static final String SQL_FIND_USER_BY_ID =
            "SELECT * FROM usr WHERE user_id=?";

    private static final String SQL_FIND_USER_BY_LOGIN =
            "SELECT * FROM usr WHERE login=?";

//    private static final String SQL_UPDATE_USER =
//            "UPDATE usr SET "
}
