/**
 * Maxwell's 'Zone' class
 *
 * This class is used to store measurements and calculations pertaining to a
 * single room or zone of a Building.
 *
 * Constructor:
 *   new Zone(String name) = creates a blank Zone with title=name
 *
 * Variables:
 *   String title = a descriptive name of the particular instance of Zone
 *   float data[28][4] = a 2D array used to store all of the Zone's values
 *                       (see ZoneData.pdf for detailed information)
 *   int dropdowns[8] = an array denoting which item is selected in each of the
 *                      big-8 dropdown boxes: NetWallCM, CeilingCM, FloorCM,
 *                                            InfiltrationCM, WindowsHM, 
 *                                            DoorsHM, FloorHM, MarginMultiplier
 *
 * Methods:
 *   void setTitle(String) = set's the Zone's title to a passed String
 *   String getTitle() = return's the String of the Zone's title
 *   void setData(int i, int j, float value) = stores value in data[i][j] 
 *   float getData(int i, int j) = returns the value stored in data[i][j]
 *   void setDropdowns(int[] values) = save new choices in dropdown selections
 *   int[] getDropdowns() = return the list of currently selected dropdowns
 *   void calc(Region reg) = runs the calculations based upon currently stored
 *                           values and the passed Region
 *   void calcPrep() = a helper method to calc() which copies some values around
 *   void output() = quickly print contents of title and data[][] to terminal 
 */
import java.io.*;

public class Zone {

    // the descriptive label of this instance of Zone
    private String title;
    // the values of this instance of Zone, as laid out in the spreadsheet
    // see further documentation, or this.calc(),  for more details
    private float[][] data = new float[28][4];
    // The positions of selected items of the big-8 dropdown boxes
    private int[] dropdowns = new int[8];

    // defining a new instance of the class, given a label
    public Zone(String name) {
	title = name;
	for (int i=0; i<data.length; i++)
	    for (int j=0; j<data[i].length; j++)
		data[i][j] = (float)0;
    }

    // methods to get and set the title/name of the zone
    public void setTitle(String name) {
	title = name; }
    public String getTitle() {
	return title; }

    // method to set the value of any location in the data[][]
    public void setData(int i, int j, float value) {
	data[i][j] = value;
    }
    // method to get the value of any location in the data[][]
    public float getData(int i, int j) {
	return data[i][j];
    }

    // method to set the values of dropdowns[]
    public void setDropdowns(int[] values) {
	for (int i=0; i<dropdowns.length; i++)
	    dropdowns[i] = values[i];
    }
    // method to get the dropdowns[] array
    public int[] getDropdowns() {
	return dropdowns;
    }

    /* calcPrep copies primary input values into their respective duplicate
     * places.  See ZoneData.pdf for more details, as this method gets all the 
     * blue values from the yellow input values */
    public void calcPrep() {
	data[15][0] = data[9][0];  // copy infiltration area
	data[15][1] = data[9][1];  // copy infiltration height
	data[16][0] = data[10][0]; // copy number of people
	data[19][0] = data[0][0];  // copy gross wall area
	// calculate total window area from N/S/EW/SkyLight Areas
	data[20][0] = data[1][0] + data[2][0] + data[3][0] + data[4][0];
	data[21][0] = data[5][0];  // copy door area
	data[23][0] = data[7][0];  // copy ceiling area
	data[24][0] = data[8][0];  // copy floor area 
	data[25][0] = data[9][0];  // copy infiltration area
	data[25][1] = data[9][1];  // copy infiltration height
  }

