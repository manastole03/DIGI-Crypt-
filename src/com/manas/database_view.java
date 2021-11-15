package com.manas;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class database_view extends javax.swing.JFrame {

	 private javax.swing.JButton deletealllogs_button;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JTable table;
	    private javax.swing.JButton turnback_button;
	    private JLabel jLabel_username,jLabel_password;
	    private JButton Login_Button;
	    private JPanel panel;
	    
    public database_view() {
       

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        turnback_button = new javax.swing.JButton();
        deletealllogs_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(100,0,800,600);
        setTitle("PassBox | Log Control Page");
        setResizable(false);
        
         panel = new JPanel();
        // contentPane = new JPanel();
         panel.setBorder(new EmptyBorder(5, 5, 5, 5));
 		setContentPane(panel);
 		panel.setLayout(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fullname", "Username", "Entry Time" , "Documents" , "Password"
            }
        ));
        jScrollPane1.setViewportView(table);

        turnback_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        //turnback_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/turnback_ico.png"))); // NOI18N
        turnback_button.setText("Turn Back");
        turnback_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turnback_buttonActionPerformed(evt);
            }
        });

        deletealllogs_button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        //deletealllogs_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/password_delete_ico.png"))); // NOI18N
        deletealllogs_button.setText("Delete All Logs");

        
        jLabel_username = new JLabel();
        jLabel_username.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel_username.setText("Username : ");
        jLabel_username.setBounds(570, 150, 250, 35);
        panel.add(jLabel_username);

        jLabel_password = new JLabel();
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
                try {
					jButton_Login_Page_Login_ButtonActionPerformed(evt);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

		
        });
        Login_Button.setBounds(575, 250, 200, 35);
		panel.add(Login_Button);
        
    }// </editor-fold>//GEN-END:initComponents

    private void turnback_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turnback_buttonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_turnback_buttonActionPerformed

   
    
	private void jButton_Login_Page_Login_ButtonActionPerformed(ActionEvent evt) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

    	Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("driver loaded.");

       Connection conn = null;
	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/locker", "root", "Manastole@01");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        System.out.println("Database Connected.");
        String sql = "SELECT * FROM new_password (username,phone_number,email_address, account_name,account_password) VALUES (?,?,?,?,?)";
        
        PreparedStatement pst = conn.prepareStatement(sql);
        
     
	           
	       
	}
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(database_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(database_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(database_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(database_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new database_view().setVisible(true);
            }
        });
    }

   
    private void setIcon() {
        //setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("passbox_ico.png")));
    }
}

