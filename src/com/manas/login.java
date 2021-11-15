package com.manas;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;

public class login extends javax.swing.JFrame {
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
   
    public login()
    {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      		setBounds(450, 190, 1014, 597);
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

		jLabel_username = new JLabel();
        jLabel_username.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel_username.setText("Username : ");
        jLabel_username.setBounds(570, 150, 250, 35);
        panel.add(jLabel_username);

        jLabel_password= new JLabel();
        jLabel_password.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel_password.setText("Password : ");
        jLabel_password.setBounds(575, 210, 250, 35);
        panel.add(jLabel_password);

        Login_Button = new JButton();
        Login_Button.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
       // jButton_Login_Page_Login_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/login_button.png"))); // NOI18N
        Login_Button.setText("Login");
        Login_Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Login_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn.png")));
        Login_Button.setOpaque(false);
        Login_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Login_Page_Login_ButtonActionPerformed(evt);
            }
        });
        Login_Button.setBounds(675, 280, 200, 35);
		panel.add(Login_Button);

		Create_New_Account = new JButton();
        Create_New_Account.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        Create_New_Account.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn.png")));
        Create_New_Account.setOpaque(false);
        Create_New_Account.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        //jButton_Login_Page_Create_New_Account.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/register_ico.png"))); // NOI18N
        Create_New_Account.setText("Create Account");
        Create_New_Account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Login_Page_Create_New_AccountActionPerformed(evt);
            }
        });       
        Create_New_Account.setBounds(675, 330, 200, 35);
        panel.add(Create_New_Account);

        Exit_Button = new JButton();
        Exit_Button.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
       // jButton_Login_Page_Exit_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/exit_ico.png"))); // NOI18N
        Exit_Button.setText("Logout");
        Exit_Button.setBackground(Color.RED);
        Exit_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Login_Page_Exit_ButtonActionPerformed(evt);
            }
        });
        Exit_Button.setBounds(800, 500, 150, 35);
        panel.add(Exit_Button);
        
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
		turn.setBounds(550, 500, 150, 35);
		panel.add(turn);
        
        Forgot_Account_Button = new JButton();
        Forgot_Account_Button.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
     //   jButton_Login_Page_Forgot_Account_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/forgot_password.png"))); // NOI18N
        Forgot_Account_Button.setText("Forgot account ?");
        Forgot_Account_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn.png")));
        Forgot_Account_Button.setOpaque(false);
        Forgot_Account_Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Forgot_Account_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Login_Page_Forgot_Account_ButtonActionPerformed(evt);
            }
        });
        Forgot_Account_Button.setBounds(675, 380, 200, 35);
        panel.add(Forgot_Account_Button);

        username1 = new JTextField();
        username1.setFont(new java.awt.Font("Tahoma", 1, 11));
        username1.setBounds(675, 150, 250, 35);
        panel.add(username1);
        
        password1 = new JPasswordField();
        password1.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        password1.setBounds(675, 210, 250, 35);
        panel.add(password1);

        Contact_Me = new JButton();
        Contact_Me.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
     //   jButton_Login_Page_Contact_Me.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/contact_us.png"))); // NOI18N
        Contact_Me.setText("Contact Me");
        Contact_Me.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn.png")));
        Contact_Me.setOpaque(false);
        Contact_Me.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Contact_Me.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try {
					contact_me_page(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        Contact_Me.setBounds(675, 430, 200, 35);
        panel.add(Contact_Me);

        Button_Logo = new JLabel();
        Button_Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img.png"))); // NOI18N
        //Button_Logo.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        Button_Logo.setBounds(15, 15, 550, 520);
        //Button_Logo.setBounds(9, 39, 597, 525);
        panel.add(Button_Logo);
        
        Name = new JLabel();
        //Name.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rr.png"))); // NOI18N
        Name.setFont(new java.awt.Font("Tahoma",Font.BOLD, 70)); // NOI18N
        Name.setForeground(new Color(244, 208, 63));
        Name.setText("DIGI CRYPT");
        Name.setBounds(500, 0, 497, 85);
        panel.add(Name);

    }
    
	private void method_turn_back(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		home frame = new home();
		frame.setVisible(true);
	}

    private void jButton_Login_Page_Exit_ButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.exit(0);
    }

    private void jButton_Login_Page_Forgot_Account_ButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
         this.setVisible(false);
        forget_password frame = new forget_password();
         frame.setVisible(true);         
    }

    private void contact_me_page(java.awt.event.ActionEvent evt) throws IOException {
        // TODO add your handling code here:
         contact_me frame = new contact_me();
         frame.setVisible(true); 
    }

    private void jButton_Login_Page_Create_New_AccountActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
         this.setVisible(false);
         create_account frame = new create_account();
         frame.setVisible(true);       
    }

    private void jButton_Login_Page_Login_ButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
       String sorgu = "SELECT * FROM locker.t1b where username=? and password=?;";
        try {
            pst=conn.prepareStatement(sorgu);
            pst.setString(1, username1.getText());
            pst.setString(2, new String(password1.getPassword()));
            rs=pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Accepted!");
                this.setVisible(false);
                int id= (Integer) rs.getObject(1);
                String str = username1.getText();
                user frame = new user(id);
                frame.setVisible(true);
            }
            else{
            JOptionPane.showMessageDialog(null,"Denied");
            }
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Error!");
        }
        
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            String sorgu = "SELECT * FROM passbox_db.users_tb where username=? and password=?;";
        try {
            pst=conn.prepareStatement(sorgu);
            pst.setString(1, username1.getText());
            pst.setString(2, password1.getText());
            rs=pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Başarılı giriş!");
                this.setVisible(false);
                //User_Control_Panel_Page frame = new User_Control_Panel_Page();
                //frame.setVisible(true);
            }
            else{
            JOptionPane.showMessageDialog(null,"Başarısız giriş!");
            }
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Sorgu da hata var!");
        }
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
                new login().setVisible(true);  
            }
        });
    } 

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/img.png")));
    }
}