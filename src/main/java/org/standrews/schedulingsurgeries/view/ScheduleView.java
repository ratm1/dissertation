package org.standrews.schedulingsurgeries.view;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    protected static String BUTTON_ADD_VIEW_SURGERIES = "VIEW SCHEDULE";
    protected static String BUTTON_SCHEDULE_SURGERIES = "SCHEDULE SURGERIES";
    /**
     * Buttons for the view.
     */
    private JButton addViewSurgeriesButton;
    private JButton scheduleSurgeriesButton;

    private RequestHandler requestHandler;

    private HashMap<Integer, ArrayList> scheduledSurgeriesMap;

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
         * Add the panels into the main frame
         */
        mainFrame.add(panelButtons, BorderLayout.NORTH);

        /**
         * Minor configurations
         */
        mainFrame.setResizable(false);
        /**
         * Configuration for correct presentation
         */
        mainFrame.pack();

        requestHandler = new RequestHandler();
    }

    public void createTabRooms() throws IOException {
        /**
         * THIS PART WILL BE THE QUERY TO RETRIEVE DATA FROM THE JSON FILE
         */
        int numberOfRooms = requestHandler.getNumberOperatingRooms();
        String response = requestHandler.getSolution();
        this.parse(response);
        tabsOperatingRooms  = new JTabbedPane();
        tabsOperatingRooms.setPreferredSize(new Dimension(1000, 850));

        for (int counterRooms = 1; counterRooms <= numberOfRooms; counterRooms++){
            for (Map.Entry<Integer, ArrayList> entry : scheduledSurgeriesMap.entrySet()) {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
                int key = entry.getKey();
                ArrayList value = entry.getValue();
                ArrayList<SurgeryView> surgeriesView = new ArrayList<>();
                if (((int) value.get(0)) == counterRooms) {
                    LocalDateTime openingOperatingRoom = LocalDateTime.parse(value.get(2).toString(), format).truncatedTo(ChronoUnit.MINUTES);
                    LocalDateTime closingOperationRoom = LocalDateTime.parse(value.get(3).toString(), format).truncatedTo(ChronoUnit.MINUTES);
                    surgeriesView.add(new SurgeryView(openingOperatingRoom, closingOperationRoom, "Surgery " + key));
                    System.out.println(openingOperatingRoom.toString());
                    System.out.println(closingOperationRoom.toString());
                    System.out.println("Surgery " + key);
                }
            }
        }


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



        /**
         * IMPORTANT PART TO CREATE THE NEW TAB PANS
         */
        mainFrame.add(tabsOperatingRooms,BorderLayout.CENTER);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public void parse(String responseJSON) {
        scheduledSurgeriesMap = new HashMap<>();
        JSONObject timeTable = new JSONObject(responseJSON);
        JSONArray scheduledSurgeries = timeTable.getJSONArray("scheduledSurgeries");
        for (int counter = 0; counter < scheduledSurgeries.length(); counter ++){
            ArrayList information = new ArrayList();
            JSONObject scheduledSurgery = scheduledSurgeries.getJSONObject(counter);
            JSONObject operatingRoom = scheduledSurgery.getJSONObject("operatingRoom");
            int scheduledSurgeryId = scheduledSurgery.getInt("scheduleSurgeryId");
            int operatingRoomId = operatingRoom.getInt("operatingRoomId");
            String operatingRoomName = operatingRoom.getString("operatingRoomName");
            information.add(operatingRoomId);
            information.add(operatingRoomName);
            String startingTimeSurgery = scheduledSurgery.getString("startingTimeSurgery");
            information.add(startingTimeSurgery);
            String finishingTimeSurgery = scheduledSurgery.getString("finishingTimeSurgery");
            information.add(finishingTimeSurgery);
            scheduledSurgeriesMap.put(scheduledSurgeryId, information);
        }
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
        panelButtons.add(scheduleSurgeriesButton);
        panelButtons.add(addViewSurgeriesButton);
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
                try {
                    createTabRooms();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.out.println("ADD AND VIEW SURGERIES BUTTON");
            }
        });
        /**
         * Action for the schedule surgeries button
         */
        scheduleSurgeriesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    requestHandler.solve();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.out.println("SCHEDULE SURGERIES BUTTON");
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
