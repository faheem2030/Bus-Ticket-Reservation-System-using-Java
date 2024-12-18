package BusReservUsingJDBC;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static String url ="jdbc:mysql://localhost:3306/busReserv";
    static String userName="root";
    static String passWord ="Faheem@1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,userName,passWord);
    }
}
