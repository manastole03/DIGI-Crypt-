package com.manas;


import java.awt.Toolkit;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author root
 */
public class view_document extends javax.swing.JFrame {
String url="jdbc:mysql://localhost:3306/";  //sizde 3306 olabilir
String veritabaniadi="passbox_db";  // ulaşmak istediğiniz veri tabanı ismi 
String surucu="com.mysql.jdbc.Driver";
String kullaniciAdi="root";  // workbench deki kullanıcı adınız ne ise o "root" olabilir
String kullaniciParolas?=""; //workbench deki şifreniz ne ise o 
Connection baglanti=null;
Statement komut=null;
ResultSet gelenveri=null; 
PreparedStatement pst=null;

    /**
     * Creates new form Database_View
     */
    public view_document() {
        initComponents();
        setIcon();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        baglantiac();
        verilistele();
    }
    public void verilistele()
    {    try {
        Object []baslik={"ID","Account Name","Username","Password","Email Address"};
        Object [][]veri;
        String sorgu="select * from passbox_db.password_database_tb";
        PreparedStatement st=baglanti.prepareStatement(sorgu);
        try (ResultSet set = st.executeQuery()) {
            int count=0; set.last(); count=set.getRow();
            veri=new Object [count][5]; set.first();
            for(int i=0;i<count;i++){
                for(int j=0;j<5;j++)
                    veri[i][j]=set.getObject(j+1);
                set.next();          }
            table.setModel(new DefaultTableModel(veri,baslik)); set.close();
        }
    } catch (SQLException ex) {
        JOptionPane.showInputDialog("veri listeleme hatası"+ex);
    }
    }
    public void baglantiac(){
       try {
        Class.forName(surucu);
        //baglantı veri tabanı seçimi kullanıcı adı ve parola ile sağlanı
        baglanti= DriverManager.getConnection(url+veritabaniadi, kullaniciAdi,kullaniciParolas?);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showInputDialog("Hata sunucu ve baglantı hatası"+ex);
        }
    }
    public void baglantikapat()
    {
     try { 
             baglanti.close();
             } catch (SQLException e) {   
             JOptionPane.showInputDialog("Hata sunucu ve baglantı kapama hatası"+e);
             } 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        turnback_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PassBox | Database View");
        setFocusable(false);
        setResizable(false);

        table.setBackground(new java.awt.Color(25, 181, 254));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Account Name", "Username", "Password", "Email Address"
            }
        ));
        table.setPreferredSize(new java.awt.Dimension(500, 240));
        table.setRowHeight(30);
        table.setRowMargin(5);
        jScrollPane1.setViewportView(table);

       // turnback_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/turnback_ico.png"))); // NOI18N
        turnback_button.setText("Turn Back");
        turnback_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turnback_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(turnback_button, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(turnback_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void turnback_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turnback_buttonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_turnback_buttonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(view_document.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_document.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_document.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_document.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view_document().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JButton turnback_button;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        //setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("passbox_ico.png")));
    }
}
