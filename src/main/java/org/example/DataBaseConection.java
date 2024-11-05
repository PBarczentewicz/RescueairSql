package org.example;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseConection {

    BasicSetings basicSetings = new BasicSetings();
    LoginUtylities loginUtylities = new LoginUtylities();
    private Connection connection = null;
    private Statement statement = null;

    private ResultSet DataBaseConnection(String sqlQuery) throws SQLException {

        try {
            Class.forName(basicSetings.getJdbcDriver());
            connection = DriverManager.getConnection(loginUtylities.getUrl(), loginUtylities.getLogin(), loginUtylities.getPassword());
            statement = connection.createStatement();
            return statement.executeQuery(sqlQuery);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }

    public ArrayList<Post> getPostQueary() throws SQLException {
        ResultSet resultSet = DataBaseConnection("Select * from wp_posts");
        ArrayList<Post> postList = new ArrayList<>();

        while (resultSet.next()) {
            postList.add(new Post(resultSet.getString("post_author"), resultSet.getString("post_title")));
        }
        closeConection();
        return postList;

    }

    private void closeConection() {
        try {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



