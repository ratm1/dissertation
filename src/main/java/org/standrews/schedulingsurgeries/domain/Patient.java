package org.standrews.schedulingsurgeries.domain;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.optaplanner.core.api.domain.lookup.PlanningId;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient extends PanacheEntityBase {
    @PlanningId
    @Id
    private Long patientId;
    private String firstName;
    private String lastName;

    public Patient(){
    }

    public Patient(long patientId, String firstName, String lastName) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getPatientId() {
        return patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
