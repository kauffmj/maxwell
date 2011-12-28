/*
 * Maxwell - A Heat-Loss and Heat-Gain Calculator
 * Developed by Allegheny College's CompSci290-Fall2011 Team
 * Maxwell.java
 *
 *
 */

import javax.swing.*;
import java.awt.*;
import com.thoughtworks.xstream.*;
import java.io.*;

public class Maxwell extends javax.swing.JFrame {
    static String xml;

    /** Creates new form Maxwell */
    public Maxwell() {
        initComponents();
    }

    /** Suppress the deprecation warnings */
    @SuppressWarnings("checked")
	
	
    /** Initialize all of the GUI Components */
    private void initComponents() {
	super.setTitle("Maxwell - Calculator");
        jLabel1 = new javax.swing.JLabel();          // "Job Name:" label
        jTextField1 = new javax.swing.JTextField();  // JobName box
        jLabel2 = new javax.swing.JLabel();          // "Job Number:" label
        jTextField2 = new javax.swing.JTextField();  // JobNumber box
        jLabel3 = new javax.swing.JLabel();          // "Date:" label
        jTextField3 = new javax.swing.JTextField();  // Date box
        jLabel4 = new javax.swing.JLabel();          // "Customer:" label
        jTextField4 = new javax.swing.JTextField();  // Customer box
        jLabel5 = new javax.swing.JLabel();          // "Address:" label
        jScrollPane3 = new javax.swing.JScrollPane();// Address scrollbar
        jTextArea3 = new javax.swing.JTextArea();    // Address box
        jLabel6 = new javax.swing.JLabel();          // "Notes:" Label
        jScrollPane1 = new javax.swing.JScrollPane();// Notes scrollbar
        jTextArea1 = new javax.swing.JTextArea();    // Notes box
        jSeparator1 = new javax.swing.JSeparator();  // Separator b/w job&zone
        jLabel7 = new javax.swing.JLabel();          // "Zone:" label
        jComboBox1 = new javax.swing.JComboBox();    // Zone dropdown
        jButton1 = new javax.swing.JButton();        // AddNewZone button
        jButton2 = new javax.swing.JButton();        // DeleteZone button
        jButton3 = new javax.swing.JButton();        // RenameZone button
        jLabel8 = new javax.swing.JLabel();          // "Region:" label
        jComboBox2 = new javax.swing.JComboBox();    // Region dropdown
        jLabel9 = new javax.swing.JLabel();          // "GrossWallArea:" label
        jTextField5 = new javax.swing.JTextField();  // GrossWallArea box
        jLabel10 = new javax.swing.JLabel();         // "NorthWindowArea:" label
        jTextField6 = new javax.swing.JTextField();  // NorthWindowArea box
        jLabel11 = new javax.swing.JLabel();         // "SouthWindowArea:" label
        jTextField7 = new javax.swing.JTextField();  // SouthWindowArea box
        jLabel12 = new javax.swing.JLabel();         // "E/WWindowArea:" label
        jTextField8 = new javax.swing.JTextField();  // E/WWindowArea box
        jLabel13 = new javax.swing.JLabel();         // "SkylightArea:" label
        jTextField9 = new javax.swing.JTextField();  // SkylightArea box
        jLabel14 = new javax.swing.JLabel();         // "DoorArea:" label
        jTextField10 = new javax.swing.JTextField(); // DoorArea box
        jLabel15 = new javax.swing.JLabel();         // "CeilingArea:" label
        jTextField11 = new javax.swing.JTextField(); // CeilingArea box
        jLabel16 = new javax.swing.JLabel();         // "FloorArea:" label
        jLabel17 = new javax.swing.JLabel();         // "InfilArea:" label
        jLabel18 = new javax.swing.JLabel();         // "InfilHeight:" label
        jLabel19 = new javax.swing.JLabel();         // "People:" label
        jLabel20 = new javax.swing.JLabel();         // "ApplianceGain:" label
        jLabel21 = new javax.swing.JLabel();         // "WindowType:" label
        jLabel22 = new javax.swing.JLabel();         // "DoorType:" label
        jTextField12 = new javax.swing.JTextField(); // FloorArea box
        jTextField13 = new javax.swing.JTextField(); // InfilArea box
        jTextField14 = new javax.swing.JTextField(); // InfilHeight box
        jTextField15 = new javax.swing.JTextField(); // People box
        jTextField16 = new javax.swing.JTextField(); // ApplianceGain box
        jComboBox3 = new javax.swing.JComboBox();    // WindowType dropdown
        jComboBox4 = new javax.swing.JComboBox();    // DoorType dropdown
        jLabel23 = new javax.swing.JLabel();         // "WallInsul:" label
        jLabel24 = new javax.swing.JLabel();         // "CeilingInsul:" label
        jLabel25 = new javax.swing.JLabel();         // "FloorInsul:" label
        jLabel26 = new javax.swing.JLabel();         // "FloorInfo:" label
        jLabel27 = new javax.swing.JLabel();         // "InfilAmount:" label
        jLabel28 = new javax.swing.JLabel();         // "LossSafeMargin:" label
        jComboBox5 = new javax.swing.JComboBox();    // WallInsul dropdown
        jComboBox6 = new javax.swing.JComboBox();    // CeilingInsul dropdown
        jComboBox7 = new javax.swing.JComboBox();    // FloorInsul dropdown
        jComboBox8 = new javax.swing.JComboBox();    // FloorInfo dropdown
        jComboBox9 = new javax.swing.JComboBox();    // InfilAmount dropdown
        jComboBox10 = new javax.swing.JComboBox();   // LossSafeMargin dropdown
        jSeparator2 = new javax.swing.JSeparator();  // Separatr b/w zone&result
        jButton4 = new javax.swing.JButton();        // Calculate Button
        jLabel29 = new javax.swing.JLabel();         // "ZoneGain:" label
        jTextField17 = new javax.swing.JTextField(); // ZoneGain box
        jLabel30 = new javax.swing.JLabel();         // "ZoneLoss:" label
        jTextField18 = new javax.swing.JTextField(); // ZoneLoss box
        jTextField19 = new javax.swing.JTextField(); // TotalLoss box
        jLabel31 = new javax.swing.JLabel();         // "TotalLoss:" label
        jLabel32 = new javax.swing.JLabel();         // "TotalGain:" label
        jTextField20 = new javax.swing.JTextField(); // TotalGain box
        jButton5 = new javax.swing.JButton();        // ClearZoneData button
        jMenuBar1 = new javax.swing.JMenuBar();      // Main Menubar
        jMenu1 = new javax.swing.JMenu();            // File Menu category
        jMenu2 = new javax.swing.JMenu();            // Help Menu category
	// File->New Menu item and actionListener
	MenuNew = new javax.swing.JMenuItem("New");
	MenuNew.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
		    MenuNewActionPerformed(evt); } });
	// File->Open Menu item and actionListener
	MenuOpen = new javax.swing.JMenuItem("Open");
	MenuOpen.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
		    MenuOpenActionPerformed(evt); } });
	// File->Save Menu item and actionListener
	MenuSave = new javax.swing.JMenuItem("Save");
	MenuSave.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
		    MenuSaveActionPerformed(evt); } });
	// File->Print Menu item and actionListener
	MenuPrint = new javax.swing.JMenuItem("Print to PDF");
	MenuPrint.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
		    MenuPrintActionPerformed(evt); } });
	// File->Exit Menu item and actionListener
	MenuExit = new javax.swing.JMenuItem("Exit");
	MenuExit.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
		    MenuExitActionPerformed(evt); } });
	// Help->About Menu item and actionListener
	MenuAbout = new javax.swing.JMenuItem("About Maxwell");
	MenuAbout.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
		    MenuAboutActionPerformed(evt); } });
	// Help->Documentation Menu item and actionListener
	MenuDocumentation = new javax.swing.JMenuItem("Documentation");
       MenuDocumentation.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
		    MenuDocumentationActionPerformed(evt); } });
	// Default operation when the Red X is clicked
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	/* Give all the labels/boxes the right text */
        jLabel2.setText("Job Number:");
        jLabel3.setText("Date:");
        jLabel4.setText("Customer:");
        jLabel5.setText("Address:");
        jTextArea3.setColumns(8);
        jTextArea3.setRows(3);
        jScrollPane3.setViewportView(jTextArea3);
        jLabel1.setText("Job Name:");
        jLabel6.setText("Notes:");
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);
        jLabel7.setText("Zone:");
	/* Pause labelling everything to take care of a few things */
	// Zone selection combobox and actionListener
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Untitled Zone" }));
	jComboBox1.addActionListener(new java.awt.event.ActionListener() {
	    public void actionPerformed(java.awt.event.ActionEvent evt) {
		jComboBox1ActionPerformed(evt);
	    }
	    });
	// AddNewZone button and actionListener
        jButton1.setText("Add New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
	    public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
	// DeleteZone button and actionListener
        jButton2.setText("Delete");
	jButton2.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
		    jButton2ActionPerformed(evt);
		}
	    });
	// RenameZone button and actionListener
        jButton3.setText("Rename");
	jButton3.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
		    jButton3ActionPerformed(evt);
		}
	    });
	/* resume labelling all labels/boxes */
        jLabel8.setText("Region:");
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Northwest PA" }));
        jLabel9.setText("Gross Wall Area:");
        jLabel10.setText("North Window Area:");
        jLabel11.setText("South Window Area:");
        jLabel12.setText("East/West Window Area:");
        jLabel13.setText("Skylight Area:");
        jLabel14.setText("Door Area:");
        jLabel15.setText("Ceiling Area:");
        jLabel16.setText("Floor Area:");
        jLabel17.setText("Infiltration Area:");
        jLabel18.setText("Infiltration Height:");
        jLabel19.setText("People:");
        jLabel20.setText("Appliance Gain:");
        jLabel21.setText("Window Type:");
        jLabel22.setText("Door Type:");
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single", "Insulated", "Storm", "Triple" }));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single", "Insulated", "Storm", "Triple" }));
        jLabel23.setText("Wall Insulation:");
        jLabel24.setText("Ceiling Insulation:");
        jLabel25.setText("Floor Insulation:");
        jLabel26.setText("Floor Information:");
        jLabel27.setText("Infiltration Amount:");
        jLabel28.setText("Loss Safety Margin:");
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Insulation", "2 Inches", "3 Inches", "6 Inches" }));
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Insulation", "3 Inches", "6 Inches", "10 Inches" }));
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Insulation", "3 Inches", "6 Inches" }));
        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Crawl Space", "Crawl - Ins.", "Base - No Ins.", "Bsmt. - 3 Inches" }));
        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 Air Change", "1/2 Air Change", "1/4 Air Change" }));
        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1.0x", "1.25x", "1.5x" }));
	/* pause labelling everything again */
	// Label Calculate button and give it an actionListener
        jButton4.setText("Calculate");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
	/* resume labelling everything */
        jLabel29.setText("Zone Gain:");
        jLabel30.setText("Zone Loss:");
        jLabel31.setText("Total Loss:");
        jLabel32.setText("Total Gain:");
	/* pause labelling everything */
	// label ClearZone button and give it an actionListener
        jButton5.setText("Clear Zone");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
	/* resume labelling everything */
	// File Menu
        jMenu1.setText("File");
	jMenu1.add(MenuNew);   // add New to File Menu
	jMenu1.add(MenuOpen);  // add Open to File Menu
	jMenu1.add(MenuSave);  // add Save to File Menu
	jMenu1.add(MenuPrint); // add Print to File Menu
	jMenu1.add(MenuExit);  // add Exit to File Menu
        jMenuBar1.add(jMenu1); // now add File Menu to Menubar
	// Help Menu
        jMenu2.setText("Help"); 
	jMenu2.add(MenuAbout); // add About to Help Menu
	jMenu2.add(MenuDocumentation); // add Documentation to Help Menu
        jMenuBar1.add(jMenu2); // now add Help Menu to Menubar
	// now activate our populated menubar
        setJMenuBar(jMenuBar1);

	/***********************************************************************
	 * AUTOMATICALLY GENERATED CODE TO PLACE THE ITEMS INTO THE GUI
	 * DO NOT MODIFY ANYTHING IN THIS UGLY-LOOKING BLOCK
	 **********************************************************************/
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 985, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField10, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(112, 112, 112)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField13, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(jTextField12, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(jTextField15, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(jTextField16, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(jComboBox3, 0, 154, Short.MAX_VALUE)
                            .addComponent(jComboBox4, 0, 154, Short.MAX_VALUE)
                            .addComponent(jTextField14, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel23)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox5, 0, 160, Short.MAX_VALUE)
                            .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox8, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox9, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 985, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel29)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jButton4))
                .addContainerGap(14, Short.MAX_VALUE))
        );
	
        pack();
	refreshScreen();
    }// </editor-fold>//GEN-END:initComponents
    /***************************************************************************
     * END OF INCREDIBLY UGLY AUTOMATICALLY GENERATED CODE
     * YOU CAN BEGIN EDITING AGAIN NOW
     **************************************************************************/



    /***************************************************************************
     * EVENT-HANDLING SECTION
     **************************************************************************/

    /* ZONE-SELECTION DROPDOWN BOX WAS TOUCHED/CHANGED */
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
	if (refreshFlag == 1) {
	    setBuildingData();
	    setZoneData(activeZone);
	    storeData();
	    activeBuilding.calc();
	    System.out.println("Zone changed to: " + 
			       jComboBox1.getSelectedIndex());
	    activeZone = jComboBox1.getSelectedIndex();
	    refreshScreen();
	}
    }

    /* ADD NEW ZONE BUTTON PRESSED */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
	//GEN-FIRST:event_jButton1ActionPerformed
	//calc current zone
	setBuildingData();
	setZoneData(activeZone);
	storeData();
	activeBuilding.calc();
	int num = activeBuilding.numZones();
	//prompt user for name of new zone
	JPanel frame = new JPanel(new GridLayout(0,4, 10, 10));
	String newname=JOptionPane.showInputDialog(frame,"New Zone Name:",null);
	int wasUsed = 0;
	if (newname != null)
	    for (int i=0; i<jComboBox1.getItemCount(); i++)
		if (newname.equals(jComboBox1.getItemAt(i)))
		    wasUsed++;
	if (newname == null)
	    System.out.println("User canceled new zone");
	else if (newname.equals("")) {
	    System.out.println("User entered no name, no change made.");
	    JPanel frame2 = new JPanel(new GridLayout(0,4, 10, 10));
	    JOptionPane.showMessageDialog(frame2,"Name cannot be blank.",
					  "Error",-1);	
	}
	else if (wasUsed >0 ){
	    System.out.println("User entered existing name, no zone added.");
	    JPanel frame2 = new JPanel(new GridLayout(0,4, 10, 10));
	    JOptionPane.showMessageDialog(frame2,"Name in use already.",
					  "Error",-1);	
	}
	else {
	    //add a new zone to building
	    activeBuilding.addZone(newname);
	    //add a new entry to zone dropdown
	    jComboBox1.addItem(newname);
	    jComboBox1.setSelectedIndex(num);
	    //refresh with info from new empty zone
	    activeZone = num;
	    refreshScreen();
	}
    }   //GEN-LAST:event_jButton1ActionPerformed

    /* DELETE ZONE BUTTON PRESSED */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
	System.out.println("Deleting Zone: " + activeZone);
	refreshFlag=0;
	if (activeBuilding.numZones() > 1) {
	    activeBuilding.rmZone(activeZone);
	    jComboBox1.removeItemAt(activeZone);
	}
	activeZone = 0;
	jComboBox1.setSelectedIndex(activeZone);
	refreshFlag=1;
	System.out.println("Active Zone: " + activeZone);
	refreshScreen();
    }

    /* RENAME ZONE PRESSED */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
	JPanel frame = new JPanel(new GridLayout(0,4, 10, 10));
	String rename=JOptionPane.showInputDialog(frame,"New Name:",null);
	int wasUsed = 0;
	if (rename != null)
	    for (int i=0; i<jComboBox1.getItemCount(); i++)
		if (rename.equals(jComboBox1.getItemAt(i)))
		    wasUsed++;
	if (rename == null) 
	    System.out.println("User entered no new name, no change was made");
	else if (rename.equals("")) {
	    System.out.println("User entered no name, no change made.");
	    JPanel frame2 = new JPanel(new GridLayout(0,4, 10, 10));
	    JOptionPane.showMessageDialog(frame2,"Name cannot be blank.",
					  "Error",-1);	
	}
	else if (wasUsed >0 ){
	    System.out.println("User entered existing name, no change made.");
	    JPanel frame2 = new JPanel(new GridLayout(0,4, 10, 10));
	    JOptionPane.showMessageDialog(frame2,"Name in use already.",
					  "Error",-1);	
	}
	else {
	    refreshFlag = 0;
	    activeBuilding.setZoneTitle(activeZone, rename);	
	    jComboBox1.removeAllItems();
	    for (int i=0; i<activeBuilding.numZones(); i++)
	        jComboBox1.addItem(activeBuilding.getZoneTitle(i));
	    jComboBox1.setSelectedIndex(activeZone);
	    refreshFlag = 1;
	}
    }

    /* CALCULATE BUTTON WAS PRESSED */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
	//GEN-FIRST:event_jButton4ActionPerformed
	
	storeData();
	
	region = activeBuilding.getRegion();
	setZoneData(activeZone);
	activeBuilding.calc();
	jTextField17.setText("" + activeBuilding.getZoneData(activeZone,18,3));
	jTextField18.setText("" + activeBuilding.getZoneData(activeZone,27,3));
	jTextField20.setText("" + activeBuilding.getTotalGain());
	jTextField19.setText("" + activeBuilding.getTotalLoss());
	// PRINT FOR DEBUGGING
	activeBuilding.output();
    }   //GEN-LAST:event_jButton4ActionPerformed

    /* CLEAR BUTTON WAS PRESSED */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
	//GEN-FIRST:event_jButton5ActionPerformed
	jTextField5.setText("0.0");
	jTextField6.setText("0.0");
	jTextField7.setText("0.0");
	jTextField8.setText("0.0");
	jTextField9.setText("0.0");
	jTextField10.setText("0.0");
	jTextField11.setText("0.0");
	jTextField12.setText("0.0");
	jTextField13.setText("0.0");
	jTextField14.setText("0.0");
	jTextField15.setText("0.0");
	jTextField16.setText("0.0");        
	jComboBox3.setSelectedIndex(0);
	jComboBox4.setSelectedIndex(0);
	jComboBox5.setSelectedIndex(0);
	jComboBox6.setSelectedIndex(0);
	jComboBox7.setSelectedIndex(0);
	jComboBox8.setSelectedIndex(0);
	jComboBox9.setSelectedIndex(0);
	jComboBox10.setSelectedIndex(0);
	setZoneData(activeZone);     // NEWNEWNEW
	activeBuilding.calc();       // NEWNEWNEW
	refreshScreen();             // NEWNEWNEW
   }   //GEN-LAST:event_jButton5ActionPerformed


    /***************************************************************************
     * HELPER METHODS
     **************************************************************************/

    /* REFRESH SCREEN FROM BUILDING/ZONE */
    public void refreshScreen() {
	// refresh job information
	jTextField1.setText(activeBuilding.getJobName());
	jTextField2.setText(activeBuilding.getJobNumber());
	jTextField3.setText(activeBuilding.getJobDate());
	jTextField4.setText(activeBuilding.getCustomer());
	jTextArea3.setText(activeBuilding.getAddress());
	jTextArea1.setText(activeBuilding.getNotes());
	// refresh values
	jTextField5.setText("" + activeBuilding.getZoneData(activeZone,0,0));
	jTextField6.setText("" + activeBuilding.getZoneData(activeZone,1,0));
	jTextField7.setText("" + activeBuilding.getZoneData(activeZone,2,0));
	jTextField8.setText("" + activeBuilding.getZoneData(activeZone,3,0));
	jTextField9.setText("" + activeBuilding.getZoneData(activeZone,4,0));
	jTextField10.setText("" + activeBuilding.getZoneData(activeZone,5,0));
	jTextField11.setText("" + activeBuilding.getZoneData(activeZone,7,0));
	jTextField12.setText("" + activeBuilding.getZoneData(activeZone,8,0));
	jTextField13.setText("" + activeBuilding.getZoneData(activeZone,9,0));
	jTextField14.setText("" + activeBuilding.getZoneData(activeZone,9,1));
	jTextField15.setText("" + activeBuilding.getZoneData(activeZone,10,0));
	jTextField16.setText("" + activeBuilding.getZoneData(activeZone,11,0));
	jTextField17.setText("" + activeBuilding.getZoneData(activeZone,18,3));
	jTextField18.setText("" + activeBuilding.getZoneData(activeZone,27,3));
	// refresh building totals
	jTextField20.setText("" + activeBuilding.getTotalGain());
	jTextField19.setText("" + activeBuilding.getTotalLoss());
	// refresh dropdowns
	int temp[] = activeBuilding.getZoneDropdowns(activeZone);
	jComboBox3.setSelectedIndex(temp[0]);
	jComboBox4.setSelectedIndex(temp[1]);
	jComboBox5.setSelectedIndex(temp[2]);
	jComboBox6.setSelectedIndex(temp[3]);
	jComboBox7.setSelectedIndex(temp[4]);
	jComboBox8.setSelectedIndex(temp[5]);
	jComboBox9.setSelectedIndex(temp[6]);
	jComboBox10.setSelectedIndex(temp[7]);
	// refresh zone-dropdown
	jComboBox1.setSelectedIndex(activeZone);
    }

    /* SEND BUILDING DESCRIPTIONS TO BUILDING OBJECT */
    private void setBuildingData() {
	activeBuilding.setBuildingData(jTextField1.getText(),
				       jTextField2.getText(),
				       jTextField3.getText(),
				       jTextField4.getText(),
				       jTextArea3.getText(),
				       jTextArea1.getText());
    }

    /* SEND INPUT DATA TO ZONE OBJECT */
    private void setZoneData(int i) {
	region = activeBuilding.getRegion();
	// store the input values/data
        activeBuilding.setZoneData(activeZone,0,0, // gross wall area
				   Float.parseFloat(jTextField5.getText()));
	activeBuilding.setZoneData(activeZone,1,0, // north window area
				   Float.parseFloat(jTextField6.getText()));
	activeBuilding.setZoneData(activeZone,2,0, // south window area
				   Float.parseFloat(jTextField7.getText()));
	activeBuilding.setZoneData(activeZone,3,0, // eastwest window area
				   Float.parseFloat(jTextField8.getText()));
	activeBuilding.setZoneData(activeZone,4,0, // skylight area
				   Float.parseFloat(jTextField9.getText()));
	activeBuilding.setZoneData(activeZone,5,0, // door area
				   Float.parseFloat(jTextField10.getText()));
	activeBuilding.setZoneData(activeZone,7,0, // ceiling area
				   Float.parseFloat(jTextField11.getText()));
	activeBuilding.setZoneData(activeZone,8,0, // floor area
				   Float.parseFloat(jTextField12.getText()));
	activeBuilding.setZoneData(activeZone,9,0, // infiltration area
				   Float.parseFloat(jTextField13.getText()));
	activeBuilding.setZoneData(activeZone,9,1, // infiltration height
				   Float.parseFloat(jTextField14.getText()));
	activeBuilding.setZoneData(activeZone,10,0, // people
				   Float.parseFloat(jTextField15.getText()));
	activeBuilding.setZoneData(activeZone,11,0, // appliance gain
				   Float.parseFloat(jTextField16.getText()));
	// multipliers of north/south/eastwest/skylight/doors based on region
	activeBuilding.setZoneData(activeZone,1,1,region.getValue(3,0));
	activeBuilding.setZoneData(activeZone,2,1,region.getValue(3,1));
	activeBuilding.setZoneData(activeZone,3,1,region.getValue(3,2));
	activeBuilding.setZoneData(activeZone,4,1,region.getValue(3,3));
	activeBuilding.setZoneData(activeZone,5,1,region.getValue(3,4));
	// windowCM (right side)
	activeBuilding.setZoneData(activeZone,20,1,
			      region.getValue(6,jComboBox3.getSelectedIndex()));
	// doorCM (right side)
	activeBuilding.setZoneData(activeZone,21,1,
			      region.getValue(6,jComboBox4.getSelectedIndex()));
	// wallHM and wallCM
	activeBuilding.setZoneData(activeZone,6,1,
			      region.getValue(0,jComboBox5.getSelectedIndex()));
	activeBuilding.setZoneData(activeZone,22,1,
			      region.getValue(9,jComboBox5.getSelectedIndex()));
	// ceilHM and ceilCM
	activeBuilding.setZoneData(activeZone,7,1,
			      region.getValue(1,jComboBox6.getSelectedIndex()));
	activeBuilding.setZoneData(activeZone,23,1,
			      region.getValue(7,jComboBox6.getSelectedIndex()));
	// florHM and florCM
	activeBuilding.setZoneData(activeZone,8,1,
			      region.getValue(2,jComboBox7.getSelectedIndex()));
	activeBuilding.setZoneData(activeZone,24,1,
			      region.getValue(8,jComboBox8.getSelectedIndex()));
	// infnHM and laHIHM and infnCM
	activeBuilding.setZoneData(activeZone,9,2,
			      region.getValue(4,jComboBox9.getSelectedIndex()));
	activeBuilding.setZoneData(activeZone,15,2,
			      region.getValue(5,jComboBox9.getSelectedIndex()));
	activeBuilding.setZoneData(activeZone,25,2,
			     region.getValue(10,jComboBox9.getSelectedIndex()));
	// safetyMargin multiplier
	if (jComboBox10.getSelectedIndex() == 1)
	    activeBuilding.setZoneData(activeZone,27,1,(float)1.25);
	else if (jComboBox10.getSelectedIndex() == 2)
	    activeBuilding.setZoneData(activeZone,27,1,(float)1.5);
	else
	    activeBuilding.setZoneData(activeZone,27,1,(float)1.0);
    }	

    /* SAVE DATA BEFORE SWITCHING */
    private void storeData() {
	// SAVE DROPDOWNS	
	int temp[]={jComboBox3.getSelectedIndex(),jComboBox4.getSelectedIndex(),
		    jComboBox5.getSelectedIndex(),jComboBox6.getSelectedIndex(),
		    jComboBox7.getSelectedIndex(),jComboBox8.getSelectedIndex(),
		    jComboBox9.getSelectedIndex(),
		    jComboBox10.getSelectedIndex()};
	activeBuilding.setZoneDropdowns(activeZone, temp);
	// 
	setBuildingData();
	
    }

    /*
     * SERIALIZE, USED TO SAVE - MAKES XML CODE FOR OBJECT
     */
    public static void serialize(Building a, String file){
	XStream xstream = new XStream();
	xml = xstream.toXML(a);
	//System.out.println(xml);
	try{
	    //String jobname = a.getJobName();
	    PrintWriter out = new PrintWriter(new FileWriter(file));
	    out.println(xml);
	    out.close();
	}catch (Exception e){
	    System.err.println("There has been an error");
	}
    }
	

    private static String readFile(String fileName) {
    
	File file = new File(fileName);
    
	char[] buffer = null;
    
	try {
	    BufferedReader bufferedReader = new BufferedReader(
	        new FileReader(file));

	    buffer = new char[(int)file.length()];

	    int i = 0;
	    int c = bufferedReader.read();

	    while (c != -1) {
		buffer[i++] = (char)c;
		c = bufferedReader.read();
	    }
	} catch (FileNotFoundException e) {
	    System.err.println("file not found");
	} catch (IOException e) {
	    System.err.println("oh noes");
	}

	return new String(buffer);
    }

	
    /*
     * DESERIALIZE, USED TO OPEN - MAKES OBJECT FROM XML CODE
     */
    public static void deserialize(String file){
	XStream xstream = new XStream();
	xml = readFile(file);
	System.out.println(xml);
	System.out.println("deserializing");
	activeBuilding = (Building)xstream.fromXML(xml);
    }


    /***************************************************************************
     *  MENU BAR CLICKS/INTERACTION
     **************************************************************************/

    // "File -> New" was clicked
    private void MenuNewActionPerformed(java.awt.event.ActionEvent evt) {
	refreshFlag = 0;
	jComboBox1.removeAllItems();
	activeBuilding = new Building();
	activeZone = 0;
	jComboBox1.addItem(activeBuilding.getZoneTitle(activeZone));
	jComboBox1.setSelectedIndex(activeZone);
	refreshFlag=1;
	refreshScreen();
	System.out.println("File -> New was clicked"); }

    // "File -> Open" was clicked
    private void MenuOpenActionPerformed(java.awt.event.ActionEvent evt) {
	System.out.println("File -> Open was clicked");
		JFileChooser c = new JFileChooser();
		c.setAcceptAllFileFilterUsed(false);
		c.addChoosableFileFilter(new xmlFilter());
		int rVal = c.showOpenDialog(Maxwell.this);
		if (rVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("Approve was pressed, loading:\n" +
							   c.getSelectedFile().getAbsolutePath());
			deserialize(c.getSelectedFile().getAbsolutePath());
			activeBuilding.output();
			activeZone = 0;
			refreshFlag = 0;
			jComboBox1.removeAllItems();
			for (int i=0; i<activeBuilding.numZones(); i++)
			    jComboBox1.addItem(activeBuilding.getZoneTitle(i));
			jComboBox1.setSelectedIndex(activeZone);
			refreshFlag = 1;
			refreshScreen();
		}
		if (rVal == JFileChooser.CANCEL_OPTION) {
			System.out.println("Cancel was pressed.  Loading of file stopped");
		}
	}

    // "File -> Save" was clicked
    private void MenuSaveActionPerformed(java.awt.event.ActionEvent evt) {
	setBuildingData();
	setZoneData(activeZone);
	JFileChooser c = new JFileChooser();
	c.setAcceptAllFileFilterUsed(false);
	c.addChoosableFileFilter(new xmlFilter());
	int rVal = c.showSaveDialog(Maxwell.this);
	if (rVal == JFileChooser.APPROVE_OPTION) {
	    String filename = c.getSelectedFile().getAbsolutePath();
	    if (filename.endsWith(".xml") || filename.endsWith(".XML"))
		System.out.println("User specified XML suffix.");
	    else {
		System.out.println("User did not specify XML Suffix.");
		filename = filename + ".xml";
	    }
	    System.out.println("Approve was pressed, loading: " + filename); 
	    serialize(activeBuilding,filename);
	}
	if (rVal == JFileChooser.CANCEL_OPTION) {
	    System.out.println("Cancel was pressed.  Saving of file stopped");
	}
	System.out.println("File -> Save was clicked"); }
    
    // "File -> Print" was clicked
    private void MenuPrintActionPerformed(java.awt.event.ActionEvent evt) {
	System.out.println("File -> Print was clicked"); 
	setBuildingData();
	setZoneData(activeZone);
	JFileChooser c = new JFileChooser();
	c.setAcceptAllFileFilterUsed(false);
	c.addChoosableFileFilter(new pdfFilter());
	int rVal = c.showSaveDialog(Maxwell.this);
	if (rVal == JFileChooser.APPROVE_OPTION) {
	    String filename = c.getSelectedFile().getAbsolutePath();
	    if (filename.endsWith(".pdf") || filename.endsWith(".PDF"))
		System.out.println("User specified PDF suffix.");
	    else {
		    System.out.println("User did not specify PDF Suffix.");
		    filename = filename + ".pdf";
		}
	    System.out.println("Approve was pressed, saving PDF:\n" + filename);
	    FirstPdf.go(activeBuilding, filename);
	}
	if (rVal == JFileChooser.CANCEL_OPTION) {
	    System.out.println("Cancel was pressed.  Saving of file stopped");
	}
    }

    // "File -> Exit" was clicked
    private void MenuExitActionPerformed(java.awt.event.ActionEvent evt) {
	System.out.println("File -> Exit was clicked... goodbye!");
	System.exit(0); }

    // "Help -> About" was clicked
    private void MenuAboutActionPerformed(java.awt.event.ActionEvent evt) {
	System.out.println("Help -> About was clicked");
	JPanel frame = new JPanel(new GridLayout(0,4, 10, 10));
	JOptionPane.showMessageDialog(frame,"Maxwell is an application to calculate the heat gain and heat loss of \na building.  The information can be entered on a zone by zone or \nroom by room basis, or as a whole building.\n\nThis application was created by the CS290 Fall 2011 Software \nDevelopment class of Allegheny College. It is available for \ndownload under the New BSD License.  \nSpecial thanks to Tom Mattis for being our customer.\n\nCopyright (c) 2011, Allegheny College\nAll rights reserved.", "About",-1);	
    }

    // "Help -> Documentation" was clicked
    private void MenuDocumentationActionPerformed(java.awt.event.ActionEvent evt) {
	//String help = readFile("helpdocumentation.txt");
	System.out.println("Help -> Documentation was clicked");
	JPanel frame = new JPanel(new GridLayout(0,4, 10, 10));
	JOptionPane.showMessageDialog(frame,"The Calculate button updates the Zone Gain, Zone Loss, Total Gain and Total loss fields. \n Updating the input fields and pressing Calculate again will update the gain and loss \nfields based on the new inputs.\n\nZONE FUNCTIONS\n-Rename the current zone by clicking Rename and entering the name you wish for the zone.\n-Add a new zone by clicking the Add New button and entering the name for the new zone.\n-Clear the contents of a zone's input fields by clicking the Clear Zone button. This will not \ndelete the entire zone.  It will only clear its contents.\n-Delete a zone by clicking the Delete button.\n\nBUILDING FUNCTIONS\n-Create a new job by clicking File->New.  A new blank job will appear.\n-Open an existing builidng or job by clicking File->Open and navigating to the .xml file that \nyou wish to open.\n-Save the current job by clicking File->Save and navigating to the directory where the job \nshould be saved.  Type a name for the file.\n-To exit the program, click File->Exit or click the X button as you would any other window.", 
				      "Documentation",-1);	
    }

    /***************************************************************************
     * MAIN METHOD
     * @param args the command line arguments
     **************************************************************************/
    public static void main(String args[]) {
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
                new Maxwell().setVisible(true);
            }
        });
	activeBuilding =  new Building();
	activeZone = 0;
	System.out.println("Testing!");
    }

    /***************************************************************************
     * GLOBALLY ACCESIBLE VARIABLES/OBJECTS
     **************************************************************************/
    private static Region region;   // the Region object of activeBuilding
    private static Building activeBuilding; //Building object we're working with
    private static int activeZone; // the index of the current zone
    private static int refreshFlag = 1; // controls whether/not refreshing works
    // ALL OF THE LABELS/BUTTONS/DROPDOWNS/ETC
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox10;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JComboBox jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem MenuNew;
    private javax.swing.JMenuItem MenuOpen;
    private javax.swing.JMenuItem MenuSave;
    private javax.swing.JMenuItem MenuPrint;
    private javax.swing.JMenuItem MenuExit;
    private javax.swing.JMenuItem MenuAbout;
    private javax.swing.JMenuItem MenuDocumentation;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // END OF GLOBAL VARIABLES/OBJECTS

}


/** FILTER CLASSES FOR FILEOPEN/FILESAVE DIALOG BOXES **/

// XML filter
class xmlFilter extends javax.swing.filechooser.FileFilter {
    public boolean accept(File file) {
	if (file.isDirectory()) {
	    return true;
	}
        String filename = file.getName();
        return (filename.endsWith(".xml") || filename.endsWith(".XML"));
    }
    public String getDescription() {
        return "Building File (.xml)";
    }
}

// PDF FILTER
class pdfFilter extends javax.swing.filechooser.FileFilter {
    public boolean accept(File file) {
	if (file.isDirectory()) {
	    return true;
	}
        String filename = file.getName();
        return (filename.endsWith(".pdf") || filename.endsWith(".PDF"));
    }
    public String getDescription() {
        return "PDF Document (.pdf)";
    }
}
