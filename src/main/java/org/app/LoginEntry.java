/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.util.MyUtils;

/**
 *
 * @author benhur
 */
public class LoginEntry {

    public static void main(String arg[]) {
        try {
            Login frame = new Login();
            frame.setSize(300, 100);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            MyUtils.centreWindow(frame);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    
}
