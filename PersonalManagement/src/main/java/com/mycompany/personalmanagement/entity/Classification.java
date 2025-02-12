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
@Table(name = "classification")
@NamedQueries({
    @NamedQuery(name = "Classification.findAll", query = "SELECT c FROM Classification c"),
    @NamedQuery(name = "Classification.findByClassificationID", query = "SELECT c FROM Classification c WHERE c.classificationID = :classificationID"),
    @NamedQuery(name = "Classification.findByName", query = "SELECT c FROM Classification c WHERE c.name = :name"),
    @NamedQuery(name = "Classification.findByDiscription", query = "SELECT c FROM Classification c WHERE c.discription = :discription")})
public class Classification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ClassificationID")
    private Integer classificationID;
    @Column(name = "Name")
    private String name;
    @Column(name = "Discription")
    private String discription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classificationClassificationID")
    private Collection<Training> trainingCollection;

    public Classification() {
    }

    public Classification(Integer classificationID) {
        this.classificationID = classificationID;
    }

    public Integer getClassificationID() {
        return classificationID;
    }

    public void setClassificationID(Integer classificationID) {
        this.classificationID = classificationID;
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

    public Collection<Training> getTrainingCollection() {
        return trainingCollection;
    }

    public void setTrainingCollection(Collection<Training> trainingCollection) {
        this.trainingCollection = trainingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classificationID != null ? classificationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classification)) {
            return false;
        }
        Classification other = (Classification) object;
        if ((this.classificationID == null && other.classificationID != null) || (this.classificationID != null && !this.classificationID.equals(other.classificationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.personalmanagement.entity.Classification[ classificationID=" + classificationID + " ]";
    }
    
}
