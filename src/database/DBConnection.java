package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private final String URL="jdbc:mysql://localhost:3306/CarSharing";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private Connection conn=null;

    DBConnection() {
        if (conn != null) {
            System.out.println("Connection already established with db");
            return;
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Connection FAILED");
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void closeConnection() {
        if (conn == null) {
            return;
        }
        try {
            conn.close();
            conn = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
