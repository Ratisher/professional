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
@Table(name = "applicant")
@NamedQueries({
    @NamedQuery(name = "Applicant.findAll", query = "SELECT a FROM Applicant a"),
    @NamedQuery(name = "Applicant.findByApplicantID", query = "SELECT a FROM Applicant a WHERE a.applicantID = :applicantID"),
    @NamedQuery(name = "Applicant.findBySurname", query = "SELECT a FROM Applicant a WHERE a.surname = :surname"),
    @NamedQuery(name = "Applicant.findByFirstname", query = "SELECT a FROM Applicant a WHERE a.firstname = :firstname"),
    @NamedQuery(name = "Applicant.findByPatronymic", query = "SELECT a FROM Applicant a WHERE a.patronymic = :patronymic"),
    @NamedQuery(name = "Applicant.findByTelephone", query = "SELECT a FROM Applicant a WHERE a.telephone = :telephone"),
    @NamedQuery(name = "Applicant.findByDateOfBirth", query = "SELECT a FROM Applicant a WHERE a.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Applicant.findByDateOfReceipt", query = "SELECT a FROM Applicant a WHERE a.dateOfReceipt = :dateOfReceipt")})
public class Applicant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ApplicantID")
    private Integer applicantID;
    @Column(name = "Surname")
    private String surname;
    @Column(name = "Firstname")
    private String firstname;
    @Column(name = "Patronymic")
    private String patronymic;
    @Column(name = "Telephone")
    private String telephone;
    @Column(name = "DateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "DateOfReceipt")
    @Temporal(TemporalType.DATE)
    private Date dateOfReceipt;
    @JsonIgnore
    @JoinColumn(name = "Education_EducationID", referencedColumnName = "EducationID")
    @ManyToOne(optional = false)
    private Education educationEducationID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "applicantApplicantID")
    private Collection<Vacation> vacationCollection;

    public Applicant() {
    }

    public Applicant(Integer applicantID) {
        this.applicantID = applicantID;
    }

    public Integer getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(Integer applicantID) {
        this.applicantID = applicantID;
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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public Education getEducationEducationID() {
        return educationEducationID;
    }

    public void setEducationEducationID(Education educationEducationID) {
        this.educationEducationID = educationEducationID;
    }

    public Collection<Vacation> getVacationCollection() {
        return vacationCollection;
    }

    public void setVacationCollection(Collection<Vacation> vacationCollection) {
        this.vacationCollection = vacationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (applicantID != null ? applicantID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Applicant)) {
            return false;
        }
        Applicant other = (Applicant) object;
        if ((this.applicantID == null && other.applicantID != null) || (this.applicantID != null && !this.applicantID.equals(other.applicantID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.personalmanagement.entity.Applicant[ applicantID=" + applicantID + " ]";
    }
    
}
