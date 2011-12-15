
    /** InsertionSortAlgorithmTest.java
  *
  * Tests the insertion sort algorithm.
  *
  * Jonathan Miller Kauffman
  * PLEDGE:
  *
  * Tyler J. Abbott
  * PLEDGE:
  *
  * Cory Matthew Jones
  * PLEDGE:
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
  */


import org.junit.Test;
import junit.framework.*;
import java.util.Random;
import java.util.Arrays;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

// creat new class for test cases
public class InsertionSortAlgorithmTest extends TestCase 
{
    
    public InsertionSortAlgorithmTest(String name) 
    {
	super(name);
    }
    
    public static TestSuite suite() 
    {
	return new TestSuite(InsertionSortAlgorithmTest.class);
    }
    // method for the array equals tests, tests will call on this method every time they are executed
    private static boolean arrayEqual(int[] array, int[] expectedarray)
    {
	// if the array length doesn't equal the expected array length, then return false
	if (array.length != expectedarray.length) 
	{	
		return false;
	}
	// run for loop to see if the arrays match 
	for(int i = 0; i < array.length; i++)
	{
		if(array[i] != expectedarray[i])
			return false;
        }
			return true; 
    }

    // Tyler James Abbott tests.
    
    @Test // test generating random arrays, returns true
    public void testgenerateRandomArray() 
	{
		int[] expectedarray = Sati.generate(10000);
		int[] array = Sati.shuffle(expectedarray, 45);
		assertTrue(arrayEqual(expectedarray, InsertionSortAlgorithm.sort(array)));
		
	}

    @Test// same test with different min and max values
    public void testgenerateRandomArray1() 
	{
		int[] expectedarray = Sati.generate(566);
		int[] array = Sati.shuffle(expectedarray, 4);
		assertTrue(arrayEqual(expectedarray, InsertionSortAlgorithm.sort(array)));
		
	}

    @Test// random array test with very large values
    public void testgenerateRandomArray2() 
	{
		int[] expectedarray = Sati.generate(7858);
		int[] array = Sati.shuffle(expectedarray, 54);
		assertTrue(arrayEqual(expectedarray, InsertionSortAlgorithm.sort(array)));
		
	} 
    @Test //random test with small array size
    public void testgenerateRandomArray3() 
	{
		int[] expectedarray = Sati.generate(1);
		int[] array = Sati.shuffle(expectedarray,654);
		assertTrue(arrayEqual(expectedarray, InsertionSortAlgorithm.sort(array)));
		
	} 


    @Test // smoke test.  calls on the method above returns true, and sorts properly 
    public void testsmoke() 
	{
		int[] array = new int[] { 57, 1 };
		int[] expectedarray = new int[] { 1, 57 }; 
		assertTrue(arrayEqual(expectedarray, InsertionSortAlgorithm.sort(array)));
		
	}

    @Test // a larger range of hard coded number. expected to be false
    public void testsmoke1() 
	{
		int[] array = new int[] { 1, 54, 6, 876, 32, 4, 15 };
		int[] expectedarray = new int[] { 1, 5, 6, 15, 32, 54, 876 }; 
		assertTrue(!arrayEqual(expectedarray, InsertionSortAlgorithm.sort(array)));
		
	}

    @Test // same as smoke one, but returns true
    public void testsmoke2() 
	{
		int[] array = new int[] { 1, 54, 6, 876, 32, 4, 15 };
		int[] expectedarray = new int[] { 1, 4, 6, 15, 32, 54, 876 }; 
		assertTrue(arrayEqual(expectedarray, InsertionSortAlgorithm.sort(array)));
		
	}

    @Test // smoke that has a very large amount of number, testing how "big" we can go 
    public void testsmoke3() 
	{
		int[] array = new int[] { 1, 54, 6, 876, 32, 4, 15, 65, 79, 34567, 87, 555, 2 };
		int[] expectedarray = new int[] { 1, 2, 4, 6, 15, 32, 54, 65, 79, 87, 555, 876, 34567 }; 
		assertTrue(arrayEqual(expectedarray, InsertionSortAlgorithm.sort(array)));
		
	}
   
   @Test // searching for an empty array.  the array and the expected are match. test passes
   public void testsearchEmptyArray()
	{
 		int[]testArray = new int[] {};
		int[]testArray1 = new int[] {};
		assertTrue(arrayEqual(testArray1, InsertionSortAlgorithm.sort(testArray)));
	} 
   @Test // the array is filled, so returns false, which is expected 
   public void testsearchEmptyArray1()
	{
 		int[]testArray = new int[] {5, 65, 32, 6, 11};
		int[]testArray1 = new int[] {};
		assertTrue(!arrayEqual(testArray1, InsertionSortAlgorithm.sort(testArray)));
	} 

    // Jonathan Miller Kauffman tests.

   @Test
   public void testsearchEmptyArray2()
	{
 		int[]testArray = new int[] {};
		int[]testArray1 = new int[] {1, 2, 3, 4, 5};
		assertTrue(!arrayEqual(testArray1, InsertionSortAlgorithm.sort(testArray)));
	}

    @Test
    public void testArraySizeOne()
    {
        int[] testArray = new int[] {3};
        int[] testArray1 = new int[] {3};
        assertTrue(arrayEqual(testArray1, InsertionSortAlgorithm.sort(testArray)));
    }

