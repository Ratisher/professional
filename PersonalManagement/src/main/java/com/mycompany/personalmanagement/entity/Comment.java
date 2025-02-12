/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.personalmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author 1208-VM1
 */
@Entity
@Table(name = "comment")
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c"),
    @NamedQuery(name = "Comment.findByCommentID", query = "SELECT c FROM Comment c WHERE c.commentID = :commentID"),
    @NamedQuery(name = "Comment.findByName", query = "SELECT c FROM Comment c WHERE c.name = :name"),
    @NamedQuery(name = "Comment.findByDateOfCreated", query = "SELECT c FROM Comment c WHERE c.dateOfCreated = :dateOfCreated"),
    @NamedQuery(name = "Comment.findByDateOfUpdated", query = "SELECT c FROM Comment c WHERE c.dateOfUpdated = :dateOfUpdated"),
    @NamedQuery(name = "Comment.findByHasComments", query = "SELECT c FROM Comment c WHERE c.hasComments = :hasComments")})
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "commentID")
    private Integer commentID;
    @Column(name = "Name")
    private String name;
    @Column(name = "DateOfCreated")
    @Temporal(TemporalType.DATE)
    private Date dateOfCreated;
    @Column(name = "DateOfUpdated")
    @Temporal(TemporalType.DATE)
    private Date dateOfUpdated;
    @Column(name = "HasComments")
    private Short hasComments;
    @JsonIgnore
    @JoinColumn(name = "document_documentID", referencedColumnName = "documentID")
    @ManyToOne(optional = false)
    private Document documentdocumentID;
    @JsonIgnore
    @JoinColumn(name = "employee_EmployeeID", referencedColumnName = "EmployeeID")
    @ManyToOne(optional = false)
    private Employee employeeEmployeeID;

    public Comment() {
    }

    public Comment(Integer commentID) {
        this.commentID = commentID;
    }

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
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

    public Short getHasComments() {
        return hasComments;
    }

    public void setHasComments(Short hasComments) {
        this.hasComments = hasComments;
    }

    public Document getDocumentdocumentID() {
        return documentdocumentID;
    }

    public void setDocumentdocumentID(Document documentdocumentID) {
        this.documentdocumentID = documentdocumentID;
    }

    public Employee getEmployeeEmployeeID() {
        return employeeEmployeeID;
    }

    public void setEmployeeEmployeeID(Employee employeeEmployeeID) {
        this.employeeEmployeeID = employeeEmployeeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commentID != null ? commentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.commentID == null && other.commentID != null) || (this.commentID != null && !this.commentID.equals(other.commentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.personalmanagement.entity.Comment[ commentID=" + commentID + " ]";
    }
    
}
