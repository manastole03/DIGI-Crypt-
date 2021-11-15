package com.manas;



import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class add_new_password extends javax.swing.JFrame {
String url="jdbc:mysql://localhost:3306/";  
String database="locker";  
String driver="com.mysql.cj.jdbc.Driver";
String username="root";  
String password="Manastole@01"; 
Connection conn=null;
Statement stat=null;
ResultSet rs=null; 
PreparedStatement pst=null;
private javax.swing.JTextField email_address_txt;
private javax.swing.JButton jButton1;
private javax.swing.JButton jButton2;
private javax.swing.JButton jButton_TurnBack;
private javax.swing.JLabel jLabel_email_address;
private javax.swing.JLabel jLabel_password;
private javax.swing.JLabel jLabel_socail_media_name;
private javax.swing.JLabel jLabel_username;
private javax.swing.JTextField password1;
private javax.swing.JTextField socail_media_name_txt;
private javax.swing.JTextField username1,phone_number;
private JPanel panal;
JLabel jLabel1,phone_no;

    public add_new_password() {
   
        try {
        Class.forName(driver);
        
        conn= DriverManager.getConnection(url+database, username,password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Database is not connected"+ex);
        }
  

        jLabel_socail_media_name = new javax.swing.JLabel();
        jLabel_username = new javax.swing.JLabel();
        jLabel_password = new javax.swing.JLabel();
        socail_media_name_txt = new javax.swing.JTextField();
        username1 = new javax.swing.JTextField();
        password1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel_email_address = new javax.swing.JLabel();
        email_address_txt = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton_TurnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DIGI Crypt | New Add Password ");
        setBounds(100,0,500,600);
        setResizable(false);
        
        panal = new JPanel();
       // panal.setBackground(new Color(2, 90, 248));
		panal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panal);
		panal.setLayout(null);
		
		jLabel1 = new JLabel();
		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userr.png"))); // NOI18N
		jLabel1.setBounds(0,300,550,300);
		panal.add(jLabel1);

        jLabel_socail_media_name.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N
        jLabel_socail_media_name.setText("Platform Name : ");
        jLabel_socail_media_name.setBounds(60, 30, 100, 30);
        panal.add(jLabel_socail_media_name);
        
        socail_media_name_txt.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N
        socail_media_name_txt.setBounds(170, 30, 200, 30);
        panal.add(socail_media_name_txt);
              
        jLabel_email_address.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N
        jLabel_email_address.setText("E-Mail Address : ");
        jLabel_email_address.setBounds(60, 70, 100, 30);
        panal.add(jLabel_email_address);

        email_address_txt.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N
        email_address_txt.setBounds(170, 70, 200, 30);
        panal.add(email_address_txt);

        jLabel_username.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N 
        jLabel_username.setText("Username : ");
        jLabel_username.setBounds(60, 150, 100, 30);
        panal.add(jLabel_username);

        jLabel_password.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N
        jLabel_password.setText("Password : ");
        jLabel_password.setBounds(60, 110, 100, 30);
        panal.add(jLabel_password);


        username1.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N
        username1.setBounds(170, 110, 200, 30);
        panal.add(username1);

        password1.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N
        password1.setBounds(170, 150, 200, 30);
        panal.add(password1);
        
        phone_no = new JLabel();
        phone_no.setText("Phone Number");
        phone_no.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N
       // phone_no.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userr.png"))); // NOI18N
		phone_no.setBounds(60,190,550,30);
		panal.add(phone_no);
		
		phone_number = new JTextField();
		phone_number.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N
		phone_number.setBounds(170, 190, 200, 30);
		panal.add(phone_number);

        jButton1.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
       // jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add_new_password_ico.png"))); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn.png"))); // NOI18N
        jButton1.setText("Add New Password");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
       // jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(160, 260, 200, 40);
        panal.add(jButton1);

   

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_new_password_ico.png"))); // NOI18N
        jButton2.setBackground(new Color(244, 208, 63 ));
        jButton2.setOpaque(false);
        jButton2.setBounds(390, 240, 80, 60);
        panal.add(jButton2);

        jButton_TurnBack.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
       // jButton_TurnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/turnback_ico.png"))); // NOI18N
        jButton_TurnBack.setText("Turn Back");
        jButton_TurnBack.setBackground(Color.gray);
        jButton_TurnBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_TurnBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_TurnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TurnBackActionPerformed(evt);
            }
        });
        jButton_TurnBack.setBounds(30, 260, 100, 40);
        panal.add(jButton_TurnBack);

      
    }

    private void jButton_TurnBackActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.setVisible(false);
        main frame = new main();
        frame.setVisible(true);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String str = "INSERT INTO new_password (username,phone_number,email_address,account_name,account_password)VALUES(?,?,?,?,?)";
        try {
           pst=conn.prepareStatement(str);
           pst.setString(1, username1.getText());
           pst.setString(2, phone_number.getText());
           pst.setString(3, email_address_txt.getText());
           pst.setString(4, socail_media_name_txt.getText());
           pst.setString(5, password1.getText());
           int x= pst.executeUpdate();
           if(x==1)
           {
        	   JOptionPane.showMessageDialog(null,"Data Inserted!");
        	   this.setVisible(false);
        	   main frame = new main();
        	   frame.setVisible(true);
           }
           else
                JOptionPane.showMessageDialog(null,"Data not Inserted !");
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Error!"+ex);
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
            java.util.logging.Logger.getLogger(add_new_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_new_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_new_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_new_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add_new_password().setVisible(true);
            }
        });
    }
}
