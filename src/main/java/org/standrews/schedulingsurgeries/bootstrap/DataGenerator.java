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
        /**
         * FIX THIS: REVIEW TO MAKE A POST REQUEST FROM THE UI
         */
        List<Time> times = new ArrayList<>();
        times.add(new Time(openingOperatingRoom,closingOperationRoom));
        Time.persist(times);
        /**
         * Insurances (DONE)
         */
        List<Insurance> insurances = new ArrayList<>();
        insurances.add(new Insurance("Unimed"));
        insurances.add(new Insurance("Sus"));
        insurances.add(new Insurance("Central de Convênios"));
        insurances.add(new Insurance("Particular"));
        insurances.add(new Insurance("IPE"));
        insurances.add(new Insurance("Bradesco"));
        insurances.add(new Insurance("Plano São Camilo"));
        Insurance.persist(insurances);
        /**
         * Patients
         */
        /** UNIQUE PATIENTS
         * WEEK 1
         * 2019-11-04 07:30:00
         * 2019-11-08 20:00:00
         */
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(102354,"NA","NA",insurances.get(0)));
        patients.add(new Patient(708897,"NA","NA",insurances.get(1)));
        patients.add(new Patient(957493,"NA","NA",insurances.get(2)));
        patients.add(new Patient(863810,"NA","NA",insurances.get(1)));
        patients.add(new Patient(220202,"NA","NA",insurances.get(0)));
        patients.add(new Patient(946932,"NA","NA",insurances.get(0)));
        patients.add(new Patient(768073,"NA","NA",insurances.get(0)));
        patients.add(new Patient(90098,"NA","NA",insurances.get(0)));
        patients.add(new Patient(935425,"NA","NA",insurances.get(0)));
        patients.add(new Patient(105458,"NA","NA",insurances.get(1)));
        patients.add(new Patient(21053,"NA","NA",insurances.get(0)));
        patients.add(new Patient(837840,"NA","NA",insurances.get(3)));
        patients.add(new Patient(953294,"NA","NA",insurances.get(2)));
        patients.add(new Patient(48853,"NA","NA",insurances.get(1)));
        patients.add(new Patient(339882,"NA","NA",insurances.get(0)));
        patients.add(new Patient(718513,"NA","NA",insurances.get(1)));
        patients.add(new Patient(910786,"NA","NA",insurances.get(0)));
        patients.add(new Patient(957988,"NA","NA",insurances.get(0)));
        patients.add(new Patient(749313,"NA","NA",insurances.get(2)));
        patients.add(new Patient(938270,"NA","NA",insurances.get(4)));
        patients.add(new Patient(17311,"NA","NA",insurances.get(1)));
        patients.add(new Patient(69889,"NA","NA",insurances.get(1)));
        patients.add(new Patient(384472,"NA","NA",insurances.get(0)));
        patients.add(new Patient(892923,"NA","NA",insurances.get(2)));
        patients.add(new Patient(839238,"NA","NA",insurances.get(1)));
        patients.add(new Patient(938842,"NA","NA",insurances.get(1)));
        patients.add(new Patient(957986,"NA","NA",insurances.get(0)));
        patients.add(new Patient(12185,"NA","NA",insurances.get(4)));
        patients.add(new Patient(845137,"NA","NA",insurances.get(2)));
        patients.add(new Patient(59795,"NA","NA",insurances.get(0)));
        patients.add(new Patient(802515,"NA","NA",insurances.get(1)));
        patients.add(new Patient(66114,"NA","NA",insurances.get(0)));
        patients.add(new Patient(928196,"NA","NA",insurances.get(3)));
        patients.add(new Patient(59529,"NA","NA",insurances.get(1)));
        patients.add(new Patient(178589,"NA","NA",insurances.get(0)));
        patients.add(new Patient(124016,"NA","NA",insurances.get(2)));
        patients.add(new Patient(946140,"NA","NA",insurances.get(3)));
        patients.add(new Patient(3090,"NA","NA",insurances.get(1)));
        patients.add(new Patient(753428,"NA","NA",insurances.get(1)));
        patients.add(new Patient(248481,"NA","NA",insurances.get(1)));
        patients.add(new Patient(5656,"NA","NA",insurances.get(2)));
        patients.add(new Patient(771595,"NA","NA",insurances.get(1)));
        patients.add(new Patient(113481,"NA","NA",insurances.get(4)));
        patients.add(new Patient(892739,"NA","NA",insurances.get(1)));
        patients.add(new Patient(896091,"NA","NA",insurances.get(1)));
        patients.add(new Patient(166324,"NA","NA",insurances.get(0)));
        patients.add(new Patient(955216,"NA","NA",insurances.get(2)));
        patients.add(new Patient(829175,"NA","NA",insurances.get(1)));
        patients.add(new Patient(445374,"NA","NA",insurances.get(1)));
        patients.add(new Patient(957989,"NA","NA",insurances.get(0)));
        patients.add(new Patient(26723,"NA","NA",insurances.get(1)));
        patients.add(new Patient(911717,"NA","NA",insurances.get(1)));
        patients.add(new Patient(31524,"NA","NA",insurances.get(1)));
        patients.add(new Patient(955446,"NA","NA",insurances.get(1)));
        patients.add(new Patient(914912,"NA","NA",insurances.get(1)));
        patients.add(new Patient(764273,"NA","NA",insurances.get(1)));
        patients.add(new Patient(930362,"NA","NA",insurances.get(1)));
        patients.add(new Patient(751699,"NA","NA",insurances.get(1)));
        patients.add(new Patient(763193,"NA","NA",insurances.get(0)));
        patients.add(new Patient(712794,"NA","NA",insurances.get(1)));
        patients.add(new Patient(673985,"NA","NA",insurances.get(1)));
        patients.add(new Patient(139630,"NA","NA",insurances.get(1)));
        patients.add(new Patient(138207,"NA","NA",insurances.get(1)));
        patients.add(new Patient(51919,"NA","NA",insurances.get(3)));
        patients.add(new Patient(820538,"NA","NA",insurances.get(1)));
        patients.add(new Patient(912725,"NA","NA",insurances.get(1)));
        patients.add(new Patient(79824,"NA","NA",insurances.get(0)));
        patients.add(new Patient(711545,"NA","NA",insurances.get(2)));
        patients.add(new Patient(669185,"NA","NA",insurances.get(2)));
        patients.add(new Patient(839657,"NA","NA",insurances.get(0)));
        patients.add(new Patient(153823,"NA","NA",insurances.get(3)));
        patients.add(new Patient(163954,"NA","NA",insurances.get(2)));
        patients.add(new Patient(749250,"NA","NA",insurances.get(0)));
        patients.add(new Patient(797725,"NA","NA",insurances.get(0)));
        patients.add(new Patient(169824,"NA","NA",insurances.get(0)));
        patients.add(new Patient(714374,"NA","NA",insurances.get(2)));
        patients.add(new Patient(933140,"NA","NA",insurances.get(3)));
        patients.add(new Patient(8853,"NA","NA",insurances.get(1)));
        patients.add(new Patient(92088,"NA","NA",insurances.get(1)));
        patients.add(new Patient(162769,"NA","NA",insurances.get(2)));
        patients.add(new Patient(879360,"NA","NA",insurances.get(2)));
        patients.add(new Patient(958018,"NA","NA",insurances.get(2)));
        patients.add(new Patient(927472,"NA","NA",insurances.get(1)));
        patients.add(new Patient(866045,"NA","NA",insurances.get(1)));
        patients.add(new Patient(176782,"NA","NA",insurances.get(0)));
        patients.add(new Patient(841437,"NA","NA",insurances.get(1)));
        patients.add(new Patient(705850,"NA","NA",insurances.get(2)));
        patients.add(new Patient(19996,"NA","NA",insurances.get(2)));
        patients.add(new Patient(954979,"NA","NA",insurances.get(3)));
        patients.add(new Patient(955655,"NA","NA",insurances.get(0)));
        patients.add(new Patient(943793,"NA","NA",insurances.get(0)));
        patients.add(new Patient(955112,"NA","NA",insurances.get(4)));
        patients.add(new Patient(121192,"NA","NA",insurances.get(2)));
        patients.add(new Patient(867095,"NA","NA",insurances.get(1)));
        patients.add(new Patient(750312,"NA","NA",insurances.get(2)));
        patients.add(new Patient(61375,"NA","NA",insurances.get(2)));
        patients.add(new Patient(106680,"NA","NA",insurances.get(2)));
        patients.add(new Patient(893251,"NA","NA",insurances.get(2)));
        patients.add(new Patient(229594,"NA","NA",insurances.get(0)));
        patients.add(new Patient(956807,"NA","NA",insurances.get(5)));
        patients.add(new Patient(422,"NA","NA",insurances.get(1)));
        patients.add(new Patient(47582,"NA","NA",insurances.get(1)));
        patients.add(new Patient(947520,"NA","NA",insurances.get(4)));
        Patient.persist(patients);
        /**
         * Surgery Type (DONE) COMPLETE NOVEMBER MONTH
         */
        List<SurgeryType> surgeryTypeList = new ArrayList<>();
        surgeryTypeList.add(new SurgeryType("E", "Elective"));
        surgeryTypeList.add(new SurgeryType("A", "Ambulatory"));
        Surgery.persist(surgeryTypeList);
        /**
         * Anesthetist (DONE) UNIQUE ANESTHETIST - COMPLETE NOVEMBER MONTH
         */
        List<Anesthetist> anesthetists = new ArrayList<>();
        anesthetists.add(new Anesthetist(151, "NA","NA"));
        anesthetists.add(new Anesthetist(809636, "NA", "NA"));
        anesthetists.add(new Anesthetist(0, "NA","NA"));
        anesthetists.add(new Anesthetist(114, "NA","NA"));
        anesthetists.add(new Anesthetist(724057, "NA", "NA"));
        anesthetists.add(new Anesthetist(656596, "NA","NA"));
        anesthetists.add(new Anesthetist(111318, "NA", "NA"));
        anesthetists.add(new Anesthetist(160617, "NA","NA"));
        anesthetists.add(new Anesthetist(948456, "NA", "NA"));
        anesthetists.add(new Anesthetist(754590, "NA","NA"));
        Anesthetist.persist(anesthetists);
        /**
         * Anesthesia Type (DONE) ANESTHESIA TYPE CODE - COMPLETE NOVEMBER MONTH
         */
        List<AnesthesiaType> anesthesiaTypes = new ArrayList<>();
        anesthesiaTypes.add(new AnesthesiaType(1));
        anesthesiaTypes.add(new AnesthesiaType(12));
        anesthesiaTypes.add(new AnesthesiaType(5));
        anesthesiaTypes.add(new AnesthesiaType(2));
        anesthesiaTypes.add(new AnesthesiaType(10));
        anesthesiaTypes.add(new AnesthesiaType(0));
        anesthesiaTypes.add(new AnesthesiaType(9));
        anesthesiaTypes.add(new AnesthesiaType(18));
        anesthesiaTypes.add(new AnesthesiaType(14));
        anesthesiaTypes.add(new AnesthesiaType(3));
        anesthesiaTypes.add(new AnesthesiaType(6));
        anesthesiaTypes.add(new AnesthesiaType(25));
        anesthesiaTypes.add(new AnesthesiaType(16));
        AnesthesiaType.persist(anesthesiaTypes);
        /**
         * Specialities (DONE) - COMPLETE NOVEMBER MONTH
         */
        List<Speciality> specialities = new ArrayList<>();
        specialities.add(new Speciality("Proctologia"));
        specialities.add(new Speciality("Oncologia Cirúrgica"));
        specialities.add(new Speciality("Cirurgia Geral"));

        specialities.add(new Speciality("Clínica Médica"));
        specialities.add(new Speciality("Urologia Cirúrgica"));
        specialities.add(new Speciality("Neurocirurgia"));

        specialities.add(new Speciality("Ginecologia"));
        specialities.add(new Speciality("Deformidades Lábio-Palatais"));
        specialities.add(new Speciality("Ortopedia/Traumatologia"));

        specialities.add(new Speciality("Cirurgia Vascular"));
        specialities.add(new Speciality("Cirurgia Cabeça-Pescoço"));
        specialities.add(new Speciality("Obstetrica"));

        specialities.add(new Speciality("Cardiologia Interverncionista"));
        specialities.add(new Speciality("Cirurgia Plástica"));
        specialities.add(new Speciality("Cirurgia Cardiovascular"));

        specialities.add(new Speciality("Neurologia"));
        specialities.add(new Speciality("Otorrinolaringologia"));
        specialities.add(new Speciality("Cirurgia Geral / Proctologia"));

        specialities.add(new Speciality("Gastroenterologia"));
        specialities.add(new Speciality("Cardiologia"));

        Speciality.persist(specialities);
        /**
         * Procedure (NOT YET DONE)
         */
        /**
         * WEEK 1
         * 2019-11-04 07:30:00
         * 2019-11-08 20:00:00
         */
        List<Procedure> procedures = new ArrayList<>();
        procedures.add(new Procedure("Hemorroidectomia Fechada Sem Esfincterotomia",specialities.get(0)));
        procedures.add(new Procedure("Amputacao Conica de Colo de Utero C/ Colpectomia Em Oncologia",specialities.get(1)));
        procedures.add(new Procedure("Extensos Ferimentos, Cicatrizes Ou Tumores - Excisao E Retalhos Cutaneos da Regiao",specialities.get(1)));
        procedures.add(new Procedure("Retossigmoidectomia Abdominal Em Oncologia",specialities.get(2)));
        procedures.add(new Procedure("Colecistectomia Sem Colangiografia Por Videolaparoscopia",specialities.get(2)));
        procedures.add(new Procedure("Anorretomiomectomia",specialities.get(2)));
        procedures.add(new Procedure("Excisao E Sutura Com Plastica Em Z Na Pele Em Oncologia",specialities.get(1)));
        procedures.add(new Procedure("Fissura Anal ",specialities.get(2)));
        procedures.add(new Procedure("Laparoscopia Cirurgica Para Miomectomia, Salpingectomia, Ooforectomia",specialities.get(2)));
        procedures.add(new Procedure("Pieloplastia",specialities.get(4)));
        procedures.add(new Procedure("Segmentectomia de Mama Em Oncologia",specialities.get(1)));
        procedures.add(new Procedure("Fistula Anal Em Dois Tempos",specialities.get(2)));
        procedures.add(new Procedure("Mastectomia Radical C/ Linfadenectomia Axilar Em Oncologia",specialities.get(1)));
        procedures.add(new Procedure("Gastroplastia Para Obesidade Morbida - Por Videolaparoscopia",specialities.get(2)));
        procedures.add(new Procedure("Tumor Cerebral - Microcirurgia",specialities.get(5)));
        procedures.add(new Procedure("Histerectomia Total (qualquer Via)",specialities.get(6)));
        procedures.add(new Procedure("Palatoplastia Total",specialities.get(7)));
        procedures.add(new Procedure("Labioplastia Unilateral Em Dois Tempos - Sus",specialities.get(7)));
        procedures.add(new Procedure("Artrodese Occipto-cervical (c2) Posterior",specialities.get(5)));
        procedures.add(new Procedure("Protese de Joelho Unilateral",specialities.get(8)));
        procedures.add(new Procedure("Prostatectomia Radical",specialities.get(4)));
        procedures.add(new Procedure("Histerectomia Total Ampliada Em Oncologia",specialities.get(1)));
        procedures.add(new Procedure("Bocio Mergulhante: Extirpacao Por Acesso Cervico-toraci",specialities.get(3)));
        procedures.add(new Procedure("Retirada de Tumor de Colo Vesical Via Endoscopica",specialities.get(4)));
        procedures.add(new Procedure("Troca de Gerador Unicameral",specialities.get(9)));
        procedures.add(new Procedure("Traqueostomia",specialities.get(5)));
        procedures.add(new Procedure("Herniorrafia Crural - Unilateral Por Videolaparoscopia",specialities.get(2)));
        procedures.add(new Procedure("Microneurorrafia unica",specialities.get(8)));
        procedures.add(new Procedure("Nefrectomia Total Em Oncologia",specialities.get(4)));
        procedures.add(new Procedure("Cirurgia Ortognata de Maxilar (osteotomia Tipo Le Fort I)",specialities.get(2)));
        procedures.add(new Procedure("Prostatectomia Radical Por Vídeo",specialities.get(2)));
        procedures.add(new Procedure("Hidrocele Unilateral",specialities.get(4)));
        procedures.add(new Procedure("Procedimentos Sequenciais Em Oncologia",specialities.get(10)));
        procedures.add(new Procedure("Orquiectomia Unilateral Em Oncologia",specialities.get(4)));
        procedures.add(new Procedure("Pseudoartrose da Clavicula Unilateral",specialities.get(8)));
        procedures.add(new Procedure("Resseccao de Tumor de Partes Moles",specialities.get(10)));
        procedures.add(new Procedure("Retossigmoidectomia Abdominal",specialities.get(2)));
        procedures.add(new Procedure("Resseccao Alargada de Tumor de Intestino Em Oncologia",specialities.get(1)));
        procedures.add(new Procedure("Herniorrafia Inguinal Bilateral",specialities.get(2)));
        procedures.add(new Procedure("Hipospadia Distal - Tratamento Em 1 Tempo",specialities.get(2)));
        procedures.add(new Procedure("Extirpacao Multipla de Lesao da Pele Ou Tecido Celular Subcutaneo",specialities.get(1)));
        procedures.add(new Procedure("Cesariana (feto unico)",specialities.get(11)));
        procedures.add(new Procedure("Recolocacao de Eletrodo",specialities.get(12)));
        procedures.add(new Procedure("By Pass Femoro Popliteo Distal",specialities.get(9)));
        procedures.add(new Procedure("Palatoplastia Primária Em Paciente Com Anomalia Crânio E Bucomaxilofacial - Sus",specialities.get(7)));
        procedures.add(new Procedure("Reconstrucao C/ Retalho Miocutaneo (qualquer Parte) Em Oncologia",specialities.get(2)));
        procedures.add(new Procedure("Palatoplastia Com Enxerto Osseo",specialities.get(7)));
        procedures.add(new Procedure("Tratamento Cirurgico de Fratura da Extremidade/metafise Distal dos Ossos do Antebraco",specialities.get(8)));
        procedures.add(new Procedure("Lipoaspiracao E Lipoabdomen",specialities.get(13)));
        procedures.add(new Procedure("Revascularizacao do Miocardio",specialities.get(14)));
        procedures.add(new Procedure("Perineoplastia",specialities.get(6)));
        procedures.add(new Procedure("Conizacao de Colo Uterino",specialities.get(6)));
        procedures.add(new Procedure("Postectomia",specialities.get(4)));
        procedures.add(new Procedure("Herniorrafia Inguinal - Unilateral Por Videolaparoscopi",specialities.get(2)));
        procedures.add(new Procedure("Mamoplastia",specialities.get(2)));
        procedures.add(new Procedure("Procedimentos Sequenciais Em Neurocirurgia",specialities.get(5)));
        procedures.add(new Procedure("Herniorrafia Inguinal Unilateral",specialities.get(4)));
        procedures.add(new Procedure("Microcirurgia Otologica Em Paciente Com Anomalia Cranio E Bucomaxilofacial",specialities.get(7)));
        procedures.add(new Procedure("Artrodese Toraco-lombo-sacra Posterior Seis Niveis",specialities.get(18)));
        procedures.add(new Procedure("Retirada de Fio Transosseo",specialities.get(8)));
        procedures.add(new Procedure("Histerectomia Total Ampliada - Qualquer Via",specialities.get(6)));
        procedures.add(new Procedure("Lipoaspiracao Estetica (somente Particular)",specialities.get(13)));
        procedures.add(new Procedure("Reconstrucao Ligamentar Intra-articular do Joelho (cruzado Anterior)",specialities.get(8)));
        procedures.add(new Procedure("Timpanotomia Para Tubo de Ventilacao - Bilateral",specialities.get(19)));
        procedures.add(new Procedure("Rtu de Prostata",specialities.get(4)));
        procedures.add(new Procedure("Ressutura de Parede Abdominal",specialities.get(17)));
        procedures.add(new Procedure("Revisao Cirurgica de Protese de Ombro",specialities.get(8)));
        procedures.add(new Procedure("Varizes Ou Safenectomia Unilateral",specialities.get(9)));
        procedures.add(new Procedure("Amputacao de Perna",specialities.get(9)));
        procedures.add(new Procedure("Revascularizacao Por Ponte / Tromboendarterectomia de Outras Arterias Distais - Sus",specialities.get(12)));
        Procedure.persist(procedures);
        /**
         * Surgeons (NOT YET DONE)
         */
        /**
         * WEEK 1
         * 2019-11-04 07:30:00
         * 2019-11-08 20:00:00
         */
        List<Surgeon> surgeons = new ArrayList<>();
        surgeons.add(new Surgeon(117,"NA","NA",specialities.get(1)));
        surgeons.add(new Surgeon(134,"NA","NA",specialities.get(2)));
        surgeons.add(new Surgeon(144,"NA","NA",specialities.get(3)));
        surgeons.add(new Surgeon(194431,"NA","NA",specialities.get(2)));
        surgeons.add(new Surgeon(130,"NA","NA",specialities.get(4)));
        surgeons.add(new Surgeon(67408,"NA","NA",specialities.get(2)));
        surgeons.add(new Surgeon(620486,"NA","NA",specialities.get(5)));
        surgeons.add(new Surgeon(723915,"NA","NA",specialities.get(6)));
        surgeons.add(new Surgeon(190,"NA","NA",specialities.get(7)));
        surgeons.add(new Surgeon(104,"NA","NA",specialities.get(7)));
        surgeons.add(new Surgeon(224,"NA","NA",specialities.get(5)));
        surgeons.add(new Surgeon(878,"NA","NA",specialities.get(8)));
        surgeons.add(new Surgeon(501222,"NA","NA",specialities.get(3)));
        surgeons.add(new Surgeon(140,"NA","NA",specialities.get(9)));
        surgeons.add(new Surgeon(736743,"NA","NA",specialities.get(2)));
        surgeons.add(new Surgeon(844768,"NA","NA",specialities.get(8)));
        surgeons.add(new Surgeon(133,"NA","NA",specialities.get(4)));
        surgeons.add(new Surgeon(140772,"NA","NA",specialities.get(8)));
        surgeons.add(new Surgeon(94617,"NA","NA",specialities.get(2)));
        surgeons.add(new Surgeon(161,"NA","NA",specialities.get(11)));
        surgeons.add(new Surgeon(720344,"NA","NA",specialities.get(9)));
        surgeons.add(new Surgeon(192721,"NA","NA",specialities.get(7)));
        surgeons.add(new Surgeon(83736,"NA","NA",specialities.get(11)));
        surgeons.add(new Surgeon(326682,"NA","NA",specialities.get(7)));
        surgeons.add(new Surgeon(209891,"NA","NA",specialities.get(8)));
        surgeons.add(new Surgeon(162,"NA","NA",specialities.get(13)));
        surgeons.add(new Surgeon(185,"NA","NA",specialities.get(14)));
        surgeons.add(new Surgeon(115,"NA","NA",specialities.get(6)));
        surgeons.add(new Surgeon(96922,"NA","NA",specialities.get(2)));
        surgeons.add(new Surgeon(137,"NA","NA",specialities.get(11)));
        surgeons.add(new Surgeon(209,"NA","NA",specialities.get(6)));
        surgeons.add(new Surgeon(760843,"NA","NA",specialities.get(2)));
        surgeons.add(new Surgeon(215751,"NA","NA",specialities.get(2)));
        surgeons.add(new Surgeon(930624,"NA","NA",specialities.get(5)));
        surgeons.add(new Surgeon(920390,"NA","NA",specialities.get(7)));
        surgeons.add(new Surgeon(171283,"NA","NA",specialities.get(8)));
        surgeons.add(new Surgeon(431032,"NA","NA",specialities.get(11)));
        surgeons.add(new Surgeon(212991,"NA","NA",specialities.get(11)));
        surgeons.add(new Surgeon(766723,"NA","NA",specialities.get(16)));
        surgeons.add(new Surgeon(1033,"NA","NA",specialities.get(17)));
        surgeons.add(new Surgeon(308562,"NA","NA",specialities.get(9)));
        surgeons.add(new Surgeon(686289,"NA","NA",specialities.get(11)));
        Surgeon.persist(surgeons);
        /**
         * Rooms (DONE)
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

        /**
         * This part is for the surgeries in a weekly basis
         */
        List <Surgery> surgeries = new ArrayList<>();

        surgeries.add(new Surgery(patients.get(0),surgeons.get(0),anesthesiaTypes.get(0),anesthetists.get(0),surgeryTypeList.get(0),procedures.get(0),51));
        surgeries.add(new Surgery(patients.get(1),surgeons.get(3),anesthesiaTypes.get(0),anesthetists.get(1),surgeryTypeList.get(0),procedures.get(1),43));
        surgeries.add(new Surgery(patients.get(2),surgeons.get(0),anesthesiaTypes.get(0),anesthetists.get(1),surgeryTypeList.get(0),procedures.get(2),66));
        surgeries.add(new Surgery(patients.get(3),surgeons.get(0),anesthesiaTypes.get(1),anesthetists.get(1),surgeryTypeList.get(0),procedures.get(3),184));
        surgeries.add(new Surgery(patients.get(4),surgeons.get(1),anesthesiaTypes.get(0),anesthetists.get(0),surgeryTypeList.get(0),procedures.get(4),62 ));
        surgeries.add(new Surgery(patients.get(5),surgeons.get(2),anesthesiaTypes.get(0),anesthetists.get(1),surgeryTypeList.get(0),procedures.get(0),49 ));
        surgeries.add(new Surgery(patients.get(6),surgeons.get(1),anesthesiaTypes.get(0),anesthetists.get(0),surgeryTypeList.get(0),procedures.get(4),62 ));
        surgeries.add(new Surgery(patients.get(7),surgeons.get(2),anesthesiaTypes.get(0),anesthetists.get(0),surgeryTypeList.get(0),procedures.get(0),50 ));
        surgeries.add(new Surgery(patients.get(8),surgeons.get(9),anesthesiaTypes.get(0),anesthetists.get(1),surgeryTypeList.get(0),procedures.get(5),103));
        surgeries.add(new Surgery(patients.get(9),surgeons.get(3),anesthesiaTypes.get(2),anesthetists.get(2),surgeryTypeList.get(0),procedures.get(6),24 ));
        surgeries.add(new Surgery(patients.get(10),surgeons.get(2),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(7),66));
        surgeries.add(new Surgery(patients.get(11),surgeons.get(3),anesthesiaTypes.get(0),anesthetists.get(1),surgeryTypeList.get(0),procedures.get(8),166));
        surgeries.add(new Surgery(patients.get(12),surgeons.get(4),anesthesiaTypes.get(1),anesthetists.get(4),surgeryTypeList.get(0),procedures.get(9),144));
        surgeries.add(new Surgery(patients.get(13),surgeons.get(3),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(10),89));
        surgeries.add(new Surgery(patients.get(14),surgeons.get(2),anesthesiaTypes.get(0),anesthetists.get(4),surgeryTypeList.get(0),procedures.get(11),39));
        surgeries.add(new Surgery(patients.get(15),surgeons.get(0),anesthesiaTypes.get(0),anesthetists.get(1),surgeryTypeList.get(0),procedures.get(12),79));
        surgeries.add(new Surgery(patients.get(16),surgeons.get(5),anesthesiaTypes.get(0),anesthetists.get(4),surgeryTypeList.get(0),procedures.get(13),135));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),244));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),99 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),102));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),102));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),196));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),210));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),123));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),88 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),159));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),183));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),50 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),50 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),43 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),30 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),139));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),86 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),87 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),252));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),325));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),55 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),42 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),59 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),42 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),108));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),30 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),164));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),32 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),155));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),125));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),218));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),180));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),101));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),27 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),33 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),66 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),180));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),175));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),251));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),180));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),64 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),105));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),105));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),24 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),94 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),306));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),409));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),277));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),147));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),67 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),88 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),52 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),37 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),40 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),62 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),64 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),107));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),69 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),234));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),292));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),287));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),99 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),42 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),63 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),49 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),49 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),243));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),99 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),109));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),59 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),241));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),87 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),115));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),52 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),56 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),37 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),106));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),148));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),56 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),148));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),73 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),84 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),113));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),66 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),52 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),123));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),298));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),62 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),54 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),131));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),79 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),134));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),152));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),47 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),55 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),80 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),62 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),92 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),178));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),97 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),136));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),24 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),24 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),99 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),116));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),109));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),116));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),109));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),52 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),43 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),69 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),55 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),123));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),184));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),113));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),115));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),49 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),186));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),54 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),65 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),122));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),135));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),108));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),138));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),66 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),36 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),35 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),44 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),27 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),49 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),122));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),114));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),82 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),64 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),18 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),88 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),124));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),113));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),20 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),83 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),132));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),94 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),67 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),67 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),40 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),419));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),86 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),43 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),67 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),72 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),45 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),46 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),53 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),215));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),59 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),53 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),57 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),62 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),91 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),69 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),170));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),173));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),62 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),47 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),62 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),51 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),73 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),57 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),88 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),24 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),124));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),36 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),72 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),27 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),38 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),62 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),40 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),66 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),68 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),121));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),55 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),18 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),54 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),111));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),106));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),161));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),41 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),52 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),99 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),285));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),67 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),53 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),101));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),36 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),36 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),98 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),145));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),73 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),54 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),113));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),99 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),110));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),147));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),113));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),81 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),101));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),36 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),69 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),66 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),118));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),70 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),145));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),137));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),137));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),98 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),65 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),216));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),43 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),89 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),83 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),88 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),66 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),101));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),34 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),18 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),39 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),64 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),47 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),43 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),149));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),67 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),119));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),119));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),34 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),20 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),119));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),25 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),301));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),64 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),99 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),144));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),68 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),277));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),152));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),98 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),279));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),91 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),102));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),81 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),104));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),37 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),421));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),50 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),79 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),294));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),58 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),53 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),84 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),91 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),63 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),248));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),36 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),146));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),46 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),34 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),34 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),36 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),54 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),54 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),54 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),234));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),151));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),108));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),147));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),244));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),126));




        /**
         * WEEK 1
         * 2019-11-04 07:30:00
         * 2019-11-08 20:00:00
         */
        /**
         * patient, surgeon, anesthesia type, anesthetist, surgery type, procedure, duration
         */



        /*
        surgeries.add(new Surgery(patients.get(0),surgeons.get(0),anesthesiaTypes.get(0),anesthetists.get(0),surgeryTypeList.get(0),procedures.get(0),60));
        surgeries.add(new Surgery(patients.get(1),surgeons.get(3),anesthesiaTypes.get(0),anesthetists.get(1),surgeryTypeList.get(0),procedures.get(1),90));
        surgeries.add(new Surgery(patients.get(2),surgeons.get(0),anesthesiaTypes.get(0),anesthetists.get(1),surgeryTypeList.get(0),procedures.get(2),90));
        surgeries.add(new Surgery(patients.get(3),surgeons.get(0),anesthesiaTypes.get(1),anesthetists.get(1),surgeryTypeList.get(0),procedures.get(3),240));
        surgeries.add(new Surgery(patients.get(4),surgeons.get(1),anesthesiaTypes.get(0),anesthetists.get(0),surgeryTypeList.get(0),procedures.get(4),90));
        surgeries.add(new Surgery(patients.get(5),surgeons.get(2),anesthesiaTypes.get(0),anesthetists.get(1),surgeryTypeList.get(0),procedures.get(0),60));
        surgeries.add(new Surgery(patients.get(6),surgeons.get(1),anesthesiaTypes.get(0),anesthetists.get(0),surgeryTypeList.get(0),procedures.get(4),90));
        surgeries.add(new Surgery(patients.get(7),surgeons.get(2),anesthesiaTypes.get(0),anesthetists.get(0),surgeryTypeList.get(0),procedures.get(0),60));
        surgeries.add(new Surgery(patients.get(8),surgeons.get(9),anesthesiaTypes.get(0),anesthetists.get(1),surgeryTypeList.get(0),procedures.get(5),90));
        surgeries.add(new Surgery(patients.get(9),surgeons.get(3),anesthesiaTypes.get(2),anesthetists.get(2),surgeryTypeList.get(0),procedures.get(6),60));
        surgeries.add(new Surgery(patients.get(10),surgeons.get(2),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(7),90));
        surgeries.add(new Surgery(patients.get(11),surgeons.get(3),anesthesiaTypes.get(0),anesthetists.get(1),surgeryTypeList.get(0),procedures.get(8),120));
        surgeries.add(new Surgery(patients.get(12),surgeons.get(4),anesthesiaTypes.get(1),anesthetists.get(4),surgeryTypeList.get(0),procedures.get(9),90));
        surgeries.add(new Surgery(patients.get(13),surgeons.get(3),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(10),150));
        surgeries.add(new Surgery(patients.get(14),surgeons.get(2),anesthesiaTypes.get(0),anesthetists.get(4),surgeryTypeList.get(0),procedures.get(11),90));
        surgeries.add(new Surgery(patients.get(15),surgeons.get(0),anesthesiaTypes.get(0),anesthetists.get(1),surgeryTypeList.get(0),procedures.get(12),120));
        surgeries.add(new Surgery(patients.get(16),surgeons.get(5),anesthesiaTypes.get(0),anesthetists.get(4),surgeryTypeList.get(0),procedures.get(13),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),360));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),360));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),210));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),30 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),301));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),300));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),180));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),240));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),240));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),240));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),210));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),300));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),180));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),270));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),450));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),330));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),360));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),360));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),360));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),240));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),180));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),240));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),180));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        */

        /**
         * WEEK 2
         * 2019-11-11 07:30:00
         * 2019-11-15 20:00:00
         */

        /*
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),360));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),240));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),180));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),30 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),360));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),180));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),30 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),30 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),180));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),210));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),102));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),270));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),30 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),20 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),20 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),20 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),180));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),30 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),30 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),210));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),100));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),510));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),30 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),360));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),318));
        */

        /**
         * WEEK 3
         * 2019-11-18 07:30:00
         * 2019-11-22 20:00:00
         */

        /*
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),210));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),30 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),30 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),30 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),180));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),28 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),240));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),30 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),30 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),30 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),49 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),33 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),180));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),180));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),30 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),30 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),30 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),180));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),30 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),360));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),180));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),360));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),240));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),180));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),30 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),440));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),360));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),150));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),240));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),90 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),30 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),30 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60 ));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),240));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),240));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),120));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),180));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),180));
        surgeries.add(new Surgery(patients.get(17),surgeons.get(6),anesthesiaTypes.get(0),anesthetists.get(3),surgeryTypeList.get(0),procedures.get(14),60));
        */

        /**
         * WEEK 4
         * 2019-11-25 07:30:00
         * 2019-11-29 20:00:00
         */


        Surgery.persist(surgeries);
    }
}
