/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author benhur
 */
class Login extends JFrame {

    JButton SUBMIT, CANCEL;
    JPanel panel;
    JLabel label1, label2;
    final JTextField text1, text2;

    Login() {
        label1 = new JLabel();
        label1.setText("Username:");
        text1 = new JTextField(15);

        label2 = new JLabel();
        label2.setText("Password:");
        text2 = new JPasswordField(15);

        SUBMIT = new JButton("SUBMIT");
        CANCEL = new JButton("CANCEL");

        panel = new JPanel(new GridLayout(3, 1));
        panel.add(label1);
        panel.add(text1);
        panel.add(label2);
        panel.add(text2);
        panel.add(SUBMIT);
        panel.add(CANCEL);
        add(panel, BorderLayout.CENTER);
        SUBMIT.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String value1 = text1.getText().trim();
                String value2 = text2.getText().trim();
                if (!value1.equals("") && !value2.equals("")) {
                    setVisible(false);
                     new NextPage();                   
                    
//                    NextPage newContentPane = new NextPage();
//        page.getContentPane().add(newContentPane);
                    
                } else {
                    System.out.println("enter a valid username and password");
                    JOptionPane.showMessageDialog(Login.this, "Incorrect login or password",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        CANCEL.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setTitle("LOGIN FORM");
    }

}
