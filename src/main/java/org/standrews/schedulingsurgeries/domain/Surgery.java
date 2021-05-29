package org.standrews.schedulingsurgeries.domain;

public class Surgery {
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
