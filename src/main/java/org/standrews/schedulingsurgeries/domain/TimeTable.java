package org.standrews.schedulingsurgeries.domain;


import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.SolverStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@PlanningSolution
public class TimeTable {

    @ValueRangeProvider(id = "startingSurgeryRange")
    @ProblemFactCollectionProperty
    private List<LocalDateTime> startingTimeSurgeries;
    @ValueRangeProvider(id = "roomRange")
    @ProblemFactCollectionProperty
    private List<OperatingRoom> operatingRooms;
    @ProblemFactCollectionProperty
    private List<Surgery> surgeries;
    @PlanningEntityCollectionProperty
    private List<ScheduledSurgery> scheduledSurgeries;
    @PlanningScore
    private HardSoftScore scoreSolver;
    private SolverStatus solverStatus;

    public TimeTable(){
    }

    public TimeTable(List<OperatingRoom> operatingRooms, List<Surgery> surgeries, List<ScheduledSurgery> scheduledSurgeries) {
        setStartingTimeSurgeries();
        this.operatingRooms = operatingRooms;
        this.surgeries = surgeries;
        this.scheduledSurgeries = scheduledSurgeries;
    }

    public List<LocalDateTime> getStartingTimeSurgeries() {
        return startingTimeSurgeries;
    }

    public void setStartingTimeSurgeries(List<LocalDateTime> startingTimeSurgeries) {
        this.startingTimeSurgeries = startingTimeSurgeries;
    }


    public void setStartingTimeSurgeries() {
        this.startingTimeSurgeries = new ArrayList<>();
        LocalDateTime startingTime = LocalDateTime.of (2021, 06, 14, 8, 30);
        LocalDateTime endTime = startingTime.plusHours(24);
        while (startingTime.isBefore(endTime)) {
            startingTimeSurgeries.add(startingTime);
            startingTime = startingTime.plusMinutes(30);
        }
    }

    public List<OperatingRoom> getOperatingRooms() {
        return operatingRooms;
    }

    public void setOperatingRooms(List<OperatingRoom> operatingRooms) {
        this.operatingRooms = operatingRooms;
    }

    public List<Surgery> getSurgeries() {
        return surgeries;
    }

    public void setSurgeries(List<Surgery> surgeries) {
        this.surgeries = surgeries;
    }

    public List<ScheduledSurgery> getScheduledSurgeries() {
        return scheduledSurgeries;
    }

    public void setScheduledSurgeries(List<ScheduledSurgery> scheduledSurgeries) {
        this.scheduledSurgeries = scheduledSurgeries;
    }

    public HardSoftScore getScoreSolver() {
        return scoreSolver;
    }

    public void setScoreSolver(HardSoftScore scoreSolver) {
        this.scoreSolver = scoreSolver;
    }

    public void setSolverStatus(SolverStatus solverStatus) {
        this.solverStatus = solverStatus;
    }

    /*
    public String getAllScheduledSurgeries() {
        StringBuilder scheduledSurgeriesInformation = new StringBuilder();
        List<ScheduledSurgery> scheduledSurgeries = this.getScheduledSurgeries();
        for (ScheduledSurgery scheduledSurgery: scheduledSurgeries) {
            scheduledSurgeriesInformation.append(scheduledSurgery.getInformationScheduledSurgery());
            scheduledSurgeriesInformation.append("\n");
        }
        return scheduledSurgeriesInformation.toString();
    }

     */
}
