/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.app;

import org.table.JTableButtonMouseListener;
import org.table.JTableButtonRenderer;
import org.table.AddUser;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import org.domain.RegPerson;
import org.util.MyUtils;

/**
 *
 * @author benhur
 */
public class NextPage extends JFrame implements ActionListener
 {
    JMenuBar menuBar;
  JMenu fileMenu;
  JMenu editMenu;
  JMenuItem openMenuItem;
  
        JFrame frame = new JFrame("Registered Users");
        
  public NextPage()
  {
      
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        menuBar = new JMenuBar();
   
    // build the File menu
    fileMenu = new JMenu("New User");
    openMenuItem = new JMenuItem("Add");
    openMenuItem.addActionListener(this);
    fileMenu.add(openMenuItem);

    // build the Edit menu
    editMenu = new JMenu("Logout");

    // add menus to menubar
    menuBar.add(fileMenu);
    menuBar.add(editMenu);

    // put the menubar on the framethis
    frame.setJMenuBar(menuBar);
        
        JTable table = new JTable(new JTableModel()); 
        JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);	
		
		TableCellRenderer buttonRenderer = new JTableButtonRenderer();
		table.getColumn("Edit").setCellRenderer(buttonRenderer);
		table.getColumn("Delete").setCellRenderer(buttonRenderer);
		table.addMouseListener(new JTableButtonMouseListener(table));
        
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().setPreferredSize(new Dimension(500, 200));
        frame.setVisible(true);
        frame.setSize(500, 200);
        MyUtils.centreWindow(frame);
	}

    public void actionPerformed(ActionEvent e) {
    AddUser dialog = new AddUser();
    dialog.setModal(true);
    frame.setVisible(false);
    dialog.setVisible(true);
    
  }
	
	public static class JTableModel extends AbstractTableModel {
            HashMap<Integer, RegPerson> people = MyUtils.getPeopleMap();
            Object[][] data = MyUtils.hashMapTo2D(people);
            
		private static final long serialVersionUID = 1L;
		private static final String[] COLUMN_NAMES = new String[] {"Id", "Name  ---  Job", "Edit", "Delete"};
		private static final Class<?>[] COLUMN_TYPES = new Class<?>[] {Integer.class, String.class, JButton.class,  JButton.class};
		
		@Override public int getColumnCount() {
			return COLUMN_NAMES.length;
		}

		@Override public int getRowCount() {
			return data.length;
		}
		
		@Override public String getColumnName(int columnIndex) {
	        return COLUMN_NAMES[columnIndex];
	    }
		
		@Override public Class<?> getColumnClass(int columnIndex) {
			return COLUMN_TYPES[columnIndex];
		}

		@Override public Object getValueAt(final int rowIndex, final int columnIndex) {
			switch (columnIndex) {
				case 0: return data[rowIndex][columnIndex];
				case 1: return data[rowIndex][columnIndex];
				case 2: // fall through
				case 3: final JButton button = new JButton(COLUMN_NAMES[columnIndex]);
						button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(button), 
//										"Button clicked for row "+rowIndex + " "+columnIndex);
                                                                        "Function not yet implememnted, sorry!!");
							}
						});
						return button;
				default: return "Error";
			}
		}	
	}

  }
