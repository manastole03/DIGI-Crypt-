
package com.manas;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import java.io.IOException;

public class forget_password extends javax.swing.JFrame {
	 private javax.swing.JButton Contact_Me;
	    private javax.swing.JButton Create_New_Account;
	    private javax.swing.JButton Exit_Button,turn;
	    private javax.swing.JButton Forgot_Account_Button;
	    private javax.swing.JButton Login_Button;
	    private javax.swing.JLabel Button_Logo;
	    private javax.swing.JLabel jLabel_username;
	    private javax.swing.JLabel Name;
	    private javax.swing.JLabel jLabel_password;
	    private javax.swing.JPanel panel;
	    private javax.swing.JPasswordField password1;
	    private javax.swing.JTextField username1;
	    
	    
String url="jdbc:mysql://localhost:3306/"; 
String database="locker";
String driver="com.mysql.cj.jdbc.Driver";
String username="root"; 
String password="Manastole@01";  
Connection conn=null;
Statement komut=null;
ResultSet rs=null; 
PreparedStatement pst=null;
    private Object e;
   
    public forget_password()
    {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      		setBounds(450, 190, 514, 340);
      		setResizable(false);
      		setLocationByPlatform(true);
      	    setName("DIGI Crypt"); // NOI18N
      	    setResizable(false);
      
        try {
        Class.forName(driver);
        
        conn= DriverManager.getConnection(url+database, username,password);
        JOptionPane.showMessageDialog(null,"DataBase is connected!");

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"DataBase is not connected!");
        }
		
        panel = new JPanel();
       // contentPane = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		//contentPane.setBackground(color1);
		
		Name = new JLabel();
		Name.setText("Forget Password");
        Name.setFont(new java.awt.Font("Tamoha", Font.BOLD, 40)); // NOI18N
		Name.setBounds(80, 30, 350, 50);
		panel.add(Name);

		jLabel_username = new JLabel();
        jLabel_username.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel_username.setText("Username : ");
        jLabel_username.setBounds(50, 120, 250, 35);
        panel.add(jLabel_username);

        jLabel_password= new JLabel();
        jLabel_password.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel_password.setText("Password : ");
        jLabel_password.setBounds(50, 180, 250, 35);
        panel.add(jLabel_password);

        Login_Button = new JButton();
        Login_Button.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
       // jButton_Login_Page_Login_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/login_button.png"))); // NOI18N
        Login_Button.setText("Update");
        Login_Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Login_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn.png")));
        Login_Button.setOpaque(false);
        Login_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Login_Page_Login_ButtonActionPerformed(evt);
            }
        });
        Login_Button.setBounds(230, 240, 200, 35);
		panel.add(Login_Button);
        
        turn = new JButton();
		turn.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
		// jButton_Login_Page_Login_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/login_button.png"))); // NOI18N
		turn.setText("Turn Back");
		turn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		//turn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn.png")));
		turn.setBackground(Color.GRAY);
		turn.setOpaque(false);
		turn.addActionListener(new java.awt.event.ActionListener() {
		     public void actionPerformed(java.awt.event.ActionEvent evt) {
		         method_turn_back(evt);
		     }
		 });
		turn.setBounds(30, 240, 150, 35);
		panel.add(turn);
        

        username1 = new JTextField();
        username1.setFont(new java.awt.Font("Tahoma", 1, 11));
        username1.setBounds(175, 120, 250, 35);
        panel.add(username1);
        
        password1 = new JPasswordField();
        password1.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        password1.setBounds(175, 180, 250, 35);
        panel.add(password1);
    }
    
	private void method_turn_back(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		login frame = new login();
		frame.setVisible(true);
	}

    private void jButton_Login_Page_Login_ButtonActionPerformed(java.awt.event.ActionEvent evt) 
    {
        try{
           String username=username1.getText();
           String password= new String(password1.getPassword());
      
           String sorgu = "UPDATE t1b SET password='"+password+"',username='"+username
                   +"' where username='"+username+"'";
           pst=conn.prepareStatement(sorgu);
           pst.execute();
           JOptionPane.showMessageDialog(null,"Accepted");
           this.setVisible(false);
           login frame = new login();
           frame.setVisible(true);
         } catch (SQLException ex) {
                JOptionPane.showConfirmDialog(null, "Exception "+ex);
            }     
    }
    
    public static void main(String args[]) {
     
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new forget_password().setVisible(true);  
            }
        });
    } 
}