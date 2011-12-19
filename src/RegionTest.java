/** Maxwell: A Heat Loss and Gain Calculator
 *  
 *  Tests the methods of the Region class.
 *
**/

import org.junit.Test;
import junit.framework.*;
import org.junit.Assert;

public class RegionTest extends TestCase
{
    @Test
    public void testName()
    {
        Region region = new Region(0);
        String expected = "Northwest Pennsylvania";
        String actual = region.name();
        assertEquals(expected,actual);
    }

    @Test
    public void testNumber()
    {
        Region region = new Region(0);
        int expected = 0;
        int actual = region.number();
        assertEquals(expected,actual);
    }

    @Test
    public void testGetItemWallCM()
    {
        Region region = new Region(0);
        String expected = "No Insulation";
        String actual = region.getItem(0,0);
        assertEquals(expected,actual);
    }

    @Test
    public void testGetValueWallCM()
    {
        Region region = new Region(0);
        float expected = (float) 4.0;
        float actual = region.getValue(0,0);
        assertEquals(expected,actual);
    }
}
