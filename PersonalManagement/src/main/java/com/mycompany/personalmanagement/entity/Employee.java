/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.personalmanagement.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
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
@Table(name = "employee")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByEmployeeID", query = "SELECT e FROM Employee e WHERE e.employeeID = :employeeID"),
    @NamedQuery(name = "Employee.findBySurname", query = "SELECT e FROM Employee e WHERE e.surname = :surname"),
    @NamedQuery(name = "Employee.findByFirstname", query = "SELECT e FROM Employee e WHERE e.firstname = :firstname"),
    @NamedQuery(name = "Employee.findByPatronymic", query = "SELECT e FROM Employee e WHERE e.patronymic = :patronymic"),
    @NamedQuery(name = "Employee.findByDateOfBirth", query = "SELECT e FROM Employee e WHERE e.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Employee.findByTelephone", query = "SELECT e FROM Employee e WHERE e.telephone = :telephone"),
    @NamedQuery(name = "Employee.findByDirectNumber", query = "SELECT e FROM Employee e WHERE e.directNumber = :directNumber"),
    @NamedQuery(name = "Employee.findByOffice", query = "SELECT e FROM Employee e WHERE e.office = :office"),
    @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email"),
    @NamedQuery(name = "Employee.findByLogin", query = "SELECT e FROM Employee e WHERE e.login = :login"),
    @NamedQuery(name = "Employee.findByPassword", query = "SELECT e FROM Employee e WHERE e.password = :password")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EmployeeID")
    private Integer employeeID;
    @Column(name = "Surname")
    private String surname;
    @Column(name = "Firstname")
    private String firstname;
    @Column(name = "Patronymic")
    private String patronymic;
    @Column(name = "DateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "Telephone")
    private String telephone;
    @Column(name = "DirectNumber")
    private String directNumber;
    @Column(name = "Office")
    private String office;
    @Column(name = "Email")
    private String email;
    @Column(name = "Login")
    private String login;
    @Column(name = "Password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeEmployeeID")
    private Collection<Absence> absenceCollection;
    @JsonIgnore
    @JoinColumn(name = "Division_DivisionID", referencedColumnName = "DivisionID")
    @ManyToOne(optional = false)
    private Division divisionDivisionID;
    @JsonIgnore
    @JoinColumn(name = "Education_EducationID", referencedColumnName = "EducationID")
    @ManyToOne(optional = false)
    private Education educationEducationID;
    @JsonIgnore
    @JoinColumn(name = "Position_PositionID", referencedColumnName = "PositionID")
    @ManyToOne(optional = false)
    private Position positionPositionID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeEmployeeID")
    private Collection<EmployeeEvent> employeeEventCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeEmployeeID")
    private Collection<Vacation> vacationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeEmployeeID")
    private Collection<Comment> commentCollection;

    public Employee() {
    }

    public Employee(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Absence> getAbsenceCollection() {
        return absenceCollection;
    }

    public void setAbsenceCollection(Collection<Absence> absenceCollection) {
        this.absenceCollection = absenceCollection;
    }

    public Division getDivisionDivisionID() {
        return divisionDivisionID;
    }

    public void setDivisionDivisionID(Division divisionDivisionID) {
        this.divisionDivisionID = divisionDivisionID;
    }

    public Education getEducationEducationID() {
        return educationEducationID;
    }

    public void setEducationEducationID(Education educationEducationID) {
        this.educationEducationID = educationEducationID;
    }

    public Position getPositionPositionID() {
        return positionPositionID;
    }

    public void setPositionPositionID(Position positionPositionID) {
        this.positionPositionID = positionPositionID;
    }

    public Collection<EmployeeEvent> getEmployeeEventCollection() {
        return employeeEventCollection;
    }

    public void setEmployeeEventCollection(Collection<EmployeeEvent> employeeEventCollection) {
        this.employeeEventCollection = employeeEventCollection;
    }

    public Collection<Vacation> getVacationCollection() {
        return vacationCollection;
    }

    public void setVacationCollection(Collection<Vacation> vacationCollection) {
        this.vacationCollection = vacationCollection;
    }

    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }
    
    @JsonGetter("divisionId")
    public int getDivision() {
        return divisionDivisionID.getDivisionID();
    }
    
    @JsonGetter("educationId")
    public int getEducationId() {
        return educationEducationID.getEducationID();
    }
    
    @JsonGetter("positionId")
    public int getPositionId() {
        return positionPositionID.getPositionID();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeID != null ? employeeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeID == null && other.employeeID != null) || (this.employeeID != null && !this.employeeID.equals(other.employeeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.personalmanagement.entity.Employee[ employeeID=" + employeeID + " ]";
    }
    
}
