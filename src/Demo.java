/**
 * This is a demo of the top-level interaction with Maxwell's calculation engine
 * 
 */

import java.util.ArrayList;
import com.thoughtworks.xstream.*;
import java.io.*;
public class Demo {
    static String xml;

    public static void serialize(Building a){
	XStream xstream = new XStream();
	xml = xstream.toXML(a);
	//System.out.println(xml);
	try{
	    PrintWriter out = new PrintWriter(new FileWriter("Building1.xml"));
	    out.println(xml);
	    out.close();
	}catch (Exception e){
	    System.err.println("There has been an error");
	}
    }
    public static void deserialize(Building newDemo){
	XStream xstream = new XStream();
	System.out.println("deserializing");
	newDemo = (Building)xstream.fromXML(xml);
	//System.out.println("The name is " + newbuild.getName());
    }
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

	serialize(demo);

	deserialize(demo);

	demo.calc();

	demo.fileoutput();
	//demo.output();
    }
}
