package com.manas;

import java.awt.Image;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class contact_me extends javax.swing.JFrame {

	  private javax.swing.JButton exit_button;
	  private JPanel panel;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton_MailSend_Button;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JLabel jLabel4;
	    private javax.swing.JLabel jLabel5;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JTextArea jTextArea1;
	    private javax.swing.JTextField jTextField1;
	    private javax.swing.JTextField jTextField2;
	    private javax.swing.JTextField jTextField3;

	
    public contact_me() throws IOException {
   

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DIGI Crypt | Contact Me");
        setBounds(100,100,400,600);
        setResizable(false);
        
        panel = new JPanel();
        // contentPane = new JPanel();
         panel.setBorder(new EmptyBorder(5, 5, 5, 5));
 		setContentPane(panel);
 		panel.setLayout(null);

 		jLabel5=new JLabel();
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/contact_me.jpg"))); // NOI18N
 		//jLabel5.setIcon(new ImageIcon(new ImageIcon("/images/contact.png").getImage().getScaledInstance(120, 200, Image.SCALE_DEFAULT)));
        jLabel5.setBounds(50,0,1000,200);
        panel.add(jLabel5);
        
 		
 		jButton_MailSend_Button = new JButton();
 		jButton_MailSend_Button.setText("Send");
        jButton_MailSend_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn.png"))); // NOI18N
        jButton_MailSend_Button.setBounds(220,510,100,30);
        jButton_MailSend_Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_MailSend_Button.setOpaque(false);
        panel.add(jButton_MailSend_Button);
        jButton_MailSend_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MailSend_ButtonActionPerformed(evt);
            }
        });
        

        //jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/PassBox.png"))); // NOI18N

 		jLabel1 = new JLabel();
 		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("Full Name : ");
        jLabel1.setBounds(60,210,100,30);
        panel.add(jLabel1);
        
        jTextField1 = new JTextField();
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jTextField1.setBounds(140,210,200,30);
        panel.add(jTextField1);
        
 		jLabel2 = new JLabel();
 		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel2.setText("Mail Address : ");
        jLabel2.setBounds(40,260,200,30);
        panel.add(jLabel2);
        
        jTextField2 = new JTextField();
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jTextField2.setBounds(140,260,200,30);
        panel.add(jTextField2);

 		jLabel3 = new JLabel();
 		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel3.setText("Subject : ");
        jLabel3.setBounds(75,310,200,30);
        panel.add(jLabel3);
        
        jTextField3 = new JTextField();
        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 14));
        jTextField3.setBounds(140,310,200,50);
        panel.add(jTextField3);

 		jLabel4 = new JLabel();
 		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel4.setText("Message : ");
        jLabel4.setBounds(70,380,200,30);
        panel.add(jLabel4);
        
        jTextArea1 = new JTextArea();
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1 = new JScrollPane();
        jScrollPane1.setViewportView(jTextArea1);
        jScrollPane1.setBounds(140,380,200,100);
        panel.add(jScrollPane1);
        
        
        exit_button = new JButton();
        exit_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn.png"))); // NOI18N
        exit_button.setText("Turn Back");
        exit_button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exit_button.setOpaque(false);
        exit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_buttonActionPerformed(evt);
            }
        });
        exit_button.setBounds(80,510,100,30);
        panel.add(exit_button);

    }

    
    private void jButton_MailSend_ButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        
    	 String to = "manastole.01@gmail.com";//change accordingly  
         String from = jTextField2.getText();  
         String host = "localhost";//or IP address  
     
        //Get the session object  
         Properties properties = System.getProperties();  
         properties.setProperty("mail.smtp.host", host);  
         Session session = Session.getDefaultInstance(properties);  
     
        //compose the message  
         try{  
            MimeMessage message = new MimeMessage(session);  
            message.setFrom(new InternetAddress(from));  
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
            message.setSubject("Ping");  
            message.setText(jTextArea1.getText());  
     
            // Send message  
            Transport.send(message);  
            System.out.println("message sent successfully....");  
     
         }catch (MessagingException mex) {mex.printStackTrace();}  
        
    }

    private void exit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_buttonActionPerformed
        // TODO add your handling code here:
        //this.setVisible(false);
    	this.setVisible(false);
    	 user frame = new user();
         frame.setVisible(true); 
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
            java.util.logging.Logger.getLogger(contact_me.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(contact_me.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(contact_me.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(contact_me.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
					new contact_me().setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }

}

