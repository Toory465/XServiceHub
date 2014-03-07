/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import dataBaseConnection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Wsdl;

/**
 *
 * @author Touraj
 */
public class WsdlDAO {

    private List<Wsdl> WsdlList;
    DBConnection dbc;

    public WsdlDAO() {
        WsdlList = new ArrayList<Wsdl>();
        dbc = new DBConnection();
    }

    public List<Wsdl> getWsdlList() {
        return WsdlList;
    }

    public void setWsdlList(List<Wsdl> WsdlList) {
        this.WsdlList = WsdlList;
    }

    public void wsdlListMaker() {
        try {
            dbc.getDBConnection();
            Statement s = dbc.getConn().createStatement();
            s.executeQuery("SELECT wsdl.PRICE, wsdl.URL, wsdl.SUBJECT, wsdl.DESCRIPTION FROM wsdl");
            ResultSet rs = s.getResultSet();
            while (rs.next()) {
                String _price = rs.getString("PRICE");
                String _url = rs.getString("URL");
                String _subject = rs.getString("SUBJECT");
                String _describtion = rs.getString("DESCRIPTION");
                Wsdl iv = new Wsdl(_price, _url, _subject, _describtion);
                WsdlList.add(iv);
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
