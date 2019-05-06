/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.table;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.app.LoginEntry;
import org.app.NextPage;
import org.users.impl.UserManagerImpl;
import org.util.MyUtils;

/**
 *
 * @author benhur
 */
public class AddUser extends JDialog
  {
    JButton SUBMIT, CANCEL;
    JPanel panel;
    JLabel label1, label2;
    final JTextField text1, text2;
    UserManagerImpl ui = new UserManagerImpl();

    public AddUser()
    {
      label1 = new JLabel();
        label1.setText("Username:");
        text1 = new JTextField(15);

        label2 = new JLabel();
        label2.setText("Job:");
        text2 = new JTextField(15);

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
        
    setSize(400, 100);
    MyUtils.centreWindow(this);
        SUBMIT.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String value1 = text1.getText().trim();
                String value2 = text2.getText().trim();
                if (value1.equals("") || value2.equals("")) {
                                    
                    System.out.println("enter the valid username and password");
                    JOptionPane.showMessageDialog(AddUser.this, "Please fill in the missing value",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    
//                    NextPage newContentPane = new NextPage();
//        page.getContentPane().add(newContentPane);
                    
                } else {
                    ui.addUserInfo(value1, value2);
                    setVisible(false);
                    new NextPage();
                    
                }

            }
        });
        CANCEL.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                    new NextPage();
            }
        });
        setTitle("LOGIN FORM");
    }
  }

