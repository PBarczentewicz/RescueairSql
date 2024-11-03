package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BasicSetings {
    private String jdbcDriver = "com.mysql.cj.jdbc.Driver";

    public String getJdbcDriver() {
        return jdbcDriver;
    }
}

