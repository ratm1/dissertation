package org.standrews.schedulingsurgeries.bootstrap;

import io.quarkus.runtime.StartupEvent;
import org.standrews.schedulingsurgeries.domain.*;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DataGeneratorTwo {
    @Transactional
    public void generateData(@Observes StartupEvent startupEvent) {
        /**
         * Opening and closing room
         */
        LocalDateTime openingOperatingRoom = LocalDateTime.of(2021, 06, 14, 8, 30);
        LocalDateTime closingOperationRoom = LocalDateTime.of(2021, 06, 18, 20, 00);
        /**
         * FIX THIS: REVIEW TO MAKE A POST REQUEST FROM THE UI
         */
        List<Time> times = new ArrayList<>();
        times.add(new Time(openingOperatingRoom,closingOperationRoom));
        Time.persist(times);
        /**
         * Insurances
         */
        List<Insurance> insurances = new ArrayList<>();
        insurances.add(new Insurance("Particular"));
        insurances.add(new Insurance("Sus"));
        insurances.add(new Insurance("Unimed"));
        Insurance.persist(insurances);
        /**
         * Patients (DONE)
         */
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(1112,"NA","NA", insurances.get(0)));
        patients.add(new Patient(2213,"NA","NA", insurances.get(0)));
        patients.add(new Patient(3314,"NA","NA", insurances.get(0)));
        Patient.persist(patients);
        /**
         * Surgery Type (DONE)
         */
        List<SurgeryType> surgeryTypeList = new ArrayList<>();
        surgeryTypeList.add(new SurgeryType("E", "Elective"));
        Surgery.persist(surgeryTypeList);
        /**
         * Anesthetist
         */
        List<Anesthetist> anesthetists = new ArrayList<>();
        anesthetists.add(new Anesthetist(234, "NA","NA"));
        anesthetists.add(new Anesthetist(456, "NA", "NA"));
        Anesthetist.persist(anesthetists);
        /**
         * Anesthesia Type (DONE)
         */
        List<AnesthesiaType> anesthesiaTypes = new ArrayList<>();
        anesthesiaTypes.add(new AnesthesiaType(10));
        anesthesiaTypes.add(new AnesthesiaType(16));
        AnesthesiaType.persist(anesthesiaTypes);

        /**
         * Specialities
         */
        List<Speciality> specialities = new ArrayList<>();
        specialities.add(new Speciality("Obstetrica"));
        specialities.add(new Speciality("Cirurgia Geral"));
        specialities.add(new Speciality("Ortopedia/Traumatologia"));
        Speciality.persist(specialities);
        /**
         * Procedure
         */
        List<Procedure> procedures = new ArrayList<>();
        procedures.add(new Procedure(234, specialities.get(0), "Cesariana (feto unico)"));
        procedures.add(new Procedure(567, specialities.get(1), "Resseccao de Tumor de Partes Moles"));
        procedures.add(new Procedure(891, specialities.get(2), "Descolamento Epifisario do Umero - Tratamento Cirurgico"));
        Procedure.persist(procedures);
        /**
         * Surgeons
         */
        List<Surgeon> surgeons = new ArrayList<>();
        surgeons.add(new Surgeon(198,"NA","NA", specialities.get(0)));
        surgeons.add(new Surgeon(197, "NA", "NA", specialities.get(1)));
        surgeons.add(new Surgeon(196, "NA", "NA", specialities.get(2)));
        Surgeon.persist(surgeons);
        /**
         * Rooms
         */
        /*
        List <OperatingRoom> operatingRooms = new ArrayList<>();
        operatingRooms.add(new OperatingRoom("Centro Cirúrgico Sala 3", openingOperatingRoom, closingOperationRoom));
        operatingRooms.add(new OperatingRoom("Centro Cirúrgico Sala 5", openingOperatingRoom, closingOperationRoom));
        OperatingRoom.persist(operatingRooms);
         */
        List <OperatingRoom> operatingRooms = new ArrayList<>();
        operatingRooms.add(new OperatingRoom("Centro Cirúrgico Sala 3", times.get(0)));
        operatingRooms.add(new OperatingRoom("Centro Cirúrgico Sala 5", times.get(0)));
        operatingRooms.add(new OperatingRoom("Centro Cirúrgico Sala 7 7", times.get(0)));
        operatingRooms.add(new OperatingRoom("Centro Cirúrgico Sala 6 6", times.get(0)));
        OperatingRoom.persist(operatingRooms);
        /**
         * Surgeries
         */
        List <Surgery> surgeries = new ArrayList<>();
        surgeries.add(new Surgery(patients.get(0), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(0),  50));
        surgeries.add(new Surgery(patients.get(1), surgeons.get(1), anesthesiaTypes.get(1), anesthetists.get(1),  surgeryTypeList.get(0), procedures.get(1),  45));
        surgeries.add(new Surgery(patients.get(1), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(2),  65));

        /*
        surgeries.add(new Surgery(patients.get(0), surgeons.get(2), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(0),  100));
        surgeries.add(new Surgery(patients.get(2), surgeons.get(1), anesthesiaTypes.get(1), anesthetists.get(1),  surgeryTypeList.get(0), procedures.get(1),  65));
        surgeries.add(new Surgery(patients.get(1), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(2),  65));

        surgeries.add(new Surgery(patients.get(0), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(0),  50));
        surgeries.add(new Surgery(patients.get(1), surgeons.get(1), anesthesiaTypes.get(1), anesthetists.get(1),  surgeryTypeList.get(0), procedures.get(1),  45));
        surgeries.add(new Surgery(patients.get(1), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(2),  65));

        surgeries.add(new Surgery(patients.get(0), surgeons.get(2), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(0),  100));
        surgeries.add(new Surgery(patients.get(2), surgeons.get(1), anesthesiaTypes.get(1), anesthetists.get(1),  surgeryTypeList.get(0), procedures.get(1),  65));
        surgeries.add(new Surgery(patients.get(1), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(2),  65));

        surgeries.add(new Surgery(patients.get(0), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(0),  150));
        surgeries.add(new Surgery(patients.get(1), surgeons.get(1), anesthesiaTypes.get(1), anesthetists.get(1),  surgeryTypeList.get(0), procedures.get(1),  45));
        surgeries.add(new Surgery(patients.get(1), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(2),  210));

        surgeries.add(new Surgery(patients.get(0), surgeons.get(2), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(0),  100));
        surgeries.add(new Surgery(patients.get(2), surgeons.get(1), anesthesiaTypes.get(1), anesthetists.get(1),  surgeryTypeList.get(0), procedures.get(1),  65));
        surgeries.add(new Surgery(patients.get(1), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(2),  165));

        surgeries.add(new Surgery(patients.get(0), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(0),  50));
        surgeries.add(new Surgery(patients.get(1), surgeons.get(1), anesthesiaTypes.get(1), anesthetists.get(1),  surgeryTypeList.get(0), procedures.get(1),  45));
        surgeries.add(new Surgery(patients.get(1), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(2),  180));

        surgeries.add(new Surgery(patients.get(0), surgeons.get(2), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(0),  100));
        surgeries.add(new Surgery(patients.get(2), surgeons.get(1), anesthesiaTypes.get(1), anesthetists.get(1),  surgeryTypeList.get(0), procedures.get(1),  165));
        surgeries.add(new Surgery(patients.get(1), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(2),  155));

        surgeries.add(new Surgery(patients.get(0), surgeons.get(2), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(0),  100));
        surgeries.add(new Surgery(patients.get(2), surgeons.get(1), anesthesiaTypes.get(1), anesthetists.get(1),  surgeryTypeList.get(0), procedures.get(1),  65));
        surgeries.add(new Surgery(patients.get(1), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(2),  65));

        surgeries.add(new Surgery(patients.get(0), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(0),  50));
        surgeries.add(new Surgery(patients.get(1), surgeons.get(1), anesthesiaTypes.get(1), anesthetists.get(1),  surgeryTypeList.get(0), procedures.get(1),  45));
        surgeries.add(new Surgery(patients.get(1), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(2),  65));

        surgeries.add(new Surgery(patients.get(0), surgeons.get(2), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(0),  100));
        surgeries.add(new Surgery(patients.get(2), surgeons.get(1), anesthesiaTypes.get(1), anesthetists.get(1),  surgeryTypeList.get(0), procedures.get(1),  65));
        surgeries.add(new Surgery(patients.get(1), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(2),  65));

        surgeries.add(new Surgery(patients.get(0), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(0),  150));
        surgeries.add(new Surgery(patients.get(1), surgeons.get(1), anesthesiaTypes.get(1), anesthetists.get(1),  surgeryTypeList.get(0), procedures.get(1),  45));
        surgeries.add(new Surgery(patients.get(1), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(2),  210));

        surgeries.add(new Surgery(patients.get(0), surgeons.get(2), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(0),  100));
        surgeries.add(new Surgery(patients.get(2), surgeons.get(1), anesthesiaTypes.get(1), anesthetists.get(1),  surgeryTypeList.get(0), procedures.get(1),  65));
        surgeries.add(new Surgery(patients.get(1), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(2),  165));

        surgeries.add(new Surgery(patients.get(0), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(0),  50));
        surgeries.add(new Surgery(patients.get(1), surgeons.get(1), anesthesiaTypes.get(1), anesthetists.get(1),  surgeryTypeList.get(0), procedures.get(1),  45));
        surgeries.add(new Surgery(patients.get(1), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(2),  180));

        surgeries.add(new Surgery(patients.get(0), surgeons.get(2), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(0),  100));
        surgeries.add(new Surgery(patients.get(2), surgeons.get(1), anesthesiaTypes.get(1), anesthetists.get(1),  surgeryTypeList.get(0), procedures.get(1),  165));
        surgeries.add(new Surgery(patients.get(1), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), procedures.get(2),  155));
        */

        Surgery.persist(surgeries);
        /**
         * Scheduled surgery
         */
        /*
        List <ScheduledSurgery> scheduledSurgeries = new ArrayList<>();
        scheduledSurgeries = setScheduleSurgeries(scheduledSurgeries, surgeries);
        ScheduledSurgery.persist(scheduledSurgeries);
         */
    }

    /*
    public List <ScheduledSurgery> setScheduleSurgeries(List <ScheduledSurgery> scheduledSurgeries, List <Surgery> surgeries) {
        for (Surgery eachSurgery: surgeries) {
            scheduledSurgeries.add(new ScheduledSurgery(eachSurgery));
        }
        return scheduledSurgeries;
    }
     */

}
