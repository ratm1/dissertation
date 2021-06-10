package org.standrews.schedulingsurgeries.view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CloseListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Window win = SwingUtilities.getWindowAncestor((Component) e.getSource());
            win.dispose();
            System.out.println("Frame Closed. ");
        }
    }

