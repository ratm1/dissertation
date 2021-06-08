package org.standrews.schedulingsurgeries.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.optaplanner.core.api.domain.lookup.PlanningId;

import javax.persistence.*;

@Entity
public class Surgery extends PanacheEntityBase {
    @PlanningId
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long surgeryId;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Surgeon surgeon;
    @ManyToOne
    private AnesthesiaType anesthesiaType;
    @ManyToOne
    private Anesthetist anesthetist;
    @ManyToOne
    private SurgeryType surgeryType;
    @ManyToOne
    private Insurance insurance;
    @ManyToOne
    private Procedure procedure;
    private Integer surgeryDuration;

    public Surgery() {
    }

    public Surgery(Patient patient, Surgeon surgeon, AnesthesiaType anesthesiaType, Anesthetist anesthetist,
                   SurgeryType surgeryType, Insurance insurance, Procedure procedure, Integer surgeryDuration) {
        this.patient = patient;
        this.surgeon = surgeon;
        this.anesthesiaType = anesthesiaType;
        this.anesthetist = anesthetist;
        this.surgeryType = surgeryType;
        this.insurance= insurance;
        this.procedure = procedure;
        this.surgeryDuration = surgeryDuration;
    }

    public Long getSurgeryId() {
        return surgeryId;
    }

    public void setSurgeryId(Long surgeryId) {
        this.surgeryId = surgeryId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Surgeon getSurgeon() {
        return surgeon;
    }

    public void setSurgeon(Surgeon surgeon) {
        this.surgeon = surgeon;
    }

    public AnesthesiaType getAnesthesiaType() {
        return anesthesiaType;
    }

    public void setAnesthesiaType(AnesthesiaType anesthesiaType) {
        this.anesthesiaType = anesthesiaType;
    }

    public Anesthetist getAnesthetist() {
        return anesthetist;
    }

    public void setAnesthetist(Anesthetist anesthetist) {
        this.anesthetist = anesthetist;
    }

    public SurgeryType getSurgeryType() {
        return surgeryType;
    }

    public void setSurgeryType(SurgeryType surgeryType) {
        this.surgeryType = surgeryType;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Integer getSurgeryDuration() {
        return surgeryDuration;
    }

    public void setSurgeryDuration(Integer surgeryDuration) {
        this.surgeryDuration = surgeryDuration;
    }

    @Override
    public String toString() {
        return "Surgery: " +  this.getSurgeryId() +" Procedure: " + this.getProcedure().getName();
    }
}
