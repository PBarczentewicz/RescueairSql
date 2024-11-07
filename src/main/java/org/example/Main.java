package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        DataBaseConection newContecion = new DataBaseConection();
        for (Post post : newContecion.getPostQuery()){
            System.out.println("Post Author " + post.post_author + " Post Title " + post.post_title);
        }
    }
}
