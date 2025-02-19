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
@Table(name = "applicant_event")
@NamedQueries({
    @NamedQuery(name = "ApplicantEvent.findAll", query = "SELECT a FROM ApplicantEvent a"),
    @NamedQuery(name = "ApplicantEvent.findById", query = "SELECT a FROM ApplicantEvent a WHERE a.id = :id")})
public class ApplicantEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonIgnore
    @JoinColumn(name = "Applicant_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Applicant applicantid;
    @JsonIgnore
    @JoinColumn(name = "Event_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Event eventid;

    public ApplicantEvent() {
    }

    public ApplicantEvent(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Applicant getApplicantid() {
        return applicantid;
    }

    public void setApplicantid(Applicant applicantid) {
        this.applicantid = applicantid;
    }

    public Event getEventid() {
        return eventid;
    }

    public void setEventid(Event eventid) {
        this.eventid = eventid;
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
        if (!(object instanceof ApplicantEvent)) {
            return false;
        }
        ApplicantEvent other = (ApplicantEvent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.testapi.entity.ApplicantEvent[ id=" + id + " ]";
    }
    
}
