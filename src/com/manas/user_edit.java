package com.manas;

import java.awt.Color;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class user_edit extends javax.swing.JFrame
{
String url="jdbc:mysql://localhost:3306/";  
String veritabaniadi="passbox_db";  
String surucu="com.mysql.jdbc.Driver";
String kullaniciAdi="root";  
String kullaniciParolas�=""; 
Connection baglanti=null;
Statement komut=null;
ResultSet gelenveri=null; 
PreparedStatement pst=null;

private javax.swing.JButton jButton1;
private javax.swing.JButton jButton2;
private javax.swing.JButton jButton_TurnBack;
private javax.swing.JButton jButton_Update;
private javax.swing.JLabel jLabel1;
private javax.swing.JLabel jLabel2;
private javax.swing.JLabel jLabel3;
private javax.swing.JLabel jLabel4;
private javax.swing.JLabel jLabel5;
private javax.swing.JPasswordField jPasswordField1;
private javax.swing.JTextField jTextField1;
private javax.swing.JTextField jTextField2;
private javax.swing.JTextField jTextField3;
private javax.swing.JTextField jTextField4;
private JPanel panel;

    public user_edit() {
       
        try {
        Class.forName(surucu);
        baglanti= DriverManager.getConnection(url+veritabaniadi, kullaniciAdi,kullaniciParolas�);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("HATA 1: Surucu ve Baglantı Hatsı !"+ex);
        }

        jButton_TurnBack = new javax.swing.JButton();
        jButton_Update = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(10,10,500,500);
        setTitle("DIGI Crypt | User Edit");
        setResizable(false);
        
        panel = new JPanel();
        //panal.setBackground(new Color(2, 90, 248));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		//panel.setBackground(new Color(133, 146, 158));


        jButton_TurnBack.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        //jButton_TurnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/turnback_ico.png"))); // NOI18N
        jButton_TurnBack.setText("Turn Back");
        jButton_TurnBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_TurnBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_TurnBack.setBackground(Color.GRAY);
        jButton_TurnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TurnBackActionPerformed(evt);
            }
        });
        jButton_TurnBack.setBounds(150, 400, 100, 40);
        panel.add(jButton_TurnBack);
        

        jButton_Update.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        //jButton_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/database_update_ico.png"))); // NOI18N
        jButton_Update.setText("Update");
        jButton_Update.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Update.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
       // jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/database_view_ico.png"))); // NOI18N
        jButton1.setText("DB View");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setHideActionText(true);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerifyInputWhenFocusTarget(false);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        //jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/PassBox.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Full Name : ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Username : ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Password : ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("E-Mail Address : ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Mobile Number : ");

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField2.setEnabled(false);

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    }

	private void jButton_TurnBackActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.setVisible(false);
    }

    private void jButton_UpdateActionPerformed(java.awt.event.ActionEvent evt) {
        try{
       String değer1=jTextField1.getText();
       String değer2=jTextField2.getText();
       String değer3=jPasswordField1.getText();
       String değer4=jTextField3.getText();
       String değer5=jTextField4.getText();
       String sorgu = "UPDATE users_tb SET fullname='"+değer1+"',username='"+değer2
               +"',password='"+değer3+"',email_address='"+değer4+"',mobile_number='"+değer5+"' where fullname='"+değer1+"'";
       pst=baglanti.prepareStatement(sorgu);
       pst.execute();
       JOptionPane.showMessageDialog(null,"Updated ");
       
     } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Sorgu da hata var "+ex);
        }   
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
      //  User_Database_View_Page frame_userdatabaseview = new User_Database_View_Page();
       /// frame_userdatabaseview.setVisible(true);
    }

    public static void main(String args[])
    {
  
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(user_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user_edit().setVisible(true);
            }
        });
    }



}
