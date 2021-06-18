package org.standrews.schedulingsurgeries.bootstrap;

import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;
import org.standrews.schedulingsurgeries.domain.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DataGenerator {
    @Transactional
    public void generateData(@Observes StartupEvent startupEvent) {
        /**
         * Opening and closing room
         */
        LocalDateTime openingOperatingRoom = LocalDateTime.of(2019, 11, 4, 7, 30);
        LocalDateTime closingOperationRoom = LocalDateTime.of(2019, 11, 8, 20, 30);

        List<Time> times = new ArrayList<>();
        times.add(new Time(openingOperatingRoom,closingOperationRoom));
        Time.persist(times);
        /**
         * Insurances
         */
        List<Insurance> insurances = new ArrayList<>();
        insurances.add(new Insurance("Unimed"));
        insurances.add(new Insurance("Sus"));
        Insurance.persist(insurances);
        /**
         * Patients
         */
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(102354,"NA","NA",insurances.get(0)));
        Patient.persist(patients);
        /**
         * Surgery Type
         */
        List<SurgeryType> surgeryTypeList = new ArrayList<>();
        surgeryTypeList.add(new SurgeryType("E", "Elective"));
        surgeryTypeList.add(new SurgeryType("A", "Ambulatory"));
        Surgery.persist(surgeryTypeList);
        /**
         * Anesthetist
         */
        List<Anesthetist> anesthetists = new ArrayList<>();
        anesthetists.add(new Anesthetist(151, "NA","NA"));
        Anesthetist.persist(anesthetists);
        /**
         * Anesthesia Type
         */
        List<AnesthesiaType> anesthesiaTypes = new ArrayList<>();
        anesthesiaTypes.add(new AnesthesiaType(1));
        AnesthesiaType.persist(anesthesiaTypes);
        /**
         * Specialities
         */
        List<Speciality> specialities = new ArrayList<>();
        specialities.add(new Speciality("Neurocirurgia"));
        Speciality.persist(specialities);
        /**
         * Procedure
         */
        List<Procedure> procedures = new ArrayList<>();
        procedures.add(new Procedure("Traqueostomia", specialities.get(0)));
        Procedure.persist(procedures);
        /**
         * Surgeons
         */
        List<Surgeon> surgeons = new ArrayList<>();
        surgeons.add(new Surgeon(96922,"NA","NA",specialities.get(0)));
        Surgeon.persist(surgeons);
        /**
         * Rooms
         */
        List <OperatingRoom> operatingRooms = new ArrayList<>();
        operatingRooms.add(new OperatingRoom("Centro Cirúrgico Sala 6 6", times.get(0)));
        operatingRooms.add(new OperatingRoom("Centro Cirúrgico Sala 4 4", times.get(0)));
        operatingRooms.add(new OperatingRoom("Centro Cirúrgico Sala 3", times.get(0)));
        operatingRooms.add(new OperatingRoom("Centro Cirúrgico Sala 1", times.get(0)));
        operatingRooms.add(new OperatingRoom("Centro Cirúrgico Sala 5", times.get(0)));
        operatingRooms.add(new OperatingRoom("Centro Cirúrgico Sala 2", times.get(0)));
        operatingRooms.add(new OperatingRoom("Hemodinâmica Sala Hemod", times.get(0)));
        operatingRooms.add(new OperatingRoom("Centro Cirúrgico Ambulatorial  Sala 3 03", times.get(0)));
        operatingRooms.add(new OperatingRoom("Centro Cirúrgico Ambulatorial  Sala 1 01", times.get(0)));
        operatingRooms.add(new OperatingRoom("Hemodinâmica 1", times.get(0)));
        OperatingRoom.persist(operatingRooms);

        List <Surgery> surgeries = new ArrayList<>();
        surgeries.add(new Surgery(patients.get(0),surgeons.get(0),anesthesiaTypes.get(0),anesthetists.get(0),surgeryTypeList.get(0),procedures.get(0),51));
        Surgery.persist(surgeries);
    }
}
