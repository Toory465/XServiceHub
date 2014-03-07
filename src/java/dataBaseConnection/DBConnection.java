/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Touraj
 */
public class DBConnection {

    String userName;
    String password;
    String url;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    Connection conn;
    public DBConnection() {
        this.userName = "root";
        this.password = "";
        this.url = "jdbc:mysql://localhost:3306/servicediscovery";
        this.conn = null;
    }
    
    public DBConnection(String userName, String password, String url) {
        this.userName = "root";
        this.password = "";
        this.url = "jdbc:mysql://localhost:3306/servicediscovery";
        this.conn = null;
    }

    public Connection getDBConnection() {
        try
        {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection(url, userName, password);
        
        }
        catch (Exception e) {
            System.err.println("Cannot connect to database server");
        }
        return conn;
    }
    
    public void closeDBConnection()
    {
         if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Database connection terminated");
                } catch (Exception e) { }
            }
    }
}
