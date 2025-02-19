/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi.entity;

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
@Table(name = "applicant")
@NamedQueries({
    @NamedQuery(name = "Applicant.findAll", query = "SELECT a FROM Applicant a"),
    @NamedQuery(name = "Applicant.findById", query = "SELECT a FROM Applicant a WHERE a.id = :id"),
    @NamedQuery(name = "Applicant.findBySurname", query = "SELECT a FROM Applicant a WHERE a.surname = :surname"),
    @NamedQuery(name = "Applicant.findByFirstname", query = "SELECT a FROM Applicant a WHERE a.firstname = :firstname"),
    @NamedQuery(name = "Applicant.findByMiddlename", query = "SELECT a FROM Applicant a WHERE a.middlename = :middlename"),
    @NamedQuery(name = "Applicant.findByDateOfBirth", query = "SELECT a FROM Applicant a WHERE a.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Applicant.findByDateOfReceipt", query = "SELECT a FROM Applicant a WHERE a.dateOfReceipt = :dateOfReceipt")})
public class Applicant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "surname")
    private String surname;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "middlename")
    private String middlename;
    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "dateOfReceipt")
    @Temporal(TemporalType.DATE)
    private Date dateOfReceipt;
    @JsonIgnore
    @JoinColumn(name = "education_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Education educationId;
    @JsonIgnore
    @JoinColumn(name = "Position_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Position positionid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "applicantid")
    private Collection<ApplicantEvent> applicantEventCollection;

    public Applicant() {
    }

    public Applicant(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfReceipt() {
        return dateOfReceipt;
    }

    public void setDateOfReceipt(Date dateOfReceipt) {
        this.dateOfReceipt = dateOfReceipt;
    }

    public Education getEducationId() {
        return educationId;
    }

    public void setEducationId(Education educationId) {
        this.educationId = educationId;
    }

    public Position getPositionid() {
        return positionid;
    }

    public void setPositionid(Position positionid) {
        this.positionid = positionid;
    }

    public Collection<ApplicantEvent> getApplicantEventCollection() {
        return applicantEventCollection;
    }

    public void setApplicantEventCollection(Collection<ApplicantEvent> applicantEventCollection) {
        this.applicantEventCollection = applicantEventCollection;
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
        if (!(object instanceof Applicant)) {
            return false;
        }
        Applicant other = (Applicant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi.entity.Applicant[ id=" + id + " ]";
    }
    
}
