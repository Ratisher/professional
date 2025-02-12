/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.personalmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author 1208-VM1
 */
@Entity
@Table(name = "division")
@NamedQueries({
    @NamedQuery(name = "Division.findAll", query = "SELECT d FROM Division d"),
    @NamedQuery(name = "Division.findByDivisionID", query = "SELECT d FROM Division d WHERE d.divisionID = :divisionID"),
    @NamedQuery(name = "Division.findByName", query = "SELECT d FROM Division d WHERE d.name = :name"),
    @NamedQuery(name = "Division.findByDiscription", query = "SELECT d FROM Division d WHERE d.discription = :discription")})
public class Division implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DivisionID")
    private Integer divisionID;
    @Column(name = "Name")
    private String name;
    @Column(name = "Discription")
    private String discription;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "divisionDivisionID")
    private Collection<Employee> employeeCollection;

    public Division() {
    }

    public Division(Integer divisionID) {
        this.divisionID = divisionID;
    }

    public Integer getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(Integer divisionID) {
        this.divisionID = divisionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (divisionID != null ? divisionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Division)) {
            return false;
        }
        Division other = (Division) object;
        if ((this.divisionID == null && other.divisionID != null) || (this.divisionID != null && !this.divisionID.equals(other.divisionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.personalmanagement.entity.Division[ divisionID=" + divisionID + " ]";
    }
    
}
