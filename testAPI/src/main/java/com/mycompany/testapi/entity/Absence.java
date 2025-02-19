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
@Table(name = "absence")
@NamedQueries({
    @NamedQuery(name = "Absence.findAll", query = "SELECT a FROM Absence a"),
    @NamedQuery(name = "Absence.findById", query = "SELECT a FROM Absence a WHERE a.id = :id"),
    @NamedQuery(name = "Absence.findByDateOfStart", query = "SELECT a FROM Absence a WHERE a.dateOfStart = :dateOfStart"),
    @NamedQuery(name = "Absence.findByDateOfEnd", query = "SELECT a FROM Absence a WHERE a.dateOfEnd = :dateOfEnd")})
public class Absence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dateOfStart")
    @Temporal(TemporalType.DATE)
    private Date dateOfStart;
    @Column(name = "dateOfEnd")
    @Temporal(TemporalType.DATE)
    private Date dateOfEnd;
    @JsonIgnore
    @JoinColumn(name = "Employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeid;
    @JsonIgnore
    @JoinColumn(name = "ReplacementEmployee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee replacementEmployeeid;
    @JsonIgnore
    @JoinColumn(name = "reasonOfAbsence_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Reasonofabsence reasonOfAbsenceid;

    public Absence() {
    }

    public Absence(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Employee getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Employee employeeid) {
        this.employeeid = employeeid;
    }

    public Employee getReplacementEmployeeid() {
        return replacementEmployeeid;
    }

    public void setReplacementEmployeeid(Employee replacementEmployeeid) {
        this.replacementEmployeeid = replacementEmployeeid;
    }

    public Reasonofabsence getReasonOfAbsenceid() {
        return reasonOfAbsenceid;
    }

    public void setReasonOfAbsenceid(Reasonofabsence reasonOfAbsenceid) {
        this.reasonOfAbsenceid = reasonOfAbsenceid;
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
        if (!(object instanceof Absence)) {
            return false;
        }
        Absence other = (Absence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi.entity.Absence[ id=" + id + " ]";
    }

}
