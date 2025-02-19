/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi.entity;

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
    @NamedQuery(name = "Comment.findById", query = "SELECT c FROM Comment c WHERE c.id = :id"),
    @NamedQuery(name = "Comment.findByText", query = "SELECT c FROM Comment c WHERE c.text = :text"),
    @NamedQuery(name = "Comment.findByDateOfCreated", query = "SELECT c FROM Comment c WHERE c.dateOfCreated = :dateOfCreated"),
    @NamedQuery(name = "Comment.findByDateOfUpdated", query = "SELECT c FROM Comment c WHERE c.dateOfUpdated = :dateOfUpdated")})
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "text")
    private String text;
    @Column(name = "dateOfCreated")
    @Temporal(TemporalType.DATE)
    private Date dateOfCreated;
    @Column(name = "dateOfUpdated")
    @Temporal(TemporalType.DATE)
    private Date dateOfUpdated;
    @JsonIgnore
    @JoinColumn(name = "Document_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Document documentid;
    @JsonIgnore
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;

    public Comment() {
    }

    public Comment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public Document getDocumentid() {
        return documentid;
    }

    public void setDocumentid(Document documentid) {
        this.documentid = documentid;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
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
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi.entity.Comment[ id=" + id + " ]";
    }
    
}
