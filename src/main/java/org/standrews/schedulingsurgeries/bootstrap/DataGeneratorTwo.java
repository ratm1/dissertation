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
         * Patients (DONE)
         */
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(1112,"NA","NA"));
        patients.add(new Patient(2213,"NA","NA"));
        patients.add(new Patient(3314,"NA","NA"));
        Patient.persist(patients);
        /**
         * Surgery Type (DONE)
         */
        List<SurgeryType> surgeryTypeList = new ArrayList<>();
        surgeryTypeList.add(new SurgeryType("E", "Elective"));
        surgeryTypeList.add(new SurgeryType( "A", "Ambulatoria"));
        Surgery.persist(surgeryTypeList);
        /**
         * Anesthetist (DONE)
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
         * Insurances (DONE)
         */
        List<Insurance> insurances = new ArrayList<>();
        insurances.add(new Insurance("Particular"));
        insurances.add(new Insurance("Sus"));
        insurances.add(new Insurance("Unimed"));
        Insurance.persist(insurances);
        /**
         * Specialities (DONE)
         */
        List<Speciality> specialities = new ArrayList<>();
        specialities.add(new Speciality("Obstetrica"));
        specialities.add(new Speciality("Cirurgia Geral"));
        specialities.add(new Speciality("Ortopedia/Traumatologia"));
        Speciality.persist(specialities);
        /**
         * Procedure (DONE)
         */
        List<Procedure> procedures = new ArrayList<>();
        procedures.add(new Procedure(234, specialities.get(0), "Cesariana (feto unico)"));
        procedures.add(new Procedure(567, specialities.get(1), "Resseccao de Tumor de Partes Moles"));
        procedures.add(new Procedure(891, specialities.get(2), "Descolamento Epifisario do Umero - Tratamento Cirurgico"));
        Procedure.persist(procedures);
        /**
         * Surgeons (DONE)
         */
        List<Surgeon> surgeons = new ArrayList<>();
        surgeons.add(new Surgeon(198,"NA","NA", specialities.get(0)));
        surgeons.add(new Surgeon(197, "NA", "NA", specialities.get(1)));
        surgeons.add(new Surgeon(196, "NA", "NA", specialities.get(2)));
        Surgeon.persist(surgeons);
        /**
         * Rooms (DONE)
         */
        List <OperatingRoom> operatingRooms = new ArrayList<>();
        operatingRooms.add(new OperatingRoom("Centro Cirúrgico Sala 3", openingOperatingRoom, closingOperationRoom));
        operatingRooms.add(new OperatingRoom("Centro Cirúrgico Sala 5", openingOperatingRoom, closingOperationRoom));
        OperatingRoom.persist(operatingRooms);
        /**
         * Surgeries
         */
        List <Surgery> surgeries = new ArrayList<>();
        surgeries.add(new Surgery(patients.get(0), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), insurances.get(0), procedures.get(0),  50));
        surgeries.add(new Surgery(patients.get(1), surgeons.get(1), anesthesiaTypes.get(1), anesthetists.get(1),  surgeryTypeList.get(0), insurances.get(1), procedures.get(1),  45));
        surgeries.add(new Surgery(patients.get(1), surgeons.get(0), anesthesiaTypes.get(0), anesthetists.get(0),  surgeryTypeList.get(0), insurances.get(0), procedures.get(2),  65));
        Surgery.persist(surgeries);
        /**
         * Scheduled surgery
         */
        List <ScheduledSurgery> scheduledSurgeries = new ArrayList<>();
        scheduledSurgeries = setScheduleSurgeries(scheduledSurgeries, surgeries);
        ScheduledSurgery.persist(scheduledSurgeries);
    }

    public List <ScheduledSurgery> setScheduleSurgeries(List <ScheduledSurgery> scheduledSurgeries, List <Surgery> surgeries) {
        for (Surgery eachSurgery: surgeries) {
            scheduledSurgeries.add(new ScheduledSurgery(eachSurgery));
        }
        return scheduledSurgeries;
    }

}
