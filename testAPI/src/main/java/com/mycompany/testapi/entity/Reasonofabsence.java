/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi.entity;

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
@Table(name = "reasonofabsence")
@NamedQueries({
    @NamedQuery(name = "Reasonofabsence.findAll", query = "SELECT r FROM Reasonofabsence r"),
    @NamedQuery(name = "Reasonofabsence.findById", query = "SELECT r FROM Reasonofabsence r WHERE r.id = :id"),
    @NamedQuery(name = "Reasonofabsence.findByName", query = "SELECT r FROM Reasonofabsence r WHERE r.name = :name"),
    @NamedQuery(name = "Reasonofabsence.findByDiscription", query = "SELECT r FROM Reasonofabsence r WHERE r.discription = :discription")})
public class Reasonofabsence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "discription")
    private String discription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reasonOfAbsenceid")
    private Collection<Absence> absenceCollection;

    public Reasonofabsence() {
    }

    public Reasonofabsence(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reasonofabsence)) {
            return false;
        }
        Reasonofabsence other = (Reasonofabsence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi.entity.Reasonofabsence[ id=" + id + " ]";
    }
    
}
