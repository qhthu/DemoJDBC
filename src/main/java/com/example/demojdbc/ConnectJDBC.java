package com.example.demojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {
    public static Connection getConnection() {

        Connection connection = null;

        String url = "jdbc:sqlserver://;databaseName=DemoJDBC";
        String user = "sa";
        String pass = "123";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Ket noi csdl thanh cong!!");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Ket noi csdl khong thanh cong!!");
        }

        return connection;
    }
}
