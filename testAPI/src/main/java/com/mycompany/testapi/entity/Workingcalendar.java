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
@Table(name = "workingcalendar")
@NamedQueries({
    @NamedQuery(name = "Workingcalendar.findAll", query = "SELECT w FROM Workingcalendar w"),
    @NamedQuery(name = "Workingcalendar.findById", query = "SELECT w FROM Workingcalendar w WHERE w.id = :id"),
    @NamedQuery(name = "Workingcalendar.findByExceptionDate", query = "SELECT w FROM Workingcalendar w WHERE w.exceptionDate = :exceptionDate"),
    @NamedQuery(name = "Workingcalendar.findByIsWorkingDay", query = "SELECT w FROM Workingcalendar w WHERE w.isWorkingDay = :isWorkingDay")})
public class Workingcalendar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "exceptionDate")
    @Temporal(TemporalType.DATE)
    private Date exceptionDate;
    @Column(name = "isWorkingDay")
    private Short isWorkingDay;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workingCalendarid")
    private Collection<EmployeeWorkingcalendar> employeeWorkingcalendarCollection;

    public Workingcalendar() {
    }

    public Workingcalendar(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getExceptionDate() {
        return exceptionDate;
    }

    public void setExceptionDate(Date exceptionDate) {
        this.exceptionDate = exceptionDate;
    }

    public Short getIsWorkingDay() {
        return isWorkingDay;
    }

    public void setIsWorkingDay(Short isWorkingDay) {
        this.isWorkingDay = isWorkingDay;
    }

    public Collection<EmployeeWorkingcalendar> getEmployeeWorkingcalendarCollection() {
        return employeeWorkingcalendarCollection;
    }

    public void setEmployeeWorkingcalendarCollection(Collection<EmployeeWorkingcalendar> employeeWorkingcalendarCollection) {
        this.employeeWorkingcalendarCollection = employeeWorkingcalendarCollection;
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
        if (!(object instanceof Workingcalendar)) {
            return false;
        }
        Workingcalendar other = (Workingcalendar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi.entity.Workingcalendar[ id=" + id + " ]";
    }
    
}
