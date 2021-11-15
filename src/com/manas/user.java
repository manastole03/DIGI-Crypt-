package com.manas;




import java.awt.Toolkit;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;


public class user extends javax.swing.JFrame {
String url="jdbc:mysql://localhost:3306/";  
String db="locker";  
String driver="com.mysql.jdbc.Driver";
String username="root";  
String password="Manastole@01"; 
Connection conn=null;
Statement komut=null;
ResultSet gelenveri=null; 
PreparedStatement pst=null;
private javax.swing.JLabel giris_saati_label;
private javax.swing.JButton jButton1;
private javax.swing.JButton jButton4;
private javax.swing.JButton jButton7;
private javax.swing.JButton AboutUs;
private javax.swing.JButton AddPassword;
private javax.swing.JButton ContactMe;
private javax.swing.JButton Database;
private javax.swing.JButton jButton_Exit;
private javax.swing.JButton jButton_UserEdit;
private javax.swing.JLabel jLabel1,jLLabel5;
private javax.swing.JLabel jLabel2;
private javax.swing.JLabel jLabel_User_Control_Panel_Page_usercontrolpanel;
private javax.swing.JButton software_update_button;
String str;
private JLabel jLabel3;
private JPanel panel;
    public void baglanti(){
        try {
        Class.forName(driver);
        conn= DriverManager.getConnection(url+db, username,password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error !"+ex);
        }
    }
    int id=-1;
     public user() {
        initComponents();
     }
    public user(int gid) {
        initComponents();
        Date today = new Date();
        giris_saati_label.setText(today.toString());
        id=gid;
        
    }
    user(int gidenid, String gidenad) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
  
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jButton7 = new javax.swing.JButton();
        AboutUs = new javax.swing.JButton();
        ContactMe = new javax.swing.JButton();
        jButton_Exit = new javax.swing.JButton();
        jLabel_User_Control_Panel_Page_usercontrolpanel = new javax.swing.JLabel();
        jButton_UserEdit = new javax.swing.JButton();
        Database = new javax.swing.JButton();
        AddPassword = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        giris_saati_label = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        software_update_button = new javax.swing.JButton();

        jButton7.setText("jButton7");


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DIGI Crypt | New Add Document ");
        setBounds(100,0,900,600);
        setResizable(false);
        
        panel = new JPanel();
       // panal.setBackground(new Color(2, 90, 248));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		

        jLabel1.setText("DIGI - CRYPT");
 		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 70));
        jLabel1.setBounds(380, 120, 510, 60);
        panel.add(jLabel1);

        
        jLLabel5 = new JLabel();
        jLLabel5.setBounds(325, 100, 560, 600);
        jLLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user_page_img.png"))); // NOI18N
        panel.add(jLLabel5);   
        
		jButton_UserEdit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_UserEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user_profile.png"))); // NOI18N
        jButton_UserEdit.setText("User Edit");
        jButton_UserEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_UserEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_UserEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UserEditActionPerformed(evt);
            }
        });
        jButton_UserEdit.setBounds(50, 10, 120, 150);
        panel.add(jButton_UserEdit);
		
        Database.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
	    Database.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/database.png"))); // NOI18N
	    Database.setText("Database");
	    Database.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    Database.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
	    Database.addActionListener(new java.awt.event.ActionListener() {
	    public void actionPerformed(java.awt.event.ActionEvent evt) {
	        	jButton_DatabaseActionPerformed(evt);
	     	}
	     });
	     Database.setBounds(220, 10, 120, 150);
	     panel.add(Database);
		
	     software_update_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
	       software_update_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/log_file.png"))); // NOI18N
	        software_update_button.setText("Manage Document");
	        software_update_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	        software_update_button.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
	        software_update_button.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                software_update_buttonActionPerformed(evt);
	            }
	        });
	        software_update_button.setBounds(220, 200, 120, 150);
	        panel.add(software_update_button);
	     
	     AddPassword.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
	        AddPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pass.png"))); // NOI18N
	        AddPassword.setText("Manage passwords");
	        AddPassword.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	        AddPassword.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
	        AddPassword.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton_AddPasswordActionPerformed(evt);
	            }
	        });
	        AddPassword.setBounds(50, 200, 120, 150);
	        panel.add(AddPassword);
	     

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/doc.png"))); // NOI18N
        jButton1.setText("Log Control");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(50, 400, 120, 150);
        panel.add(jButton1);
        
        ContactMe.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ContactMe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/contact-info.png"))); // NOI18N
        ContactMe.setText("Contact Me");
        ContactMe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ContactMe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ContactMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ContactMeActionPerformed(evt);
            }
        });
        ContactMe.setBounds(220, 400, 120, 150);
        panel.add(ContactMe);

        AboutUs.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        // jButton_AboutUs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/about_me.png"))); // NOI18N
         AboutUs.setText("About Us");
         AboutUs.setBackground(Color.GRAY);
         AboutUs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
         AboutUs.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
         AboutUs.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jButton_AboutUsActionPerformed(evt);
             }
         });
         AboutUs.setBounds(600, 10, 120, 40);
         panel.add(AboutUs);
        
        
        jButton_Exit.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
      //  jButton_Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/exit_ico.png"))); // NOI18N
        jButton_Exit.setText("Logout");
        jButton_Exit.setBackground(Color.RED);
        jButton_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExitActionPerformed(evt);
            }
        });
        jButton_Exit.setBounds(750, 10, 120, 40);
        panel.add(jButton_Exit);
    }

    private void jButton_ExitActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
      //  System.exit(0);
    	this.setVisible(false);
    	login frame = new login();
    	frame.setVisible(true);
    }

    private void jButton_UserEditActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        // User_Edit_Page frame = new User_Edit_Page(id);
         //frame.setVisible(true);  
    }

    private void jButton_AboutUsActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        about_me frame = new about_me();
         frame.setVisible(true); 
    }

    private void jButton_AddPasswordActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
         main frame = new main();
         frame.setVisible(true); 
    }

    private void jButton_DatabaseActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Database_doc frame = new Database_doc();
        frame.setVisible(true);
    }

    private void jButton_ContactMeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    	contact_me frame;
		try {
			frame = new contact_me();
	    	frame.setVisible(true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void software_update_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    	//String str1 = jLabel3.getText();
        main_document frame_softwareupdatepage = new main_document();
        //frame_softwareupdatepage.my_str(str1);
        frame_softwareupdatepage.setVisible(true);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        //Log_Control_Page frame_logcontrolpage = new Log_Control_Page();
        //frame_logcontrolpage.setVisible(true);
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
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user().setVisible(true);
            }
        });
    }

}
