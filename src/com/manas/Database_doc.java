package com.manas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Database_doc extends JFrame{
JFrame frame, frame1;
JTextField textbox;
JPasswordField textbox1;
JLabel label,label1;
JButton button;
JPanel panel;
static JTable table;

String url="jdbc:mysql://localhost:3306/";  //sizde 3306 olabilir
String database="locker";  // ulaşmak istediğiniz veri tabanı ismi 
String driver="com.mysql.cj.jdbc.Driver";
String username="root";  // workbench deki kullanıcı adınız ne ise o "root" olabilir
String password="Manastole@01"; //workbench deki şifreniz ne ise o 
Connection conn=null;
Statement komut=null;
ResultSet rs=null; 
PreparedStatement pst=null;
String[] columnNames = {"Username", "Email Address", "Account Name","Account Password"};
private JLabel jLabel_username,lbl1;
private JLabel jLabel_password;
private  JButton Login_Button,turn;
private JTextField username1;
private JPasswordField password1;
private JPanel lower_panel;


public  Database_doc()
{
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("DIGI Crypt | Security Login");
    setBounds(300,20,400,350);
    setResizable(false);
 
    panel = new JPanel();
    // contentPane = new JPanel();
    panel.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(panel);
	panel.setLayout(null);
	//contentPane.setBackground(color1);

	lbl1 = new JLabel();
	lbl1.setText("Security Login");
	 lbl1.setFont(new java.awt.Font("Yu Gothic UI", 1, 30)); // NOI18N
	 lbl1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	 lbl1.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
	lbl1.setBounds(90, 10, 300, 50);	
	panel.add(lbl1);
	
	jLabel_username = new JLabel();
	 jLabel_username.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
	 jLabel_username.setText("Username : ");
	 jLabel_username.setBounds(15, 100, 250, 35);
	 panel.add(jLabel_username);

	 jLabel_password= new JLabel();
	 jLabel_password.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
	 jLabel_password.setText("Password : ");
	 jLabel_password.setBounds(15, 170, 250, 35);
	 panel.add(jLabel_password);

	  Login_Button = new JButton();
	 Login_Button.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
	// jButton_Login_Page_Login_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/login_button.png"))); // NOI18N
	 Login_Button.setText("View Database");
	 Login_Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	 Login_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn.png")));
	 Login_Button.setOpaque(false);
	 Login_Button.addActionListener(new java.awt.event.ActionListener() {
	     public void actionPerformed(java.awt.event.ActionEvent evt) {
	         showTableData();
	     }
	 });
	 Login_Button.setBounds(180, 250, 200, 35);
		panel.add(Login_Button);
		
		turn = new JButton();
		turn.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
		// jButton_Login_Page_Login_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/login_button.png"))); // NOI18N
		turn.setText("Turn Back");
		turn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		turn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn.png")));
		turn.setOpaque(false);
		turn.addActionListener(new java.awt.event.ActionListener() {
		     public void actionPerformed(java.awt.event.ActionEvent evt) {
		         showTableData();
		     }
		 });
		turn.setBounds(10, 250, 150, 35);
		panel.add(turn);


	   username1 = new JTextField();
      username1.setFont(new java.awt.Font("Tahoma", 1, 11));
      username1.setBounds(120, 100, 250, 35);
      panel.add(username1);
      
       password1 = new JPasswordField();
      password1.setFont(new java.awt.Font("Tahoma", 1, 11)); 
      password1.setBounds(120, 170, 250, 35);
      panel.add(password1);
	
     
      
} 

public void actionPerformed(ActionEvent ae)
{
button = (JButton)ae.getSource();
System.out.println("Showing Table Data.......");
showTableData(); 
} 

public void showTableData()
{
	try {
        Class.forName(driver);
        
        conn= DriverManager.getConnection(url+database, username,password);
        JOptionPane.showMessageDialog(null,"DataBase is connected!");

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"DataBase is not connected!");
        }
        
	String str = "SELECT * FROM locker.t1b where username=? and password=?;";
    try {
        pst=conn.prepareStatement(str);
        pst.setString(1, username1.getText());
        pst.setString(2, new String(password1.getPassword()));
        rs=pst.executeQuery();
        if(rs.next()){
            JOptionPane.showMessageDialog(null,"Accepted!");
            frame1 = new JFrame("Database Search Result");
        	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	frame1.setLayout(new BorderLayout()); 
        	//TableModel tm = new TableModel();
        	DefaultTableModel model = new DefaultTableModel();
        	model.setColumnIdentifiers(columnNames);
        	//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
        	//table = new JTable(model);
        	table = new JTable();
        	table.setModel(model); 
        	table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        	table.setFillsViewportHeight(true);
        	JScrollPane scroll = new JScrollPane(table);
        	scroll.setHorizontalScrollBarPolicy(
        	JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        	scroll.setVerticalScrollBarPolicy(
        	JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
        	
        	 lower_panel = new JPanel();
             lower_panel.setBounds(0, 400, 1000, 100);
             frame1.add(lower_panel);
             

     		turn = new JButton();
     		turn.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
     		// jButton_Login_Page_Login_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/login_button.png"))); // NOI18N
     		turn.setText("Turn Back");
     		turn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
     		turn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn.png")));
     		turn.setOpaque(false);
     		turn.addActionListener(new java.awt.event.ActionListener() {
     		     public void actionPerformed(java.awt.event.ActionEvent evt) {
     		         method(evt);
     		     }

     		 });
     		turn.setBounds(10, 250, 300, 35);
     		lower_panel.add(turn);
        	
        	String username2 = username1.getText();
        	String document_name= "";
        	String document_number = "";
        	String description = "";
        	java.sql.Blob image ;
        	try
        	{ 
        		//Class.forName(driver); 
        		//Connection con = DriverManager.getConnection(url, username, password);
        		String sql = "select document_name,document_number,description,photo from new_document where username='"+username2+"'";
        		PreparedStatement ps = conn.prepareStatement(sql);
        		ResultSet rs = ps.executeQuery();
        		int i =0;
        		if(rs.next())
        		{
        			document_name = rs.getString("document_name");
        			document_number = rs.getString("document_number");
        			description = rs.getString("description");
        			image = rs.getBlob("photo");
        			
        			
        			
        			model.addRow(new Object[]{document_name, document_number, description, image});
        			i++; 
        		}
        		if(i <1)
        		{
        			JOptionPane.showMessageDialog(null, "No Record Found","Error",
        			JOptionPane.ERROR_MESSAGE);
        		}
        		if(i ==1)
        		{
        			System.out.println(i+" Record Found");
        		}
        		else
        		{
        			System.out.println(i+" Records Found");
        		}
        	}
        	catch(Exception ex)
        	{
        		JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
        		JOptionPane.ERROR_MESSAGE);
        	}
        	
        	frame1.add(scroll);
        	frame1.setVisible(true);
        	frame1.setBounds(10,10,1000,500);
        }
        else{
        JOptionPane.showMessageDialog(null,"Denied");
        }
    } catch (SQLException ex) {
        JOptionPane.showConfirmDialog(null, "Error!");
    }
}
	
public void method(ActionEvent evt)
{
	frame1.setVisible(false);
	main_document frame = new main_document();
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
              new Database_doc().setVisible(true);
          }
      });
}


}