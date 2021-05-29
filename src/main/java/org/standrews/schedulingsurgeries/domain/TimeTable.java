package org.standrews.schedulingsurgeries.domain;

import org.joda.time.DateTime;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.List;

public class TimeTable {

    private List<DateTime> startingTimeSurgeriesList;
    private List<OperatingRoom> operatingRoomsList;
    private List<Surgery> surgeriesList;
    private List<ScheduledSurgery> scheduledSurgeriesList;
    private HardSoftScore scoreSolver;

    public TimeTable(){
    }

    public List<DateTime> getStartingTimeSurgeriesList() {
        return startingTimeSurgeriesList;
    }

    public void setStartingTimeSurgeriesList(List<DateTime> startingTimeSurgeriesList) {
        this.startingTimeSurgeriesList = startingTimeSurgeriesList;
    }

    public List<OperatingRoom> getOperatingRoomsList() {
        return operatingRoomsList;
    }

    public void setOperatingRoomsList(List<OperatingRoom> operatingRoomsList) {
        this.operatingRoomsList = operatingRoomsList;
    }

    public List<Surgery> getSurgeriesList() {
        return surgeriesList;
    }

    public void setSurgeriesList(List<Surgery> surgeriesList) {
        this.surgeriesList = surgeriesList;
    }

    public List<ScheduledSurgery> getScheduledSurgeriesList() {
        return scheduledSurgeriesList;
    }

    public void setScheduledSurgeriesList(List<ScheduledSurgery> scheduledSurgeriesList) {
        this.scheduledSurgeriesList = scheduledSurgeriesList;
    }

    public HardSoftScore getScoreSolver() {
        return scoreSolver;
    }

    public void setScoreSolver(HardSoftScore scoreSolver) {
        this.scoreSolver = scoreSolver;
    }

    public String getAllScheduledSurgeries() {
        StringBuilder scheduledSurgeriesInformation = new StringBuilder();
        List<ScheduledSurgery> scheduledSurgeries = this.getScheduledSurgeriesList();
        for (ScheduledSurgery scheduledSurgery: scheduledSurgeries) {
            scheduledSurgeriesInformation.append(scheduledSurgery.getInformationScheduledSurgery());
            scheduledSurgeriesInformation.append("\n");
        }
        return scheduledSurgeriesInformation.toString();
    }
}
