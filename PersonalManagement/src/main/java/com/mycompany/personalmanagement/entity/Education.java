/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.personalmanagement.entity;

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
@Table(name = "education")
@NamedQueries({
    @NamedQuery(name = "Education.findAll", query = "SELECT e FROM Education e"),
    @NamedQuery(name = "Education.findByEducationID", query = "SELECT e FROM Education e WHERE e.educationID = :educationID"),
    @NamedQuery(name = "Education.findByName", query = "SELECT e FROM Education e WHERE e.name = :name")})
public class Education implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EducationID")
    private Integer educationID;
    @Column(name = "Name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educationEducationID")
    private Collection<Employee> employeeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educationEducationID")
    private Collection<Applicant> applicantCollection;

    public Education() {
    }

    public Education(Integer educationID) {
        this.educationID = educationID;
    }

    public Integer getEducationID() {
        return educationID;
    }

    public void setEducationID(Integer educationID) {
        this.educationID = educationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    public Collection<Applicant> getApplicantCollection() {
        return applicantCollection;
    }

    public void setApplicantCollection(Collection<Applicant> applicantCollection) {
        this.applicantCollection = applicantCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (educationID != null ? educationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Education)) {
            return false;
        }
        Education other = (Education) object;
        if ((this.educationID == null && other.educationID != null) || (this.educationID != null && !this.educationID.equals(other.educationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.personalmanagement.entity.Education[ educationID=" + educationID + " ]";
    }
    
}
