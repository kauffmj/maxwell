/**
  * This file is part of Razza.
  *
  * Razza is free software: you can redistribute it and/or modify it under
  * the terms of the GNU Lesser Public License as published by the Free
  * Software Foundation, either version 2 of the License, or (at your option)
  * any later version.
  *
  * Razza is distributed in the hope that it will be useful, but WITHOUT
  * WARRANTY; without even the implied warranty of MERCHANTABILITY or
  * FITNESS FOR A PARTICULAR PURPOSE.  Se the GNU Lesser Public License for
  * more details.
  *
  * You should have received a copy of the GNU Lesser Public License along
  * with Razza.  If not, see <http://www.gnu.org/licenses/>.
**/


import junit.framework.Test;
import junit.framework.TestSuite;
import org.junit.*;
import java.util.ArrayList;

public class AllTests 
{
    public static Test suite() 
    {
	    TestSuite suite = new TestSuite("Maxwell");

        suite.addTestSuite(BuildingTest.class);
        suite.addTestSuite(RegionTest.class);

	    return suite;
    }
    
    public static void main(String[] args)
    {
	    junit.textui.TestRunner.run(suite());
    }
}
