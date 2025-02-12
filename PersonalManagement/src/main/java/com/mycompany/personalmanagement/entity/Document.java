/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.personalmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author 1208-VM1
 */
@Entity
@Table(name = "document")
@NamedQueries({
    @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d"),
    @NamedQuery(name = "Document.findByDocumentID", query = "SELECT d FROM Document d WHERE d.documentID = :documentID"),
    @NamedQuery(name = "Document.findByName", query = "SELECT d FROM Document d WHERE d.name = :name"),
    @NamedQuery(name = "Document.findByDateOfCreated", query = "SELECT d FROM Document d WHERE d.dateOfCreated = :dateOfCreated"),
    @NamedQuery(name = "Document.findByDateOfUpdated", query = "SELECT d FROM Document d WHERE d.dateOfUpdated = :dateOfUpdated")})
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "documentID")
    private Integer documentID;
    @Column(name = "Name")
    private String name;
    @Column(name = "DateOfCreated")
    @Temporal(TemporalType.DATE)
    private Date dateOfCreated;
    @Column(name = "DateOfUpdated")
    @Temporal(TemporalType.DATE)
    private Date dateOfUpdated;
    @JsonIgnore
    @JoinColumn(name = "category_categoryID", referencedColumnName = "categoryID")
    @ManyToOne(optional = false)
    private Category categorycategoryID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentdocumentID")
    private Collection<Comment> commentCollection;

    public Document() {
    }

    public Document(Integer documentID) {
        this.documentID = documentID;
    }

    public Integer getDocumentID() {
        return documentID;
    }

    public void setDocumentID(Integer documentID) {
        this.documentID = documentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfCreated() {
        return dateOfCreated;
    }

    public void setDateOfCreated(Date dateOfCreated) {
        this.dateOfCreated = dateOfCreated;
    }

    public Date getDateOfUpdated() {
        return dateOfUpdated;
    }

    public void setDateOfUpdated(Date dateOfUpdated) {
        this.dateOfUpdated = dateOfUpdated;
    }

    public Category getCategorycategoryID() {
        return categorycategoryID;
    }

    public void setCategorycategoryID(Category categorycategoryID) {
        this.categorycategoryID = categorycategoryID;
    }

    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentID != null ? documentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.documentID == null && other.documentID != null) || (this.documentID != null && !this.documentID.equals(other.documentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.personalmanagement.entity.Document[ documentID=" + documentID + " ]";
    }
    
}
