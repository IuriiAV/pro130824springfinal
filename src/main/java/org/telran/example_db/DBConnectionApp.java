package org.telran.example_db;

import java.sql.*;

/**
 * Driver
 * use DriverManager -> getConnection (connectString, user name, password)
 * Connection :
 *  createStatement
 *  prepareStatement
 *
 * execute - create, update, delete, insert, drop
 * executeQuery -> return ResultSet  -> select
 *
 */
public class DBConnectionApp {

    public static void main(String[] args) {
        String host = "localhost"; //server DB
        String port = "3306";
        String dbName = "test_social";
        String userName = "root";
        String password = "rootroot";

        //Коннект к БД
        Connection connection = null;
        String connectionString = "jdbc:mysql://" + host + ":" + port + "/" + dbName;

        //ACID -
        try {
            //String driver = "driver name";
            //Class.forName(driver);

            connection = DriverManager.getConnection(connectionString, userName, password);

            String createTable = "CREATE TABLE IF NOT EXISTS network_users (id int, name varchar(255))";
            Statement request = connection.createStatement();
            //connection.prepareStatement() -- для запроса с параметрами
            boolean response = request.execute(createTable);
            System.out.println("Table network_users is created = " + response);

            String insertData = "INSERT INTO network_users(id,name) VALUES(1,'Alex'), (2, 'Max')";
            response = request.execute(insertData);

            String select = "SELECT * FROM network_users";
            ResultSet resultSet = request.executeQuery(select);
            while (resultSet.next()) {
                System.out.println("id = " + resultSet.getInt(1) + " name = "
                        + resultSet.getString(2));
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
