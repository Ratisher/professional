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
@Table(name = "event")
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
    @NamedQuery(name = "Event.findById", query = "SELECT e FROM Event e WHERE e.id = :id"),
    @NamedQuery(name = "Event.findByName", query = "SELECT e FROM Event e WHERE e.name = :name"),
    @NamedQuery(name = "Event.findByDateOfEvent", query = "SELECT e FROM Event e WHERE e.dateOfEvent = :dateOfEvent"),
    @NamedQuery(name = "Event.findByDiscription", query = "SELECT e FROM Event e WHERE e.discription = :discription")})
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "dateOfEvent")
    @Temporal(TemporalType.DATE)
    private Date dateOfEvent;
    @Column(name = "discription")
    private String discription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventid")
    private Collection<ApplicantEvent> applicantEventCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventid")
    private Collection<Responsibleemployees> responsibleemployeesCollection;
    @JsonIgnore
    @JoinColumn(name = "EventStatus_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Eventstatus eventStatusid;
    @JsonIgnore
    @JoinColumn(name = "TypeOfEvent_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Typeofevent typeOfEventid;

    public Event() {
    }

    public Event(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(Date dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Collection<ApplicantEvent> getApplicantEventCollection() {
        return applicantEventCollection;
    }

    public void setApplicantEventCollection(Collection<ApplicantEvent> applicantEventCollection) {
        this.applicantEventCollection = applicantEventCollection;
    }

    public Collection<Responsibleemployees> getResponsibleemployeesCollection() {
        return responsibleemployeesCollection;
    }

    public void setResponsibleemployeesCollection(Collection<Responsibleemployees> responsibleemployeesCollection) {
        this.responsibleemployeesCollection = responsibleemployeesCollection;
    }

    public Eventstatus getEventStatusid() {
        return eventStatusid;
    }

    public void setEventStatusid(Eventstatus eventStatusid) {
        this.eventStatusid = eventStatusid;
    }

    public Typeofevent getTypeOfEventid() {
        return typeOfEventid;
    }

    public void setTypeOfEventid(Typeofevent typeOfEventid) {
        this.typeOfEventid = typeOfEventid;
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
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi.entity.Event[ id=" + id + " ]";
    }
    
}
