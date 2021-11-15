package com.manas;


import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class main extends javax.swing.JFrame
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
	    
    public main() 
    {

        jButton_new_password_add = new javax.swing.JButton();
        jButton_database_view = new javax.swing.JButton();
        jButton_password_delete = new javax.swing.JButton();
        jButton_new_add_password_logo = new javax.swing.JButton();
        jButton_TurnBack = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DIGI Crypt | Management Password Page");
        setBounds(300,20,800,650);
        setResizable(false);
        
        panal = new JPanel();
		panal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panal);
		panal.setLayout(null);

        jButton_new_password_add.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_new_password_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_pass.png"))); // NOI18N
        jButton_new_password_add.setText("Add Password");
        jButton_new_password_add.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_new_password_add.setVerifyInputWhenFocusTarget(false);
        jButton_new_password_add.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_new_password_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_new_password_addActionPerformed(evt);
            }
        });
        jButton_new_password_add.setBounds(450,150,120,150);
        panal.add(jButton_new_password_add);
        
        
        jButton_database_view.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_database_view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/view_pass.png"))); // NOI18N
        jButton_database_view.setText("View Entries");
        jButton_database_view.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_database_view.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_database_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_database_viewActionPerformed(evt);
            }
        });
        jButton_database_view.setBounds(600,150,120,150);
        panal.add(jButton_database_view);

        jButton_password_delete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_password_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        jButton_password_delete.setText("Delete Entry");
        jButton_password_delete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_password_delete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_password_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_password_deleteActionPerformed(evt);
            }
        });
        jButton_password_delete.setBounds(600,360,120,150);
        panal.add(jButton_password_delete);

       // jButton_new_add_password_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo/PassBox.png"))); // NOI18N
        jLabel1 = new JLabel();
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/p (2).png")));
        jLabel1.setBounds(0, 20, 550, 250);
        panal.add(jLabel1);
        
        jLabel2 = new JLabel();
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ki.png")));
        jLabel2.setBounds(0, 0, 600, 620);
        panal.add(jLabel2);

        jButton_TurnBack.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        //jButton_TurnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/turn_back.png"))); // NOI18N
        jButton_TurnBack.setText("Turn Back");
        jButton_TurnBack.setBackground(Color.GRAY);
        jButton_TurnBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_TurnBack.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_TurnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TurnBackActionPerformed(evt);
            }
        });
        jButton_TurnBack.setBounds(500,540,200,40);
        panal.add(jButton_TurnBack);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update_pass.png"))); // NOI18N
        jButton1.setText("Update entry");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed1(evt);
            }	
        });
        jButton1.setBounds(450,360,120,150);
        panal.add(jButton1);
        
        about_me = new JButton();
        about_me.setText("About Me");
        about_me.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        about_me.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        about_me.setBackground(new Color(189, 195, 199 ));
        about_me.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        about_me.setBounds(500,60,200,40);
        panal.add(about_me);

    }

    private void jButton_new_password_addActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        add_new_password frame_newpassword = new add_new_password();
        frame_newpassword.setVisible(true); 
    }

    private void jButton1ActionPerformed1(ActionEvent evt) {
		// TODO Auto-generated method stub
		update_password frame = new update_password();
		frame.setVisible(true);
	}
    
    private void jButton_database_viewActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Database frame_databaseview = new Database();
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
        delete_password frame = new delete_password();
        frame.setVisible(true);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }
}
