package org.standrews.schedulingsurgeries.view;

import org.json.JSONObject;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

public class InformationSurgeryView {
    private int surgeryId;
    private int patientId;
    private int surgeonId;
    private String specialityName;
    private String procedure;
    private int duration;


    public InformationSurgeryView(int surgeryId, int patientId, int surgeonId, String specialityName, String procedure,
                                  int duration) {
        this.surgeryId = surgeryId;
        this.patientId = patientId;
        this.surgeonId = surgeonId;
        this.specialityName = specialityName;
        this.procedure = procedure;
        this.duration = duration;
    }

    public int getSurgeryId() {
        return surgeryId;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getSurgeonId() {
        return surgeonId;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public String getProcedure() {
        String[] words = procedure.split("\\s");
        if (words.length > 3) {
            StringBuilder procedureShortFormat = new StringBuilder();
            procedureShortFormat.append(words[0]);
            procedureShortFormat.append(" ");
            procedureShortFormat.append(words[1]);
            procedureShortFormat.append(" ");
            procedureShortFormat.append(words[2]);
            procedureShortFormat.append("\n");
            for (int i = 3; i < words.length; i++) {
                procedureShortFormat.append(words[i]);
                procedureShortFormat.append(" ");
            }

            return procedureShortFormat.toString();
        }
        return procedure;
    }

    public int getDuration() {
        return duration;
    }
}

