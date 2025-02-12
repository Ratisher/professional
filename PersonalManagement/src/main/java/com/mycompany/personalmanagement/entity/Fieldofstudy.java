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
@Table(name = "fieldofstudy")
@NamedQueries({
    @NamedQuery(name = "Fieldofstudy.findAll", query = "SELECT f FROM Fieldofstudy f"),
    @NamedQuery(name = "Fieldofstudy.findByFieldOfStudyID", query = "SELECT f FROM Fieldofstudy f WHERE f.fieldOfStudyID = :fieldOfStudyID"),
    @NamedQuery(name = "Fieldofstudy.findByName", query = "SELECT f FROM Fieldofstudy f WHERE f.name = :name"),
    @NamedQuery(name = "Fieldofstudy.findByDiscription", query = "SELECT f FROM Fieldofstudy f WHERE f.discription = :discription")})
public class Fieldofstudy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FieldOfStudyID")
    private Integer fieldOfStudyID;
    @Column(name = "Name")
    private String name;
    @Column(name = "Discription")
    private String discription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fieldOfStudyFieldOfStudyID")
    private Collection<Trainingmaterial> trainingmaterialCollection;

    public Fieldofstudy() {
    }

    public Fieldofstudy(Integer fieldOfStudyID) {
        this.fieldOfStudyID = fieldOfStudyID;
    }

    public Integer getFieldOfStudyID() {
        return fieldOfStudyID;
    }

    public void setFieldOfStudyID(Integer fieldOfStudyID) {
        this.fieldOfStudyID = fieldOfStudyID;
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

    public Collection<Trainingmaterial> getTrainingmaterialCollection() {
        return trainingmaterialCollection;
    }

    public void setTrainingmaterialCollection(Collection<Trainingmaterial> trainingmaterialCollection) {
        this.trainingmaterialCollection = trainingmaterialCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fieldOfStudyID != null ? fieldOfStudyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fieldofstudy)) {
            return false;
        }
        Fieldofstudy other = (Fieldofstudy) object;
        if ((this.fieldOfStudyID == null && other.fieldOfStudyID != null) || (this.fieldOfStudyID != null && !this.fieldOfStudyID.equals(other.fieldOfStudyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.personalmanagement.entity.Fieldofstudy[ fieldOfStudyID=" + fieldOfStudyID + " ]";
    }
    
}
