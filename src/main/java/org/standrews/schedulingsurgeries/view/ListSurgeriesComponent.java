package org.standrews.schedulingsurgeries.view;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.HashMap;

public class ListSurgeriesComponent extends JComponent {
    private Graphics2D graphics;
    private ArrayList<InformationSurgeryView> informationSurgeryView;

    public ListSurgeriesComponent(ArrayList<InformationSurgeryView> informationSurgeryView) {
           this.informationSurgeryView = informationSurgeryView;
    }

    @Override
    public void paintComponent(Graphics graphics){
        this.graphics = (Graphics2D) graphics;
        addLabelsSurgeries();
        addLinesListSurgeries();
        addListSurgeries();
    }

    public void addLabelsSurgeries() {
        /**
         * This part is to create the labels such as surgery id, patient id, surgeon id, speciality, anesthesia type, anesthetist id,
         * surgery type, procedure, duration
         */
        int xCoordinate = 10;
        int yCoordinate = 20;
        String[] labels = {"Surgery Id   ", "Patient Id  ", "Surgeon Id  ", "Speciality  ", "Procedure  ", "Duration  "};

        for (int label = 0; label < labels.length; label++) {
            String text = labels[label];
            graphics.drawString(text, xCoordinate, yCoordinate);
            xCoordinate = xCoordinate + 160;
        }
    }

    public void addLinesListSurgeries() {
        double xCoordinate = 0;
        double yCoordinateOne = 20;
        double yCoordinateTwo = 900;
        for (int lineDimension = 160; lineDimension < 1000; lineDimension = lineDimension + 160) {
            xCoordinate = lineDimension;
            this.graphics.draw(new Line2D.Double(xCoordinate, yCoordinateOne, xCoordinate, yCoordinateTwo));
        }
    }

    private void addListSurgeries() {
        double yOneCoordinate = 40;
        for (InformationSurgeryView eachInformationSurgery: informationSurgeryView) {
            graphics.drawString(Integer.toString(eachInformationSurgery.getSurgeryId()), 20, (float) yOneCoordinate);
            graphics.drawString(Integer.toString(eachInformationSurgery.getPatientId()), 170, (float) yOneCoordinate);
            graphics.drawString(Integer.toString(eachInformationSurgery.getSurgeonId()), 350, (float) yOneCoordinate);
            graphics.drawString(eachInformationSurgery.getSpecialityName(), 500, (float) yOneCoordinate);
            System.out.println("Part of add list surgeries");
            System.out.println(eachInformationSurgery.getProcedure());
            graphics.drawString(eachInformationSurgery.getProcedure().trim(), 650, (float) yOneCoordinate);
            graphics.drawString(Integer.toString(eachInformationSurgery.getDuration()), 810, (float) yOneCoordinate);
            yOneCoordinate = yOneCoordinate + 60;
        }
    }

}
