
/**
  * CS 290 - Principles of Software Development
  * Laboratory Five
  *
  * AllTests.java
  *
  * Runs a user-specified subset of the test suite.
  *
  * @author Jonathan Miller Kauffman
  * @author Gregory M. Kapfhammer
  *
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
    public static Test suite(String testSuiteList) 
    {
	    TestSuite suite = new TestSuite("SortingAlgorithms");

        //for(String testSuite : testSuiteList)
        //{
        //    suite.addTestSuite(Class.forName(testSuite));
        //}

        if(testSuiteList.contains("BubbleSortTest") || testSuiteList.length() == 0)
            suite.addTestSuite(BubbleSortTest.class);
        if(testSuiteList.contains("EQSortAlgorithmTest") || testSuiteList.length() == 0)
            suite.addTestSuite(EQSortAlgorithmTest.class);
        if(testSuiteList.contains("CountingSortAlgorithmTest") || testSuiteList.length() == 0)
            suite.addTestSuite(CountingSortAlgorithmTest.class);
        if(testSuiteList.contains("InsertionSortAlgorithmTest") || testSuiteList.length() == 0)
            suite.addTestSuite(InsertionSortAlgorithmTest.class);
        if(testSuiteList.contains("QuickSortTest") || testSuiteList.length() == 0)
            suite.addTestSuite(QuickSortTest.class);
        if(testSuiteList.contains("GnomeSortAlgorithmTest") || testSuiteList.length() == 0)
            suite.addTestSuite(GnomeSortAlgorithmTest.class);
        if(testSuiteList.contains("MergeSortTest") || testSuiteList.length() == 0)
            suite.addTestSuite(MergeSortTest.class);
        if(testSuiteList.contains("RadixSortAlgorithmTest") || testSuiteList.length() == 0)
            suite.addTestSuite(RadixSortAlgorithmTest.class);
        if(testSuiteList.contains("ShellSortTest") || testSuiteList.length() == 0)
            suite.addTestSuite(ShellSortTest.class);

        /*if(testSuiteList.length() == 0)
        {
	        suite.addTestSuite(BubbleSortTest.class);
	        suite.addTestSuite(EQSortAlgorithmTest.class);
	        suite.addTestSuite(CountingSortAlgorithmTest.class);
	        suite.addTestSuite(InsertionSortAlgorithmTest.class);
	        suite.addTestSuite(QuickSortTest.class);
	        suite.addTestSuite(GnomeSortAlgorithmTest.class);
	        suite.addTestSuite(MergeSortTest.class);
	        suite.addTestSuite(RadixSortAlgorithmTest.class);
	        suite.addTestSuite(ShellSortTest.class);
        }*/

	    return suite;
    }
    
    public static void main(String[] args)
    {
        String testSuiteList = "";
        for(int i=0;i<args.length;i++)
            if(!args[i].equals(""))
            testSuiteList += (args[i] + " ");
	    junit.textui.TestRunner.run(suite(testSuiteList));
    }
}
