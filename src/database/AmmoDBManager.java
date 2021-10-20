package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
class to handle database connections
*/
public class AmmoDBManager {
    
    private static final String USER_NAME = "pdc";
    private static final String PASSWORD = "pdc";
    
    private static final String URL = "jdbc:derby:PDC;create=true";
    
    Connection conn;
    
    public AmmoDBManager()
    {
        establishConnection();
    }
    
    public void establishConnection() {
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);


            } catch (SQLException ex) {
                System.out.println(ex.getMessage());

            }
        }
    }
    
    public ResultSet myQuery(String sql) {

        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    
    public void myUpdate(String sql)
    {
        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
        public Connection getConnection() {
        return this.conn;
    }
    
    
}