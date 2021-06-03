package org.standrews.schedulingsurgeries.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.optaplanner.core.api.domain.lookup.PlanningId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Procedure extends PanacheEntityBase {
    @PlanningId
    @Id
    private Long procedureId;
    @ManyToOne
    private Speciality speciality;
    private String name;

    public Procedure(){}

    public Procedure(long procedureId, Speciality speciality, String name) {
        this.procedureId = procedureId;
        this.speciality = speciality;
        this.name = name;
    }

    public Long getProcedureId() {
        return procedureId;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public String getName() {
        return name;
    }
}
