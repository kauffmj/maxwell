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
 *
 * Methods:
 *   void setTitle(String) = set's the Zone's title to a passed String
 *   String getTitle() = return's the String of the Zone's title
 *   void setData(int i, int j, float value) = stores value in data[i][j] 
 *   float getData(int i, int j) = returns the value stored in data[i][j]
 *   void calc(Region reg) = runs the calculations based upon currently stored
 *                           values and the passed Region
 *   void output() = quickly print contents of title and data[][] to terminal 
 */

public class Zone {

    // the descriptive label of this instance of Zone
    private String title;
    // the values of this instance of Zone, as laid out in the spreadsheet
    // see further documentation, or this.calc(),  for more details
    private float[][] data = new float[28][4];

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

    public void calc(Region reg) {
	// START LEFT-HAND-SIDE OF SPREADSHEET
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
}
