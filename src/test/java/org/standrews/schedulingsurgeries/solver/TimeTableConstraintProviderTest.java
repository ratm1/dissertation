package org.standrews.schedulingsurgeries.solver;

import org.junit.jupiter.api.Test;
import org.optaplanner.test.api.score.stream.ConstraintVerifier;
import org.standrews.schedulingsurgeries.domain.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TimeTableConstraintProviderTest {

    private final ConstraintVerifier<TimeTableConstraintProvider, TimeTable> constraintVerifier =
            ConstraintVerifier.build(new TimeTableConstraintProvider(), TimeTable.class, ScheduledSurgery.class);

    @Test
    public void operatingRoomConflict(){
        LocalDateTime openingOperatingRoom = LocalDateTime.of(2021, 06, 14, 8, 30);
        LocalDateTime closingOperationRoom = LocalDateTime.of(2021, 06, 18, 20, 00);

        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(11,"NA","NA"));
        patients.add(new Patient(22,"NA","NA"));

        List<SurgeryType> surgeryTypeList = new ArrayList<>();
        surgeryTypeList.add(new SurgeryType(123, "E", "Elective"));
        surgeryTypeList.add(new SurgeryType(234, "A", "Ambulatoria"));

        List<Speciality> specialities = new ArrayList<>();
        specialities.add(new Speciality("Obstetrica"));
        specialities.add(new Speciality("Cirurgia Geral"));
        specialities.add(new Speciality("Ortopedia/Traumatologia"));

        List<Surgeon> surgeons = new ArrayList<>();
        surgeons.add(new Surgeon(198,"NA","NA", specialities.get(0)));
        surgeons.add(new Surgeon(197, "NA", "NA", specialities.get(1)));

        List<AnesthesiaType> anesthesiaTypes = new ArrayList<>();
        anesthesiaTypes.add(new AnesthesiaType(10));
        anesthesiaTypes.add(new AnesthesiaType(16));

        List<Anesthetist> anesthetists = new ArrayList<>();
        anesthetists.add(new Anesthetist(234, "NA","NA"));
        anesthetists.add(new Anesthetist(456, "NA", "NA"));

        List<Insurance> insurances = new ArrayList<>();
        insurances.add(new Insurance("Particular"));
        insurances.add(new Insurance("Sus"));
        insurances.add(new Insurance("Unimed"));

        List<Procedure> procedures = new ArrayList<>();
        procedures.add(new Procedure(234, specialities.get(0), "Cesariana (feto unico)"));
        procedures.add(new Procedure(567, specialities.get(1), "Resseccao de Tumor de Partes Moles"));
        procedures.add(new Procedure(891, specialities.get(2), "Descolamento Epifisario do Umero - Tratamento Cirurgico"));

        List <OperatingRoom> operatingRooms = new ArrayList<>();
        operatingRooms.add(new OperatingRoom("Centro Cirúrgico Sala 3", openingOperatingRoom, closingOperationRoom));
        operatingRooms.add(new OperatingRoom("Centro Cirúrgico Sala 5", openingOperatingRoom, closingOperationRoom));

        Surgery surgeryOne = new Surgery(patients.get(0), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), insurances.get(0), procedures.get(0),  40);
        Surgery surgeryTwo = new Surgery(patients.get(1), surgeons.get(1), anesthesiaTypes.get(1), anesthetists.get(1),  surgeryTypeList.get(0), insurances.get(1), procedures.get(1),  40);

        LocalDateTime startTimeSurgery = LocalDateTime.of(2021, 06, 14, 10, 30);
        ScheduledSurgery scheduledSurgeryOne = new ScheduledSurgery(surgeryOne);
        ScheduledSurgery scheduledSurgeryTwo = new ScheduledSurgery(surgeryTwo);
        scheduledSurgeryOne.setStartingTimeSurgery(startTimeSurgery);
        scheduledSurgeryOne.setOperatingRoom(operatingRooms.get(0));
        scheduledSurgeryOne.setScheduleSurgeryId(121);
        scheduledSurgeryTwo.setStartingTimeSurgery(startTimeSurgery);
        scheduledSurgeryTwo.setOperatingRoom(operatingRooms.get(0));
        scheduledSurgeryTwo.setScheduleSurgeryId(234);

        constraintVerifier.verifyThat(TimeTableConstraintProvider::operatingRoomConflict)
                .given(scheduledSurgeryOne, scheduledSurgeryTwo)
                .penalizes(1);

    }
}
