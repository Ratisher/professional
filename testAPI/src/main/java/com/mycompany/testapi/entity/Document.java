/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi.entity;

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
    @NamedQuery(name = "Document.findById", query = "SELECT d FROM Document d WHERE d.id = :id"),
    @NamedQuery(name = "Document.findByTitle", query = "SELECT d FROM Document d WHERE d.title = :title"),
    @NamedQuery(name = "Document.findByDateOfCreated", query = "SELECT d FROM Document d WHERE d.dateOfCreated = :dateOfCreated"),
    @NamedQuery(name = "Document.findByDateOfUpdated", query = "SELECT d FROM Document d WHERE d.dateOfUpdated = :dateOfUpdated"),
    @NamedQuery(name = "Document.findByCategory", query = "SELECT d FROM Document d WHERE d.category = :category"),
    @NamedQuery(name = "Document.findByHasComments", query = "SELECT d FROM Document d WHERE d.hasComments = :hasComments")})
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "dateOfCreated")
    @Temporal(TemporalType.DATE)
    private Date dateOfCreated;
    @Column(name = "dateOfUpdated")
    @Temporal(TemporalType.DATE)
    private Date dateOfUpdated;
    @Column(name = "category")
    private String category;
    @Column(name = "hasComments")
    private Short hasComments;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentid")
    private Collection<Comment> commentCollection;

    public Document() {
    }

    public Document(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Short getHasComments() {
        return hasComments;
    }

    public void setHasComments(Short hasComments) {
        this.hasComments = hasComments;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi.entity.Document[ id=" + id + " ]";
    }
    
}
