package org.standrews.schedulingsurgeries.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@PlanningEntity
@Entity
public class ScheduledSurgery extends PanacheEntityBase {
    @PlanningId
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleSurgeryId;
    @OneToOne
    private Surgery surgery;
    @ManyToOne
    private OperatingRoom operatingRoom;
    private LocalDateTime startingTimeSurgery;
    private LocalDateTime finishingTimeSurgery;

    public ScheduledSurgery(){
    }

    public ScheduledSurgery(Surgery surgery) {
        this.surgery = surgery;
    }

    public ScheduledSurgery(Surgery surgery, LocalDateTime startingTimeSurgery, LocalDateTime finishingTimeSurgery, OperatingRoom operatingRoom) {
        this(surgery);
        this.startingTimeSurgery = startingTimeSurgery;
        this.finishingTimeSurgery = finishingTimeSurgery;
        this.operatingRoom = operatingRoom;
    }

    public Long getScheduleSurgeryId() {
        return scheduleSurgeryId;
    }

    public void setScheduleSurgeryId(Long scheduleSurgeryId) {
        this.scheduleSurgeryId = scheduleSurgeryId;
    }

    public Surgery getSurgery() {
        return surgery;
    }

    public void setSurgery(Surgery surgery) {
        this.surgery = surgery;
    }

    @PlanningVariable(valueRangeProviderRefs = {"roomRange"})
    public OperatingRoom getOperatingRoom() {
        return operatingRoom;
    }

    public void setOperatingRoom(OperatingRoom operatingRoom) {
        this.operatingRoom = operatingRoom;
    }

    @PlanningVariable(valueRangeProviderRefs = {"startingSurgeryRange"})
    public LocalDateTime getStartingTimeSurgery() {
        return startingTimeSurgery;
    }

    public void setStartingTimeSurgery(LocalDateTime startingTimeSurgery) {
        setStartingTimeSurgery(true, startingTimeSurgery);
    }
    public void setStartingAssignedTimeSurgery(LocalDateTime startingTimeSurgery) {
        this.startingTimeSurgery = startingTimeSurgery;
    }

    public LocalDateTime getFinishingTimeSurgery() {
        return finishingTimeSurgery;
    }

    public void setFinishingTimeSurgery(LocalDateTime finishingTimeSurgery) {
        this.finishingTimeSurgery = finishingTimeSurgery;
    }

    public void setStartingTimeSurgery(boolean hasFinishSurgery, LocalDateTime startingTimeSurgery) {
        this.startingTimeSurgery = startingTimeSurgery;
        if (hasFinishSurgery) {
            if(startingTimeSurgery == null) {
                setFinishingTimeSurgery(null);
            } else {
                int procedureDuration = this.getSurgery().getSurgeryDuration();
                LocalDateTime finishingSurgery = startingTimeSurgery.plusMinutes(procedureDuration);
                setFinishingTimeSurgery(finishingSurgery);
            }
        }
    }

    public boolean availableTime() {
        if (this.getOperatingRoom() == null) {
            return false;
        }
        OperatingRoom operatingRoom = this.getOperatingRoom();
        LocalDateTime openingRoomDateTime = operatingRoom.getOpeningTime();
        LocalDateTime closingRoomDateTime = operatingRoom.getClosingTime();
        LocalDateTime startingSurgery = this.getStartingTimeSurgery();
        LocalDateTime finishingSurgery = this.getFinishingTimeSurgery();
        return containInOneOfTheIntervalsOfTheWeek(openingRoomDateTime, closingRoomDateTime, startingSurgery, finishingSurgery);
    }

    private boolean containInOneOfTheIntervalsOfTheWeek(LocalDateTime openingRoomDateTime, LocalDateTime closingRoomDateTime, LocalDateTime startingSurgery, LocalDateTime finishingSurgery) {
        List<LocalDateTime> openingRoomWeekly = new ArrayList<>();
        List<LocalDateTime> closingRoomWeekly = new ArrayList<>();
        int numberOfDays = closingRoomDateTime.getDayOfMonth() - openingRoomDateTime.getDayOfMonth();
        int hours = closingRoomDateTime.getHour() - openingRoomDateTime.getHour();
        int minutes =  closingRoomDateTime.getMinute() - openingRoomDateTime.getMinute();
        int totalMinutes = (hours * 60) + minutes;
        openingRoomWeekly.add(openingRoomDateTime);
        for (int openingDays = 1; openingDays <= numberOfDays; openingDays++) {
            closingRoomWeekly.add(openingRoomDateTime.plusMinutes(totalMinutes));
            openingRoomDateTime = openingRoomDateTime.plusDays(1);
            openingRoomWeekly.add(openingRoomDateTime);
        }
        closingRoomWeekly.add(closingRoomDateTime);
        return calculateSpecificInterval(openingRoomWeekly, closingRoomWeekly, startingSurgery, finishingSurgery);
    }

    private boolean calculateSpecificInterval(List<LocalDateTime> openingRoomWeekly,  List<LocalDateTime> closingRoomWeekly, LocalDateTime startingSurgery, LocalDateTime finishingSurgery) {
        for (int counterDay = 0; counterDay < openingRoomWeekly.size(); counterDay++) {
            if (containsInTheInterval(openingRoomWeekly.get(counterDay), closingRoomWeekly.get(counterDay), startingSurgery, finishingSurgery)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsInTheInterval(LocalDateTime openingRoomDateTime, LocalDateTime closingRoomDateTime, LocalDateTime startingSurgery,  LocalDateTime finishingSurgery) {
        if ((startingSurgery.isAfter(openingRoomDateTime) || startingSurgery.isEqual(openingRoomDateTime))
                && (finishingSurgery.isEqual(closingRoomDateTime) || finishingSurgery.isBefore(closingRoomDateTime))) {
            return true;
        } else {
            return false;
        }
    }

// TO DO: REVIEW
    @Override
    public String toString() {
        StringBuilder information = new StringBuilder();
        String startingTimeSurgery = this.getStartingTimeSurgery() == null ? "null " : this.getStartingTimeSurgery().toString();
        String finishingTimeSurgery = this.getFinishingTimeSurgery() == null ? "null ": this.getFinishingTimeSurgery().toString();
        information.append("Elective surgery -");
        information.append(" Speciality: ");
        information.append(this.getSurgery().getSurgeon().getSpeciality().getName());
        information.append(" Procedure: ");
        information.append(this.getSurgery().getProcedure().getName());
        information.append(" Surgeon: ");
        information.append(this.getSurgery().getSurgeon());
        information.append(" Starting time: ");
        information.append(startingTimeSurgery);
        information.append(" Finishing time: ");
        information.append(finishingTimeSurgery);
        return information.toString();
    }

}
