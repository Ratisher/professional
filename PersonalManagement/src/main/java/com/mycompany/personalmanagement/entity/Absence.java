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
@Table(name = "absence")
@NamedQueries({
    @NamedQuery(name = "Absence.findAll", query = "SELECT a FROM Absence a"),
    @NamedQuery(name = "Absence.findByAbsenceID", query = "SELECT a FROM Absence a WHERE a.absenceID = :absenceID"),
    @NamedQuery(name = "Absence.findByDate", query = "SELECT a FROM Absence a WHERE a.date = :date"),
    @NamedQuery(name = "Absence.findByReason", query = "SELECT a FROM Absence a WHERE a.reason = :reason")})
public class Absence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AbsenceID")
    private Integer absenceID;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "Reason")
    private String reason;
    @JsonIgnore
    @JoinColumn(name = "Employee_EmployeeID", referencedColumnName = "EmployeeID")
    @ManyToOne(optional = false)
    private Employee employeeEmployeeID;
    @JsonIgnore
    @JoinColumn(name = "TypeOfReason_TypeOfReasonID", referencedColumnName = "TypeOfReasonID")
    @ManyToOne(optional = false)
    private Typeofreason typeOfReasonTypeOfReasonID;

    public Absence() {
    }

    public Absence(Integer absenceID) {
        this.absenceID = absenceID;
    }

    public Integer getAbsenceID() {
        return absenceID;
    }

    public void setAbsenceID(Integer absenceID) {
        this.absenceID = absenceID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Employee getEmployeeEmployeeID() {
        return employeeEmployeeID;
    }

    public void setEmployeeEmployeeID(Employee employeeEmployeeID) {
        this.employeeEmployeeID = employeeEmployeeID;
    }

    public Typeofreason getTypeOfReasonTypeOfReasonID() {
        return typeOfReasonTypeOfReasonID;
    }

    public void setTypeOfReasonTypeOfReasonID(Typeofreason typeOfReasonTypeOfReasonID) {
        this.typeOfReasonTypeOfReasonID = typeOfReasonTypeOfReasonID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (absenceID != null ? absenceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Absence)) {
            return false;
        }
        Absence other = (Absence) object;
        if ((this.absenceID == null && other.absenceID != null) || (this.absenceID != null && !this.absenceID.equals(other.absenceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.personalmanagement.entity.Absence[ absenceID=" + absenceID + " ]";
    }
    
}
