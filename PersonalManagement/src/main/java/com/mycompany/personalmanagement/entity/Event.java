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
@Table(name = "event")
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
    @NamedQuery(name = "Event.findByEventID", query = "SELECT e FROM Event e WHERE e.eventID = :eventID"),
    @NamedQuery(name = "Event.findByName", query = "SELECT e FROM Event e WHERE e.name = :name"),
    @NamedQuery(name = "Event.findByDateTime", query = "SELECT e FROM Event e WHERE e.dateTime = :dateTime"),
    @NamedQuery(name = "Event.findByDiscription", query = "SELECT e FROM Event e WHERE e.discription = :discription")})
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EventID")
    private Integer eventID;
    @Column(name = "Name")
    private String name;
    @Column(name = "DateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    @Column(name = "Discription")
    private String discription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventEventID")
    private Collection<EmployeeEvent> employeeEventCollection;
    @JsonIgnore
    @JoinColumn(name = "EventStatus_EventStatusID", referencedColumnName = "EventStatusID")
    @ManyToOne(optional = false)
    private Eventstatus eventStatusEventStatusID;
    @JsonIgnore
    @JoinColumn(name = "TypeOfEvent_TypeOfEventID", referencedColumnName = "TypeOfEventID")
    @ManyToOne(optional = false)
    private Typeofevent typeOfEventTypeOfEventID;

    public Event() {
    }

    public Event(Integer eventID) {
        this.eventID = eventID;
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Collection<EmployeeEvent> getEmployeeEventCollection() {
        return employeeEventCollection;
    }

    public void setEmployeeEventCollection(Collection<EmployeeEvent> employeeEventCollection) {
        this.employeeEventCollection = employeeEventCollection;
    }

    public Eventstatus getEventStatusEventStatusID() {
        return eventStatusEventStatusID;
    }

    public void setEventStatusEventStatusID(Eventstatus eventStatusEventStatusID) {
        this.eventStatusEventStatusID = eventStatusEventStatusID;
    }

    public Typeofevent getTypeOfEventTypeOfEventID() {
        return typeOfEventTypeOfEventID;
    }

    public void setTypeOfEventTypeOfEventID(Typeofevent typeOfEventTypeOfEventID) {
        this.typeOfEventTypeOfEventID = typeOfEventTypeOfEventID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventID != null ? eventID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventID == null && other.eventID != null) || (this.eventID != null && !this.eventID.equals(other.eventID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.personalmanagement.entity.Event[ eventID=" + eventID + " ]";
    }
    
}
