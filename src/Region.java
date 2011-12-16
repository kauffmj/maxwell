/** 
 * Maxwell's 'Region' Class
 *
 * This class is used to store and return all of the options and coefficients
 * utilized in Building and Zone calculations.
 *
 * Methods:
 *
 * String getItem(int i,int j) = return the name of multiplier i's jth option 
 * float getValue(int,String) = return a multiplier based upon which multiplier
 *                              and the text of the desired option.
 * float getValue(int i,int j) = return the value of multiplier i's jth option
 * int getLength(int i) = returns the number of options in multiplier i
 * String getCategory(int i) = returns the title of multiplier i
 */

import java.util.ArrayList;

public class Region {

    private int regionNumber;
    private String regionName;
    private Object[][] wallCM; // Wall Cooling Multipliers
    private Object[][] ceilCM; // Ceiling Cooling Multipliers
    private Object[][] florCM; // Floor Cooling Multipliers
    private Object[][] windCM; // Window Cooling Multipliers
    private Object[][] infnCM; // Infiltration Cooling Multipliers
    private Object[][] laHICM; // Latent Heat Infiltration Multipliers
    private Object[][] windHM;
    private Object[][] ceilHM;
    private Object[][] florHM;
    private Object[][] wallHM;
    private Object[][] infnHM;


    public Region(int i) {
	regionNumber = i;
	if (i == 0) { // If region is NorthWest PA
	    regionName = "Northwest Pennsylvania";

	    wallCM = new Object[4][2];
	    wallCM[0][0]="No Insulation";  wallCM[0][1]=new Float(4.0);
	    wallCM[1][0]="2 Inches";       wallCM[1][1]=new Float(2.0);
	    wallCM[2][0]="3 Inches";       wallCM[2][1]=new Float(1.5);
	    wallCM[3][0]="6 Inches";       wallCM[3][1]=new Float(1.0);
	    
	    ceilCM = new Object[4][2];
	    ceilCM[0][0]="No Insulation";  ceilCM[0][1]=new Float(11.0);
	    ceilCM[1][0]="3 Inches";       ceilCM[1][1]=new Float(3.2);
	    ceilCM[2][0]="6 Inches";       ceilCM[2][1]=new Float(2.1);
	    ceilCM[3][0]="10 Inches";      ceilCM[3][1]=new Float(1.3);
	    
	    florCM = new Object[3][2];
	    florCM[0][0]="No Insulation";  florCM[0][1]=new Float(4.0);
	    florCM[1][0]="3 Inches";       florCM[1][1]=new Float(0.8);
	    florCM[2][0]="6 Inches";       florCM[2][1]=new Float(0.5);
	    
	    windCM = new Object[5][2];
	    windCM[0][0]="North";          windCM[0][1]=new Float(15.0);
	    windCM[1][0]="South";          windCM[1][1]=new Float(25.0);
	    windCM[2][0]="East/West";      windCM[2][1]=new Float(45.0);
	    windCM[3][0]="Skylight";       windCM[3][1]=new Float(139.0);
	    windCM[4][0]="Doors";          windCM[4][1]=new Float(11.0);
	    
	    infnCM = new Object[3][2];
	    infnCM[0][0]="1 Air Change";   infnCM[0][1]=new Float(0.275);
	    infnCM[1][0]="1/2 Air Change"; infnCM[1][1]=new Float(0.137);
	    infnCM[2][0]="1/4 Air Change"; infnCM[2][1]=new Float(0.068);
	    
	    laHICM = new Object[3][2];
	    laHICM[0][0]="1 Air Change";   laHICM[0][1]=new Float(0.26);
	    laHICM[1][0]="1/2 Air Change"; laHICM[1][1]=new Float(0.13);
	    laHICM[2][0]="1/4 Air Change"; laHICM[2][1]=new Float(0.065);

	    windHM = new Object[4][2];
	    windHM[0][0]="Single";         windHM[0][1]=new Float(80.0);
	    windHM[1][0]="Insulated";      windHM[1][1]=new Float(48.0);
	    windHM[2][0]="Storm";          windHM[2][1]=new Float(40.0);
	    windHM[3][0]="Triple";         windHM[3][1]=new Float(23.0);

	    ceilHM = new Object[4][2];
	    ceilHM[0][0]="No Insulation";  ceilHM[0][1]=new Float(21.0);
	    ceilHM[1][0]="3 Inches";       ceilHM[1][1]=new Float(6.0);
	    ceilHM[2][0]="6 Inches";       ceilHM[2][1]=new Float(4.0);
	    ceilHM[3][0]="10 inches";      ceilHM[3][1]=new Float(2.0);

	    florHM = new Object[4][2];
	    florHM[0][0]="Crawl Space";    florHM[0][1]=new Float(21.0);
	    florHM[1][0]="Crawl - Ins.";   florHM[1][1]=new Float(5.0);
	    florHM[2][0]="Base - No Ins."; florHM[2][1]=new Float(4.0);
	    florHM[3][0]="Bsmt. - 3 Inches"; florHM[3][1]=new Float(2.0);

	    wallHM = new Object[4][2];
	    wallHM[0][0]="No Insulation";  wallHM[0][1]=new Float(18.0);
	    wallHM[1][0]="2 Inches";       wallHM[1][1]=new Float(7.0);
	    wallHM[2][0]="3 Inches";       wallHM[2][1]=new Float(5.0);
	    wallHM[3][0]="6 Inches";       wallHM[3][1]=new Float(4.0);

	    infnHM = new Object[3][2];
	    infnHM[0][0]="1 Air Change";   infnHM[0][1]=new Float(1.26);
	    infnHM[1][0]="1/2 Air Change"; infnHM[1][1]=new Float(0.63);
	    infnHM[2][0]="1/4 Air Change"; infnHM[2][1]=new Float(0.32);

	}
    }

