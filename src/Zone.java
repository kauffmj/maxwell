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

 public void bigfileoutput() {
try{
	//System.out.println("Into fileoutput()");
	PrintWriter pout = new PrintWriter(new FileWriter("Building.rtf",true));
	for (int i=0; i<data.length; i++) {
	if(i == 0)
	    System.out.println("Gross Wall:\t\t" + "\n\t\tArea = " + data[i][0]);
	else if(i == 1)
	    System.out.println("North Window:\t" + "\n\t\tArea = " + data[i][0] + "\n\t\tHeat Multiplier = " + data[i][1] + "\n\t\tGain = " + data[i][3]);
	else if(i == 2)
	    System.out.println("South Window:\t" + "\n\t\tArea = " + data[i][0] + "\n\t\tHeat Multiplier = " + data[i][1] + "\n\t\tGain = " + data[i][3] );
	else if(i == 3)
	    System.out.println("East/West Window:\t" + "\n\t\tArea = " + data[i][0] + "\n\t\tHeat Multiplier = " + data[i][1] + "\n\t\tGain = " + data[i][3] );
	else if(i == 4)
	    System.out.println("Skylight:\t\t" + "\n\t\tArea = " + data[i][0] + "\n\t\tHeat Multiplier = " + data[i][1] + "\n\t\tGain = " + data[i][3]);
	else if(i == 5)
	    System.out.println("Doors:\t\t" + "\n\t\tArea = " + data[i][0] + "\n\t\tHeat Multiplier = " + data[i][1] + "\n\t\tGain = " + data[i][3]);
	else if(i == 6)
	    System.out.println("Net Wall:\t\t" + "\n\t\tArea = " + data[i][0] + "\n\t\tHeat Multiplier = " + data[i][1] + "\n\t\tGain = " + data[i][3]);
	else if(i == 7)
	    System.out.println("Ceiling:\t\t" + "\n\t\tArea = " + data[i][0] + "\n\t\tHeat Multiplier = " + data[i][1] + "\n\t\tGain = " + data[i][3]);
	else if(i == 8)
	    System.out.println("Floor:\t\t" + "\n\t\tArea = " + data[i][0] + "\n\t\tHeat Multiplier = " + data[i][1] + "\n\t\tGain = " + data[i][3]);
	else if(i == 9)
	    System.out.println("Infiltration:\t\t" + "\n\t\tArea = " + data[i][0] + "\n\t\tHeight = " + data[i][1] + "\n\t\tHeat Multiplier = " + data[i][2] + "\n\t\tGain = " + data[i][3]);
	else if(i == 10)
	    System.out.println("Number of People\t" + " = [" + data[i][0]);
	else if(i == 11)
	    System.out.println("Appliance Gain\t\t" + " = [" + data[i][0]);
	else if(i == 12)
	    System.out.println("BLANK\t\t\t" + " = [" + data[i][0]);
	else if(i == 13)
	    System.out.println("Heat Gain Subtotal\t" + " = [" + data[i][0]);
	else if(i == 14)
	    System.out.println("BLANK\t\t\t" + " = [" + data[i][0]);
	else if(i == 15)
	    System.out.println("Latent Infiltration\t" + " = [" + data[i][0]);
	else if(i == 16)
	    System.out.println("Number of People\t" + " = [" + data[i][0]);
	else if(i == 17)
	    System.out.println("BLANK\t\t\t" + " = [" + data[i][0]);
	else if(i == 18)
	    System.out.println("Heat Gain Subtotal\t" + " = [" + data[i][0]);
	else if(i == 19)
	    System.out.println("Gross Wall Area\t\t" + " = [" + data[i][0]);
	else if(i == 20)
	    System.out.println("All Windows Area\t" + " = [" + data[i][0]);
	else if(i == 21)
	    System.out.println("Doors Area\t\t" + " = [" + data[i][0]);
	else if(i == 22)
	    System.out.println("Net Wall Area\t\t" + " = [" + data[i][0]);
	else if(i == 23)
	    System.out.println("Ceiling Area\t\t" + " = [" + data[i][0]);
	else if(i == 24)
	    System.out.println("Floor Area\t\t" + " = [" + data[i][0]);
	else if(i == 25)
	    System.out.println("Infiltration Area\t" + " = [" + data[i][0]);
	else if(i == 26)
	    System.out.println("BLANK\t\t\t" + " = [" + data[i][0]);
	else
	    System.out.println("Heat Loss Subtotal\t" + " = [" + data[i][0]);
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
	}
	}catch(Exception e){
	    System.err.println("There has been an error");
}
    }
}
