package com.krasn.facultative.controllers;

import com.krasn.facultative.models.HikariConnectionPoll;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@WebServlet("/test")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        try (Connection connection = HikariConnectionPoll.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select course_name, description, status, \n" +
                    "       (select first_name from usr where user_id = techer_id) as first_name, \n" +
                    "       (select last_name from usr where user_id=techer_id) as last_name from course;");
            while (resultSet.next()){
            printWriter.println(resultSet.getString("course_name"));
            printWriter.println(resultSet.getString("description"));
            printWriter.println(resultSet.getString("status"));
            printWriter.println(resultSet.getString("first_name"));
            printWriter.println(resultSet.getString("last_name"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
