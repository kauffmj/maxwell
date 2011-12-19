/** Maxwell: A Heat Loss and Gain Calculator
 *  
 *  Tests the methods of the Building class.
 *
**/

import org.junit.Test;
import junit.framework.*;
import org.junit.Assert;

public class BuildingTest extends TestCase
{
    @Test
    public void testZeroParameterConstructor()
    {
        Building building = new Building();
        int expected = 1;
        int actual = building.numZones();
        assertEquals(expected,actual);
    }

    @Test
    public void testOneParameterConstructor()
    {
        Building building = new Building(5);
        int expected = 5;
        int actual = building.numZones();
        assertEquals(expected,actual);
    }

    @Test
    public void testZeroParameterAddZone()
    {
        Building building = new Building();
        building.addZone();
        int expected = 2;
        int actual = building.numZones();
        assertEquals(expected,actual);
    }

    @Test
    public void testOneParameterAddZone()
    {
        Building building = new Building();
        building.addZone("Kitchen");
        String expected = "Kitchen";
        String actual = building.getZoneTitle(1);
        assertEquals(expected,actual);
    }

    @Test
    public void testRmZoneValid()
    {
        Building building = new Building();
        building.addZone();
        building.rmZone(0);
        int expected = 1;
        int actual = building.numZones();
        assertEquals(expected,actual);
    }

    @Test
    public void testRmZoneInvalid()
    {
        Building building = new Building();
        building.addZone();
        building.rmZone(3);
        int expected = 2;
        int actual = building.numZones();
        assertEquals(expected,actual);
    }

    @Test
    public void testSetBuildingData()
    {
        Building building = new Building();
        building.setBuildingData("Old House","34","12/12/2012","Jim","Somewhere", "Note here.");
        String expected = "Old House";
        String actual = building.getJobName();
        assertEquals(expected,actual);

        expected = "34";
        actual = building.getJobNumber();
        assertEquals(expected,actual);

        expected = "12/12/2012";
        actual = building.getJobDate();
        assertEquals(expected,actual);

        expected = "Jim";
        actual = building.getCustomer();
        assertEquals(expected,actual);

        expected = "Somewhere";
        actual = building.getAddress();
        assertEquals(expected,actual);

        expected = "Note here.";
        actual = building.getNotes();
        assertEquals(expected,actual);
    }

    @Test
    public void testSetZoneTitle()
    {
        Building building = new Building();
        building.addZone();
        building.setZoneTitle(0,"Zone1");
        String expected = "Zone1";
        String actual = building.getZoneTitle(0);
        assertEquals(expected,actual);
    }

    @Test
    public void testSetRegion()
    {
        Building building = new Building();
        building.setRegion(0);
        int expected1 = 0;
        int actual1 = building.getRegionNumber();
        assertEquals(expected1,actual1);

        String expected2 = "Northwest Pennsylvania";
        String actual2 = building.getRegionName();
        assertEquals(expected2,actual2);
    }

    @Test
    public void testSetZoneData()
    {
        Building building = new Building();
        building.setZoneData(0,1,1,(float).5);
        float expected = (float).5;
        float actual = building.getZoneData(0,1,1);
        assertEquals(expected,actual);
    }

    @Test
    public void testSetZoneDropdowns()
    {
        Building building = new Building();
        int[] expected = {1,2,3,4,5,6,7,8};
        building.setZoneDropdowns(0,expected);
        int[] actual = building.getZoneDropdowns(0);
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void testGetTotalGainLoss()
    {
        Building building = new Building();
        building.setZoneData(0,1,1,(float).5);
        building.calc();
        float expected1 = (float)0.0;
        float actual1 = building.getTotalGain();
        assertEquals(expected1,actual1);

        float expected2 = (float)0.0;
        float actual2 = building.getTotalLoss();
        assertEquals(expected2,actual2);
    }
}
