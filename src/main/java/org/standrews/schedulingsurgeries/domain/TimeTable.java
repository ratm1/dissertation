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
    @ProblemFactCollectionProperty
    private List<Patient> patients;
    @ProblemFactCollectionProperty
    private List<SurgeryType> surgeryTypes;
    @ProblemFactCollectionProperty
    private List<Anesthetist> anesthetists;
    @ProblemFactCollectionProperty
    private List<AnesthesiaType> anesthesiaTypes;
    @PlanningEntityCollectionProperty
    private List<ScheduledSurgery> scheduledSurgeries;
    @PlanningScore
    private HardSoftScore scoreSolver;
    private SolverStatus solverStatus;

    public TimeTable(){
    }

    public TimeTable(List<OperatingRoom> operatingRooms, List<Surgery> surgeries, List<Patient> patients,
                     List<SurgeryType> surgeryTypes, List<Anesthetist> anesthetists, List<AnesthesiaType> anesthesiaTypes,
                     List<ScheduledSurgery> scheduledSurgeries) {
        setStartingTimeSurgeries();
        this.operatingRooms = operatingRooms;
        this.surgeries = surgeries;
        this.patients = patients;
        this.surgeryTypes = surgeryTypes;
        this.anesthetists = anesthetists;
        this.anesthesiaTypes =  anesthesiaTypes;
        this.scheduledSurgeries = scheduledSurgeries;
    }

    public List<LocalDateTime> getStartingTimeSurgeries() {
        return startingTimeSurgeries;
    }

    public void setStartingTimeSurgeries(List<LocalDateTime> startingTimeSurgeries) {
        this.startingTimeSurgeries = startingTimeSurgeries;
    }

    public List<AnesthesiaType> findAnesthesiaTypes() {
        return anesthesiaTypes;
    }

    public List<SurgeryType> findSurgeryTypes() {
        return surgeryTypes;
    }

    public List<Anesthetist> findAnesthetists() {
        return anesthetists;
    }

    public List<Patient> findThePatients() {
        return patients;
    }

    public void setStartingTimeSurgeries() {
        this.startingTimeSurgeries = new ArrayList<>();
        LocalDateTime openingOperatingRoom = LocalDateTime.of(2021, 06, 14, 8, 30);
        LocalDateTime closingOperationRoom = LocalDateTime.of(2021, 06, 18, 20, 00);
        while (openingOperatingRoom .isBefore(closingOperationRoom)) {
            startingTimeSurgeries.add(openingOperatingRoom );
            openingOperatingRoom  = openingOperatingRoom .plusMinutes(30);
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
