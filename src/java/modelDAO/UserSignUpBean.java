package modelDAO;

import dataBaseConnection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Touraj
 */
public class UserSignUpBean {

    public boolean checkDublicate() {
        return true;
    }

    public boolean CheckEmailValidity(String emailAddress) {
        boolean result = true;
        DBConnection dbc = new DBConnection();
        PreparedStatement prepStmt = null;
        try {
            dbc.getDBConnection();
            String q = "SELECT users.fk_role_id"
                    + " FROM users"
                    + " WHERE (users.id = ? )";
            prepStmt = dbc.getConn().prepareStatement(q);
            prepStmt.setString(1, emailAddress);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                result = false;
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

    public void userSignUn(String userName_, String family, String companyName, String emailAddress, String url_, String password_) {
        DBConnection dbc = new DBConnection();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        PreparedStatement prepStmt = null;
        dbc.getDBConnection();
        try {
            String k = "INSERT INTO `servicediscovery`.`users` (`NAME`, `FAMILY`, `COMPANY_NAME`, `EMAIL`, `WEBSITE`, `REGISTERED_DATE`, `PASSWORD`) "
                    + " VALUES (? , ? , ? , ? , ? , ? , ?)";

            prepStmt = dbc.getConn().prepareStatement(k);
            prepStmt.setString(1, userName_);
            prepStmt.setString(2, family);
            prepStmt.setString(3, companyName);
            prepStmt.setString(4, emailAddress);
            prepStmt.setString(5, url_);
            prepStmt.setString(6, dateFormat.format(cal.getTime()));
            prepStmt.setString(7, password_);


            prepStmt.executeUpdate();
            System.out.println(" rows were retrieved");
        } catch (Exception e) {
            System.err.println(e.getMessage());
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
    }
}
