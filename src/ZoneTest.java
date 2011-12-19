/** Maxwell: A Heat Loss and Gain Calculator
 *  
 *  Tests the methods of the Zone class.
 *
**/

import org.junit.Test;
import junit.framework.*;
import org.junit.Assert;

public class ZoneTest extends TestCase
{
    @Test
    public void testSetTitle()
    {
        Zone zone = new Zone("zone1");
        zone.setTitle("zoney");
        String expected = "zoney";
        String actual = zone.getTitle();
        assertEquals(expected,actual);
    }

    @Test
    public void testSetData()
    {
        Zone zone = new Zone("zone1");
        zone.setData(1,1,(float).5);
        float expected = (float).5;
        float actual = zone.getData(1,1);
        assertEquals(expected,actual);
    }

    @Test
    public void testSetDropdowns()
    {
        Zone zone = new Zone("zone1");
        int[] expected = {1,2,3,4,5,6,7,8};
        zone.setDropdowns(expected);
        int[] actual = zone.getDropdowns();
        Assert.assertArrayEquals(expected,actual);
    }
}
