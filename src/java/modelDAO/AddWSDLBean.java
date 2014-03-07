/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import dataBaseConnection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Category;

/**
 *
 * @author Touraj
 */
public class AddWSDLBean {

    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public AddWSDLBean() {
        categories = new ArrayList<Category>();
    }

    public void categoryListMaker() {
        DBConnection db = new DBConnection();

        try {
            db.getDBConnection();
            Statement s = db.getConn().createStatement();
            s.executeQuery("select id,name from category");
            ResultSet rs = s.getResultSet();
            while (rs.next()) {
                int _id = rs.getInt("id");
                String _name = rs.getString("name");
                Category ct = new Category(_id, _name);
                categories.add(ct);
            }
            rs.close();
            s.close();
            System.out.println(" rows were retrieved");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
        } finally {
            if (db.getConn() != null) {
                try {
                    db.getConn().close();
                    System.out.println("Database connection terminated");
                } catch (Exception e) {
                }
            }
        }
    }

    public void AddWSDL(int userId_, int categoryId_, String price, String url_, int tech_id_, String subject, String description) {
        DBConnection dbc = new DBConnection();
        PreparedStatement prepStmt = null;
        try {
            dbc.getDBConnection();
            String k = "INSERT INTO `servicediscovery`.`wsdl` (`fk_owner_id`, `fk_category_id`, `price`, `URL`, `fk_techniques_id`, `subject`, `description`,`status`) "
                    + " VALUES (? , ? , ? , ? , ? , ? , ? ,'1')";
            prepStmt = dbc.getConn().prepareStatement(k);
            prepStmt.setInt(1, userId_);
            prepStmt.setInt(2, categoryId_);
            prepStmt.setString(3, price);
            prepStmt.setString(4, url_);
            prepStmt.setInt(5, tech_id_);
            prepStmt.setString(6, subject);
            prepStmt.setString(7, description);
            prepStmt.executeUpdate();
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
            } catch (Exception e) {
            }
        }
    }
}
