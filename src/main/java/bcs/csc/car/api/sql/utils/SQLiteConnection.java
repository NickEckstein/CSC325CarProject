package bcs.csc.car.api.sql.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {

    public static Connection connect() {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:./NHTSA.sqlite");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e + "");
        }
        return connection;
    }

}
