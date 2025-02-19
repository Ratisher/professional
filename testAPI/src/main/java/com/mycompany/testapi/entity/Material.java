/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi.entity;

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
@Table(name = "material")
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m"),
    @NamedQuery(name = "Material.findById", query = "SELECT m FROM Material m WHERE m.id = :id"),
    @NamedQuery(name = "Material.findByTitle", query = "SELECT m FROM Material m WHERE m.title = :title"),
    @NamedQuery(name = "Material.findByDateCreated", query = "SELECT m FROM Material m WHERE m.dateCreated = :dateCreated"),
    @NamedQuery(name = "Material.findByDateUpdated", query = "SELECT m FROM Material m WHERE m.dateUpdated = :dateUpdated")})
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "dateCreated")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;
    @Column(name = "dateUpdated")
    @Temporal(TemporalType.DATE)
    private Date dateUpdated;
    @JsonIgnore
    @JoinColumn(name = "Employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeid;
    @JsonIgnore
    @JoinColumn(name = "Sphere_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Sphere sphereid;
    @JsonIgnore
    @JoinColumn(name = "StatusOfMaterial_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Statusofmaterial statusOfMaterialid;
    @JsonIgnore
    @JoinColumn(name = "TypeOfMaterial_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Typeofmaterial typeOfMaterialid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialid")
    private Collection<TrainingMaterial> trainingMaterialCollection;

    public Material() {
    }

    public Material(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Employee getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Employee employeeid) {
        this.employeeid = employeeid;
    }

    public Sphere getSphereid() {
        return sphereid;
    }

    public void setSphereid(Sphere sphereid) {
        this.sphereid = sphereid;
    }

    public Statusofmaterial getStatusOfMaterialid() {
        return statusOfMaterialid;
    }

    public void setStatusOfMaterialid(Statusofmaterial statusOfMaterialid) {
        this.statusOfMaterialid = statusOfMaterialid;
    }

    public Typeofmaterial getTypeOfMaterialid() {
        return typeOfMaterialid;
    }

    public void setTypeOfMaterialid(Typeofmaterial typeOfMaterialid) {
        this.typeOfMaterialid = typeOfMaterialid;
    }

    public Collection<TrainingMaterial> getTrainingMaterialCollection() {
        return trainingMaterialCollection;
    }

    public void setTrainingMaterialCollection(Collection<TrainingMaterial> trainingMaterialCollection) {
        this.trainingMaterialCollection = trainingMaterialCollection;
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
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi.entity.Material[ id=" + id + " ]";
    }
    
}