    public String getItem(int i, int j) {
	Object item;
	if (i == 0)
	    item = wallCM[j][0];
	else if (i == 1)
	    item = ceilCM[j][0];
	else if (i == 2)
	    item = florCM[j][0];
	else if (i == 3)
	    item = windCM[j][0];
	else if (i == 4)
	    item = infnCM[j][0];
	else if (i == 5)
	    item = laHICM[j][0];
	else if (i == 6)
	    item = windHM[j][0];
	else if (i == 7)
	    item = ceilHM[j][0];
	else if (i == 8)
	    item = florHM[j][0];
	else if (i == 9)
	    item = wallHM[j][0];
	else if (i == 10)
	    item = infnHM[j][0];
	else
	    return "Error";
	return (String)item;
    }

    /* INCOMPLETE BY A LOT */
    public float getValue(int i, String s) {
	Object value;
	if (i == 0) // wallCM
	    for (int x=0; x<wallCM.length; x++)
		if (s.equals((String)wallCM[x][0]))
		    return ((Float)wallCM[x][1]).floatValue();
	return (float)(-1.0);
    }

    public float getValue(int i, int j) {
	Object value;
	if (i == 0)
	    value = wallCM[j][1];
	else if (i == 1)
	    value = ceilCM[j][1];
	else if (i == 2)
	    value = florCM[j][1];
	else if (i == 3)
	    value = windCM[j][1];
	else if (i == 4)
	    value = infnCM[j][1];
	else if (i == 5)
	    value = laHICM[j][1];
	else if (i == 6)
	    value = windHM[j][1];
	else if (i == 7)
	    value = ceilHM[j][1];
	else if (i == 8)
	    value = florHM[j][1];
	else if (i == 9)
	    value = wallHM[j][1];
	else if (i == 10)
	    value = infnHM[j][1];
	else
	    return (float)(-1);
	Float temp = (Float)value;
	return temp.floatValue();
    }

    /* INCOMPLETE BY A LOT AND WRONG APPROACH */
    public int getLength(int i) {
	if (i==2 || i==4 || i==5)
	    return (int)3;
	else if (i==0 || i==1)
	    return (int)4;
	else if (i==3)
	    return (int)5;
	else
	    return (int)0;
    }
    /* INCOMPLETE BY A LOT */
    public String getCategory(int i) {
	if (i == 0)
	    return "Wall CM";
	else if (i == 1)
	    return "Ceiling CM";
	else if (i == 2)
	    return "Floor CM";
	else if (i == 3)
	    return "Window CM";
	else if (i == 4)
	    return "Infiltration CM";
	else if (i == 5)
	    return "Latent Infiltration CM";
	else
	    return "Error";
    }

    public String name() {
	return regionName;
    }
    public int number() {
	return regionNumber;
    }
}