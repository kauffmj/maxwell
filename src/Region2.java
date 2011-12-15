import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException; 

public class Region2{

    public static String[][] AllRegions;
    public static String[] Multipliers;

    public static void main (String argv []){
	int want = Integer.parseInt(argv[0]);
	//System.out.println("We are looking for Region " + want + ".");
	try {
            DocumentBuilderFactory docBuilderFactory = 
		DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse (new File("regions.xml"));

            NodeList listOfRegions = doc.getElementsByTagName("region");
            int totalRegions = listOfRegions.getLength();
            System.out.println("Total number of available regions: " + 
			       totalRegions);
	    AllRegions = new String[totalRegions][2];
	    int i = want;


	    //for(int i=0; i<listOfRegions.getLength() ; i++){

	    Node RegionNode = listOfRegions.item(i);
	    if(RegionNode.getNodeType() == Node.ELEMENT_NODE){
		
		Element RegionElement = (Element)RegionNode;
		//-------
		NodeList idList = RegionElement.getElementsByTagName("id");
		NodeList nameList = RegionElement.getElementsByTagName("name");
		Element idElement = (Element)idList.item(0);
		Element nameElement = (Element)nameList.item(0);
		
		NodeList textIdList = idElement.getChildNodes();
		NodeList textNameList = nameElement.getChildNodes();
		//System.out.println(((Node)textIdList.item(0)).getNodeValue().trim() + ": " 
		//+ ((Node)textNameList.item(0)).getNodeValue().trim());
		AllRegions[i][0] = ((Node)textIdList.item(0)).getNodeValue().trim();
		AllRegions[i][1] = ((Node)textNameList.item(0)).getNodeValue().trim();
		//-------
		/*NodeList lastNameList = firstPersonElement.getElementsByTagName("last");
		  Element lastNameElement = (Element)lastNameList.item(0);
		  
		  NodeList textLNList = lastNameElement.getChildNodes();
		  System.out.println("Last Name : " + 
		  ((Node)textLNList.item(0)).getNodeValue().trim());
		  
		  //----
		  NodeList ageList = firstPersonElement.getElementsByTagName("age");
		  Element ageElement = (Element)ageList.item(0);
		  
		  NodeList textAgeList = ageElement.getChildNodes();
		  System.out.println("Age : " + 
		  ((Node)textAgeList.item(0)).getNodeValue().trim());
		*/
		//------
		
		
	    }//end of if clause
	    
	    
	    //}//end of for loop with i var
	    
	    
        }catch (SAXParseException err) {
	    System.out.println ("** Parsing error" + ", line " 
				+ err.getLineNumber () + ", uri " + err.getSystemId ());
	    System.out.println(" " + err.getMessage ());

        }catch (SAXException e) {
	    Exception x = e.getException ();
	    ((x == null) ? e : x).printStackTrace ();

        }catch (Throwable t) {
	    t.printStackTrace ();
        }
        //System.exit (0);


	System.out.println("========================================" + 
			   "=======================================");
	System.out.println("We are looking for Region " + want + ".");
	System.out.println("========================================" + 
			   "=======================================");
	System.out.println(AllRegions[want][0] + "\t" + AllRegions[want][1]);
	/*for (int r = 0; r < AllRegions.length; r ++) {
	System.out.println(AllRegions[r][0] + "\t" + AllRegions[r][1]);
	    if (Integer.parseInt(AllRegions[r][0]) == want) {
		System.out.println("\t#\tMultiplier:");
		//for (int m = 0; m < Multipliers.length; m++)
		//    System.out.println("\t" + Multipliers[m]);
	    }
	    }*/


    }//end of main


}