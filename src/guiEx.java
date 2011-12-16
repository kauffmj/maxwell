import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Color;

/** 
	This class demonstrates the basics of setting up a Java Swing GUI uisng the
	BorderLayout. You should be able to use this program to drop in other
	components when building a GUI 
*/
public class guiEx
{


	//declare colors 

	// Initialize all swing objects.
	private JFrame f = new JFrame("Gui Example"); //create Frame
	//f.setLayout(new GridBagLayout());

	// Create the panels, to allow easy layout management
	private JPanel westP = new JPanel(new GridLayout(0,4, 10, 10));
	private JPanel eastP = new JPanel(new GridLayout(0,4, 10, 10));
	private JPanel calcPanel = new JPanel();
	private JPanel topP = new JPanel(new GridLayout(0,12,10,10));
	private JPanel notes = new JPanel();

	// Create buttons
	private JButton calc = new JButton("Calculate");
	private JButton hm1 = new JButton("");
	private JButton gain1 = new JButton("");
	private JButton hm2 = new JButton("");
	private JButton gain2 = new JButton("");

	//Create the border for the jlabels to distinguish them 
	private Border b=  LineBorder.createGrayLineBorder();


	//Create Labels
	private JLabel gWall = new JLabel("Gross Wall");
	private JLabel area = new JLabel("Area");
	private JLabel hm = new JLabel("H.M.");
	private JLabel gain= new JLabel("Gain"); 
	private JLabel blank = new JLabel("");
	private JLabel blank1 = new JLabel("");
	private JLabel area1 = new JLabel("Area");
	private JLabel cm = new JLabel("C.M.");
	private JLabel loss= new JLabel("Loss"); 
	private JLabel gWall1 = new JLabel("Gross Wall");
	private JLabel nWall = new JLabel("North Wall");
	private JLabel sWall = new JLabel("South Wall");
	private JLabel oWall = new JLabel("East/West Wall");
	private JLabel sLite = new JLabel("Sky-Lite");
	private JLabel door = new JLabel("Doors");
	private JLabel windows = new JLabel("Windows");
	private JLabel doors = new JLabel("Doors");
	private JLabel netWall = new JLabel("Net Wall");
	private JLabel netWall1 = new JLabel("");
	private JLabel ceiling = new JLabel("Ceiling");
	private JLabel floor = new JLabel("Floor");
	private JLabel netWall3 = new JLabel("Net Wall");
	private JLabel netWall4 = new JLabel("");
	private JLabel infiltration = new JLabel("Infiltration");
	private JLabel blanki1 = new JLabel("");
	private JLabel blanki2 = new JLabel("");
	private JLabel blanki3 = new JLabel("");
	private JLabel lossSubTotal = new JLabel("Subtotal");
	private JLabel blankl1 = new JLabel("");
	private JLabel blankl2 = new JLabel("");
	private JLabel total1 = new JLabel("Total Heat Lost");
	private JLabel blankt1 = new JLabel("");
	private JLabel blankt2 = new JLabel("");
	private JLabel eCeiling = new JLabel("Ceiling");
	private JLabel eFloor = new JLabel("Floor");
	private JLabel eInf = new JLabel("Infiltration");
	private JLabel eBlanki1 = new JLabel("");
	private JLabel eBlanki2 = new JLabel("");
	private JLabel eBlanki3 = new JLabel("");
	private JLabel people = new JLabel("People");
	private JLabel appliance = new JLabel("Appliance");
	private JLabel eSubtotal = new JLabel("Subtotal");
	private JLabel eBlanks1 = new JLabel("");
	private JLabel eBlanks2 = new JLabel("");
	private JLabel ductLoss = new JLabel("Duct Loss");
	private JLabel totalSensible = new JLabel("Total Sensible");
	private JLabel eBlankts1 = new JLabel("");
	private JLabel eBlankts2 = new JLabel("");
	private JLabel latentInfiltration = new JLabel("Latent Infiltration");
	private JLabel li1 = new JLabel("");
	private JLabel li2 = new JLabel("");
	private JLabel li3 = new JLabel("");
	private JLabel people2 = new JLabel("People");
	private JLabel tLatent = new JLabel("Total Latent");
	private JLabel eBlanktl1 = new JLabel("");
	private JLabel eBlanktl2 = new JLabel("");
	private JLabel tGain = new JLabel("Total Gain");
	private JLabel eBlanktg1 = new JLabel("");
	private JLabel eBlanktg2 = new JLabel("");
	private JLabel first= new JLabel("");
	private JLabel second= new JLabel("");	
	private JLabel third= new JLabel("");
	private JLabel forth= new JLabel("");
	private JLabel notes2 = new JLabel("Notes:");
	

	

