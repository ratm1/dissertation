package org.standrews.schedulingsurgeries.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SurgeryType extends PanacheEntityBase {
    @PlanningId
    @Id
    private Long surgeryTypeId;
    private String code;
    private String name;

    public SurgeryType(){}

    public SurgeryType(long surgeryTypeId, String code, String name) {
        this.surgeryTypeId = surgeryTypeId;
        this.code = code;
        this.name = name;
    }

    public Long getSurgeryTypeId() {
        return surgeryTypeId;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
