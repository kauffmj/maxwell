/** 
 * Maxwell's 'Building' class
 *
 * This class is used to store information about a building in order to
 * calculate the Heat Loss and Heat Gain.  This information includes data
 * pertaining to the job, and a series of measurements of different zones.
 *
 * Constructors:
 *   new Building() = creates a blank Building with one blank Zone
 *   new Building(int i) = creates a blank Building with i blank Zones
 *
 * Variables:
 *   String jobName,jobDate,customer,address,notes = the Building's descriptors
 *   int jobNumber, regionNumber = the Building's descriptors
 *   Region region = a local instance of the Region class with multipliers
 *                   that are appropriate for the selected region
 *   ArrayList<Zone> zone = the list of Zone objects that the Building owns
 *   float totalGain, totalLoss = the sums of Gain/Loss over all Zones, as
 *                                calculated by Building.calc()
 *
 * Methods:
 *   void calc() = run calculations for each Zone and sum to totalGain,totalLoss
 *   void output() = print Building details to terminal, then iteratively print
 *              details of each of the associated Zones
 *   void addZone() = add a new untitled Zone to the end of zone ArrayList
 *   void addZone(String name) = add a new named Zone to zone ArrayList 
 *   void rmZone(int i) = remove the Zone i from the zone ArrayList
 * Getters/Setters:
 *   void setZoneTitle(int i, String name) = set the title of zone(i) to name
 *   String getZoneTitle(int i) = return the String holding the title of zone(i)
 *   void setRegion(int i) = set the Building's region to Region i
 *   int getRegionNumber() = return the Region number as an integer
 *   String getRegionName() = return the String of the region's name
 *   Region getRegion() = return the Building's current Region object
 *   void setZoneData(int i,j,k, float val) = in zone[i], set data[j][k] to val
 *                                   (see ZoneData.pdf for detailed information)
 *   float getZoneData(int i,j,k) = return thefloat from data[j][k] in zone[i]
 *                                   (see ZoneData.pdf for detailed information)
 *   void setZoneDropdowns(int i, int[] val) = save dropdown choices to Zone i
 *   int[] getZoneDropdowns(int i) = return array of dropdown choices of Zone i
 *   int numZones() = return an int of how many zones the Building has
 */

import java.util.ArrayList;
import java.io.*;

public class Building {
    
    // information about the job
    private String jobName, jobNumber, jobDate, customer, address, notes;
    private int regionNumber;
    private Region region;
    private ArrayList<Zone> zone;
    private float totalGain, totalLoss;

    // Constructors
    public Building() {
	setRegion(0);
	zone = new ArrayList(1);
	zone.add(new Zone("Untitled Zone"));
    }
    public Building(int size) {
	setRegion(0);
	zone = new ArrayList(size);
	for (int i=0; i<size; i++)
	    zone.add(new Zone("Untitled Zone"));
    }

    public void addZone() {
	zone.add(new Zone("Untitled Zone")); }
    public void addZone(String name) {
	zone.add(new Zone(name)); }
    public void rmZone(int i) {
	if (zone.size() > i)
	    zone.remove(i); }

    // method to set all Building data at once
    public void setBuildingData(String name, String number, String date,
				String cust, String add, String note) {
	jobName = name;
	jobNumber = number;
	jobDate = date;
	customer = cust;
	address = add;
	notes = note;
    }
    public String getJobName() {
	return jobName; }
    public String getJobNumber() {
	return jobNumber; }
    public String getJobDate() {
	return jobDate; }
    public String getCustomer() {
	return customer; }
    public String getAddress() {
	return address; }
    public String getNotes() {
	return notes; }
 
    // methods to get/set titles of individual zones
    public void setZoneTitle(int i, String name) {
	zone.get(i).setTitle(name); }
    public String getZoneTitle(int i) {
	return zone.get(i).getTitle(); }
	
    // methods to set/get the region of the building
    public void setRegion(int i) {
	regionNumber = i;
	region = new Region(i);
    }
    public int getRegionNumber() {
	return region.number(); }
    public String getRegionName() {
	return region.name(); }
    public Region getRegion() {
	return region; }

    public void setZoneData(int i, int j, int k, float value) {
	zone.get(i).setData(j,k,value); }
    public float getZoneData(int i, int j, int k) {
	return zone.get(i).getData(j,k); }
    public void setZoneDropdowns(int i, int[] values) {
	zone.get(i).setDropdowns(values); }
    public int[] getZoneDropdowns(int i) {
	return zone.get(i).getDropdowns(); }

    public int numZones() {
	return zone.size(); }

    public float getTotalGain() {
	return totalGain; }
    public float getTotalLoss() {
	return totalLoss; }
    
    // calculate all zones and update the totals from that
    public void calc() {
	// reset totals to zero
	totalGain = totalLoss = 0;
	for (int i=0; i<zone.size(); i++) {
	    zone.get(i).calc(region);
	    totalGain += zone.get(i).getData(18,3);
	    totalLoss += zone.get(i).getData(27,3);
	}
    }
    
    public void output() {
	System.out.println("Job Name:  " + jobName);
	System.out.println("Job Number:  " + jobNumber);
	System.out.println("Job Date:  " + jobDate);
	System.out.println("Region:  "+getRegionNumber()+" - "+getRegionName());
	System.out.println("Customer:  " + customer);
	System.out.println("Address:  " + address);
	System.out.println("Notes:\n" + notes);
	System.out.println();
	for (int i=0; i<zone.size(); i++) {
	    System.out.println("Zone " + i + ": " + zone.get(i).getTitle());
	    zone.get(i).output();
	    System.out.println();
	}
    }
    public void fileoutput(){
try{
	    PrintWriter out = new PrintWriter(new FileWriter("Building.rtf"));
	    out.println("Job Name:  " + jobName);
		out.println("Job Number:  " + jobNumber);
		out.println("Job Date:  " + jobDate);
		out.println("Region:  "+getRegionNumber()+" - "+getRegionName());
		out.println("Customer:  " + customer);
		out.println("Address:  " + address);
		out.println("Notes:\n" + notes);
		out.println();
		for (int i=0; i<zone.size(); i++) {
	    		out.println("Zone " + i + ": " + zone.get(i).getTitle());
			System.out.println("Right before fileoutput()");
	   		zone.get(i).nomultsoutput();
	    		out.println();
			out.print("Hello from building");
		}
    
	    out.close();
	}catch (Exception e){
	    System.err.println("There has been an error");
	}
}

}