	//ANSWER LABELS
	private JLabel nWallA = new JLabel("0");
	private JLabel sWallA = new JLabel("0");
	private JLabel oWallA = new JLabel("0");
	private JLabel sLiteA = new JLabel("0");
	private JLabel doorsA = new JLabel("0");
	private JLabel windowsA = new JLabel("0");
	//private JLabel doorsdoA = new JLabel("");
	private JLabel netWallA = new JLabel("0");
	private JLabel ceilingA = new JLabel("0");
	private JLabel floorA = new JLabel("0");
	private JLabel doorA = new JLabel("0");
	private JLabel netWallA1 = new JLabel("0");
	private JLabel infA = new JLabel("0");
	private JLabel subtotalC = new JLabel("0");
	private JLabel totalC = new JLabel("0");
	private JLabel eCeilingA = new JLabel("0");
	private JLabel eFloorA = new JLabel("0");
	private JLabel eInfA = new JLabel("0");
	private JLabel peopleA = new JLabel("0");
	private JLabel applianceA = new JLabel("0");
	private JLabel subtotalH = new JLabel("0");
	private JLabel ductLossA = new JLabel("0");
	private JLabel totalSensibleA = new JLabel("0");
	private JLabel latentInfA = new JLabel("0");
	private JLabel people2A = new JLabel("0");
	private JLabel totalLatentA = new JLabel("0");
	private JLabel totalGainA = new JLabel("0");
	
	

	

	//misc labels
	private JLabel peopleF = new JLabel("300");
	private JLabel ductLossF = new JLabel("0.05");
	private JLabel people2F = new JLabel("230");
	
	


	//create array for drop down menu
	private String[] factors = {"123"};
	private String[] windowsDoorsHM = {"80","48","40","23"};
	private String[] ceilingHM = {"21","6","4","2"};
	private String[] floorHM = {"21","5","4","2"};
	private String[] infiltrationHM = {"1.26",".95",".63",".32"};
	private String[] wallHM = {"18","7","5","4"};
	/*private String[] windowsDoorsHM = {"80","48","40","23"};
	private String[] windowsDoorsHM = {"80","48","40","23"};
	private String[] windowsDoorsHM = {"80","48","40","23"};
	private String[] windowsDoorsHM = {"80","48","40","23"};
	private String[] windowsDoorsHM = {"80","48","40","23"};
	private String[] windowsDoorsHM = {"80","48","40","23"};
	*///create drop down menus
	//private JComboBox example = new JComboBox(factors);

	//CREATE comboboxes
	private JComboBox nW2 = new JComboBox(factors);
	private JComboBox sW2 = new JComboBox(factors);
	private JComboBox oW2 = new JComboBox(factors);
	private JComboBox sLite2 = new JComboBox(factors);
	private JComboBox door2 = new JComboBox(factors);
	private JComboBox doors2 = new JComboBox(factors);
	private JComboBox ceiling2 = new JComboBox(factors);
	private JComboBox floor2 = new JComboBox(factors);
	private JComboBox windows2 = new JComboBox(factors);
	private JComboBox netWall2 = new JComboBox(factors);
	private JComboBox netWall5 = new JComboBox(factors);
	private JComboBox infiltration2 = new JComboBox(factors);
	private JComboBox einfiltration2 = new JComboBox(factors);
	private JComboBox appliance2 = new JComboBox(factors);
	private JComboBox latentInfiltration2 = new JComboBox(factors);
	private JComboBox eCeiling2 = new JComboBox(factors);
	private JComboBox eFloor2 = new JComboBox(factors);
	
	
	
	

