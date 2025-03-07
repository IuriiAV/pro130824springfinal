package org.telran.dbexample;

import java.sql.*;

public class DBConnectionApp {

    public static void main(String[] args) {
        String host = "localhost"; //server db
        String port = "3306";
        String dbName = "test_social";
        String username = "root";
        String password = "eowM=EStU23KSp";

        //connection to DB
        Connection connection = null;
        String connectionString = "jdbc:mysql://" + host + ":" + port + "/" + dbName;

        //create connection to db
        try {
            connection = DriverManager.getConnection(connectionString, username, password);

            String createTable = "CREATE TABLE IF NOT EXISTS network_users (id int, name varchar(255))";
            Statement request = connection.createStatement();
            boolean execute = request.execute(createTable);
            System.out.println(execute);

            String insertData = "INSERT INTO network_users(id, name) VALUES(1, 'Alex'), (2, 'Max')";

            request.execute(insertData);

            String select = "SELECT * FROM network_users";

            ResultSet resultSet = request.executeQuery(select);
            while (resultSet.next()) {
                System.out.println("id = " + resultSet.getInt(1) + " name = " + resultSet.getString(2));
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
