/** RadixSortAlgorithmTest.java
  *
  * Tests the radix sort algorithm.
  * Please note that negative array indices were not
  * tested, as this implementation of radix sort
  * can only handle non-negative integers.
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



import junit.framework.*;
import org.junit.Test;
import java.util.Random;
import java.util.Arrays;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class RadixSortAlgorithmTest extends TestCase
{

    private static boolean arrayEqual(int[] array, int[] expectedarray)
    {
        if(array.length != expectedarray.length)
            return false;

	    for(int i = 0; i < array.length; i++)
	    {
		    if(array[i] != expectedarray[i])
			    return false;
        }
			return true; 
    }

    @Test
    public void testSmokeOne() 
	{
		int[] array = new int[] { 3, 23, 342, 26, 13 };
		int[] expectedarray = new int[] { 3, 13, 23, 26, 342 }; 
		assertTrue(arrayEqual(expectedarray, RadixSortAlgorithm.sort(array)));
		
	}

    @Test
    public void testSmokeTwo() 
	{
		int[] array = new int[] { 3, 43, 32, 36, 13, 332, 1005, 89, 123, 2398, 3, 4 };
		int[] expectedarray = new int[] { 3, 3, 4, 13, 32, 36, 43, 89, 123, 332, 1005, 2398 }; 
		assertTrue(arrayEqual(expectedarray, RadixSortAlgorithm.sort(array)));
		
	}

    @Test
    public void testBoundaryOne()
    {
        int[] array = new int[] {};
        int[] expectedarray= new int[] {};
		assertTrue(arrayEqual(expectedarray, RadixSortAlgorithm.sort(array)));
    }

    @Test
    public void testBoundaryTwo()
    {
        int[] array = new int[] {3};
        int[] expectedarray= new int[] {3};
		assertTrue(arrayEqual(expectedarray, RadixSortAlgorithm.sort(array)));
    }

    @Test
    public void testBoundaryThree()
    {
        int[] expectedarray = Sati.generate(10000,100);
        int[] array = Sati.shuffle(expectedarray,10);
		assertTrue(arrayEqual(expectedarray, RadixSortAlgorithm.sort(array)));
    }

    @Test
    public void testBoundaryFour()
    {
        int[] expectedarray = Sati.generate(10000,1000000);
        int[] array= Sati.shuffle(expectedarray,14);
		assertTrue(arrayEqual(expectedarray, RadixSortAlgorithm.sort(array)));
    }

//Tyler's Tests 

   @Test
   public void testsearchEmptyArray()
	{
 		int[]testArray = new int[] {};
		int[]testArray1 = new int[] {};
		assertTrue(arrayEqual(testArray1, RadixSortAlgorithm.sort(testArray)));
	} 
   @Test
   public void testsearchEmptyArray1()
	{
 		int[]testArray = new int[] {1};
		int[]testArray1 = new int[] {1};
		assertTrue(arrayEqual(testArray1, RadixSortAlgorithm.sort(testArray)));
	} 
   @Test
   public void testsearchEmptyArray2()
	{
 		int[]testArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		int[]testArray1 = new int[] {};
		assertTrue(!arrayEqual(testArray1, RadixSortAlgorithm.sort(testArray)));
	} 
   @Test
   public void testsearchEmptyArray3()
	{
 		int[]testArray = new int[] {89, 8527, 8, 123578, 11};
		int[]testArray1 = new int[] {};
		assertTrue(!arrayEqual(testArray1, RadixSortAlgorithm.sort(testArray)));
	} 

    @Test
    public void testgenerateRandomArray() 
	{
		int[] expectedarray = Sati.generate(5,50000);
		int[] array = Sati.shuffle(expectedarray,5);
		//Arrays.sort(expectedarray);
		assertTrue(arrayEqual(expectedarray, RadixSortAlgorithm.sort(array)));
		
	}

    @Test
    public void testgenerateRandomArray1() 
	{
		int[] expectedarray = Sati.generate(56, 777);
		int[] array = Sati.shuffle(expectedarray,5);
		assertTrue(arrayEqual(expectedarray, RadixSortAlgorithm.sort(array)));
		
	}

    @Test
    public void testgenerateRandomArray2() 
	{
		int[] expectedarray = Sati.generate(3324,12);
		int[] array = Sati.shuffle(expectedarray,7);
		assertTrue(arrayEqual(expectedarray, RadixSortAlgorithm.sort(array)));
		
	} 
    
    @Test
    public void testgenerateRandomArray3() 
	{
		int[] expectedarray = Sati.generate(1,8923);
		int[] array = Sati.shuffle(expectedarray,15);
		assertTrue(arrayEqual(expectedarray, RadixSortAlgorithm.sort(array)));
		
	} 
     
    @Test
    public void testGetRadix1()
       {
        int actual = RadixSortAlgorithm.getRadix(987654321, 9);
        int expected = 9;
        int[] expectedarray= new int[] {};
		assertEquals(actual, expected);
       }
    @Test
    public void testGetRadix2()
       {
        int actual = RadixSortAlgorithm.getRadix(987654321, 3);
        int expected = 3;
        int[] expectedarray= new int[] {};
		assertEquals(actual, expected);
       }
    //cory's tests
    @Test
    public void testGetRadix5()
    {
        int actual = RadixSortAlgorithm.getRadix(9594321, 2);
        int expected = 2;
        int[] expectedarray = new int[] {};
        assertEquals(actual, expected);
    }
    @Test
    public void testGetRadix6()
    {
        int actual = RadixSortAlgorithm.getRadix(9594821, 3);
        int expected = 8;
        int[] expectedarray = new int[] {};
        assertEquals(actual, expected);
    }
    @Test
    public void testGetRadix7()
    {
        int actual = RadixSortAlgorithm.getRadix(9594381, 2);
        int expected = 8;
        int[] expectedarray = new int[] {};
        assertEquals(actual, expected);
    }
    @Test
    public void testGetRadix8()
    {
        int actual = RadixSortAlgorithm.getRadix(9594331, 2);
        int expected = 3;
        int[] expectedarray = new int[] {};
        assertEquals(actual, expected);
    }
    @Test
    public void testGetRadix9()
    {
        int actual = RadixSortAlgorithm.getRadix(9594321, 7);
        int expected = 9;
        int[] expectedarray = new int[] {};
        assertEquals(actual, expected);
    }

    @Test
    public void testgenerateRandomArray4() 
	{
		int[] expectedarray = Sati.generate(58, 877);
		int[] array = Sati.shuffle(expectedarray,25);
		assertTrue(arrayEqual(expectedarray, RadixSortAlgorithm.sort(array)));
		
	}
    
    @Test
    public void testgenerateRandomArray5() 
	{
		int[] expectedarray = Sati.generate(100, 8777);
		int[] array = Sati.shuffle(expectedarray,3);
		assertTrue(arrayEqual(expectedarray, RadixSortAlgorithm.sort(array)));
		
	}
    
    @Test
    public void testgenerateRandomArray6() 
	{
		int[] expectedarray = Sati.generate(81, 573);
		int[] array = Sati.shuffle(expectedarray,13);
		assertTrue(arrayEqual(expectedarray, RadixSortAlgorithm.sort(array)));
		
	}

    @Test
    public void testgenerateRandomArray7() 
	{
		int[] expectedarray = Sati.generate(98, 573);
		int[] array = Sati.shuffle(expectedarray,12);
		assertTrue(arrayEqual(expectedarray, RadixSortAlgorithm.sort(array)));
		
	}
   
    
    @Test
    public void testgenerateArray1() 
	{
		int[] array = {232,478,871,233,15030};
		int[] expectedarray = {232,233,478,871,15030};
		Arrays.sort(expectedarray);
		assertTrue(arrayEqual(expectedarray, RadixSortAlgorithm.sort(array)));
		
	}

    @Test
    public void testPerformanceOne()
    {
		int[] array = Sati.shuffle(Sati.generate(20, 50),5);
		long actual = InsertionSortAlgorithm.sortPerformance(array);
        long expected = 10 * array.length;
		assertThat(expected, greaterThanOrEqualTo(actual));
    }

    @Test
    public void testPerformanceTwo()
    {
		int[] array = Sati.shuffle(Sati.generate(20, 50000),7);
		long actual = InsertionSortAlgorithm.sortPerformance(array);
        long expected = 10 * array.length;
		assertThat(expected, greaterThanOrEqualTo(actual));
    }

    @Test
    public void testPerformanceThree()
    {
		int[] array = Sati.shuffle(Sati.generate(20, 50),12);
		long actual = InsertionSortAlgorithm.sortPerformance(array);
        long expected = 10 * array.length;
		assertThat(expected, greaterThanOrEqualTo(actual));
    }

    @Test
    public void testPerformanceFour()
    {
		int[] array = Sati.shuffle(Sati.generate(20, 500),20);
		long actual = InsertionSortAlgorithm.sortPerformance(array);
        long expected = 10 * array.length;
		assertThat(expected, greaterThanOrEqualTo(actual));
    }
}
