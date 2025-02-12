/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.personalmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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

/**
 *
 * @author 1208-VM1
 */
@Entity
@Table(name = "training")
@NamedQueries({
    @NamedQuery(name = "Training.findAll", query = "SELECT t FROM Training t"),
    @NamedQuery(name = "Training.findByTrainingID", query = "SELECT t FROM Training t WHERE t.trainingID = :trainingID")})
public class Training implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TrainingID")
    private Integer trainingID;
    @JsonIgnore
    @JoinColumn(name = "Classification_ClassificationID", referencedColumnName = "ClassificationID")
    @ManyToOne(optional = false)
    private Classification classificationClassificationID;
    @JsonIgnore
    @JoinColumn(name = "EventStatus_EventStatusID", referencedColumnName = "EventStatusID")
    @ManyToOne(optional = false)
    private Eventstatus eventStatusEventStatusID;
    @JsonIgnore
    @JoinColumn(name = "TrainingMaterial_TrainingMaterialID", referencedColumnName = "TrainingMaterialID")
    @ManyToOne(optional = false)
    private Trainingmaterial trainingMaterialTrainingMaterialID;

    public Training() {
    }

    public Training(Integer trainingID) {
        this.trainingID = trainingID;
    }

    public Integer getTrainingID() {
        return trainingID;
    }

    public void setTrainingID(Integer trainingID) {
        this.trainingID = trainingID;
    }

    public Classification getClassificationClassificationID() {
        return classificationClassificationID;
    }

    public void setClassificationClassificationID(Classification classificationClassificationID) {
        this.classificationClassificationID = classificationClassificationID;
    }

    public Eventstatus getEventStatusEventStatusID() {
        return eventStatusEventStatusID;
    }

    public void setEventStatusEventStatusID(Eventstatus eventStatusEventStatusID) {
        this.eventStatusEventStatusID = eventStatusEventStatusID;
    }

    public Trainingmaterial getTrainingMaterialTrainingMaterialID() {
        return trainingMaterialTrainingMaterialID;
    }

    public void setTrainingMaterialTrainingMaterialID(Trainingmaterial trainingMaterialTrainingMaterialID) {
        this.trainingMaterialTrainingMaterialID = trainingMaterialTrainingMaterialID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trainingID != null ? trainingID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Training)) {
            return false;
        }
        Training other = (Training) object;
        if ((this.trainingID == null && other.trainingID != null) || (this.trainingID != null && !this.trainingID.equals(other.trainingID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.personalmanagement.entity.Training[ trainingID=" + trainingID + " ]";
    }
    
}
