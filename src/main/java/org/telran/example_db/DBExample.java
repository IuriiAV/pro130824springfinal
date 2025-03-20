package org.telran.example_db;

import java.sql.*;
import java.util.Scanner;

/**
 * ACID
 * A - atomicity
 * C - consistency
 * I - isolation
 * D - durability
 */
public class DBExample {

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        connection.setAutoCommit(false); // true

        Statement statement = null;
        statement = connection.createStatement();

        Scanner scanner = new Scanner(System.in);

        try {
            //2 Add Alex
            //Здесь будет открыта новая транзакция
            statement.execute("INSERT INTO network_users(id,name) VALUES(1,'Alex')");

            System.out.println("Input option : ");
            if (scanner.nextInt() == 1) {
                throw new RuntimeException();
            }

            //3 Add Max
            statement.execute("INSERT INTO network_users(id,name) VALUES (2, 'Max')");
            connection.commit(); // транзакция будет применена

        } catch (RuntimeException e) {
            connection.rollback();
        }

        connection.close();
    }

    private static Connection getConnection() {
        Connection connection = null;
        String connectionString = "jdbc:mysql://localhost:3306/test_social";
        try {
            connection = DriverManager.getConnection(connectionString, "root", "rootroot");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
