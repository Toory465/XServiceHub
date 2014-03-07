/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import dataBaseConnection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Touraj
 */
public class SignInBean {

    DBConnection dbc;
    String email;
    String password;

    public SignInBean(String userName, String password) {
        this.email = userName;
        this.password = password;
        dbc = new DBConnection();
    }

    public int checkMemberShip() {
        int result = -1;
        dbc.getDBConnection();
        PreparedStatement prepStmt = null;
        try {
            String q = "SELECT users.id"
                    + " FROM users"
                    + " WHERE (users.EMAIL = ? AND users.PASSWORD = ?)";
            prepStmt = dbc.getConn().prepareStatement(q);
            prepStmt.setString(1, email);
            prepStmt.setString(2, password);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                result = rs.getInt("users.id");
            }
            rs.close();
            System.out.println(" rows were retrieved");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
        } finally {

            try {
                if (dbc.getConn() != null) {
                    dbc.getConn().close();
                }
                if (prepStmt != null) {
                    prepStmt.close();
                }
                System.out.println("Database connection terminated");
            } catch (Exception e) { /* ignore close errors */ }
        }
        return result;
    }

    public String getUserName() {
        String result = null;
        PreparedStatement prepStmt = null;
        try {
            dbc.getDBConnection();
            String q = "SELECT users.name"
                    + " FROM users"
                    + " WHERE (users.EMAIL = ? AND users.PASSWORD = ?)";
            prepStmt = dbc.getConn().prepareStatement(q);
            prepStmt.setString(1, email);
            prepStmt.setString(2, password);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                result = rs.getString("users.name");
            }
            rs.close();
            System.out.println(" rows were retrieved");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
        } finally {
            try {
                if (dbc.getConn() != null) {
                    dbc.getConn().close();
                }
                if (prepStmt != null) {
                    prepStmt.close();
                }
                System.out.println("Database connection terminated");
            } catch (Exception e) { /* ignore close errors */ }
        }
        return result;

    }
}
