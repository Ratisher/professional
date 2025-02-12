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
@Table(name = "typeofstudy")
@NamedQueries({
    @NamedQuery(name = "Typeofstudy.findAll", query = "SELECT t FROM Typeofstudy t"),
    @NamedQuery(name = "Typeofstudy.findByTypeOfStudyID", query = "SELECT t FROM Typeofstudy t WHERE t.typeOfStudyID = :typeOfStudyID"),
    @NamedQuery(name = "Typeofstudy.findByName", query = "SELECT t FROM Typeofstudy t WHERE t.name = :name"),
    @NamedQuery(name = "Typeofstudy.findByDiscription", query = "SELECT t FROM Typeofstudy t WHERE t.discription = :discription")})
public class Typeofstudy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TypeOfStudyID")
    private Integer typeOfStudyID;
    @Column(name = "Name")
    private String name;
    @Column(name = "Discription")
    private String discription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeOfStudyTypeOfStudyID")
    private Collection<Trainingmaterial> trainingmaterialCollection;

    public Typeofstudy() {
    }

    public Typeofstudy(Integer typeOfStudyID) {
        this.typeOfStudyID = typeOfStudyID;
    }

    public Integer getTypeOfStudyID() {
        return typeOfStudyID;
    }

    public void setTypeOfStudyID(Integer typeOfStudyID) {
        this.typeOfStudyID = typeOfStudyID;
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
        hash += (typeOfStudyID != null ? typeOfStudyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typeofstudy)) {
            return false;
        }
        Typeofstudy other = (Typeofstudy) object;
        if ((this.typeOfStudyID == null && other.typeOfStudyID != null) || (this.typeOfStudyID != null && !this.typeOfStudyID.equals(other.typeOfStudyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.personalmanagement.entity.Typeofstudy[ typeOfStudyID=" + typeOfStudyID + " ]";
    }
    
}
