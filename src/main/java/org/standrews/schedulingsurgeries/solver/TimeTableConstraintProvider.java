package org.standrews.schedulingsurgeries.solver;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;
import org.standrews.schedulingsurgeries.domain.ScheduledSurgery;

public class TimeTableConstraintProvider  implements ConstraintProvider {
    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[] {
                operatingRoomConflict(constraintFactory),
                availableTimeOperatingTheater(constraintFactory)
        };
    }

    private Constraint operatingRoomConflict(ConstraintFactory constraintFactory) {
        return constraintFactory.from(ScheduledSurgery.class)
                .join(ScheduledSurgery.class,
                        Joiners.equal(ScheduledSurgery::getOperatingRoom),
                        Joiners.overlapping(ScheduledSurgery::getStartingTimeSurgery, ScheduledSurgery::getFinishingTimeSurgery),
                        Joiners.lessThan(ScheduledSurgery::getScheduleSurgeryId))
                .penalize("Conflict operating room", HardSoftScore.ONE_HARD);
    }


    private Constraint availableTimeOperatingTheater(ConstraintFactory constraintFactory) {
        return constraintFactory.from(ScheduledSurgery.class)
                .filter((scheduledSurgery -> scheduledSurgery.availableTime() == false))
                .penalize("Conflict unavailable time", HardSoftScore.ONE_HARD);
    }
}