	//Create text fields
	private JTextField gWallA = new JTextField("0", 7);
	private JTextField gWallA2= new JTextField("0", 7);
	private JTextField gWallC = new JTextField("0", 7);
	private JTextField nWall1 = new JTextField("0", 7);
	private JTextField sWall1 = new JTextField("0", 7);
	private JTextField oWall1 = new JTextField("0", 7);
	private JTextField sLite1 = new JTextField("0", 7);
	private JTextField ceiling1 = new JTextField("0",7);
	private JTextField wind1 = new JTextField("0",7);
	private JTextField doors1 = new JTextField("0",7);
	private JTextField netw1 = new JTextField("0",7);
	private JTextField door1 = new JTextField("0",7);
	private JTextField floor1 = new JTextField("0",7);
	private JTextField infiltrationArea = new JTextField("Area" , 7);
	private JTextField infiltrationHeight = new JTextField("Height" , 7);
	private JTextField eCeiling1 = new JTextField("0",7);
	private JTextField eFloor1 = new JTextField("0",7);
	private JTextField eInfArea = new JTextField("Area",7);
	private JTextField eInfHeight = new JTextField("Height",7);
	private JTextField people1 = new JTextField("0",7);
	private JTextField appliance1 = new JTextField("0",7);
	private JTextField ductLoss1 = new JTextField("0",7);
	private JTextField latInfArea = new JTextField("0",7);
	private JTextField latInfHeight = new JTextField("0",7);
	private JTextField people3 = new JTextField("0",7);
	private JTextField eInfArea1 = new JTextField("Area",7);
	private JTextField eInfHeight1 = new JTextField("Height",7);
	

	/*private JTextField ceiling1 = new JTextField(null,7);
	private JTextField ceiling1 = new JTextField(null,7);
	private JTextField ceiling1 = new JTextField(null,7);
*/
    // Create the  Menu
	private JMenuBar mb = new JMenuBar(); // Menubar
	private JMenu mnuFile = new JMenu("File"); // File Entry on Menu bar
	private JMenuItem mnuItemQuit = new JMenuItem("Quit"); // Quit sub item
	private JMenu mnuHelp = new JMenu("About"); // Help Menu entry
	private JMenuItem mnuItemAbout = new JMenuItem("About Maxwell"); // About Entry
	private JMenuItem mnuItemNew = new JMenuItem("New");
	private JMenuItem mnuItemOpen = new JMenuItem("Open");
	private JMenuItem mnuItemSave = new JMenuItem("Save");
	private JMenuItem mnuItemPrint = new JMenuItem("Print to PDF");
	private JMenuItem mnuItemDocumentation = new JMenuItem("Documentation");




	//create extra stuff
	private JLabel jobName = new JLabel("Job Name");
	private JLabel date = new JLabel("Date");
	private JLabel customer = new JLabel("Customer");
	private JLabel jobNumber = new JLabel("Job Number");
	private JLabel region = new JLabel("Region");
	private JLabel address = new JLabel("Address");

	//textfields
	private JTextField jobNameT = new JTextField(null, 10);
	private JTextField dateT = new JTextField(null , 10);
	private JTextField customerT = new JTextField(null , 10);
	private JTextField jobNumberT = new JTextField(null , 10);
	///private JTextField addressT = new JTextField(null , 10);

	//combo
	private JComboBox region1 = new JComboBox(factors);

	//textarea
	private JTextArea notes1 = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(notes1);
	private JTextArea addressT = new JTextArea(10,3);
	JScrollPane scrollPane1 = new JScrollPane(addressT);

