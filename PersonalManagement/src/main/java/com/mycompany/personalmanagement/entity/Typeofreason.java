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
@Table(name = "typeofreason")
@NamedQueries({
    @NamedQuery(name = "Typeofreason.findAll", query = "SELECT t FROM Typeofreason t"),
    @NamedQuery(name = "Typeofreason.findByTypeOfReasonID", query = "SELECT t FROM Typeofreason t WHERE t.typeOfReasonID = :typeOfReasonID"),
    @NamedQuery(name = "Typeofreason.findByName", query = "SELECT t FROM Typeofreason t WHERE t.name = :name"),
    @NamedQuery(name = "Typeofreason.findByDiscription", query = "SELECT t FROM Typeofreason t WHERE t.discription = :discription")})
public class Typeofreason implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TypeOfReasonID")
    private Integer typeOfReasonID;
    @Column(name = "Name")
    private String name;
    @Column(name = "Discription")
    private String discription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeOfReasonTypeOfReasonID")
    private Collection<Absence> absenceCollection;

    public Typeofreason() {
    }

    public Typeofreason(Integer typeOfReasonID) {
        this.typeOfReasonID = typeOfReasonID;
    }

    public Integer getTypeOfReasonID() {
        return typeOfReasonID;
    }

    public void setTypeOfReasonID(Integer typeOfReasonID) {
        this.typeOfReasonID = typeOfReasonID;
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

    public Collection<Absence> getAbsenceCollection() {
        return absenceCollection;
    }

    public void setAbsenceCollection(Collection<Absence> absenceCollection) {
        this.absenceCollection = absenceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeOfReasonID != null ? typeOfReasonID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typeofreason)) {
            return false;
        }
        Typeofreason other = (Typeofreason) object;
        if ((this.typeOfReasonID == null && other.typeOfReasonID != null) || (this.typeOfReasonID != null && !this.typeOfReasonID.equals(other.typeOfReasonID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.personalmanagement.entity.Typeofreason[ typeOfReasonID=" + typeOfReasonID + " ]";
    }
    
}
