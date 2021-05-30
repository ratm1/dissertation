package org.standrews.schedulingsurgeries.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.optaplanner.core.api.domain.lookup.PlanningId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Surgery extends PanacheEntityBase {
    @PlanningId
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long surgeryId;
    private String patient;
    private String surgeon;
    private String anesthesiaType;
    private String anesthetist;
    private String speciality;
    private String surgeryType;
    private String insuranceName;
    private String procedureName;
    private Integer procedureDuration;

    public Surgery() {
    }

    public Surgery(String patient, String surgeon, String anesthesiaType, String anesthetist, String speciality, String surgeryType, String insuranceName, String procedureName, Integer procedureDuration) {
        this.patient = patient;
        this.surgeon = surgeon;
        this.anesthesiaType = anesthesiaType;
        this.anesthetist = anesthetist;
        this.speciality = speciality;
        this.surgeryType = surgeryType;
        this.insuranceName = insuranceName;
        this.procedureName = procedureName;
        this.procedureDuration = procedureDuration;
    }

    public Long getSurgeryId() {
        return surgeryId;
    }

    public void setSurgeryId(Long surgeryId) {
        this.surgeryId = surgeryId;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getSurgeon() {
        return surgeon;
    }

    public void setSurgeon(String surgeon) {
        this.surgeon = surgeon;
    }

    public String getAnesthesiaType() {
        return anesthesiaType;
    }

    public void setAnesthesiaType(String anesthesiaType) {
        this.anesthesiaType = anesthesiaType;
    }

    public String getAnesthetist() {
        return anesthetist;
    }

    public void setAnesthetist(String anesthetist) {
        this.anesthetist = anesthetist;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getSurgeryType() {
        return surgeryType;
    }

    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public Integer getProcedureDuration() {
        return procedureDuration;
    }

    public void setProcedureDuration(Integer procedureDuration) {
        this.procedureDuration = procedureDuration;
    }

    @Override
    public String toString() {
        return "Surgery: " +  this.getSurgeryId() +" Procedure: " + this.getProcedureName();
    }
}
