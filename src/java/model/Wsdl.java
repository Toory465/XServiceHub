/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Touraj
 */
@Entity
@Table(name = "wsdl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wsdl.findAll", query = "SELECT w FROM Wsdl w"),
    @NamedQuery(name = "Wsdl.findById", query = "SELECT w FROM Wsdl w WHERE w.id = :id"),
    @NamedQuery(name = "Wsdl.findByFkOwnerId", query = "SELECT w FROM Wsdl w WHERE w.fkOwnerId = :fkOwnerId"),
    @NamedQuery(name = "Wsdl.findByPrice", query = "SELECT w FROM Wsdl w WHERE w.price = :price"),
    @NamedQuery(name = "Wsdl.findByUrl", query = "SELECT w FROM Wsdl w WHERE w.url = :url"),
    @NamedQuery(name = "Wsdl.findBySubject", query = "SELECT w FROM Wsdl w WHERE w.subject = :subject"),
    @NamedQuery(name = "Wsdl.findByDescription", query = "SELECT w FROM Wsdl w WHERE w.description = :description"),
    @NamedQuery(name = "Wsdl.findByFkTechniquesId", query = "SELECT w FROM Wsdl w WHERE w.fkTechniquesId = :fkTechniquesId"),
    @NamedQuery(name = "Wsdl.findByStatus", query = "SELECT w FROM Wsdl w WHERE w.status = :status"),
    @NamedQuery(name = "Wsdl.findByFkCategoryId", query = "SELECT w FROM Wsdl w WHERE w.fkCategoryId = :fkCategoryId")})
public class Wsdl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRICE")
    private String price;
    @Basic(optional = false)
    @Column(name = "URL")
    private String url;
    @Basic(optional = false)
    @Column(name = "SUBJECT")
    private String subject;
    @Basic(optional = false)
    @Column(name = "DESCRIPTION")
    private String description;

    public Wsdl() {
    }

    public Wsdl( String price, String url, String subject, String description) {

        this.price = price;
        this.url = url;
        this.subject = subject;
        this.description = description;

    }
}
