/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.personalmanagement.entity;

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
@Table(name = "trainingmaterial")
@NamedQueries({
    @NamedQuery(name = "Trainingmaterial.findAll", query = "SELECT t FROM Trainingmaterial t"),
    @NamedQuery(name = "Trainingmaterial.findByTrainingMaterialID", query = "SELECT t FROM Trainingmaterial t WHERE t.trainingMaterialID = :trainingMaterialID"),
    @NamedQuery(name = "Trainingmaterial.findByName", query = "SELECT t FROM Trainingmaterial t WHERE t.name = :name"),
    @NamedQuery(name = "Trainingmaterial.findByApprovalDate", query = "SELECT t FROM Trainingmaterial t WHERE t.approvalDate = :approvalDate"),
    @NamedQuery(name = "Trainingmaterial.findByUpdateDate", query = "SELECT t FROM Trainingmaterial t WHERE t.updateDate = :updateDate"),
    @NamedQuery(name = "Trainingmaterial.findByAuthor", query = "SELECT t FROM Trainingmaterial t WHERE t.author = :author")})
public class Trainingmaterial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TrainingMaterialID")
    private Integer trainingMaterialID;
    @Column(name = "Name")
    private String name;
    @Column(name = "ApprovalDate")
    @Temporal(TemporalType.DATE)
    private Date approvalDate;
    @Column(name = "UpdateDate")
    @Temporal(TemporalType.DATE)
    private Date updateDate;
    @Column(name = "Author")
    private String author;
    @JsonIgnore
    @JoinColumn(name = "FieldOfStudy_FieldOfStudyID", referencedColumnName = "FieldOfStudyID")
    @ManyToOne(optional = false)
    private Fieldofstudy fieldOfStudyFieldOfStudyID;
    @JsonIgnore
    @JoinColumn(name = "StatusOfStudy_StatusOfStudyID", referencedColumnName = "StatusOfStudyID")
    @ManyToOne(optional = false)
    private Statusofstudy statusOfStudyStatusOfStudyID;
    @JsonIgnore
    @JoinColumn(name = "TypeOfStudy_TypeOfStudyID", referencedColumnName = "TypeOfStudyID")
    @ManyToOne(optional = false)
    private Typeofstudy typeOfStudyTypeOfStudyID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainingMaterialTrainingMaterialID")
    private Collection<Training> trainingCollection;

    public Trainingmaterial() {
    }

    public Trainingmaterial(Integer trainingMaterialID) {
        this.trainingMaterialID = trainingMaterialID;
    }

    public Integer getTrainingMaterialID() {
        return trainingMaterialID;
    }

    public void setTrainingMaterialID(Integer trainingMaterialID) {
        this.trainingMaterialID = trainingMaterialID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Fieldofstudy getFieldOfStudyFieldOfStudyID() {
        return fieldOfStudyFieldOfStudyID;
    }

    public void setFieldOfStudyFieldOfStudyID(Fieldofstudy fieldOfStudyFieldOfStudyID) {
        this.fieldOfStudyFieldOfStudyID = fieldOfStudyFieldOfStudyID;
    }

    public Statusofstudy getStatusOfStudyStatusOfStudyID() {
        return statusOfStudyStatusOfStudyID;
    }

    public void setStatusOfStudyStatusOfStudyID(Statusofstudy statusOfStudyStatusOfStudyID) {
        this.statusOfStudyStatusOfStudyID = statusOfStudyStatusOfStudyID;
    }

    public Typeofstudy getTypeOfStudyTypeOfStudyID() {
        return typeOfStudyTypeOfStudyID;
    }

    public void setTypeOfStudyTypeOfStudyID(Typeofstudy typeOfStudyTypeOfStudyID) {
        this.typeOfStudyTypeOfStudyID = typeOfStudyTypeOfStudyID;
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
        hash += (trainingMaterialID != null ? trainingMaterialID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trainingmaterial)) {
            return false;
        }
        Trainingmaterial other = (Trainingmaterial) object;
        if ((this.trainingMaterialID == null && other.trainingMaterialID != null) || (this.trainingMaterialID != null && !this.trainingMaterialID.equals(other.trainingMaterialID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.personalmanagement.entity.Trainingmaterial[ trainingMaterialID=" + trainingMaterialID + " ]";
    }
    
}
