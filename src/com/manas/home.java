package com.manas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


public class home<LoginButton> extends javax.swing.JFrame 
{

    private static final long serialVersionUID = 1L;

    int deviceWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    int deviceHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

    private void customizeComponents() {
        setLocationRelativeTo(this);
    }

    JLabel jLabel2 = new JLabel();
	JLabel ToLabel = new JLabel();
	JLabel WelcomeLabel = new JLabel();
	 JLabel AppNameLabel ;
	 JLabel AppNameLabel1 ;
	 JButton LoginButton ;
    JLabel BannerLabel = new JLabel();
    JButton ApplyButton ;
    JButton ApplyButton1;
    JPanel panal ;
    
    public home() {
       

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 600, 600);
		setResizable(true);
		
		panal = new JPanel();
		panal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panal);
		panal.setLayout(null);
	

		AppNameLabel = new JLabel();
        AppNameLabel.setFont(new Font("Lato", Font.PLAIN, 47));
        //AppNameLabel.setForeground(new Color(128, 139, 150 ));
        AppNameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jh.png"))); // NOI18N
        //AppNameLabel.setText("Welcome to Health Management System");
        AppNameLabel.setBounds(0, 0,500, 600);
        AppNameLabel.setForeground(Color.BLACK);
        panal.add(AppNameLabel);

        LoginButton = new JButton();
        LoginButton.setFont(new Font("Lato", Font.BOLD, 20));
        LoginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn.png"))); // NOI18N
        //LoginButton.setForeground(new Color(128, 139, 150 ));
        LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
                login loginScreen = new login();
                loginScreen.setVisible(true);
			}
		});
        //LoginButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginButton.setText("LOGIN HERE");
       // LoginButton.setToolTipText("");
        LoginButton.setOpaque(false);
      //  LoginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LoginButton.setBounds(350, 50, 200, 38);
        panal.add(LoginButton);

        ApplyButton = new JButton();
        ApplyButton.setFont(new Font("Lato", Font.BOLD, 20));
        //ApplyButton.setForeground(new java.awt.Color(255, 255, 255));
        ApplyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
                create_account loginScreen = new create_account();
                loginScreen.setVisible(true);
			}
		});
        ApplyButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ApplyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn.png"))); // NOI18N
        ApplyButton.setText(" Create Account ");
        ApplyButton.setToolTipText("add a new user");
        //ApplyButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ApplyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ApplyButton.setBounds(350, 120, 200, 40);
       // ApplyButton.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        //ApplyButton.setBorder(new Border(10));
        panal.add(ApplyButton);

        ApplyButton1 = new JButton();
        ApplyButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
                about_me frame = new about_me();
                frame.setVisible(true);
			}
		});
       // ApplyButton1.setForeground(new java.awt.Color(255, 255, 255));
        ApplyButton1.setFont(new Font("Lato", Font.BOLD, 18));
        ApplyButton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ApplyButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn.png"))); // NOI18N
        ApplyButton1.setText(" About Me");
        ApplyButton1.setToolTipText("");
        ApplyButton1.setOpaque(false);
       // ApplyButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ApplyButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ApplyButton1.setBounds(405, 510, 150, 40);
        panal.add(ApplyButton1);  
    }

    public static void main(String[] args)
    {
    	EventQueue.invokeLater(new Runnable()
    	{
    		public void run() 
    		{
    			try 
    			{
    				home frame = new home();
    				frame.setVisible(true);
    			} 
    			catch (Exception e)
    			{
    				e.printStackTrace();
    			}
    		}
    	});
    }

}
