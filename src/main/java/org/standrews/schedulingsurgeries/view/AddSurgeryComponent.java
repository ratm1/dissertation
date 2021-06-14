package org.standrews.schedulingsurgeries.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

public class AddSurgeryComponent extends JPanel {
    /**
     * Surgery message
     */
    private JLabel addSurgeriesMessage;
    /**
     * Patient id
     */
    private JLabel patientLabel;
    private JTextField patientTextField;
    /**
     * Surgeon id
     */
    private JLabel surgeonLabel;
    private JTextField surgeonTextField;
    /**
     * Anesthesia type
     */
    private JLabel anesthesiaTypeLabel;
    private JComboBox anesthesiaTypeBox;
    /**
     * Anesthetist
     */
    private JLabel anesthetistLabel;
    private JTextField anesthetistTextField;
    /**
     * Surgery type
     */
    private JLabel surgeryTypeCodeLabel;
    private JComboBox surgeryTypeCodeBox;
    /**
     * Procedure
     */
    private JLabel procedureLabel;
    private JComboBox procedureBox;
    /**
     * Duration
     */
    private JLabel durationLabel;
    private JTextField durationTextField;
    /**
     * Machine learning component
     */
    private JLabel neuralNetworksLabel;
    private JCheckBox neuralNetworksBox;
    /**
     * Add surgery button
     */
    private JButton addSurgeryButton;
    /**
     * Grid layout
     */
    private GridBagLayout layout;
    private GridBagConstraints gridConstraints;
    /**
     * Request handler
     */
    private RequestHandler requestHandler;

    public void addInformation(RequestHandler requestHandler) throws IOException {
          this.requestHandler = requestHandler;
          setTextFieldAndComboBox(requestHandler);
          setGridLayout();
          setActionListener();
    }

    public void setTextFieldAndComboBox(RequestHandler requestHandler) throws IOException {
        /**
         * Surgery Message
         */
        addSurgeriesMessage = new JLabel();
        addSurgeriesMessage.setText("PLEASE FILL THE FIELDS TO ADD THE SURGERIES");
        addSurgeriesMessage.setFont(new java.awt.Font("Arial", Font.ITALIC, 20));
        /**
         * Patient id
         */
        patientLabel = new JLabel("Patient id ");
        patientTextField = new JTextField(16);
        /**
         * Surgeon id
         */
        surgeonLabel = new JLabel("Surgeon id ");
        surgeonTextField = new JTextField(16);
        /**
         * Anesthesia type
         */
        anesthesiaTypeLabel = new JLabel("Anesthesia Type ");
        Integer anesthesiaTypes[] = requestHandler.getAnesthesiaTypes(); // REVIEW
        anesthesiaTypeBox = new JComboBox(anesthesiaTypes);
        /**
         * Anesthetist
         */
        anesthetistLabel = new JLabel("Anesthetist id ");
        anesthetistTextField = new JTextField(16);
        /**
         * Surgery type
         */
        surgeryTypeCodeLabel = new JLabel("Surgery type code ");
        String surgeryTypesCode[] = requestHandler.getSurgeryTypeCodes(); // REVIEW
        surgeryTypeCodeBox = new JComboBox(surgeryTypesCode);
        /**
         * Procedure - HERE
         */
        procedureLabel = new JLabel("Procedure ");
        String procedures[] = requestHandler.getProcedures(); // REVIEW
        procedureBox = new JComboBox(procedures);
        /**
         * Duration
         */
        durationLabel = new JLabel("Duration ");
        durationTextField = new JTextField(16);
        /**
         * Machine learning component
         */
        neuralNetworksLabel = new JLabel("Neural networks");
        neuralNetworksBox = new JCheckBox();
        /**
         * Add surgery button
         */
        addSurgeryButton = new JButton("ADD SURGERY");
    }

    public void setGridLayout() {
        layout = new GridBagLayout();
        this.setLayout(layout);
        gridConstraints = new GridBagConstraints();
        this.setPreferredSize(new Dimension(1000, 750));
        /**
         * Surgery message constraint
         */
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 0;
        this.add(addSurgeriesMessage, gridConstraints);
        /**
         * Patient id
         */
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        this.add(patientLabel, gridConstraints);
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 2;
        this.add(patientTextField, gridConstraints);
        /**
         * Surgeon id
         */
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 4;
        this.add(surgeonLabel, gridConstraints);
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 4;
        this.add(surgeonTextField, gridConstraints);
        /**
         * Anesthesia type
         */
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 8;
        this.add(anesthesiaTypeLabel, gridConstraints);
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 8;
        this.add(anesthesiaTypeBox, gridConstraints);
        /**
         * Anesthetist
         */
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 12;
        this.add(anesthetistLabel, gridConstraints);
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 12;
        this.add(anesthetistTextField, gridConstraints);
        /**
         * Surgery type
         */
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 16;
        this.add(surgeryTypeCodeLabel, gridConstraints);
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 16;
        this.add(surgeryTypeCodeBox, gridConstraints);
        /**
         * Procedure - HERE
         */
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 20;
        this.add(procedureLabel, gridConstraints);
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 20;
        this.add(procedureBox, gridConstraints);
        /**
         * Duration
         */
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 24;
        this.add(durationLabel, gridConstraints);
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 24;
        this.add(durationTextField, gridConstraints);
        /**
         * Neural networks checkbox
         */
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 28;
        this.add(neuralNetworksLabel, gridConstraints);
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 28;
        this.add(neuralNetworksBox, gridConstraints);

        /**
         * Add surgery button
         */
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 32;
        this.add(addSurgeryButton, gridConstraints);
    }

    public void setActionListener() {
        addSurgeryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Long surgeonId = Long.valueOf(surgeonTextField.getText());
                    Integer anesthesiaTypeCode = (int) anesthesiaTypeBox.getSelectedItem();
                    Long anesthetistId = Long.valueOf(anesthetistTextField.getText());
                    String speciality = requestHandler.getSpeciality(surgeonId.intValue());
                    String surgeryTypeCode = surgeryTypeCodeBox.getSelectedItem().toString();
                    String procedureName = procedureBox.getSelectedItem().toString();
                    Integer duration = 0;

                    Long patientId = Long.valueOf(patientTextField.getText());
                    Long anesthesiaId = requestHandler.getAnesthesiaTypeId(anesthesiaTypeCode);
                    Long surgeryTypeId = requestHandler.getSurgeryTypeId(surgeryTypeCode);
                    Long procedureId = requestHandler.getProcedureId(procedureName);

                    if (neuralNetworksBox.isSelected()){
                        System.out.println("THE CHECKBOX HAS BEEN SELECTED");
                        duration = requestHandler.getDuration(surgeonId, anesthesiaTypeCode, anesthetistId, speciality,
                                surgeryTypeCode, procedureName);
                    } else {
                        System.out.println("THE CHECKBOX HAS NOT BEEN SELECTED");
                        duration = Integer.valueOf(durationTextField.getText());
                    }
                        requestHandler.postSurgery(patientId, surgeonId, anesthesiaId, anesthetistId, surgeryTypeId, procedureId, duration);
                } catch (NumberFormatException | IOException exception) {
                    String message = "Review that all fields are filled";
                    JOptionPane.showMessageDialog(new JFrame(), message, "Error",
                            JOptionPane.ERROR_MESSAGE);
                    exception.printStackTrace();
                }
               }
            }
        );

        neuralNetworksBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                  if (e.getStateChange() == ItemEvent.SELECTED) {
                      durationTextField.setEditable(false);
                      durationTextField.setText("");
                  } else {
                      durationTextField.setEditable(true);
                  }
             }
            }
        );
    }
}