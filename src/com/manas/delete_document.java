
package com.manas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.MaskFormatter;

public class delete_document extends JFrame
{

    private final ImageIcon icon;
    private final JFrame frameAddNewEntry = new JFrame("Add New Donor");
    private JPanel panel = new JPanel();
    private final JButton btnCancel, btnAdd;
    private final Color clrRed = new Color(195, 5, 5);
    private  JLabel lblName, lblNID, lblImage,lbl1;
    private  JTextField tfName, txtUsername;  
    private  MaskFormatter  mskNID;
    private  JFormattedTextField tfNID;
    private JLabel username3;

  
	public delete_document() {

        //adding image for icon
        icon = new ImageIcon(getClass().getResource("/images/plus.png"));
        frameAddNewEntry.setIconImage(icon.getImage());                         //set frame icon

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DIGI Crypt | New Add Document ");
        setBounds(100,0,650,600);
        setResizable(false);
        
        panel = new JPanel();
       // panal.setBackground(new Color(2, 90, 248));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(133, 146, 158));

		username3 = new JLabel();
		username3.setText("Username*");
		//username3.setFont(new java.awt.Font("Tahoma", 1, 11));
		username3.setBounds(40, 10, 100, 20);
		panel.add(username3);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(40, 30, 150,25);
		panel.add(txtUsername);
		
        //name
        lblName = new JLabel(" Document Name:*");
        lblName.setBounds(220, 10, 125, 20);
        panel.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(220, 30, 150, 25);
        panel.add(tfName);

        //adhaar_number
        lblNID = new JLabel("Document Number :");
        lblNID.setBounds(400,10, 125, 20);
        panel.add(lblNID);

        mskNID = new MaskFormatter();
        try {
            mskNID.setMask("######");
        } catch (ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frameAddNewEntry, "Invalid Number", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        tfNID = new JFormattedTextField(mskNID);
        tfNID.setBounds(400, 30, 150, 25);
        panel.add(tfNID);
      
        lbl1 = new JLabel();
        lbl1.setIcon(new ImageIcon(getClass().getResource("/images/delete_page.png")));
        lbl1.setBounds(0, 60, 750, 600);
        panel.add(lbl1);
        

        btnAdd = new JButton("Delete Document");
        btnAdd.setBackground(new Color(39, 174, 96));                                          //button background color: Blue
        btnAdd.setForeground(Color.WHITE);                                      //button text color: White
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));                       //set button cursor
        btnAdd.setBounds(40, 350, 100, 20);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                insertData();
            }
        });
        btnAdd.setBounds(300,90,150,30);
       panel.add(btnAdd);

        btnCancel = new JButton("Turn Back");
        btnCancel.setBackground(clrRed);                                        //button background color: clrRed
        btnCancel.setForeground(Color.WHITE);                                   //button text color: White
        btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));   
       // btnCancel.setBackground(new Color(213, 219, 219));
        btnCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                method();
            }	

        });
        btnCancel.setBounds(150,90,100,30);
        panel.add(btnCancel);


    }

    private ImageIcon resizeImage(String imagePath) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();

        image = image.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        return imageIcon;
    }

    private ImageIcon resizeImage(ImageIcon imageIcon) {
        Image image = imageIcon.getImage();
        image = image.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon retImage = new ImageIcon(image);
        return retImage;
    }

    private void insertData() {
        boolean ok = true;

        String user_name = txtUsername.getText();
        String name = tfName.getText();
        String document_number = tfNID.getText();
        
      
        if (name.equals("")) {
            JOptionPane.showMessageDialog(frameAddNewEntry, "'Name' Can't Be Empty.", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (name.length() > 30) {
            JOptionPane.showMessageDialog(frameAddNewEntry, " Name is too long (MAX 30 character)", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (document_number.length() > 15) {
            JOptionPane.showMessageDialog(frameAddNewEntry, "Document_number is too long (MAX 30 character)", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (ok == true) {
            try {
            	
            	Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("driver loaded.");

               Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/locker", "root", "Manastole@01");
                System.out.println("Database Connected.");
                String sql = "DELETE FROM new_document WHERE username=? AND document_name=? AND document_number=?";
                
                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, user_name);
                pst.setString(2, name);
                pst.setString(3, document_number);

                pst.executeUpdate();

                System.out.println("Data Deleted Successfully.");
                JOptionPane.showMessageDialog(null,"Data Deletion Successfully Completed.");
            }
            catch (Exception ex) {
                System.out.println("AddNewEntry.getData():");
                JOptionPane.showMessageDialog(null,"Data Deletion Denied!.");
                ex.printStackTrace();
            }
        }
    }
    
    private void method() {
		// TODO Auto-generated method stub
    	this.setVisible(false);
    	main_document frame = new main_document();
    	frame.setVisible(true);
	}
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete_document frame = new delete_document();
					( frame).setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