    @Test
    public void testArraySizeTwo()
    {
        int[] testArray = new int[] {45642};
        int[] testArray1 = new int[] {45642};
        assertTrue(arrayEqual(testArray1, InsertionSortAlgorithm.sort(testArray)));
    }
    @Test
    public void testArraySizeThree()
    {
        int[] testArray = new int[] {6, 5, 4, 3, 2, 1};
        int[] testArray1 = new int[] {1, 2, 3, 4, 5, 6};
        assertTrue(arrayEqual(testArray1, InsertionSortAlgorithm.sort(testArray)));
    }
   
    @Test
    public void testPerformanceOne()
    {
		int[] array = Sati.shuffle(Sati.generate(20,50),10);
		long actual = InsertionSortAlgorithm.sortPerformance(array);
        long expected = array.length * array.length;
		assertThat(expected, greaterThanOrEqualTo(actual));
    }

    @Test
    public void testPerformanceTwo()
    {
		int[] array = Sati.shuffle(Sati.generate(20,5000),15);
		long actual = InsertionSortAlgorithm.sortPerformance(array);
        long expected = array.length * array.length;
		assertThat(expected, greaterThanOrEqualTo(actual));
    }

    @Test
    public void testPerformanceThree()
    {
		int[] array = Sati.shuffle(Sati.generate(10000, 50),20);
		long actual = InsertionSortAlgorithm.sortPerformance(array);
        long expected = array.length * array.length;
		assertThat(expected, greaterThanOrEqualTo(actual));
    }

    @Test
    public void testPerformanceFour()
    {
		int[] array = Sati.shuffle(Sati.generate(10000, 5000),25);
		long actual = InsertionSortAlgorithm.sortPerformance(array);
        long expected = array.length * array.length;
		assertThat(expected, greaterThanOrEqualTo(actual));
    }

     @Test
    public void testPerformanceFive()
    {
		int[] array = Sati.shuffle(Sati.generate(78, 456),13);
		long actual = InsertionSortAlgorithm.sortPerformance(array);
        long expected = array.length * array.length;
		assertThat(expected, greaterThanOrEqualTo(actual));
    }
     @Test
    public void testPerformanceSix()
    {
		int[] array = Sati.shuffle(Sati.generate(600, 4),7);
		long actual = InsertionSortAlgorithm.sortPerformance(array);
        long expected = array.length * array.length;
		assertThat(expected, greaterThanOrEqualTo(actual));
    }
	
    //cory's tests
   
    @Test
    public void testgenerateRandomArray4() 
	{
		int[] expectedarray = Sati.generate(58);
		int[] array = Sati.shuffle(expectedarray, 8);
		assertTrue(arrayEqual(expectedarray, InsertionSortAlgorithm.sort(array)));
		
	}
    
    @Test
    public void testgenerateRandomArray5() 
	{
		int[] expectedarray = Sati.generate(100);
		int[] array = Sati.shuffle(expectedarray, 222);
		assertTrue(arrayEqual(expectedarray, InsertionSortAlgorithm.sort(array)));
		
	}
    
    @Test
    public void testgenerateRandomArray6() 
	{
		int[] expectedarray = Sati.generate(81);
		int[] array = Sati.shuffle(expectedarray,877);
		assertTrue(arrayEqual(expectedarray, InsertionSortAlgorithm.sort(array)));
		
	}
    
    @Test
    public void testgenerateRandomArray7() 
	{
		int[] expectedarray = Sati.generate(573);
		int[] array = Sati.shuffle(expectedarray,34);
		assertTrue(arrayEqual(expectedarray, InsertionSortAlgorithm.sort(array)));
		
	}
    
    @Test
    public void testgenerateRandomArray8() 
	{
		int[] expectedarray = Sati.generate(159);
		int[] array = Sati.shuffle(expectedarray, 56);
		assertTrue(arrayEqual(expectedarray, InsertionSortAlgorithm.sort(array)));
		
	}
    
    @Test
    public void testgenerateRandomArray9() 
	{
		int[] expectedarray = Sati.generate(997);
		int[] array = Sati.shuffle(expectedarray,6);
		assertTrue(arrayEqual(expectedarray, InsertionSortAlgorithm.sort(array)));
		
	}
    @Test
    public void testArray1() 
	{
		int[] array = {123,478,871,292,15030};
		int[] expectedarray = {123,292,478,871,15030};
		Arrays.sort(expectedarray);
		assertTrue(arrayEqual(expectedarray, InsertionSortAlgorithm.sort(array)));
		
	}
    
    @Test
    public void testArray2() 
	{
		int[] array = {232,478,871,233,15030};
		int[] expectedarray = {232,233,478,15030,871};
		Arrays.sort(expectedarray);
		assertTrue(arrayEqual(expectedarray, InsertionSortAlgorithm.sort(array)));
		
	}
    
    @Test
    public void testArray3() 
	{
		int[] array = {478,871,15030,92,233};
		int[] expectedarray = {92,233,478,871,15030};
		Arrays.sort(expectedarray);
		assertTrue(arrayEqual(expectedarray, InsertionSortAlgorithm.sort(array)));
		
	}
    
   @Test
    public void testArray4() 
	{
		int[] array = {33333,3333,333,33,3};
		int[] expectedarray = {33333,3333,333,33,3};
		Arrays.sort(expectedarray);
		assertTrue(arrayEqual(expectedarray, InsertionSortAlgorithm.sort(array)));
		
	}
    
}

	
