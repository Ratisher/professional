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
@Table(name = "typeofevent")
@NamedQueries({
    @NamedQuery(name = "Typeofevent.findAll", query = "SELECT t FROM Typeofevent t"),
    @NamedQuery(name = "Typeofevent.findByTypeOfEventID", query = "SELECT t FROM Typeofevent t WHERE t.typeOfEventID = :typeOfEventID"),
    @NamedQuery(name = "Typeofevent.findByName", query = "SELECT t FROM Typeofevent t WHERE t.name = :name"),
    @NamedQuery(name = "Typeofevent.findByDiscription", query = "SELECT t FROM Typeofevent t WHERE t.discription = :discription")})
public class Typeofevent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TypeOfEventID")
    private Integer typeOfEventID;
    @Column(name = "Name")
    private String name;
    @Column(name = "Discription")
    private String discription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeOfEventTypeOfEventID")
    private Collection<Event> eventCollection;

    public Typeofevent() {
    }

    public Typeofevent(Integer typeOfEventID) {
        this.typeOfEventID = typeOfEventID;
    }

    public Integer getTypeOfEventID() {
        return typeOfEventID;
    }

    public void setTypeOfEventID(Integer typeOfEventID) {
        this.typeOfEventID = typeOfEventID;
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

    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeOfEventID != null ? typeOfEventID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typeofevent)) {
            return false;
        }
        Typeofevent other = (Typeofevent) object;
        if ((this.typeOfEventID == null && other.typeOfEventID != null) || (this.typeOfEventID != null && !this.typeOfEventID.equals(other.typeOfEventID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.personalmanagement.entity.Typeofevent[ typeOfEventID=" + typeOfEventID + " ]";
    }
    
}
