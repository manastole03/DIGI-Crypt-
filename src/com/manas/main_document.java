package com.manas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class main_document extends javax.swing.JFrame
{
	 private javax.swing.JButton jButton1;
	 private javax.swing.JButton jButton_TurnBack;
	 private javax.swing.JButton jButton_database_view;
	 private javax.swing.JButton jButton_new_add_password_logo;
	 private javax.swing.JButton jButton_new_password_add;
	 private javax.swing.JButton jButton_password_delete;
	 private JButton about_me;
	 private JButton add_new_doc;
	 private JLabel jLabel1;
	 private JLabel jLabel2;
	 private JPanel panal;
	    
    public main_document() 
    {

        jButton_new_password_add = new javax.swing.JButton();
        jButton_database_view = new javax.swing.JButton();
        jButton_password_delete = new javax.swing.JButton();
        jButton_new_add_password_logo = new javax.swing.JButton();
        jButton_TurnBack = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DIGI-CRYPT");
        setBounds(300,20,900,650);
        setResizable(false);
        
        panal = new JPanel();
		panal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panal);
		panal.setLayout(null);

        /*jButton_new_password_add.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        //jButton_new_password_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/add_password_ico.png"))); // NOI18N
        jButton_new_password_add.setText("Add new Password");
        jButton_new_password_add.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_new_password_add.setVerifyInputWhenFocusTarget(false);
        jButton_new_password_add.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_new_password_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_new_password_addActionPerformed(evt);
            }
        });
        jButton_new_password_add.setBounds(500,200,200,60);
        panal.add(jButton_new_password_add);*/
        
        
        jButton_database_view.setFont(new java.awt.Font("Tahoma", Font.BOLD, 10)); // NOI18N
        jButton_database_view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/view.png"))); // NOI18N
        jButton_database_view.setText("View Documents");
        jButton_database_view.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_database_view.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_database_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_database_viewActionPerformed(evt);
            }
        });
        jButton_database_view.setBounds(720,150,120,150);
        panal.add(jButton_database_view);

        jButton_password_delete.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton_password_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        jButton_password_delete.setText("Delete Document");
        jButton_password_delete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_password_delete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_password_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_password_deleteActionPerformed(evt);
            }
        });
        jButton_password_delete.setBounds(570,340,120,150);
        panal.add(jButton_password_delete);

       // jButton_new_add_password_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/PassBox.png"))); // NOI18N
        jLabel1 = new JLabel();
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/p (2).png")));
        jLabel1.setBounds(20, 60, 550, 250);
        panal.add(jLabel1);
        
        jLabel2 = new JLabel();
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/document_page_img.png")));
        jLabel2.setBounds(0, 115, 600, 620);
        panal.add(jLabel2);

        jButton_TurnBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        //jButton_TurnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/turnback_ico.png"))); // NOI18N
        jButton_TurnBack.setText("Turn Back");
        jButton_TurnBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_TurnBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_TurnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TurnBackActionPerformed(evt);
            }
        });
        jButton_TurnBack.setBounds(600,520,200,60);
        panal.add(jButton_TurnBack);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        jButton1.setText("Update Document");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(720,340,120,150);
        panal.add(jButton1);
        
        about_me = new JButton();
        about_me.setText("About Me");
        about_me.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        about_me.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        about_me.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        about_me.setBackground(new Color(189, 195, 199 ));
        about_me.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              abtActionPerformed(evt);
            }
        });
        about_me.setBounds(600,40,200,60);
        panal.add(about_me);
        
        add_new_doc = new JButton();
        add_new_doc.setText("Add Document");
        add_new_doc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        add_new_doc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        add_new_doc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add_new_doc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        add_new_doc.setBackground(new Color(189, 195, 199 ));
        add_new_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add_new_doc.setBounds(570,150,120,150);
        panal.add(add_new_doc);

    }

    private void jButton_new_password_addActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        add_new_document frame_newpassword = new add_new_document();
        frame_newpassword.setVisible(true); 
    }

    private void jButton_database_viewActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Database_doc frame_databaseview = new Database_doc();
        frame_databaseview.setVisible(true); 
    }

    private void jButton_TurnBackActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.setVisible(false);
        user frame = new user();
        frame.setVisible(true);
    }

    private void jButton_password_deleteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        delete_document frame = new delete_document();
        frame.setVisible(true);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        add_new_document frame = new add_new_document();
        frame.setVisible(true);
    }

    private void abtActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		about_me frame = new about_me();
		frame.setVisible(true);
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
            java.util.logging.Logger.getLogger(main_document.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main_document.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main_document.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main_document.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main_document().setVisible(true);
            }
        });
    }
}
