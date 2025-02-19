/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
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
@Table(name = "employee")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id"),
    @NamedQuery(name = "Employee.findBySurname", query = "SELECT e FROM Employee e WHERE e.surname = :surname"),
    @NamedQuery(name = "Employee.findByFirstname", query = "SELECT e FROM Employee e WHERE e.firstname = :firstname"),
    @NamedQuery(name = "Employee.findByMiddlename", query = "SELECT e FROM Employee e WHERE e.middlename = :middlename"),
    @NamedQuery(name = "Employee.findByTelephone", query = "SELECT e FROM Employee e WHERE e.telephone = :telephone"),
    @NamedQuery(name = "Employee.findByDirectNumber", query = "SELECT e FROM Employee e WHERE e.directNumber = :directNumber"),
    @NamedQuery(name = "Employee.findByRoom", query = "SELECT e FROM Employee e WHERE e.room = :room"),
    @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email"),
    @NamedQuery(name = "Employee.findByDateOfBirth", query = "SELECT e FROM Employee e WHERE e.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Employee.findByName", query = "SELECT e FROM Employee e WHERE e.name = :name"),
    @NamedQuery(name = "Employee.findByPassword", query = "SELECT e FROM Employee e WHERE e.password = :password"),
    @NamedQuery(name = "Employee.findByCompanyTelephone", query = "SELECT e FROM Employee e WHERE e.companyTelephone = :companyTelephone")})
public class Employee implements Serializable {

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
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "directNumber")
    private String directNumber;
    @Column(name = "room")
    private Integer room;
    @Column(name = "email")
    private String email;
    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "companyTelephone")
    private String companyTelephone;
    @JsonIgnore
    @JoinColumn(name = "Division_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Division divisionid;
    @JsonIgnore
    @JoinColumn(name = "Position_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Position positionid;

    public Employee() {
    }

    @JsonGetter("divisionId")
    public int getDivisionId() {
        return divisionid.getId();
    }
    
    @JsonGetter("positionId")
    public int getPositionId() {
        return positionid.getId();
    }
    
    public Employee(Integer id) {
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDirectNumber() {
        return directNumber;
    }

    public void setDirectNumber(String directNumber) {
        this.directNumber = directNumber;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyTelephone() {
        return companyTelephone;
    }

    public void setCompanyTelephone(String companyTelephone) {
        this.companyTelephone = companyTelephone;
    }

    public Division getDivisionid() {
        return divisionid;
    }

    public void setDivisionid(Division divisionid) {
        this.divisionid = divisionid;
    }

    public Position getPositionid() {
        return positionid;
    }

    public void setPositionid(Position positionid) {
        this.positionid = positionid;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi.entity.Employee[ id=" + id + " ]";
    }
    
}
