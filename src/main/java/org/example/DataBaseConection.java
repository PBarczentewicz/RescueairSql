package org.example;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseConection {

    BasicSetings basicSetings = new BasicSetings();
    LoginUtylities loginUtylities = new LoginUtylities();

    public void setingsForSql() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName(basicSetings.getJdbcDriver());
            connection = DriverManager.getConnection(loginUtylities.getUrl(), loginUtylities.getLogin(), loginUtylities.getPassword());
            String sqlQuery = "SELECT * From wp_commentmeta";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                String firstColumn = resultSet.getNString("Column1");
                String secondColumn = resultSet.getNString("Column2");
                System.out.println("Pierwsza Kolumna: " + firstColumn + "Druga Kolumna " + secondColumn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


