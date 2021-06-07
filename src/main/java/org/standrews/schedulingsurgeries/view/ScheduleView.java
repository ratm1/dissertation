package org.standrews.schedulingsurgeries.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ScheduleView implements ActionListener {
    /**
     * Default width and height.
     */
    private static int DEFAULT_FRAME_WIDTH = 1000;
    private static int DEFAULT_FRAME_HEIGHT = 1000;

    /**
     * Variables for the frame and panels.
     */
    private JFrame mainFrame;
    private JPanel panelButtons;
    private JTabbedPane tabsOperatingRooms;
    /**
     * REVIEW
     */
    /*
    private JPanel panelCanvas;
    private JPanel panelAddSurgeries;
    */
    /**
     * Strings from buttons.
     */
    protected static String BUTTON_ADD_VIEW_SURGERIES = "ADD AND VIEW SURGERIES";
    protected static String BUTTON_SCHEDULE_SURGERIES = "SCHEDULE SURGERIES";
    /**
     * Buttons for the view.
     */
    private JButton addViewSurgeriesButton;
    private JButton scheduleSurgeriesButton;

    public ScheduleView() {
        /**
         * Main frame configuration
         */
        createMainFrame();
        /**
         * Create the panel for the buttons
         */
        createPanelButtons();
        /**
         * Create tab rooms
         */
        createTabRooms();
        /**
         * Add the panels into the main frame
         */
        mainFrame.add(panelButtons, BorderLayout.NORTH);
        mainFrame.add(tabsOperatingRooms,BorderLayout.CENTER);
        /**
         * Minor configurations
         */
        mainFrame.setResizable(false);
        /**
         * Configuration for correct presentation
         */
        mainFrame.pack();
    }

    public void createTabRooms(){
        /**
         * THIS PART WILL BE THE QUERY TO RETRIEVE DATA FROM THE JSON FILE
         */
        tabsOperatingRooms  = new JTabbedPane();
        tabsOperatingRooms.setPreferredSize(new Dimension(1000, 850));

        /**
         * OR1
         */
        ArrayList<SurgeryView> surgeriesOne = new ArrayList<>();
        surgeriesOne.add(new SurgeryView(LocalDateTime.of(2021,06,14,9,30), LocalDateTime.of(2021,06,14,10,30),"Surgery 1"));
        surgeriesOne.add(new SurgeryView(LocalDateTime.of(2021,06,14,10,45), LocalDateTime.of(2021,06,14,11,30),"Surgery 2"));
        surgeriesOne.add(new SurgeryView(LocalDateTime.of(2021,06,15,10,45), LocalDateTime.of(2021,06,15,11,30),"Surgery 3"));
        surgeriesOne.add(new SurgeryView(LocalDateTime.of(2021,06,16,12,30), LocalDateTime.of(2021,06,16,13,50),"Surgery 4"));
        JComponent operatingRoomOne = new WeeklySurgeriesView(surgeriesOne);
        tabsOperatingRooms.add("OR1", operatingRoomOne);
        /**
         * OR2
         */
        ArrayList<SurgeryView> surgeriesTwo = new ArrayList<>();
        surgeriesTwo.add(new SurgeryView(LocalDateTime.of(2021,06,15,9,30), LocalDateTime.of(2021,06,15,10,30),"Surgery 5"));
        surgeriesTwo.add(new SurgeryView(LocalDateTime.of(2021,06,16,10,45), LocalDateTime.of(2021,06,16,11,30),"Surgery 6"));
        surgeriesTwo.add(new SurgeryView(LocalDateTime.of(2021,06,17,11,45), LocalDateTime.of(2021,06,17,12,30),"Surgery 7"));
        surgeriesTwo.add(new SurgeryView(LocalDateTime.of(2021,06,18,12,31), LocalDateTime.of(2021,06,18,13,50),"Surgery 8"));
        JComponent operatingRoomTwo = new WeeklySurgeriesView(surgeriesTwo);
        tabsOperatingRooms.add("OR2", operatingRoomTwo);

        ArrayList<SurgeryView> surgeriesThree = new ArrayList<>();
        surgeriesThree.add(new SurgeryView(LocalDateTime.of(2021,06,15,10,40), LocalDateTime.of(2021,06,15,10,50),"Surgery 9"));
        surgeriesThree.add(new SurgeryView(LocalDateTime.of(2021,06,16,11,10), LocalDateTime.of(2021,06,16,11,30),"Surgery 10"));
        surgeriesThree.add(new SurgeryView(LocalDateTime.of(2021,06,17,11,45), LocalDateTime.of(2021,06,17,12,30),"Surgery 11"));
        surgeriesThree.add(new SurgeryView(LocalDateTime.of(2021,06,18,12,50), LocalDateTime.of(2021,06,18,13,20),"Surgery 12"));
        JComponent operatingRoomThree = new WeeklySurgeriesView(surgeriesThree);
        tabsOperatingRooms.add("OR3", operatingRoomThree);

    }

    public void createMainFrame() {
        mainFrame = new JFrame("SCHEDULING SURGERIES");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT);
        mainFrame.setVisible(true);
    }

    public void createPanelButtons() {
        addViewSurgeriesButton = new JButton(BUTTON_ADD_VIEW_SURGERIES);
        scheduleSurgeriesButton = new JButton(BUTTON_SCHEDULE_SURGERIES);
        panelButtons = new JPanel();
        panelButtons.setPreferredSize(new Dimension(1000, 50));
        panelButtons.setBackground(Color.gray);
        panelButtons.add(addViewSurgeriesButton);
        panelButtons.add(scheduleSurgeriesButton);
        addButtonSListener();
    }

    /**
     * Method for buttons listener
     */
    public void addButtonSListener() {
        /**
         * Action for the button add and view surgeries button
         */
        addViewSurgeriesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //   createPanelAddSurgeries();
                System.out.println("ADD AND VIEW SURGERIES BUTTON");
            }
        });
        /**
         * Action for the schedule surgeries button
         */
        scheduleSurgeriesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //   createPanelAddSurgeries();
                System.out.println("SCHEDULE SURGERIES BUTTON");
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
