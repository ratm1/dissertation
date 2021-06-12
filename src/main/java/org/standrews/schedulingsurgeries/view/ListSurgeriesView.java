package org.standrews.schedulingsurgeries.view;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ListSurgeriesView implements ActionListener {
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
    protected static String BUTTON_ADD_SURGERIES = "ADD SURGERIES";
    protected static String BUTTON_VIEW_SURGERIES = "VIEW SURGERIES";
    /**
     * Buttons for the view.
     */
    private JButton addSurgeriesButton;
    private JButton ViewSurgeriesButton;

    private RequestHandler requestHandler;

    private HashMap<Integer, ArrayList> scheduledSurgeriesMap;

    public ListSurgeriesView() throws IOException {
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

        createSurgeriesView();
        /**
         * Minor configurations
         */
        mainFrame.setResizable(false);
        /**
         * Configuration for correct presentation
         */
        mainFrame.pack();
    }

    public void createSurgeriesView() throws IOException {
        requestHandler = new RequestHandler();
        int numberOfRooms = requestHandler.getNumberOperatingRooms();
        /*
        ListSurgeriesComponent listSurgeriesComponent = new ListSurgeriesComponent();
        listSurgeriesComponent.setPreferredSize(new Dimension(1000, 850));
        mainFrame.add(listSurgeriesComponent,BorderLayout.CENTER);
         */
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
        mainFrame = new JFrame("ADD VIEW SURGERIES");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT);
        mainFrame.setVisible(true);
    }

    public void createPanelWelcome() {
        welcomeMessage = new JLabel();
        welcomeMessage.setText("WELCOME TO THE SCHEDULING HEALTHCARE SYSTEM");
        welcomeMessage.setFont(new Font("Arial", Font.ITALIC, 20));
        welcomeMessage.setOpaque(true);
        welcomeMessage.setBackground(Color.WHITE);
        welcomeMessage.setForeground(Color.BLUE);
        panelWelcome = new JPanel();
        panelWelcome.setPreferredSize(new Dimension(1000, 850));
        panelWelcome.add(welcomeMessage);
    }

    public void createPanelButtons() {
        addSurgeriesButton = new JButton(BUTTON_ADD_SURGERIES);
        ViewSurgeriesButton = new JButton(BUTTON_VIEW_SURGERIES);
        panelButtons = new JPanel();
        panelButtons.setPreferredSize(new Dimension(1000, 40));
        panelButtons.setBackground(Color.gray);

        panelButtons.add(addSurgeriesButton);
        panelButtons.add(ViewSurgeriesButton);
        addButtonSListener();
    }

    /**
     * Method for buttons listener
     */
    public void addButtonSListener() {
        /**
         * Action for the add button
         */
        addSurgeriesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("ADD SURGERIES BUTTON");
            }
        });
        /**
         * Action for the view button
         */
        ViewSurgeriesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("UPDATE VIEW SURGERIES BUTTON");
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
        Window win = SwingUtilities.getWindowAncestor((Component) e.getSource());
        win.dispose();
        mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
         */

    }
}
