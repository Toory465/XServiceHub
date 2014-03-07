package modelDAO;

import dataBaseConnection.DBConnection;
import model.IndexView;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Touraj
 */
public class UserWSDLBean {

    private List<IndexView> queries;
    DBConnection dbc;
    int userID;

    public UserWSDLBean() {
        queries = new ArrayList<IndexView>();
        dbc = new DBConnection();
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public List<IndexView> getQueries() {
        return queries;
    }

    public void setQueries(List<IndexView> queries) {
        this.queries = queries;
    }

    public void userWSDLdelete(int _wsdl_id) throws Exception {
        PreparedStatement prepStmt = null;
        dbc.getDBConnection();
        try {
            String k = "update `servicediscovery`.`wsdl`"
                    + " set wsdl.status = '0' "
                    + " where ( wsdl.id = ?)";
            prepStmt = dbc.getConn().prepareStatement(k);
            prepStmt.setInt(1, _wsdl_id);
            prepStmt.executeUpdate();
            System.out.println(" rows were delete");
        } finally {
            try {
                if (dbc.getConn() != null) {
                    dbc.getConn().close();
                }
                if (prepStmt != null) {
                    prepStmt.close();
                }
                System.out.println("Database connection terminated");
            } catch (Exception e) {
            }
        }

    }

    public boolean checkAdmin() {
        int role = 1;
        PreparedStatement prepStmt = null;
        try {
            dbc.getDBConnection();
            String q = "SELECT users.fk_role_id"
                    + " FROM users"
                    + " WHERE (users.id = ? )";
            prepStmt = dbc.getConn().prepareStatement(q);
            prepStmt.setInt(1, userID);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                role = rs.getInt("users.id");
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
        boolean result = false;
        if (role == 2) {
            result = true;
        }
        return result;
    }

    public void UserViewMaker() {
        PreparedStatement prepStmt = null;
        dbc.getDBConnection();
        try {
            String q = "SELECT wsdl.id , users.Name, wsdl.PRICE, wsdl.URL, wsdl.SUBJECT, wsdl.DESCRIPTION, techniques.name as tech_name, category.name as ctg_name "
                    + " FROM wsdl, users, techniques, category"
                    + " WHERE (users.id = wsdl.fk_owner_id"
                    + " AND techniques.id = wsdl.fk_techniques_id"
                    + " AND category.id = wsdl.fk_category_id"
                    + " AND users.id = ? "
                    + " AND wsdl.status = '1')";

            String q_admin = "SELECT wsdl.id , users.Name, wsdl.PRICE, wsdl.URL, wsdl.SUBJECT, wsdl.DESCRIPTION, techniques.name as tech_name, category.name as ctg_name "
                    + " FROM wsdl, users, techniques, category"
                    + " WHERE (users.id = wsdl.fk_owner_id"
                    + " AND techniques.id = wsdl.fk_techniques_id"
                    + " AND category.id = wsdl.fk_category_id"
                    + " AND wsdl.status = '1')";

//            prepStmt = dbc.getConn().prepareStatement(q);
//            prepStmt.setInt(1, userID);
////            if (checkAdmin()) {
                prepStmt = dbc.getConn().prepareStatement(q_admin);
//            }
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                int _wsdl_id = rs.getInt("id");
                String _owner = rs.getString("Name");
                String _price = rs.getString("PRICE");
                String _url = rs.getString("URL");
                String _subject = rs.getString("SUBJECT");
                String _describtion = rs.getString("DESCRIPTION");
                String _technique = rs.getString("tech_name");
                String _category = rs.getString("ctg_name");
                IndexView iv = new IndexView(_wsdl_id, _owner, _price, _url, _subject, _describtion, _technique, _category);
                queries.add(iv);
            }
            rs.close();
            System.out.println(" rows were retrieved");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
        } finally {
            if (dbc.getConn() != null) {
                try {
                    dbc.getConn().close();
                    System.out.println("Database connection terminated");
                } catch (Exception e) { /* ignore close errors */ }
            }
        }
    }
}
