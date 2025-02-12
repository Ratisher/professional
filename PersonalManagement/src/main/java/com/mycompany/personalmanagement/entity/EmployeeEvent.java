/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.personalmanagement.entity;

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
@Table(name = "employee_event")
@NamedQueries({
    @NamedQuery(name = "EmployeeEvent.findAll", query = "SELECT e FROM EmployeeEvent e"),
    @NamedQuery(name = "EmployeeEvent.findByIdEmployeeEventID", query = "SELECT e FROM EmployeeEvent e WHERE e.idEmployeeEventID = :idEmployeeEventID")})
public class EmployeeEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEmployee_EventID")
    private Integer idEmployeeEventID;
    @JsonIgnore
    @JoinColumn(name = "Employee_EmployeeID", referencedColumnName = "EmployeeID")
    @ManyToOne(optional = false)
    private Employee employeeEmployeeID;
    @JsonIgnore
    @JoinColumn(name = "Event_EventID", referencedColumnName = "EventID")
    @ManyToOne(optional = false)
    private Event eventEventID;
    @JsonIgnore
    @JoinColumn(name = "Role_RoleID", referencedColumnName = "RoleID")
    @ManyToOne(optional = false)
    private Role roleRoleID;

    public EmployeeEvent() {
    }

    public EmployeeEvent(Integer idEmployeeEventID) {
        this.idEmployeeEventID = idEmployeeEventID;
    }

    public Integer getIdEmployeeEventID() {
        return idEmployeeEventID;
    }

    public void setIdEmployeeEventID(Integer idEmployeeEventID) {
        this.idEmployeeEventID = idEmployeeEventID;
    }

    public Employee getEmployeeEmployeeID() {
        return employeeEmployeeID;
    }

    public void setEmployeeEmployeeID(Employee employeeEmployeeID) {
        this.employeeEmployeeID = employeeEmployeeID;
    }

    public Event getEventEventID() {
        return eventEventID;
    }

    public void setEventEventID(Event eventEventID) {
        this.eventEventID = eventEventID;
    }

    public Role getRoleRoleID() {
        return roleRoleID;
    }

    public void setRoleRoleID(Role roleRoleID) {
        this.roleRoleID = roleRoleID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmployeeEventID != null ? idEmployeeEventID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeEvent)) {
            return false;
        }
        EmployeeEvent other = (EmployeeEvent) object;
        if ((this.idEmployeeEventID == null && other.idEmployeeEventID != null) || (this.idEmployeeEventID != null && !this.idEmployeeEventID.equals(other.idEmployeeEventID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.personalmanagement.entity.EmployeeEvent[ idEmployeeEventID=" + idEmployeeEventID + " ]";
    }
    
}
