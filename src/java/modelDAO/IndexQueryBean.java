package modelDAO;

import dataBaseConnection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.IndexView;

/**
 *
 * @author Touraj
 */
public class IndexQueryBean {

    private List<IndexView> queries;
    DBConnection dbc;

    public IndexQueryBean() {
        queries = new ArrayList<IndexView>();
        dbc = new DBConnection();
    }

    public List<IndexView> getQueries() {
        return queries;
    }

    public void setQueries(List<IndexView> queries) {
        this.queries = queries;
    }

    public void viewMaker() {
        try {
            dbc.getDBConnection();
            Statement s = dbc.getConn().createStatement();
            s.executeQuery("SELECT wsdl.id as wsdlId, users.Name, wsdl.PRICE, wsdl.URL, wsdl.SUBJECT, wsdl.DESCRIPTION, techniques.name as tech_name, category.name as ctg_name "
                    + " FROM wsdl, users, techniques, category"
                    + " WHERE (users.id = wsdl.fk_owner_id"
                    + " AND techniques.id = wsdl.fk_techniques_id"
                    + " AND category.id = wsdl.fk_category_id)");
            ResultSet rs = s.getResultSet();


            while (rs.next()) {
                int _wsdl_id = rs.getInt("wsdlId");
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
            s.close();
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
