package org.standrews.schedulingsurgeries.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.optaplanner.core.api.domain.lookup.PlanningId;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class OperatingRoom extends PanacheEntityBase {
    @PlanningId
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long operatingRoomId;
    private String operatingRoomName;


    private LocalDateTime startingTimeWeekly;
    private LocalDateTime finishTimeWeekly ;

    public OperatingRoom(){
    }

    public OperatingRoom(String operatingRoomName, LocalDateTime startingTimeWeekly, LocalDateTime finishTimeWeekly) {
        this.operatingRoomName = operatingRoomName;
        this.startingTimeWeekly = startingTimeWeekly;
        this.finishTimeWeekly = finishTimeWeekly;
    }

    public Long getOperatingRoomId() {
        return operatingRoomId;
    }

    public String getOperatingRoomName() {
        return operatingRoomName;
    }

    public LocalDateTime getOpeningTime() {
        return startingTimeWeekly;
    }

    public LocalDateTime getClosingTime() {
        return finishTimeWeekly;
    }

    @Override
    public String toString() {
        return operatingRoomName;
    }
}
