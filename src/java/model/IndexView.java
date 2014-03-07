/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * This Class just create an object which is used for for index page
 * @author Touraj
 */
public class IndexView {
    
    private int wsdl_id;
    private String owner;
    private String price;
    private String wsdl;
    private String subject;
    private String describtion;
    private String technique;
    private String category;

    
    public IndexView(int _wsdl_id,String owner, String price, String wsdl, String subject, String describtion, String technique, String category) {
        
        this.wsdl_id=_wsdl_id;
        this.owner = owner;
        this.price = price;
        this.wsdl = wsdl;
        this.subject = subject;
        this.describtion = describtion;
        this.technique = technique;
        this.category = category;
    }

    
    public int getWsdl_id() {
        return wsdl_id;
    }

    public void setWsdl_id(int wsdl_id) {
        this.wsdl_id = wsdl_id;
    }
    
    
    
    //////Getter & Setter

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWsdl() {
        return wsdl;
    }

    public void setWsdl(String wsdl) {
        this.wsdl = wsdl;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public String getTechnique() {
        return technique;
    }

    public void setTechnique(String technique) {
        this.technique = technique;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
