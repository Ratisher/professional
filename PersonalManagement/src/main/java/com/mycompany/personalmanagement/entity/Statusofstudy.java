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
@Table(name = "statusofstudy")
@NamedQueries({
    @NamedQuery(name = "Statusofstudy.findAll", query = "SELECT s FROM Statusofstudy s"),
    @NamedQuery(name = "Statusofstudy.findByStatusOfStudyID", query = "SELECT s FROM Statusofstudy s WHERE s.statusOfStudyID = :statusOfStudyID"),
    @NamedQuery(name = "Statusofstudy.findByName", query = "SELECT s FROM Statusofstudy s WHERE s.name = :name"),
    @NamedQuery(name = "Statusofstudy.findByDiscription", query = "SELECT s FROM Statusofstudy s WHERE s.discription = :discription")})
public class Statusofstudy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StatusOfStudyID")
    private Integer statusOfStudyID;
    @Column(name = "Name")
    private String name;
    @Column(name = "Discription")
    private String discription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusOfStudyStatusOfStudyID")
    private Collection<Trainingmaterial> trainingmaterialCollection;

    public Statusofstudy() {
    }

    public Statusofstudy(Integer statusOfStudyID) {
        this.statusOfStudyID = statusOfStudyID;
    }

    public Integer getStatusOfStudyID() {
        return statusOfStudyID;
    }

    public void setStatusOfStudyID(Integer statusOfStudyID) {
        this.statusOfStudyID = statusOfStudyID;
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
        hash += (statusOfStudyID != null ? statusOfStudyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statusofstudy)) {
            return false;
        }
        Statusofstudy other = (Statusofstudy) object;
        if ((this.statusOfStudyID == null && other.statusOfStudyID != null) || (this.statusOfStudyID != null && !this.statusOfStudyID.equals(other.statusOfStudyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.personalmanagement.entity.Statusofstudy[ statusOfStudyID=" + statusOfStudyID + " ]";
    }
    
}
