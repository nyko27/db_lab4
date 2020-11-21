package ua.lviv.iot.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/sky_scanner?useUnicode"
            + "=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "dbpassword";
    private static Connection CONNECTION = null;

    private DbConnector() {
    }

    public static Connection getConnection() {
        try {
            if (CONNECTION == null || CONNECTION.isClosed()) {
                try {
                    CONNECTION = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                } catch (SQLException exception){
                    printExeption(exception);
                }
            }
        } catch (SQLException exception) {
            printExeption(exception);
        }
        return CONNECTION;
    }

    private static void printExeption(SQLException exception) {
        System.out.println("SQL Exeption: " + exception.getMessage());
        System.out.println("SQL State: " + exception.getSQLState());
        System.out.println("SQL Error Code: " + exception.getErrorCode());
    }
}