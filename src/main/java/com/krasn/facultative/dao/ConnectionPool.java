package com.krasn.facultative.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {

//    private static HikariConfig config = new HikariConfig("application.properties");
//    private static HikariDataSource ds = new HikariDataSource( config );
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;
    static {
        config.setJdbcUrl( "jdbc:mysql://localhost:3306/facultative_db" );
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setUsername( "root" );
        config.setPassword( "root" );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource( config );
    }

    private ConnectionPool() {}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
