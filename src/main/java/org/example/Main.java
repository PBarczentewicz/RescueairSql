package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        DataBaseConection newContecion = new DataBaseConection();
        for (Post post : newContecion.getPostQueary()){
            System.out.println("Post " + post.post_author + post.post_title);
        }
    }
}
