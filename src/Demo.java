/**
 * This is a demo of the top-level interaction with Maxwell's calculation engine
 * 
 */

import java.util.ArrayList;

public class Demo {

    public static void main(String[] args){
	int numRooms = 1;
	Building demo = new Building(numRooms);
	//demo.output();
	demo.setZoneData(0,0,0,1600);
	demo.setZoneData(0,3,0,177);  demo.setZoneData(0,3,1,45);
	demo.setZoneData(0,6,1,1);
	demo.setZoneData(0,7,0,1940); demo.setZoneData(0,7,1,(float)1.3);
	demo.setZoneData(0,8,0,1940); demo.setZoneData(0,8,1,4);
	demo.setZoneData(0,9,0,1940); demo.setZoneData(0,9,1,8);
	demo.setZoneData(0,9,2,(float)0.068);
	demo.setZoneData(0,10,0,4);
	demo.setZoneData(0,11,0,2000);
	demo.calc();
	demo.output();
    }
}
