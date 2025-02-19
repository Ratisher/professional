/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi.entity;

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
@Table(name = "training_material")
@NamedQueries({
    @NamedQuery(name = "TrainingMaterial.findAll", query = "SELECT t FROM TrainingMaterial t"),
    @NamedQuery(name = "TrainingMaterial.findById", query = "SELECT t FROM TrainingMaterial t WHERE t.id = :id")})
public class TrainingMaterial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonIgnore
    @JoinColumn(name = "Material_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Material materialid;
    @JsonIgnore
    @JoinColumn(name = "Training_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Training trainingid;

    public TrainingMaterial() {
    }

    public TrainingMaterial(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Material getMaterialid() {
        return materialid;
    }

    public void setMaterialid(Material materialid) {
        this.materialid = materialid;
    }

    public Training getTrainingid() {
        return trainingid;
    }

    public void setTrainingid(Training trainingid) {
        this.trainingid = trainingid;
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
        if (!(object instanceof TrainingMaterial)) {
            return false;
        }
        TrainingMaterial other = (TrainingMaterial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi.entity.TrainingMaterial[ id=" + id + " ]";
    }
    
}
