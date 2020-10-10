package com.krasn.facultative.dao.entity.impl;

import com.krasn.facultative.dao.ConnectionPool;
import com.krasn.facultative.dao.Query;
import com.krasn.facultative.dao.entity.UserDao;
import com.krasn.facultative.domain.enums.UserRole;
import com.krasn.facultative.domain.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class UserDaoImpl  extends AbstractDao<User, Long> implements UserDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class.getName());

    @Override
    public User getByLogin(String login) {
        User user = null;

        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement stmt = connection.prepareStatement(Query.SELECT_USER_BY_LOGIN)) {

            stmt.setString(1, login);
            user = parseResultSet(stmt.executeQuery()).iterator().next();
        } catch (SQLException e) {
            LOGGER.error("Exception while getting students.\n", e);
        } catch (NullPointerException e) {
            LOGGER.error("NPE exception while creating statement.\n", e);
        } catch (NoSuchElementException e) {
            LOGGER.error("Can't find any user with login {} ",login, e);
        }

        return user;
    }

    @Override
    public List<User> getTeachers() {
        List<User> list = new ArrayList<>();

        try (Connection connection = ConnectionPool.getConnection();
             Statement stmt = connection.createStatement()) {

            list = parseResultSet(stmt.executeQuery(Query.SELECT_ALL_TEACHERS));
        } catch (SQLException e) {
            LOGGER.error("Exception while getting unblocked students.\n", e);
        } catch (NullPointerException e) {
            LOGGER.error("NPE exception while creating statement.\n", e);
        }

        return list;
    }

    @Override
    protected String getInsertQuery() {
        return Query.INSERT_USER;
    }

    @Override
    protected void prepareStatementForCreate(PreparedStatement stmt, User object) {
        try {
            stmt.setString(1, object.getLogin());
            stmt.setString(2, object.getPassword());
            stmt.setString(3, object.getUserRole().name());
            stmt.setString(4, object.getFirstName());
            stmt.setString(5, object.getLastName());

        } catch (SQLException e) {
            LOGGER.error("Exception while preparing statement for create.\n", e);
        }
    }

    @Override
    protected List<User> parseResultSet(ResultSet rs) {
        List<User> list = new ArrayList<>();

        try {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("usr_id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setUserRole(UserRole.getRole(rs.getString("role")));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setBlocked(rs.getBoolean("blocked"));
                list.add(user);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception while parsing result set.\n", e);
        }
        return list;
    }

    @Override
    protected String getSelectByIdQuery() {
        return null;
    }

    @Override
    protected String getSelectAllQuery() {
        return Query.SELECT_ALL_USERS;
    }

    @Override
    protected String getLastInsertId() {
        return Query.SELECT_LAST_INSERT_USER;
    }

    @Override
    protected String getUpdateQuery() {
        return null;
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement stmt, User object) {
        try {
            stmt.setString(1, object.getLogin());
            stmt.setString(2, object.getPassword());
            stmt.setString(3, object.getUserRole().name());
            stmt.setString(4, object.getFirstName());
            stmt.setString(5, object.getLastName());
            stmt.setBoolean(6, object.isBlocked());
            stmt.setLong(7, object.getId());
        } catch (SQLException e) {
            LOGGER.error("Exception while preparing statement for update.\n", e);
        }
    }

    @Override
    protected String getDeleteQuery() {
        return null;
    }

    @Override
    public User get(Long key) {
        return null;
    }
}
