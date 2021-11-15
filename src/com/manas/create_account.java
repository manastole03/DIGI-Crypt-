package com.manas;


import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class create_account extends javax.swing.JFrame
{
String url="jdbc:mysql://localhost:3306/";  
String database="locker";   
String driver="com.mysql.cj.jdbc.Driver";
String username1="root"; 
String password1="Manastole@01"; 
java.sql.Connection conn=null;
java.sql.Statement stat=null;
ResultSet rs=null; 
PreparedStatement pst=null;
  

private javax.swing.JTextField email_address;
private javax.swing.JTextField fullname;
private javax.swing.JButton jButton1;
private javax.swing.JButton jButton2;
private javax.swing.JButton jButton_Create_a_New_Account_Page_TurnBack_Button;
private javax.swing.JCheckBox jCheckBox1;
private javax.swing.JCheckBox jCheckBox2;
private javax.swing.JLabel jLabel1;
private javax.swing.JLabel jLabel2;
private javax.swing.JLabel jLabel3;
private javax.swing.JLabel jLabel4;
private javax.swing.JLabel jLabel5;
private javax.swing.JLabel jLabel6;
private javax.swing.JLabel jLabel7;
private javax.swing.JLabel jLabel8;
private javax.swing.JPasswordField jPasswordField2;
private javax.swing.JTextField mobile_number;
private javax.swing.JPasswordField password;
private javax.swing.JTextField username;
private javax.swing.JPanel panel;


    public create_account()
    {
   
        try
        {
        	Class.forName(driver);
        	conn= DriverManager.getConnection(url+database, username1,password1);
        	System.out.print("db connected");
        }
        catch (ClassNotFoundException | SQLException ex)
        {
            System.out.println("ds"+ex);
        }
  
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Digi Crypt | Create a New Account");
        setBounds(100,100,700,450);
        setResizable(false);
        
        panel = new JPanel();
         panel.setBorder(new EmptyBorder(5, 5, 5, 5));
 		setContentPane(panel);
 		panel.setLayout(null);

        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        username = new javax.swing.JTextField();
        email_address = new javax.swing.JTextField();
        mobile_number = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButton_Create_a_New_Account_Page_TurnBack_Button = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        fullname = new javax.swing.JTextField();

        jLabel8 = new JLabel();
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ioi.png"))); // NOI18N
        jLabel8.setBounds(0, 10, 320, 400);
        panel.add(jLabel8);
        
     
        jLabel7.setText("Full Name : ");
        jLabel7.setFont(new java.awt.Font("Helvetica", 1, 15)); // NOI18N
        jLabel7.setBounds(350, 50, 100, 30);
        panel.add(jLabel7);

        fullname.setText("");
        fullname.setFont(new java.awt.Font("Helvetica", 1, 15)); // NOI18N
        fullname.setBounds(450, 50, 200, 30);
        panel.add(fullname);
        
        jLabel1.setText("Username : ");
        jLabel1.setFont(new java.awt.Font("Helvetica", 1, 15)); // NOI18N
        jLabel1.setBounds(350, 100, 100, 30);
        panel.add(jLabel1);
        
        
        username.setBounds(450, 100, 200, 30);
        username.setFont(new java.awt.Font("Helvetica", 1, 15)); // NOI18N
        panel.add(username);

        jLabel2.setText("Password : ");
        jLabel2.setFont(new java.awt.Font("Helvetica", 1, 15)); // NOI18N
        jLabel2.setBounds(350, 150, 100, 30);
        panel.add(jLabel2);
        
        jPasswordField2.setText("");
        jPasswordField2.setFont(new java.awt.Font("Helvetica", 1, 15)); // NOI18N
        jPasswordField2.setBounds(450, 150, 200, 30);
        panel.add(jPasswordField2);

        jLabel3.setText("E-Mail Address :");
        jLabel3.setFont(new java.awt.Font("Helvetica", 1, 15)); // NOI18N
        jLabel3.setBounds(307, 200, 150, 30);
        panel.add(jLabel3);
        
        email_address.setText("");
        email_address.setFont(new java.awt.Font("Helvetica", 1, 15)); // NOI18N
        email_address.setBounds(450, 200, 200, 30);
        panel.add(email_address);

        jLabel4.setText("Mobile Number :");
        jLabel4.setFont(new java.awt.Font("Helvetica", 1, 15)); // NOI18N
        jLabel4.setBounds(305, 250, 200, 30);
        panel.add(jLabel4);
        
        mobile_number.setText("");
        mobile_number.setFont(new java.awt.Font("Helvetica", 1, 15)); // NOI18N
        mobile_number.setBounds(450, 250, 200, 30);
        panel.add(mobile_number);

      //  jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/register.png"))); // NOI18N
        jButton1.setText("Register");
        jButton1.setFont(new java.awt.Font("Helvetica", 1, 15)); // NOI18N
        jButton1.setBackground((Color.RED));
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(500, 370, 120, 40);
        panel.add(jButton1);

        jLabel5.setText("Confidentiality Agreement : ");
        jLabel5.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        jLabel5.setBounds(350, 300, 150, 20);
        panel.add(jLabel5);

        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });
        jCheckBox1.setBounds(500, 300, 50, 20);
        panel.add(jCheckBox1);

        jLabel6.setText("Terms & Conditions : ");
        jLabel6.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        jLabel6.setBounds(350, 330, 150, 20);
        panel.add(jLabel6);

        jCheckBox2.setEnabled(false);
        jCheckBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox2ItemStateChanged(evt);
            }
        });
        jCheckBox2.setBounds(500, 330, 50, 20);
        panel.add(jCheckBox2);

        jButton_Create_a_New_Account_Page_TurnBack_Button.setText("Turn Back");
        jButton_Create_a_New_Account_Page_TurnBack_Button.setBackground(Color.GRAY);
        jButton_Create_a_New_Account_Page_TurnBack_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Create_a_New_Account_Page_TurnBack_ButtonActionPerformed(evt);
            }
        });
        jButton_Create_a_New_Account_Page_TurnBack_Button.setBounds(350, 370, 120, 40);
        panel.add(jButton_Create_a_New_Account_Page_TurnBack_Button);
 
    }

    private void jButton_Create_a_New_Account_Page_TurnBack_ButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
         this.setVisible(false);
         login frame = new login();
         frame.setVisible(true); 
    }

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {
        // TODO add your handling code here:
        int secili=evt.getStateChange();
        int secili_degil = evt.getStateChange();
        if(secili == ItemEvent.SELECTED)
            jCheckBox2.setEnabled(true);
        else
            jCheckBox2.setEnabled(false);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String sorgu = "INSERT INTO t1b(fullname,username,password,email_address,mobile_number)VALUES(?,?,?,?,?);";
        try {
           pst=conn.prepareStatement(sorgu);
           pst.setString(1, fullname.getText());
           pst.setString(2, username.getText());
           pst.setString(3, new String(jPasswordField2.getPassword()));
           pst.setString(4, email_address.getText());
           pst.setString(5, mobile_number.getText());
           int x= pst.executeUpdate();
           if(x==1)
           {
                JOptionPane.showMessageDialog(null,"Data Inserted Sucessfully");
           		this.setVisible(false);
           		login frame = new login();
           		frame.setVisible(true);
           }
           else
           {
                JOptionPane.showMessageDialog(null,"Data not Inserted Sucessfully");
           }
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "NOT Inserted"+ex);
        }
        
    }

    private void jCheckBox2ItemStateChanged(java.awt.event.ItemEvent evt) {
        int secili=evt.getStateChange();
        int secili_degil = evt.getStateChange();
        if(secili == ItemEvent.SELECTED)
            jButton1.setEnabled(true);
        else
            jButton1.setEnabled(false);
                
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
            java.util.logging.Logger.getLogger(create_account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(create_account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(create_account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(create_account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new create_account().setVisible(true);
            }
        });
    }
}
