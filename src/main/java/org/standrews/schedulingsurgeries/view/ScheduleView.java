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
    private JPanel panelWelcome;
    private JLabel welcomeMessage;
    private JPanel operatingRoomsInformation;
    /**
     * Strings from buttons.
     */
    protected static String BUTTON_ADD_VIEW_SURGERIES = "ADD AND VIEW SURGERIES";
    protected static String BUTTON_SCHEDULE_SURGERIES = "SCHEDULE SURGERIES";
    protected static String BUTTON_VIEW_SCHEDULE = "VIEW SCHEDULE";
    /**
     * Buttons for the view.
     */
    private JButton addViewSurgeriesButton;
    private JButton scheduleSurgeriesButton;
    private JButton viewScheduleButton;

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
         * Create the welcome panel
         */
        createPanelWelcome();
        /**
         * Add the panels into the main frame
         */
        mainFrame.add(panelButtons, BorderLayout.NORTH);
        mainFrame.add(panelWelcome, BorderLayout.CENTER);
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
        mainFrame.remove(panelWelcome);
        this.mainFrame.repaint(0,0,1000,1000);
        int numberOfRooms = requestHandler.getNumberOperatingRooms();
        String response = requestHandler.getSolution();
        this.parse(response);
        tabsOperatingRooms  = new JTabbedPane();
        operatingRoomsInformation = new JPanel();
        tabsOperatingRooms.setPreferredSize(new Dimension(1000, 850));
        operatingRoomsInformation.setPreferredSize(new Dimension(1000, 100));

        for (int roomNumber = 1; roomNumber <= numberOfRooms; roomNumber++){
            ArrayList<SurgeryView> surgeriesView = new ArrayList<>();
            for (Map.Entry<Integer, ArrayList> entry : scheduledSurgeriesMap.entrySet()) {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
                int key = entry.getKey();
                ArrayList value = entry.getValue();
                if (((int) value.get(0)) == roomNumber) {
                    LocalDateTime openingOperatingRoom = LocalDateTime.parse(value.get(2).toString(), format).truncatedTo(ChronoUnit.MINUTES);
                    LocalDateTime closingOperationRoom = LocalDateTime.parse(value.get(3).toString(), format).truncatedTo(ChronoUnit.MINUTES);
                    surgeriesView.add(new SurgeryView(openingOperatingRoom, closingOperationRoom, "Surgery " + key));
                }
            }
            JComponent operatingRoom = new WeeklySurgeriesComponent(surgeriesView);
            tabsOperatingRooms.add("OR " + roomNumber, operatingRoom);
        }

        mainFrame.add(tabsOperatingRooms,BorderLayout.CENTER);
        mainFrame.add(operatingRoomsInformation, BorderLayout.SOUTH);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public void parse(String responseJSON) {
        scheduledSurgeriesMap = new HashMap<>();
        JSONObject timeTable = new JSONObject(responseJSON);
        JSONArray scheduledSurgeries = timeTable.getJSONArray("surgeries");
        for (int counter = 0; counter < scheduledSurgeries.length(); counter ++){
            ArrayList information = new ArrayList();
            JSONObject scheduledSurgery = scheduledSurgeries.getJSONObject(counter);
            JSONObject operatingRoom = scheduledSurgery.getJSONObject("operatingRoom");
            int scheduledSurgeryId = scheduledSurgery.getInt("surgeryId");
            System.out.println(scheduledSurgeryId);
            int operatingRoomId = operatingRoom.getInt("operatingRoomId");
            System.out.println(operatingRoomId);
            String operatingRoomName = operatingRoom.getString("operatingRoomName");
            information.add(operatingRoomId);
            information.add(operatingRoomName);
            System.out.println(operatingRoomName);
            String startingTimeSurgery = scheduledSurgery.getString("startingTimeSurgery");
            System.out.println(startingTimeSurgery);
            information.add(startingTimeSurgery);
            String finishingTimeSurgery = scheduledSurgery.getString("finishingTimeSurgery");
            System.out.println(finishingTimeSurgery);
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

    public void createPanelWelcome() {
        welcomeMessage = new JLabel();
        welcomeMessage.setText("WELCOME TO THE SCHEDULING HEALTHCARE SYSTEM");
        welcomeMessage.setFont(new java.awt.Font("Arial", Font.ITALIC, 20));
        welcomeMessage.setOpaque(true);
        welcomeMessage.setBackground(Color.WHITE);
        welcomeMessage.setForeground(Color.BLUE);
        panelWelcome = new JPanel();
        panelWelcome.setPreferredSize(new Dimension(1000, 850));
        panelWelcome.add(welcomeMessage);
    }

    public void createPanelButtons() {
        addViewSurgeriesButton = new JButton(BUTTON_ADD_VIEW_SURGERIES);
        scheduleSurgeriesButton = new JButton(BUTTON_SCHEDULE_SURGERIES);
        viewScheduleButton = new JButton(BUTTON_VIEW_SCHEDULE);
        viewScheduleButton.setEnabled(false);
        panelButtons = new JPanel();
        panelButtons.setPreferredSize(new Dimension(1000, 40));
        panelButtons.setBackground(Color.gray);

        panelButtons.add(addViewSurgeriesButton);
        panelButtons.add(scheduleSurgeriesButton);
        panelButtons.add(viewScheduleButton);
        addButtonSListener();
    }

    /**
     * Method for buttons listener
     */
    public void addButtonSListener() {
        /**
         * Action for the button add and view surgeries button
         */
        viewScheduleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    createTabRooms();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.out.println("VIEW SCHEDULE BUTTON");
            }
        });
        /**
         * Action for the schedule surgeries button
         */
        scheduleSurgeriesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    requestHandler.solve();
                    viewScheduleButton.setEnabled(true);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.out.println("SCHEDULE SURGERIES BUTTON");
            }
        });
        /**
         * Action for the add and view surgeries button
         */
        addViewSurgeriesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("ADD AND VIEW SURGERIES BUTTON");
                try {
                    new ListSurgeriesView();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
