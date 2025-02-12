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
@Table(name = "vacation")
@NamedQueries({
    @NamedQuery(name = "Vacation.findAll", query = "SELECT v FROM Vacation v"),
    @NamedQuery(name = "Vacation.findByVacationID", query = "SELECT v FROM Vacation v WHERE v.vacationID = :vacationID"),
    @NamedQuery(name = "Vacation.findByDateOfStart", query = "SELECT v FROM Vacation v WHERE v.dateOfStart = :dateOfStart"),
    @NamedQuery(name = "Vacation.findByDateOfEnd", query = "SELECT v FROM Vacation v WHERE v.dateOfEnd = :dateOfEnd")})
public class Vacation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VacationID")
    private Integer vacationID;
    @Column(name = "DateOfStart")
    @Temporal(TemporalType.DATE)
    private Date dateOfStart;
    @Column(name = "DateOfEnd")
    @Temporal(TemporalType.DATE)
    private Date dateOfEnd;
    @JsonIgnore
    @JoinColumn(name = "Applicant_ApplicantID", referencedColumnName = "ApplicantID")
    @ManyToOne(optional = false)
    private Applicant applicantApplicantID;
    @JsonIgnore
    @JoinColumn(name = "Employee_EmployeeID", referencedColumnName = "EmployeeID")
    @ManyToOne(optional = false)
    private Employee employeeEmployeeID;

    public Vacation() {
    }

    public Vacation(Integer vacationID) {
        this.vacationID = vacationID;
    }

    public Integer getVacationID() {
        return vacationID;
    }

    public void setVacationID(Integer vacationID) {
        this.vacationID = vacationID;
    }

    public Date getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public Date getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(Date dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    public Applicant getApplicantApplicantID() {
        return applicantApplicantID;
    }

    public void setApplicantApplicantID(Applicant applicantApplicantID) {
        this.applicantApplicantID = applicantApplicantID;
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
        hash += (vacationID != null ? vacationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacation)) {
            return false;
        }
        Vacation other = (Vacation) object;
        if ((this.vacationID == null && other.vacationID != null) || (this.vacationID != null && !this.vacationID.equals(other.vacationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.personalmanagement.entity.Vacation[ vacationID=" + vacationID + " ]";
    }
    
}
