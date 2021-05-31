package org.standrews.schedulingsurgeries.bootstrap;

import io.quarkus.runtime.StartupEvent;

import org.standrews.schedulingsurgeries.domain.OperatingRoom;
import org.standrews.schedulingsurgeries.domain.ScheduledSurgery;
import org.standrews.schedulingsurgeries.domain.Surgery;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DataGenerator {
    @Transactional
    public void generateData(@Observes StartupEvent startupEvent) {
        /*
        DateTime openingTime = new DateTime(2021, 06, 14, 8, 30);
        DateTime closingTime = new DateTime(2021, 06, 18, 21, 00);
         */

        LocalDateTime openingOperatingRoom = LocalDateTime.of(2021, 06, 14, 8, 30);
        LocalDateTime closingOperationRoom = LocalDateTime.of(2021, 06, 14, 20, 00);


        List <OperatingRoom> operatingRooms = new ArrayList<>();
        /*
        operatingRooms.add(new OperatingRoom("Centro Cirúrgico Sala 3", "25-05-2021 07:30","25-05-2021 20:00"));
        operatingRooms.add(new OperatingRoom("Centro Cirúrgico Sala 5", "25-05-2021 07:30","25-05-2021 20:00"));
         */
        operatingRooms.add(new OperatingRoom("Centro Cirúrgico Sala 3", openingOperatingRoom, closingOperationRoom));
        operatingRooms.add(new OperatingRoom("Centro Cirúrgico Sala 5", openingOperatingRoom, closingOperationRoom));
        OperatingRoom.persist(operatingRooms);

        List <Surgery> surgeries = new ArrayList<>();
        surgeries.add(new Surgery("patient101", "Dr. Alice", "2", "anesthetist101",  "Oncologist", "E", "Unimed", "Resection of the Mammary Sector",  50));
        surgeries.add(new Surgery("patient102", "Dr. Alex", "2", "anesthetist102",  "General surgery", "E", "Unimed", "Surgical Abrasion With Cryotherapy",  45));
        surgeries.add(new Surgery("patient103", "Dr. Turin", "2", "anesthetist103",   "Surgical Urology", "E", "Unimed", "Bilateral Hydrocele",  65));
        surgeries.add(new Surgery("patient104", "Dr. Marie", "2", "anesthetist104",   "General surgery", "E", "Unimed", "Diagnostic Laparoscopy",  50));
        surgeries.add(new Surgery("patient105", "Dr. Tesla", "2", "anesthetist105",  "Oncologist", "E", "Unimed", "Exeresis of Skin Tumor",  130));
        surgeries.add(new Surgery("patient106", "Dr. Irene", "2", "anesthetist106",   "Orthopedics", "E", "Unimed", "Partial Hip Prosthesis",  35));
        surgeries.add(new Surgery("patient107", "Dr. Andrews", "2", "anesthetist107",  "Obstetric", "E", "Unimed", "Caesarean section (single fetus)",  45));
        surgeries.add(new Surgery("patient108", "Dr. Alice", "2", "anesthetist108",  "Oncologist", "E", "Unimed", "Resection of the Mammary Sector",  50));
        surgeries.add(new Surgery("patient109", "Dr. Alex", "2", "anesthetist109",  "General surgery", "E", "Unimed", "Surgical Abrasion With Cryotherapy",  45));
        surgeries.add(new Surgery("patient110", "Dr. Turin", "2", "anesthetist110",  "Surgical Urology", "E", "Unimed", "Bilateral Hydrocele",  65));
        surgeries.add(new Surgery("patient101", "Dr. Alice", "2", "anesthetist101",  "Oncologist", "E", "Unimed", "Resection of the Mammary Sector",  50));
        surgeries.add(new Surgery("patient102", "Dr. Alex", "2", "anesthetist102",  "General surgery", "E", "Unimed", "Surgical Abrasion With Cryotherapy",  45));
        surgeries.add(new Surgery("patient103", "Dr. Turin", "2", "anesthetist103",   "Surgical Urology", "E", "Unimed", "Bilateral Hydrocele",  65));
        surgeries.add(new Surgery("patient104", "Dr. Marie", "2", "anesthetist104",   "General surgery", "E", "Unimed", "Diagnostic Laparoscopy",  50));
        surgeries.add(new Surgery("patient105", "Dr. Tesla", "2", "anesthetist105",  "Oncologist", "E", "Unimed", "Exeresis of Skin Tumor",  130));
        surgeries.add(new Surgery("patient106", "Dr. Irene", "2", "anesthetist106",   "Orthopedics", "E", "Unimed", "Partial Hip Prosthesis",  35));
        Surgery.persist(surgeries);

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
