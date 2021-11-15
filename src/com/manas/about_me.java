package com.manas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;

import javax.swing.BorderFactory;
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
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class about_me extends JFrame
{
	private final JFrame frameAddNewEntry = new JFrame("Add New Donor");
	private JButton btn1,btn2,btn3,btn4,btn5,btn6;
	private JPanel panel = new JPanel();
	private   JLabel lblImage,lbl2;
	private JButton jButton_Create_a_New_Account_Page_TurnBack_Button;
	private JTextArea textArea;

  
	public about_me() {

        //adding image for icon
        //icon = new ImageIcon(getClass().getResource("/images/plus.png"));
        //frameAddNewEntry.setIconImage(icon.getImage());                         //set frame icon

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DIGI Crypt | About us ");
        setBounds(100,0,800,600);
        setResizable(false);
        
        panel = new JPanel();
       // panal.setBackground(new Color(2, 90, 248));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(120, 130, 139));
		setContentPane(panel);
		panel.setLayout(null);
      
		jButton_Create_a_New_Account_Page_TurnBack_Button = new JButton();
		 jButton_Create_a_New_Account_Page_TurnBack_Button.setText("Turn Back");
	     jButton_Create_a_New_Account_Page_TurnBack_Button.setBackground(Color.WHITE);
	        jButton_Create_a_New_Account_Page_TurnBack_Button.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton_Create_a_New_Account_Page_TurnBack_ButtonActionPerformed(evt);
	            }

	        });
	        jButton_Create_a_New_Account_Page_TurnBack_Button.setBounds(550, 500, 120, 40);
	        panel.add(jButton_Create_a_New_Account_Page_TurnBack_Button);
		
        JLabel lbl1 = new JLabel();
        lbl1.setIcon(new ImageIcon(getClass().getResource("/images/about_us.png")));
        lbl1.setBounds(0, 90, 500, 600);
        panel.add(lbl1);      
      
        btn2 = new JButton();
        btn2.setIcon(new ImageIcon(getClass().getResource("/images/manas.png")));
        btn2.setBounds(550, 20, 170, 211);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        btn2.setBorder(border);
        panel.add(btn2);      
      

        btn1 = new JButton("Cancel");
      //  btn1.setBackground(clrRed);           
        btn1.setIcon(new ImageIcon(getClass().getResource("/images/twitter.png")));
        btn1.setMargin(new Insets(10, 15, 10, 0));
//button background color: clrRed
        btn1.setBackground(new Color(78, 170, 255));                                   //button text color: White
        btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));   
       // btnCancel.setBackground(new Color(213, 219, 219));
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frameAddNewEntry.dispose();
            }

        });
        btn1.setBounds(340,10,80,70);
        panel.add(btn1);
        
        
        btn3 = new JButton("Cancel");
        //  btn1.setBackground(clrRed);           
          btn3.setIcon(new ImageIcon(getClass().getResource("/images/linkedin.png")));
          btn3.setBackground(new Color(3, 134, 254));
          btn3.setMargin(new Insets(10, 15, 10, 0));
  //button background color: clrRed
          btn3.setForeground(Color.WHITE);                                   //button text color: White
          btn3.setCursor(new Cursor(Cursor.HAND_CURSOR));   
         // btnCancel.setBackground(new Color(213, 219, 219));
          btn3.addActionListener(new ActionListener() {

              @Override
              public void actionPerformed(ActionEvent e)
              {
              	 try {
                       
              	        Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/manas-tole-ab05b1197/"));
              	         
              	    } catch (Exception  e1) {
              	        e1.printStackTrace();
              	    }
              }

          });
          btn3.setBounds(100,10,70,70);
          panel.add(btn3);

          
          btn4 = new JButton("Cancel");
          //  btn1.setBackground(clrRed);           
          btn4.setIcon(new ImageIcon(getClass().getResource("/images/github.png")));
          btn4.setBackground(new Color(215, 219, 221));
          btn4.setMargin(new Insets(20, 15, 10, 0));
    //button background color: clrRed
          //btn4.setBackground(Color.WHITE);                                   //button text color: White
          //btn4.setCursor(new Cursor(Cursor.HAND_CURSOR));   
           // btnCancel.setBackground(new Color(213, 219, 219));
          btn4.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e)
                {
                	 try {
                         
                	        Desktop.getDesktop().browse(new URI("https://manastole03.github.io/Manas-Tole-/"));
                	         
                	    } catch (Exception  e1) {
                	        e1.printStackTrace();
                	    }
                }

            });
          btn4.setBounds(180,10,150,50);
          panel.add(btn4);

          
          btn5 = new JButton("Cancel");
          //  btn1.setBackground(clrRed);           
          btn5.setIcon(new ImageIcon(getClass().getResource("/images/profile_pic.png")));
          btn5.setBackground(Color.WHITE);
          btn5.setMargin(new Insets(0, 10, 0, 0));
    //button background color: clrRed
          //btn4.setBackground(Color.WHITE);                                   //button text color: White
          //btn4.setCursor(new Cursor(Cursor.HAND_CURSOR));   
           // btnCancel.setBackground(new Color(213, 219, 219));
          btn5.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e)
                {
                	 try {
                         
                	        Desktop.getDesktop().browse(new URI("https://manastole03.github.io/Manas-Tole-/"));
                	         
                	    } catch (Exception  e1) {
                	        e1.printStackTrace();
                	    }
                }

            });
          btn5.setBounds(10,10,80,70);
          panel.add(btn5);
          
          textArea = new JTextArea(
                  "Versatile and flexible personality with a knack for technical\r\n"
                  + "innovation. Community leader and environmentalist with\r\n"
                  + "an attitude to give back to society. Have a creative mind\r\n"
                  + "and practical in approach. An avid reader and a Blockchain\r\n"
                  + "technology enthusiast.\r\n", 
                  6, 
                  20);
          textArea.setFont(new Font("Serif", Font.BOLD, 16));
          textArea.setBackground(new Color(120, 130, 139));
          textArea.setLineWrap(true);
          textArea.setWrapStyleWord(true);
          textArea.setOpaque(false);
          textArea.setEditable(false);
          textArea.setBounds(520,280,250,250);
          panel.add(textArea);
    }

	private void jButton_Create_a_New_Account_Page_TurnBack_ButtonActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		user frame = new user();
		frame.setVisible(true);
	}
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					about_me frame = new about_me();
					( frame).setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