    /** Constructor for the GUI */
    public guiEx(){
		// Set menubar
        f.setJMenuBar(mb);
        
	//set layout
	GridBagLayout gridbag = new GridBagLayout();
	GridBagConstraints t = new GridBagConstraints();
	GridBagConstraints e = new GridBagConstraints();
	GridBagConstraints w = new GridBagConstraints();
	GridBagConstraints c = new GridBagConstraints();
	GridBagConstraints n = new GridBagConstraints();
	f.setLayout(gridbag);
		//Build Menus
	mnuFile.add(mnuItemNew);
	mnuFile.add(mnuItemOpen);
	mnuFile.add(mnuItemSave);
	mnuFile.add(mnuItemPrint);
        mnuFile.add(mnuItemQuit);  // Create Quit line
	mnuHelp.add(mnuItemDocumentation);
        mnuHelp.add(mnuItemAbout); // Create About line
        mb.add(mnuFile);        // Add Menu items to form
        mb.add(mnuHelp);
	

	//Disable buttons
	gain1.setEnabled(false);
	hm1.setEnabled(false);
	gain2.setEnabled(false);
	hm2.setEnabled(false);
        //set borders
	gWall.setBorder(b);
	loss.setBorder(b);
	area.setBorder(b);
	cm.setBorder(b);
	blank1.setBorder(b);
	area1.setBorder(b);
	blank.setBorder(b);
	gain.setBorder(b);
	hm.setBorder(b);
	gWall1.setBorder(b);
	nWall.setBorder(b);
	sWall.setBorder(b);
	oWall.setBorder(b);
	nWallA.setBorder(b);
	sWallA.setBorder(b);
	oWallA.setBorder(b);
	windowsA.setBorder(b);
	doorsA.setBorder(b);
	netWall.setBorder(b);
	netWall1.setBorder(b);
	netWallA.setBorder(b);
	windows.setBorder(b);
	doors.setBorder(b);
	sLite.setBorder(b);
	sLiteA.setBorder(b);
	ceiling.setBorder(b);
	ceilingA.setBorder(b);
	door.setBorder(b);
	doorA.setBorder(b);
	floor.setBorder(b);
	floorA.setBorder(b);
	netWall3.setBorder(b);
	netWall4.setBorder(b);
	netWallA1.setBorder(b);
	//blanki1.setBorder(b);
	blanki2.setBorder(b);
	blanki3.setBorder(b);
	infiltration.setBorder(b);
	infA.setBorder(b);
	lossSubTotal.setBorder(b);
	blankl1.setBorder(b);
	blankl2.setBorder(b);
	total1.setBorder(b); 
	blankt1.setBorder(b); 
	blankt2.setBorder(b); 
	subtotalC.setBorder(b);
	totalC.setBorder(b);
	eCeiling.setBorder(b);
	eFloor.setBorder(b);
	eInf.setBorder(b);	
	eBlanki1.setBorder(b);
	eBlanki2.setBorder(b);
	eBlanki3.setBorder(b);
	people.setBorder(b);
	appliance.setBorder(b);
	eSubtotal.setBorder(b);
	eBlanks1.setBorder(b);
	eBlanks2.setBorder(b);
	ductLoss.setBorder(b);
	totalSensible.setBorder(b);
	eBlankts1.setBorder(b);
	eBlankts2.setBorder(b);
	latentInfiltration.setBorder(b);
	li1.setBorder(b);
	li2.setBorder(b);
	li3.setBorder(b);
	people2.setBorder(b);
	tLatent.setBorder(b);
	eBlanktl1.setBorder(b);
	eBlanktl2.setBorder(b);
	tGain.setBorder(b);
	eBlanktg1.setBorder(b);
	eBlanktg2.setBorder(b);
	eCeilingA.setBorder(b);
	eFloorA.setBorder(b);
	eInfA.setBorder(b);
	peopleA.setBorder(b);
	applianceA.setBorder(b);
	subtotalH.setBorder(b);
	ductLossA.setBorder(b);
	totalSensibleA.setBorder(b);
	latentInfA.setBorder(b);
	people2A.setBorder(b);
	totalLatentA.setBorder(b);
	totalGainA.setBorder(b);
	jobName.setBorder(b);
	date.setBorder(b);
	customer.setBorder(b);
	jobNumber.setBorder(b);
	region.setBorder(b);
	address.setBorder(b);
	first.setBorder(b);
	second.setBorder(b);
	third.setBorder(b);
	forth.setBorder(b);
	westP.setBorder(b);
	eastP.setBorder(b);
	topP.setBorder(b);
	notes1.setBorder(b);
        // Setup Main Frame

	westP.add(blank);
	westP.add(area);
	westP.add(hm);
	westP.add(gain);

	eastP.add(blank1);
	eastP.add(area1);
	eastP.add(cm);
	eastP.add(loss);

	westP.add(gWall);
	westP.add(gWallA);
	westP.add(first);
	westP.add(second);
	
	eastP.add(gWall1);
	eastP.add(gWallA2);
	eastP.add(third);
	eastP.add(forth);

	westP.add(nWall);
	westP.add(nWall1);
	westP.add(nW2);
	westP.add(nWallA);

	eastP.add(windows);
	eastP.add(wind1);
	eastP.add(windows2);
	eastP.add(windowsA);

	westP.add(sWall);
	westP.add(sWall1);
	westP.add(sW2);
	westP.add(sWallA);

	eastP.add(doors);
	eastP.add(doors1);
	eastP.add(doors2);
	eastP.add(doorsA);

	westP.add(oWall);
	westP.add(oWall1);
	westP.add(oW2);
	westP.add(oWallA);

	eastP.add(netWall);
	eastP.add(netWall1);
	eastP.add(netWall2);
	eastP.add(netWallA);

	westP.add(sLite);
	westP.add(sLite1);
	westP.add(sLite2);
	westP.add(sLiteA);

	eastP.add(ceiling);
	eastP.add(ceiling1);
	eastP.add(ceiling2);
	eastP.add(ceilingA);

	westP.add(door);
	westP.add(door1);
	westP.add(door2);
	westP.add(doorA);
	
	eastP.add(floor);
	eastP.add(floor1);
	eastP.add(floor2);
	eastP.add(floorA);

	westP.add(netWall3);
	westP.add(netWall4);
	westP.add(netWall5);
	westP.add(netWallA1);
	
	eastP.add(infiltration);
	eastP.add(infiltrationArea);
	eastP.add(infiltration2);
	eastP.add(infA);
	eastP.add(blanki1);
	eastP.add(infiltrationHeight);
	eastP.add(blanki2);
	eastP.add(blanki3);

	eastP.add(lossSubTotal);
	eastP.add(blankl1);
	eastP.add(blankl2);
	eastP.add(subtotalC);

	eastP.add(total1);
	eastP.add(blankt1);
	eastP.add(blankt2);
	eastP.add(totalC);

	westP.add(netWall3);
	westP.add(netWall4);
	westP.add(netWall5);
	westP.add(netWallA1);	

	westP.add(eCeiling);
	westP.add(eCeiling1);
	westP.add(eCeiling2);
	westP.add(eCeilingA);
	
	westP.add(eFloor);
	westP.add(eFloor1);
	westP.add(eFloor2);
	westP.add(eFloorA);

	westP.add(eInf);
	westP.add(eInfArea);
	westP.add(einfiltration2);
	westP.add(eInfA);
	westP.add(eBlanki1);	
	westP.add(eInfHeight);
	westP.add(eBlanki2);
	westP.add(eBlanki3);
	
	westP.add(people);
	westP.add(people1);
	westP.add(peopleF);
	westP.add(peopleA);	
	
	westP.add(appliance);
	westP.add(appliance1);
	westP.add(appliance2);
	westP.add(applianceA);

	westP.add(eSubtotal);
	westP.add(eBlanks1);
	westP.add(eBlanks2);
	westP.add(subtotalH);	
	

	westP.add(ductLoss);
	westP.add(ductLoss1);
	westP.add(ductLossF);
	westP.add(ductLossA);
	
	westP.add(totalSensible);
	westP.add(eBlankts1);
	westP.add(eBlankts2);
	westP.add(totalSensibleA);

	westP.add(latentInfiltration);
	westP.add(eInfArea1);
	westP.add(latentInfiltration2);
	westP.add(latentInfA);
	westP.add(li1);
	westP.add(eInfHeight1);
	westP.add(li2);
	westP.add(li3);
	
	westP.add(people2);
	westP.add(people3);
	westP.add(people2F);
	westP.add(people2A);

	westP.add(tLatent);
	westP.add(eBlanktl1);
	westP.add(eBlanktl2);
	westP.add(totalLatentA);

	westP.add(tGain);
	westP.add(eBlanktg1);
	westP.add(eBlanktg2);
	westP.add(totalGainA);
	
	eastP.setSize(100,100);
	notes.setSize(100,100);
	calcPanel.add(calc);
	
	topP.add(jobName);
	topP.add(jobNameT);
	topP.add(date);
	topP.add(dateT);
	topP.add(customer);
	topP.add(customerT);
	topP.add(jobNumber);
	topP.add(jobNumberT);
	topP.add(region);
	topP.add(region1);
	topP.add(address);

	addressT.setLineWrap(true);
	topP.add(addressT);

	//int pos = 6;
    	//notes1.insert("  ", pos);

	//notes1.setColumns(7);
	//notes1.setRows(10);
	notes1.setColumns(20);
        notes1.setRows(5);
	notes1.setLineWrap(true);
        scrollPane.setViewportView(notes1);

	notes.setBorder(b);
	notes.add(notes2,BorderLayout.NORTH);
	notes.add(notes1, BorderLayout.SOUTH);
	e.fill = GridBagConstraints.BOTH;
	e.insets = new Insets(10,10,10,10);  //top padding
	e.gridwidth=3;
	e.gridheight = 1;
	e.gridy=1;
	e.gridx = 3;
	e.weightx=.5;
	e.anchor = GridBagConstraints.NORTHEAST;


	w.insets = new Insets(10,10,10,10);  //top padding
	w.gridwidth=3;
	w.gridheight = 3;
	w.gridy=1;
	w.gridx =0;
	//w.weightx = .5;
	//w.anchor = GridBagConstraints.NORTHWEST;
	w.fill = GridBagConstraints.BOTH;

	gridbag.setConstraints(westP, w);
	gridbag.setConstraints(eastP, e);
	gridbag.setConstraints(f, e);

	//t.anchor = GridBagConstraints.NORTH;
	t.gridy = 0;
	t.gridwidth=0;
	//t.weightx = 1.0;
	//t.gridx = 0;
	t.fill = GridBagConstraints.BOTH;


	gridbag.setConstraints(topP,t);
		
	//topP.setBackground(Color.WHITE);
	//topP.setForeground(Color.WHITE);	
	westP.setBackground(Color.ORANGE);
	eastP.setBackground(Color.cyan);
	eastP.setForeground(Color.WHITE);

	c.gridy=4;
	c.fill = GridBagConstraints.BOTH;
	c.gridwidth = 3;
	c.gridx = 2;
	c.anchor = GridBagConstraints.SOUTH;
	gridbag.setConstraints(calcPanel, c);
	
	n.fill = GridBagConstraints.BOTH;
	n.insets = new Insets(10,10,10,10);
	n.gridwidth = 3;
	n.gridheight = 1;
	n.gridy = 3;
	n.gridx = 3;
	//n.anchor = GridBagConstraints.SOUTHEAST;
	//n.weighty = 1;
	//n.weightx = 1;

	gridbag.setConstraints(notes , n);
	
	f.getContentPane().add(westP);
	f.getContentPane().add(eastP);
	f.getContentPane().add(topP);
	f.getContentPane().add(calcPanel);
	f.getContentPane().add(notes);
	//topP.add(example);

		/*topP.add(topP, BorderLayout.NORTH);
		topP.add(topP1,BorderLayout.NORTH);
		topP.add(leftP, BorderLayout.WEST);*/

		// Allows the Swing App to be closed
        f.addWindowListener(new ListenCloseWdw());
		
		//Add Menu listener
        mnuItemQuit.addActionListener(new ListenMenuQuit());
	
	//Add action listener to calculate button
	calc.addActionListener(new CalcListener());
    }
	
    public class ListenMenuQuit implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);         
        }
    }
	
    public class ListenCloseWdw extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            System.exit(0);         
        }
    }

	public class CalcListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int gWallArea = Integer.parseInt(gWallA.getText());
			int gWallArea2 = Integer.parseInt(gWallA2.getText());
			//String factor1 = (String)example.getSelectedItem();
			//int fac = Integer.parseInt(factor1);
			System.out.println("button was clicked.... these are the values: " + gWallArea + "  " + gWallArea2);
			//System.out.println("the value in the drop down menu: " + fac);
		}
	}
	
    public void launchFrame(){
        // Display Frame
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack(); //Adjusts panel to components for display
        f.setVisible(true);
    }
    
    public static void main(String args[]){
        guiEx gui = new guiEx();
        gui.launchFrame();
    }
}
