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
@Table(name = "eventstatus")
@NamedQueries({
    @NamedQuery(name = "Eventstatus.findAll", query = "SELECT e FROM Eventstatus e"),
    @NamedQuery(name = "Eventstatus.findByEventStatusID", query = "SELECT e FROM Eventstatus e WHERE e.eventStatusID = :eventStatusID"),
    @NamedQuery(name = "Eventstatus.findByName", query = "SELECT e FROM Eventstatus e WHERE e.name = :name"),
    @NamedQuery(name = "Eventstatus.findByDiscription", query = "SELECT e FROM Eventstatus e WHERE e.discription = :discription")})
public class Eventstatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EventStatusID")
    private Integer eventStatusID;
    @Column(name = "Name")
    private String name;
    @Column(name = "Discription")
    private String discription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventStatusEventStatusID")
    private Collection<Training> trainingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventStatusEventStatusID")
    private Collection<Event> eventCollection;

    public Eventstatus() {
    }

    public Eventstatus(Integer eventStatusID) {
        this.eventStatusID = eventStatusID;
    }

    public Integer getEventStatusID() {
        return eventStatusID;
    }

    public void setEventStatusID(Integer eventStatusID) {
        this.eventStatusID = eventStatusID;
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

    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventStatusID != null ? eventStatusID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eventstatus)) {
            return false;
        }
        Eventstatus other = (Eventstatus) object;
        if ((this.eventStatusID == null && other.eventStatusID != null) || (this.eventStatusID != null && !this.eventStatusID.equals(other.eventStatusID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.personalmanagement.entity.Eventstatus[ eventStatusID=" + eventStatusID + " ]";
    }
    
}
