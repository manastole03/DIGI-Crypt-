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

public class add_new_document extends JFrame
{

    private final ImageIcon icon;
    private final JFrame frameAddNewEntry = new JFrame("Add New Donor");
    private JPanel panel = new JPanel();
    private final JButton btnCancel, btnAdd, btnChoose;
    private final Color clrRed = new Color(195, 5, 5);
    private final Color clrCyan = new Color(130, 185, 220);
    private  JLabel lblName, lblNID, lblAddress, lblImage,lbl1;
    private  JTextField tfName,txtUsername;
    private  JTextArea  taAddress;   
    private  MaskFormatter  mskNID;
    private  JFormattedTextField tfNID;
    private String imagePath;
    private JLabel username3;

  
	public add_new_document() {

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

		username3 = new JLabel();
		username3.setText("Username*");
		username3.setFont(new java.awt.Font("Tahoma", 1, 11));
		username3.setBounds(500, 270, 100, 20);
		panel.add(username3);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(500, 290, 240,25);
		panel.add(txtUsername);
		
        //name
        lblName = new JLabel("Name:*");
        lblName.setBounds(500, 320, 100, 20);
        panel.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(500, 340, 240, 25);
        panel.add(tfName);

        //adhaar_number
        lblNID = new JLabel("Document Number :");
        lblNID.setBounds(500,370, 150, 20);
        panel.add(lblNID);

        mskNID = new MaskFormatter();
        try {
            mskNID.setMask("######");
        } catch (ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frameAddNewEntry, "Invalid Number", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        tfNID = new JFormattedTextField(mskNID);
        tfNID.setBounds(500, 390, 240, 25);
        panel.add(tfNID);


        lblAddress = new JLabel("Document Details (optional):");
        lblAddress.setBounds(500, 420, 200, 20);
        panel.add(lblAddress);

        taAddress = new JTextArea();
        taAddress.setLineWrap(true);

        JScrollPane scrlPaneAdrs = new JScrollPane();
        scrlPaneAdrs.setBounds(500, 440, 240, 70);
        scrlPaneAdrs.setViewportView(taAddress);
        panel.add(scrlPaneAdrs);
       
      
        lbl1 = new JLabel();
        lbl1.setIcon(new ImageIcon(getClass().getResource("/images/document.png")));
        lbl1.setBounds(0, 20, 500, 600);
        panel.add(lbl1);
        

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

        btnAdd = new JButton("Add Data");
        btnAdd.setBackground(new Color(39, 174, 96));                                         
        btnAdd.setForeground(Color.WHITE);                                      
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));                       
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
        btnCancel.setBackground(clrRed);                                       
        btnCancel.setForeground(Color.WHITE);                                   
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

        String user_name = txtUsername.getText();
        String name = tfName.getText();
        String document_number = tfNID.getText();
        String description = taAddress.getText();

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
        
        if (name.equals("")) {
            JOptionPane.showMessageDialog(frameAddNewEntry, "'Name' Can't Be Empty.", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (description.length() > 50) {
            JOptionPane.showMessageDialog(frameAddNewEntry, "description is too long (MAX 30 character).", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (name.length() > 30) {
            JOptionPane.showMessageDialog(frameAddNewEntry, " Name is too long (MAX 30 character)", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (document_number.length() > 15) {
            JOptionPane.showMessageDialog(frameAddNewEntry, "Document_number is too long (MAX 30 character)", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (ok == true) {
            try {
            	
            	Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("driver loaded.");

               Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/locker", "root", "Manastole@01");
                System.out.println("Database Connected.");
                String sql = "INSERT INTO new_document (username,document_name,document_number, description,photo) VALUES (?,?,?,?,?)";
                
                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, user_name);
                pst.setString(2, name);
                pst.setString(3, document_number);
                pst.setString(4, description);
                pst.setBlob(5, isImage);

                pst.executeUpdate();

                System.out.println("Data Inserted Successfully.");
                JOptionPane.showMessageDialog(null,"Data Inserted!");
                this.setVisible(false);
                main_document frame = new main_document();
                frame.setVisible(true);
            }
            catch (Exception ex) {
                System.out.println("AddNewEntry.getData():");
                JOptionPane.showMessageDialog(null,"Data not Inserted!");
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_new_document frame = new add_new_document();
					( frame).setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

