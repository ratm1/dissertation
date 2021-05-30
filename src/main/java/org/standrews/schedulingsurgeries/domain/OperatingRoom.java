package org.standrews.schedulingsurgeries.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.optaplanner.core.api.domain.lookup.PlanningId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OperatingRoom extends PanacheEntityBase {
    @PlanningId
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long operatingRoomId;
    private String operatingRoomName;
    private String openingTime;
    private String closingTime;

    public OperatingRoom(){
    }

    public OperatingRoom(String operatingRoomName, String openingTime, String closingTime) {
        this.operatingRoomName = operatingRoomName;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public Long getOperatingRoomId() {
        return operatingRoomId;
    }

    public String getOperatingRoomName() {
        return operatingRoomName;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    @Override
    public String toString() {
        return operatingRoomName;
    }
}
