package org.standrews.schedulingsurgeries.rest;


import org.joda.time.DateTime;
import org.optaplanner.core.api.score.ScoreManager;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.SolverJob;
import org.optaplanner.core.api.solver.SolverManager;
import org.optaplanner.core.api.solver.SolverStatus;
import org.standrews.schedulingsurgeries.domain.OperatingRoom;
import org.standrews.schedulingsurgeries.domain.ScheduledSurgery;
import org.standrews.schedulingsurgeries.domain.Surgery;
import org.standrews.schedulingsurgeries.domain.TimeTable;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

@Path("/timeTable")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TimeTableResource {

    private static final Long SINGLETON_TIME_TABLE_ID = 1L;

    @Inject
    SolverManager<TimeTable, Long> solverManager;

    @Inject
    ScoreManager<TimeTable, HardSoftScore> scoreManager;

    SolverJob<TimeTable, Long> solverJob;

    @GET
    public TimeTable getTimeTable(){
        SolverStatus solverStatus = getSolverStatus();
        TimeTable solution = findById(SINGLETON_TIME_TABLE_ID);
        scoreManager.updateScore(solution);
        solution.setSolverStatus(solverStatus);
        return solution;
    }

    public SolverStatus getSolverStatus() {
        return solverManager.getSolverStatus(SINGLETON_TIME_TABLE_ID);
    }

    @GET
    @Path("/solution")
    public TimeTable getSolution() throws ExecutionException, InterruptedException {
        TimeTable solution = solverJob.getFinalBestSolution();
        return solution;
    }

    @Transactional
    protected TimeTable findById(Long id) {
        return new TimeTable(
                OperatingRoom.listAll(),
                Surgery.listAll(),
                ScheduledSurgery.listAll());
    }

    @POST
    @Path("/solve")
    @Transactional
    public void solve() {
        solverJob = solverManager.solve(SINGLETON_TIME_TABLE_ID, findById(SINGLETON_TIME_TABLE_ID));
    }

    @POST
    @Path("/stopSolving")
    public void stopSolving() {
        solverManager.terminateEarly(SINGLETON_TIME_TABLE_ID);
    }

}
