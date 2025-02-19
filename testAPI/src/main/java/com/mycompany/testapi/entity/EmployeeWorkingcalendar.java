/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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

/**
 *
 * @author 1208-VM1
 */
@Entity
@Table(name = "employee_workingcalendar")
@NamedQueries({
    @NamedQuery(name = "EmployeeWorkingcalendar.findAll", query = "SELECT e FROM EmployeeWorkingcalendar e"),
    @NamedQuery(name = "EmployeeWorkingcalendar.findById", query = "SELECT e FROM EmployeeWorkingcalendar e WHERE e.id = :id")})
public class EmployeeWorkingcalendar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonIgnore
    @JoinColumn(name = "Employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeid;
    @JsonIgnore
    @JoinColumn(name = "WorkingCalendar_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Workingcalendar workingCalendarid;

    public EmployeeWorkingcalendar() {
    }

    public EmployeeWorkingcalendar(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Employee employeeid) {
        this.employeeid = employeeid;
    }

    public Workingcalendar getWorkingCalendarid() {
        return workingCalendarid;
    }

    public void setWorkingCalendarid(Workingcalendar workingCalendarid) {
        this.workingCalendarid = workingCalendarid;
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
        if (!(object instanceof EmployeeWorkingcalendar)) {
            return false;
        }
        EmployeeWorkingcalendar other = (EmployeeWorkingcalendar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi.entity.EmployeeWorkingcalendar[ id=" + id + " ]";
    }
    
}
