package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTest {
    public static Connection getCon() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        String url = "jdbc:mysql://192.168.0.40:3306/transnova?useSSL=false";
        String user = "root";
        String password = "6yhn7ujm";

        return DriverManager.getConnection(url, user, password);
    }
}