    public void calc(Region reg) {
	// START LEFT-HAND-SIDE OF SPREADSHEET
	calcPrep();  // copy the inputs around to their duplicate values
	// calculate Gain of northWindow through doors
	for (int i=1; i<6; i++)
	    data[i][3] = data[i][0]*data[i][1];
	// calculate netWall area
	data[6][0] = data[0][0];
	for (int i=1; i<6; i++)
	    data[6][0] -= data[i][0];
	// calculate Gain of netWall through floor
	for (int i=6; i<9; i++)
	    data[i][3] = data[i][0]*data[i][1];
	// calculate Gain of infiltration
	data[9][3] = data[9][0] * data[9][1] * data[9][2];
	// calculate Gain of People
	data[10][1] = (float)300;
	data[10][3] = data[10][0] * data[10][1];
	// calculate Gain of Appliance
	data[11][3] = data[11][0];
	// calculate subTotal of Gains
	data[12][3] = 0;
	for (int i = 1; i<12; i++)
	    data[12][3] += data[i][3];
	// calculate duct loss
	data[13][0] = data[12][3];
	data[13][1] = (float)0.05;
	data[13][3] = data[13][0] * data[13][1];
	// calculate totalSensible
	data[14][3] = data[12][3] + data[13][3];
	// calculate latentinfiltration
	data[15][3] = data[15][0] * data[15][1] * data[15][2];
	// calculate peopleLatent
	data[16][1] = (float)230;
	data[16][3] = data[16][0] * data[16][1];
	// calculate totalLatent
	data[17][3] = data[15][3] + data[16][3];
	// calculate totalGain
	data[18][0] = data[14][3];
	data[18][1] = data[17][3];
	data[18][3] = data[18][0] + data[18][1];
	// END LEFT-HAND-SIDE OF SPREADSHEET
	// BEGIN RIGHT-HAND-SIDE OF SPREADSHEET
	data[22][0] = data[6][0];  // copy net wall area from left hand side
	// calculate losses of windows through floor
	for (int i=20; i<25; i++)
	    data[i][3] = data[i][0] * data[i][1];
	// calculate loss of infiltration
	data[25][3] = data[25][0] * data[25][1] * data[25][2];
	// calculate heat loss subtotal
	data[26][3] = 0;
	for (int i=20; i<26; i++)
	    data[26][3] += data[i][3];
	// calculate total loss
	data[27][0] = data[26][3];
	data[27][3] = data[27][0] * data[27][1];
	// END RIGHT-HAND-SIDE OF SPREADSHEET
    }

    public void output() {
	for (int i=0; i<data.length; i++) {
	    System.out.print(i + " = [" + data[i][0]);
	    for (int j=1; j<data[i].length; j++)
		System.out.print(", " + data[i][j]);
	    System.out.println("]");
	}
    }

