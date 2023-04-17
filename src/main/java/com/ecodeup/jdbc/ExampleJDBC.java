package com.ecodeup.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExampleJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/people?serverTimezone=UTC";
        String username = "root";
        String password = "localhost";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Person");

            while (resultSet.next()){
                System.out.println(resultSet.getString("id_person") + " | " + resultSet.getString("name_person"));
            }

            connection.close();
            statement.close();
            resultSet.close();

        } catch (Exception e){
            //System.err.println(e);
            e.printStackTrace();
        }
    }
}
