package org.standrews.schedulingsurgeries.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import javax.persistence.*;

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
    private DateTime startingTimeSurgery;
    private DateTime finishingTimeSurgery;

    public ScheduledSurgery(){
    }

    public ScheduledSurgery(Surgery surgery) {
        this.surgery = surgery;
    }

    public ScheduledSurgery(Surgery surgery, DateTime startingTimeSurgery, DateTime finishingTimeSurgery, OperatingRoom operatingRoom) {
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
    public DateTime getStartingTimeSurgery() {
        return startingTimeSurgery;
    }

    public void setStartingTimeSurgery(DateTime startingTimeSurgery) {
        setStartingTimeSurgery(true, startingTimeSurgery);
    }
    public void setStartingAssignedTimeSurgery(DateTime startingTimeSurgery) {
        this.startingTimeSurgery = startingTimeSurgery;
    }

    public DateTime getFinishingTimeSurgery() {
        return finishingTimeSurgery;
    }

    public void setFinishingTimeSurgery(DateTime finishingTimeSurgery) {
        this.finishingTimeSurgery = finishingTimeSurgery;
    }

    public void setStartingTimeSurgery(boolean hasFinishSurgery, DateTime startingTimeSurgery) {
        this.startingTimeSurgery = startingTimeSurgery;
        if (hasFinishSurgery) {
            if(startingTimeSurgery == null) {
                setFinishingTimeSurgery(null);
            } else {
                int procedureDuration = this.getSurgery().getProcedureDuration();
                DateTime finishingSurgery = startingTimeSurgery.plusMinutes(procedureDuration);
                setFinishingTimeSurgery(finishingSurgery);
            }
        }
    }

    public boolean availableTime() {
        if (this.getOperatingRoom() == null) {
            return false;
        }
        DateTimeFormatter formatDate = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm");
        OperatingRoom operatingRoom = this.getOperatingRoom();
        String openingRoom = operatingRoom.getOpeningTime();
        String closingRoom = operatingRoom.getClosingTime();
        DateTime openingRoomDateTime = formatDate.parseDateTime(openingRoom);
        DateTime closingRoomDateTime = formatDate.parseDateTime(closingRoom);
        Interval intervalOperatingRoom = new Interval(openingRoomDateTime, closingRoomDateTime);
        Interval intervalSurgery = new Interval(this.getStartingTimeSurgery(), this.getFinishingTimeSurgery());
        return containsInTheInterval(intervalOperatingRoom, intervalSurgery);
    }

    private boolean containsInTheInterval(Interval intervalOperatingRoom, Interval intervalSurgery) {
        if (intervalOperatingRoom.contains(intervalSurgery)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formatDate = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm");
        StringBuilder information = new StringBuilder();
        String startingTimeSurgery = this.getStartingTimeSurgery() == null ? "null " : this.getStartingTimeSurgery().toString(formatDate);
        String finishingTimeSurgery = this.getFinishingTimeSurgery() == null ? "null ": this.getFinishingTimeSurgery().toString(formatDate);
        information.append("Elective surgery -");
        information.append(" Speciality: ");
        information.append(this.getSurgery().getSpeciality());
        information.append(" Procedure: ");
        information.append(this.getSurgery().getProcedureName());
        information.append(" Surgeon: ");
        information.append(this.getSurgery().getSurgeon());
        information.append(" Starting time: ");
        information.append(startingTimeSurgery);
        information.append(" Finishing time: ");
        information.append(finishingTimeSurgery);
        return information.toString();
    }

    public String informationScheduledSurgery() {
        StringBuilder information = new StringBuilder();
        DateTimeFormatter formatDate = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm");
        String startSurgery = this.getStartingTimeSurgery().toString(formatDate);
        String finishSurgery = this.getFinishingTimeSurgery().toString(formatDate);
        information.append("-- Elective Surgery --");
        information.append("\n");
        information.append("Speciality: ");
        information.append(this.getSurgery().getSpeciality());
        information.append("\n");
        information.append("Procedure: ");
        information.append(this.getSurgery().getProcedureName());
        information.append("\n");
        information.append("Surgeon: ");
        information.append(this.getSurgery().getSurgeon());
        information.append("\n");
        information.append("Operating room: ");
        information.append(this.getOperatingRoom().getOperatingRoomName());
        information.append("\n");
        information.append("Starting time: ");
        information.append(startSurgery);
        information.append("\n");
        information.append("Finishing time: ");
        information.append(finishSurgery);
        return information.toString();
    }
}
