package com.manas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.MaskFormatter;

public class update_page extends JFrame
{

    private final ImageIcon icon;
    private final JFrame frameAddNewEntry = new JFrame("Add New Donor");
    private JPanel panel = new JPanel();
    private final JButton btnCancel, btnAdd, btnChoose;
    private final Color clrRed = new Color(195, 5, 5);
    private final Color clrBlue = new Color(15, 70, 140);
    private final Color clrYellow = new Color(240, 230, 180);
    private final Color clrCyan = new Color(130, 185, 220);
    private  JLabel lblName, lblNID, lblAddress, lblImage,lbl1;
    private  JTextField tfName, tfFatherName,  txtWeight,txtFamilyName;
    private  JTextArea taDiseas, taAddress;   
    private  JSpinner spAge;
    private  JCheckBox chbSttmnt; 
    private  MaskFormatter  mskNID;
    private  JFormattedTextField tfMobile, tfNID;
    private String imagePath;
    private  JComboBox date1;
   
    private String[] date = {"Password", "Document"};
    //private JFrame frame;
  
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public update_page() {

        //adding image for icon
        icon = new ImageIcon(getClass().getResource("/images/plus.png"));
        frameAddNewEntry.setIconImage(icon.getImage());                         //set frame icon

        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DIGI Crypt | New Add Document ");
        setBounds(100,0,800,600);
        setResizable(false);
        
        panel = new JPanel();
       // panal.setBackground(new Color(2, 90, 248));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);

        //name
        lblName = new JLabel("Username:*");
        lblName.setBounds(500, 260, 100, 20);
        panel.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(500, 280, 240, 25);
        panel.add(tfName);

        //adhaar_number
        lblNID = new JLabel("Document Number :");
        lblNID.setBounds(500,320, 150, 20);
        panel.add(lblNID);

        mskNID = new MaskFormatter();
        try {
            mskNID.setMask("######");
        } catch (ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frameAddNewEntry, "Invalid Number", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        tfNID = new JFormattedTextField(mskNID);
        tfNID.setBounds(500, 340, 240, 25);
        panel.add(tfNID);


        lblAddress = new JLabel("Document Details (optional):");
        lblAddress.setBounds(500, 380, 200, 20);
        panel.add(lblAddress);

        taAddress = new JTextArea();
        taAddress.setLineWrap(true);

        JScrollPane scrlPaneAdrs = new JScrollPane();
        scrlPaneAdrs.setBounds(500, 400, 240, 100);
        scrlPaneAdrs.setViewportView(taAddress);
        panel.add(scrlPaneAdrs);
       
      
     /*   lbl1 = new JLabel();
        lbl1.setIcon(new ImageIcon(getClass().getResource("/images/document.png")));
        lbl1.setBounds(0, 20, 500, 600);
        panel.add(lbl1);*/
        

        lblImage = new JLabel();
        lblImage.setBounds(520, 20, 180, 180);
     //   lblImage.setBorder(blueline);
        lblImage.setForeground(new Color(2, 90, 248));
        lblImage.setIcon(resizeImage(new ImageIcon(getClass().getResource("/images/document_user.png"))));
        panel.add(lblImage);

        btnChoose = new JButton("Select Document");
        btnChoose.setBounds(530, 215, 150, 30);
        btnChoose.setBackground(clrCyan);
        btnChoose.setForeground(Color.WHITE);
        panel.add(btnChoose);
        
       date1 = new JComboBox(date);

       date1.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
        	   String s = (String) date1.getSelectedItem();//get the selected item

               switch (s) {//check for a match
                   case "password":
                       	
                   	 
                   	lblAddress.setVisible(true);
                    btnChoose.setVisible(false);
                          
                       break;
                   case "document":
                                 tfName.setVisible(false);            
                       break;
                   default:
                       
                       break;
               }
           }
       });
       date1.setBounds(100, 10, 100, 50);
       panel.add(date1);
        /*ActionListener cbActionListener = new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {

                String s = (String) date1.getSelectedItem();//get the selected item

                switch (s) {//check for a match
                    case "password":
                        	
                    	   lblAddress = new JLabel("Document Details (optional):");
                           lblAddress.setBounds(500, 380, 200, 20);
                           panel.add(lblAddress);

                           taAddress = new JTextArea();
                           taAddress.setLineWrap(true);
                           
                        break;
                    case "document":
                                              
                        break;
                    default:
                        
                        break;
                }
            }
        };*/

       // date1.addActionListener(cbActionListener);
       

        btnChoose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //create a file chooser to select image
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

                //filter the files
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
                fileChooser.addChoosableFileFilter(filter);

                imagePath = null;
                int result = fileChooser.showSaveDialog(null);
                //if the user click on save in Jfilechooser
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    imagePath = selectedFile.getAbsolutePath();
                    lblImage.setIcon(resizeImage(imagePath));
                }//if the user click on cancel in Jfilechooser
                else if (result == JFileChooser.CANCEL_OPTION) {
                    System.out.println("No File Selected");
                }
            }

        });

        btnAdd = new JButton("Add Donor");
        btnAdd.setBackground(new Color(39, 174, 96));                                          //button background color: Blue
        btnAdd.setForeground(Color.WHITE);                                      //button text color: White
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));                       //set button cursor
        btnAdd.setBounds(40, 350, 100, 20);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                insertData();
            }
        });
        btnAdd.setBounds(650,520,100,30);
       panel.add(btnAdd);

        btnCancel = new JButton("Cancel");
        btnCancel.setBackground(clrRed);                                        //button background color: clrRed
        btnCancel.setForeground(Color.WHITE);                                   //button text color: White
        btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));   
       // btnCancel.setBackground(new Color(213, 219, 219));
        btnCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frameAddNewEntry.dispose();
            }

        });
        btnCancel.setBounds(475,520,100,30);
        panel.add(btnCancel);


    }

    private ImageIcon resizeImage(String imagePath) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();

        image = image.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        return imageIcon;
    }

    private ImageIcon resizeImage(ImageIcon imageIcon) {
        Image image = imageIcon.getImage();
        image = image.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon retImage = new ImageIcon(image);
        return retImage;
    }

    private void insertData() {
        boolean ok = true;

        String name = tfName.getText();
        String fname = tfFatherName.getText();
        String family_name = txtFamilyName.getText();
     //   String gender = cbGender.getSelectedItem().toString();
      //  String bloodGroup = cbBloodGroup.getSelectedItem().toString();
        String weight = txtWeight.getText();
      //  String maritalStts = cbMaritalStts.getSelectedItem().toString();
        String nid = tfNID.getText();
        String mobile = tfMobile.getText();
     //   String division = cbDivision.getSelectedItem().toString();
     //   String district = cbDistrict.getSelectedItem().toString();
        String address = taAddress.getText();
        
        
        int age = (int) spAge.getModel().getValue();

        InputStream isImage = null;
        if (imagePath == null) {
            isImage = getClass().getResourceAsStream("images/user.png");
        } else {
            try {
                isImage = Files.newInputStream(Paths.get(imagePath));
            } catch (IOException ex) {
                ok = false;
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frameAddNewEntry, "'Picture' is invalid.",
                        "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (!txtWeight.getText().isEmpty()) {
            try {
                Float.parseFloat(txtWeight.getText());
            } catch (NumberFormatException ex) {
                ok = false;
                txtWeight.setText("");
                JOptionPane.showMessageDialog(frameAddNewEntry, "'Weight' is invalid.",
                        "Error!", JOptionPane.ERROR_MESSAGE);
                System.out.println("AddNewDonor.tfWeight.getText(): " + ex);
            }
        }
      /*  if (chbSttmnt.isSelected() && date == null) {
            ok = false;
            JOptionPane.showMessageDialog(frameAddNewEntry, "'Last Donation Date' is invalid.",
                    "Error!", JOptionPane.ERROR_MESSAGE);
        }*/

        if (name.equals("")) {
            JOptionPane.showMessageDialog(frameAddNewEntry, "'Name' Can't Be Empty.", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (name.length() > 30) {
            JOptionPane.showMessageDialog(frameAddNewEntry, "'Name' is too long (MAX 30 character).", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (fname.equals("")) {
            JOptionPane.showMessageDialog(frameAddNewEntry, "'Father's Name' Can't Be Empty.", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (fname.length() > 30) {
            JOptionPane.showMessageDialog(frameAddNewEntry, "'Father's Name' is too long (MAX 30 character)", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (family_name.length() > 30) {
            JOptionPane.showMessageDialog(frameAddNewEntry, "'Mother's Name' is too long (MAX 30 character)", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (mobile.trim().equals("+8801")) {
            JOptionPane.showMessageDialog(frameAddNewEntry, "'Mobile No' Can't Be Empty.", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (weight.trim().equals("")) {
            JOptionPane.showMessageDialog(frameAddNewEntry, "'Weight' Can't Be Empty.", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (ok == true) {
            try {
               
            	Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("driver loaded.");

               Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/locker", "root", "danceguru@39");
                System.out.println("Database Connected.");
                String sql = "INSERT INTO db_table112 (id, name,fathers_name,family_name, gender,age,weight, blood_group,marital_status,adhaar_number, mobile_number, state, district,address,photo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                
                PreparedStatement pst = conn.prepareStatement(sql);

                int id = 0;
				pst.setInt(1, id);
                pst.setString(2, name);
                pst.setString(3, fname);
                pst.setString(4, family_name);
               // pst.setString(5, gender);
                pst.setInt(6, age);
                pst.setString(7, weight);
                pst.setString(10, nid);
               // pst.setString(11, date);
                //pst.setString(11, date1);
                pst.setString(11, mobile);
                pst.setString(14, address);
                pst.setBlob(15, isImage);

                pst.executeUpdate();

                System.out.println("Data Inserted Successfully.");
                
                int choice = JOptionPane.showConfirmDialog(frameAddNewEntry,
                        "Data Added Successfully.\nDo you want to add another?", "Messege.",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                //if user choose NO then dispose this window
                //otherwise clear all the field                        
                if (choice == JOptionPane.NO_OPTION) {
                    frameAddNewEntry.dispose();
                } else {
                    tfName.setText("");
                    tfFatherName.setText("");
                    txtFamilyName.setText("");
                    txtWeight.setText("");
                    tfNID.setText("");
                    taDiseas.setText("");
                    tfMobile.setText("");
                    taAddress.setText("");
                    chbSttmnt.setSelected(false);
                    //dcLstDonation.setDate(null);
                    //dcLstDonation.setEnabled(false);
                 //   cbGender.setSelectedIndex(0);
                 //   cbBloodGroup.setSelectedIndex(0);
                 //   cbMaritalStts.setSelectedIndex(0);
                  //  cbDivision.setSelectedIndex(0);
                  //  cbDistrict.setSelectedIndex(0);
                    spAge.setValue(18);
                   // lblImage.setIcon(resizeImage(new ImageIcon(getClass().getResource("images/user.png"))));
                }
            } catch (Exception ex) {
                System.out.println("AddNewEntry.getData():");
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_page frame = new update_page();
					( frame).setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