 public void nomultsoutput() {
try{
	System.out.println("Into fileoutput()");
	PrintWriter fout = new PrintWriter(new FileWriter("Building.rtf",true));
	fout.println("HEAT GAIN");	
	fout.println("\t\t\tArea\t\tGain");
	for (int i=0; i<data.length; i++) {
	if(i == 0)
	    fout.println("Gross Wall:\t\t" + data[i][0]);
	else if(i == 1)
	    fout.println("North Window:\t\t" + data[i][0] + "\t\t" + data[i][3]);
	else if(i == 2)
	    fout.println("South Window:\t\t" + data[i][0] + "\t\t" + data[i][3] );
	else if(i == 3)
	    fout.println("East/West Window:\t" + data[i][0] + "\t\t" + data[i][3] );
	else if(i == 4)
	    fout.println("Skylight:\t\t" + data[i][0] + "\t\t" + data[i][3]);
	else if(i == 5)
	    fout.println("Doors:\t\t\t" + data[i][0] + "\t\t" + data[i][3]);
	else if(i == 6)
	    fout.println("Net Wall:\t\t" + data[i][0] + "\t\t" + data[i][3]);
	else if(i == 7)
	    fout.println("Ceiling:\t\t" + data[i][0] + "\t\t" + data[i][3]);
	else if(i == 8)
	    fout.println("Floor:\t\t\t" + data[i][0] + "\t\t" + data[i][3]);
	else if(i == 9)
	    fout.println("Infiltration:\t\t" + data[i][0] + "\t\t" + data[i][3] + "\tHeight = " + data[i][1]);
	else if(i == 10)
	    fout.println("People:\t\t\t" + data[i][0] + "\t\t" + data[i][3]);
//+ "\n\t\tSensible Gain = " + data[i][3] + "\n\t\tLatent Gain = " + data[i+6][3]);
	else if(i == 11)
	    fout.println("Appliance:\t\t" + data[i][0] + "\t\t" + data[i][3]);
	else if(i == 12)
	    fout.println("Subtotal Gain:\t\t\t\t" + data[i+1][3]);
	else if(i == 13)
	    fout.println("Duct Loss:\t\t\t\t" + data[i][3]);
	else if(i == 14)
	    fout.println("Total Sensible Gain:\t\t\t" + data[i][3]);
	else if(i == 15)
	    fout.println("Latent Infiltration:\t" + data[i][0] + "\t\t" + data[i][3] + "\t\tHeight = " + data[i][1]);
	else if(i == 16)
	    fout.println("Latent People Gain\t\t\t" + data[i][3]);
	else if(i == 17)
	    fout.println("Total Latent Gain:\t\t\t" + data[i][3]);
	else if(i == 18){
	    fout.println("TOTAL GAIN:\t\t\t\t" + data[i][3]);
	    fout.println();
	    fout.println();
	    fout.println("HEAT LOSS");
	    fout.println("\t\t\tArea\t\tLoss");
            fout.println();}
	else if(i == 19)
	    fout.println("Gross Wall:\t\t" + data[i][3]);
	else if(i == 20)
	    fout.println("All Windows:\t\t" + data[i][0] + "\t\t" + data[i][3]);
	else if(i == 21)
	    fout.println("Doors:\t\t\t" + data[i][0] + "\t\t" + data[i][3]);
	else if(i == 22)
	    fout.println("Net Wall:\t\t" + data[i][0] + "\t\t" + data[i][3]);
	else if(i == 23)
	    fout.println("Ceiling:\t\t" + data[i][0] + "\t\t" + data[i][3]);
	else if(i == 24)
	    fout.println("Floor:\t\t\t" + data[i][0] + "\t\t" + data[i][3]);
	else if(i == 25)
	    fout.println("Infiltration:\t\t" + data[i][0] + "\t\t" + data[i][3] + "\t\tHeight = " + data[i][1]);
	else if(i == 26) 
	    fout.println("Heat Loss Subtotal\t\t\t" + data[i][3]);
	else if (i == 27){
	    fout.println("TOTAL LOSS:\t\t\t\t" + data[i][3]);
	    //for (int j=1; j<data[i].length; j++)
		//System.out.print(", " + data[i][j]);
	    //System.out.println("]");
	    fout.close();}
	}
}catch (Exception e){
	//oh noes
}
    }

public void bigfileoutput(){

try{
	System.out.println("Into fileoutput()");
	PrintWriter fout = new PrintWriter(new FileWriter("Building.rtf",true));
	fout.println("HEAT GAIN");
	for (int i=0; i<data.length; i++) {
	if(i == 0)
	    fout.println("Gross Wall:\t\t" + "\n\t\tArea = " + data[i][0]);
	else if(i == 1)
	    fout.println("North Window:\t" + "\n\t\tArea = " + data[i][0] + "\n\t\tHeat Multiplier = " + data[i][1] + "\n\t\tGain = " + data[i][3]);
	else if(i == 2)
	    fout.println("South Window:\t" + "\n\t\tArea = " + data[i][0] + "\n\t\tHeat Multiplier = " + data[i][1] + "\n\t\tGain = " + data[i][3]);
	else if(i == 3)
	    fout.println("East/West Window:\t" + "\n\t\tArea = " + data[i][0] + "\n\t\tHeat Multiplier = " + data[i][1] + "\n\t\tGain = " + data[i][3]);
	else if(i == 4)
	    fout.println("Skylight:\t\t" + "\n\t\tArea = " + data[i][0] + "\n\t\tHeat Multiplier = " + data[i][1] + "\n\t\tGain = " + data[i][3]);
	else if(i == 5)
	    fout.println("Doors:\t\t" + "\n\t\tArea = " + data[i][0] + "\n\t\tHeat Multiplier = " + data[i][1] + "\n\t\tGain = " + data[i][3]);
	else if(i == 6)
	    fout.println("Net Wall:\t\t" + "\n\t\tArea = " + data[i][0] + "\n\t\tHeat Multiplier = " + data[i][1] + "\n\t\tGain = " + data[i][3]);
	else if(i == 7)
	    fout.println("Ceiling:\t\t" + "\n\t\tArea = " + data[i][0] + "\n\t\tHeat Multiplier = " + data[i][1] + "\n\t\tGain = " + data[i][3]);
	else if(i == 8)
	    fout.println("Floor:\t\t" + "\n\t\tArea = " + data[i][0] + "\n\t\tHeat Multiplier = " + data[i][1] + "\n\t\tGain = " + data[i][3]);
	else if(i == 9)
	    fout.println("Infiltration:\t\t" + "\n\t\tArea = " + data[i][0] + "\n\t\tHeight = " + data[i][1] + "\n\t\tHeat Multiplier = " + data[i][2] + "\n\t\tGain = " + data[i][3]);
	else if(i == 10)
	    fout.println("People:\t\t" + "\n\t\tNumber of People = " + data[i][0] + "\n\t\tSensible Gain = " + data[i][3] + "\n\t\tLatent Gain = " + data[i+6][3]);
	else if(i == 11)
	    fout.println("Appliance Gain: " + data[i][0]);
	else if(i == 12)
	    fout.println("Duct Loss:" + "\n\t\tSubtotal Gain = " + data[i][3] + "\n\t\tLoss Factor = " + data[i+1][1] + "\n\t\tDuct Loss = " + data[i+1][3]);
	//else if(i == 13)
	    //System.out.println("Heat Gain Subtotal\t" + " = [" + data[i][0]);
	else if(i == 14)
	    fout.println("Total Sensible Gain: " + data[i][0]);
	else if(i == 15)
	    fout.println("Latent Infiltration:\t" + "\n\t\tArea = " + data[i][0] + "\n\t\tHeight = " + data[i][1] + "\n\t\tHeat Multiplier = " + data[i][2] + "\n\t\tLoss = " + data[i][3]);
	//else if(i == 16)
	    //System.out.println("Number of People\t" + "\n\tArea = " + data[i][0]);
	else if(i == 17)
	    fout.println("Total Latent Gain: " + data[i][3]);
	else if(i == 18){
	    fout.println("TOTAL GAIN: " + data[i][3]);
	    fout.println();
	    fout.println("HEAT LOSS");
            fout.println();}
	else if(i == 19)
	    fout.println("Gross Wall Area: " + data[i][3]);
	else if(i == 20)
	    fout.println("All Windows: " + "\n\t\tArea = " + data[i][0] + "\n\t\tCooling Multiplier = " + data[i][1] + "\n\t\tLoss = " + data[i][3]);
	else if(i == 21)
	    fout.println("Doors:" + "\n\t\tArea = " + data[i][0] + "\n\t\tCooling Multiplier = " + data[i][1] + "\n\t\tLoss = " + data[i][3]);
	else if(i == 22)
	    fout.println("Net Wall:\t\t" + "\n\t\tArea = " + data[i][0] + "\n\t\tCooling Multiplier = " + data[i][1] + "\n\t\tLoss = " + data[i][3]);
	else if(i == 23)
	    fout.println("Ceiling:\t\t" + "\n\t\tArea = " + data[i][0] + "\n\t\tCooling Multiplier = " + data[i][1] + "\n\t\tLoss = " + data[i][3]);
	else if(i == 24)
	    fout.println("Floor:\t\t" + "\n\t\tArea = " + data[i][0] + "\n\t\tCooling Multiplier = " + data[i][1] + "\n\t\tLoss = " + data[i][3]);
	else if(i == 25)
	    fout.println("Infiltration:" + "\n\t\tArea = " + data[i][0] + "\n\t\tHeight = " + data[i][1] + "\n\t\tCooling Multiplier = " + data[i][2] + "\n\t\tLoss = " + data[i][3]);
	//else if(i == 26)
	    //System.out.println("BLANK\t\t\t" + " = [" + data[i][0]);
	else if (i == 27){
	    fout.println("Total Loss:\t\t" + "\n\t\tLoss Subtotal = " + data[i][0] + "\n\t\tMargin Multiplier = " + data[i][1] + "\n\t\tTOTAL LOSS = " + data[i][3]);
fout.close();}
	    //for (int j=1; j<data[i].length; j++)
		//System.out.print(", " + data[i][j]);
	    //System.out.println("]");
	}
}catch (Exception e){
	//oh noes
}
    }



    public void fileoutput1() {
	try{
	//System.out.println("Into fileoutput()");
	PrintWriter pout = new PrintWriter(new FileWriter("Building.rtf",true));
	for (int i=0; i<data.length; i++) {
	//System.out.println("Into first for loop");
	pout.print("hello from zone");
	    pout.print(i + " = [" + data[i][0]);
	    for (int j=1; j<data[i].length; j++){
		//System.out.println("Into second for loop");
		pout.print(", " + data[i][j]);}
	    pout.println("]");
	    pout.close();
	}
	}catch(Exception e){
	    System.err.println("There has been an error");
}
    }
}
