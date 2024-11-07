package org.example;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseConection {
    LoginUtylities loginUtylities = new LoginUtylities();

    public ArrayList<Post> getPostQuery() {
        ArrayList<Post> postList = new ArrayList<>();
        String sqlQuery = "SELECT post_author, post_title FROM wp_posts";

        try (Connection connection = DriverManager.getConnection(loginUtylities.getUrl(), loginUtylities.getLogin(), loginUtylities.getPassword());
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            while (resultSet.next()) {
                String author = resultSet.getString("post_author");
                String title = resultSet.getString("post_title");
                postList.add(new Post(author, title));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }
}



