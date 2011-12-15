

import static org.junit.Assert.*;
import junit.framework.TestCase;
import org.junit.Test;
import java.util.Random;
import java.util.Arrays;
import static org.hamcrest.Matchers.*;

/** EQSortAlgorithmTest.java
  *
  * Tests the EQ sort algorithm.
  *
  * @author Jonathan Miller Kauffman
  * PLEDGE:
  *
  * @author Tyler J. Abbott
  * PLEDGE:
  *
  * @author Cory Matthew Jones
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

public class EQSortAlgorithmTest extends TestCase{

	/**
	 * Generates a random array of integers
	 * @param arraySize the size of the array you want
	 * @param maxValue  the max value you want
	 * @return an array full of values at the specified size
	 */
	
public static int[] generateRandomArray(int arraySize, int maxValue)
    {
        Random rand = new Random();
        int[] randomArray = new int[arraySize];
        for(int i=0;i < arraySize; i++)
        {
            randomArray[i] = rand.nextInt(maxValue);
        }

        return randomArray;
    }
	
	/**
	 * Test method for {@link EQSortAlgorithm#sort(int[])}.
	 * 
	 */
	@Test
	public  void testSort() {
		int[] array =  { 3, 28, 342, 26, 13 };
		int[] expectedarray = new int[] { 3, 13, 26, 28, 342 }; 
		array = EQSortAlgorithm.sort(array);
		assertArrayEquals(expectedarray, array);
	}
	


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

 

// Tyler James Abbott's tests 

   @Test
    public void testsmoke() 
	{
		int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		int[] expectedarray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}; 
		assertTrue(arrayEqual(expectedarray, EQSortAlgorithm.sort(array)));
		
	}

    @Test
    public void testsmokeone() 
	{
		int[] array = new int[] { 76, 843, 44, 1, 3, 9 };
		int[] expectedarray = new int[] { 1, 3, 9, 44, 76, 843 }; 
		assertTrue(arrayEqual(expectedarray, EQSortAlgorithm.sort(array)));
		
	}

    @Test
    public void testsmoketwo() 
	{
		int[] array = new int[] {6, 1 };
		int[] expectedarray = new int[] { 1, 6 }; 
		assertTrue(arrayEqual(expectedarray, EQSortAlgorithm.sort(array)));
		
	}

    @Test
    public void testsmokethree() 
	{
		int[] array = new int[] { 5678, 6789, 1234, 2345, 3456, 9876 };
		int[] expectedarray = new int[] { 1234, 2345, 3456, 5678, 6789, 9876 }; 
		assertTrue(arrayEqual(expectedarray, EQSortAlgorithm.sort(array)));
		
	}

   @Test
   public void testsearchEmptyArray()
	{
 		int[]testArray = new int[] {};
		int[]testArray1 = new int[] {};
		assertTrue(arrayEqual(testArray1, EQSortAlgorithm.sort(testArray)));
	} 
   @Test
   public void testsearchEmptyArrayone()
	{
 		int[]testArray = new int[] {1};
		int[]testArray1 = new int[] {};
		assertTrue(!arrayEqual(testArray1, EQSortAlgorithm.sort(testArray)));
	} 

   @Test
   public void testsearchEmptyArraytwo()
	{
 		int[]testArray = new int[] {1, 987, 45, 2, 56, 8, 34, 55};
		int[]testArray1 = new int[] {};
		assertTrue(!arrayEqual(testArray1, EQSortAlgorithm.sort(testArray)));
	} 

    @Test
    public void testgenerateRandomArray() 
	{
		int[] expectedarray = Sati.generate(777);
		int[] array = Sati.shuffle(expectedarray, 7) ;
		assertTrue(arrayEqual(expectedarray, EQSortAlgorithm.sort(array)));
		
	}

    @Test
    public void testgenerateRandomArray1() 
	{
		int[] expectedarray = Sati.generate(6);
		int[] array = Sati.shuffle(expectedarray, 89);
		assertTrue(arrayEqual(expectedarray, EQSortAlgorithm.sort(array)));
		
	}

    @Test
    public void testgenerateRandomArray2() 
	{
		int[] expectedarray = Sati.generate(23);
		int[] array = Sati.shuffle(expectedarray, 34);
		assertTrue(arrayEqual(expectedarray, EQSortAlgorithm.sort(array)));
		
	} 
    @Test
    public void testgenerateRandomArray3() 
	{
		int[] expectedarray = Sati.generate(3);
		int[] array = Sati.shuffle(expectedarray, 3);
		assertTrue(arrayEqual(expectedarray, EQSortAlgorithm.sort(array)));
		
	} 
    @Test
    public void testgenerateRandomArray4() 
	{
		int[] expectedarray = Sati.generate(56);
		int[] array = Sati.shuffle(expectedarray, 4);
		assertTrue(arrayEqual(expectedarray, EQSortAlgorithm.sort(array)));
		
	} 

    @Test
    public void testgenerateRandomArray5() 
	{
		int[] expectedarray = Sati.generate(5656);
		int[] array = Sati.shuffle(expectedarray, 657);
		assertTrue(arrayEqual(expectedarray, EQSortAlgorithm.sort(array)));
		
	} 
// Jonathan Miller Kauffman's tests
 @Test
   public void testsearchEmptyArray2()
	{
 		int[]testArray = new int[] {};
		int[]testArray1 = new int[] {1, 2, 3, 4, 5};
		assertTrue(!arrayEqual(testArray1, EQSortAlgorithm.sort(testArray)));
	}

    @Test
    public void testArraySizeOne()
    {
        int[] testArray = new int[] {3};
        int[] testArray1 = new int[] {3};
        assertTrue(arrayEqual(testArray1, EQSortAlgorithm.sort(testArray)));
    }

   @Test
    public void testSmokeOne() 
	{
		int[] array = new int[] { 7, 23, 32, 26, 13 };
		int[] expectedarray = new int[] { 7, 13, 23, 26, 32 }; 
		assertTrue(arrayEqual(expectedarray, EQSortAlgorithm.sort(array)));
		
	}

    @Test
    public void testSmokeTwo() 
	{
		int[] array = new int[] { 3, 43, 32, 36, 13, 332, 1005, 89, 123, 2398, 3, 4 };
		int[] expectedarray = new int[] { 3, 3, 4, 13, 32, 36, 43, 89, 123, 332, 1005, 2398 }; 
		assertTrue(arrayEqual(expectedarray, EQSortAlgorithm.sort(array)));
		
	}

    @Test
    public void testSmokeThree() 
	{
		int[] array = new int[] { 3, 43};
		int[] expectedarray = new int[] { 3, 43}; 
		assertTrue(arrayEqual(expectedarray, EQSortAlgorithm.sort(array)));
		
	}

    @Test
    public void testSmokeFour() 
	{
		int[] array = new int[] { 5, 4, 3, 2, 1 };
		int[] expectedarray = new int[] { 1, 2, 3, 4, 5 }; 
		assertTrue(arrayEqual(expectedarray, EQSortAlgorithm.sort(array)));
		
	}

    @Test
    public void testBoundaryOne()
    {
        int[] array = new int[] {};
        int[] expectedarray= new int[] {};
		assertTrue(arrayEqual(expectedarray, EQSortAlgorithm.sort(array)));
    }

    @Test
    public void testBoundaryTwo()
    {
        int[] array = new int[] {7};
        int[] expectedarray= new int[] {7};
		assertTrue(arrayEqual(expectedarray, EQSortAlgorithm.sort(array)));
    }

    @Test
    public void testBoundaryThree()
    {
        int[] array = generateRandomArray(3000,300);
        int[] expectedarray= Arrays.copyOf(array,array.length);
        Arrays.sort(expectedarray);
		assertTrue(arrayEqual(expectedarray, EQSortAlgorithm.sort(array)));
    }

    @Test
    public void testBoundaryFour()
    {
        int[] array = generateRandomArray(3000,300000);
        int[] expectedarray= Arrays.copyOf(array,array.length);
        Arrays.sort(expectedarray);
		assertTrue(arrayEqual(expectedarray, EQSortAlgorithm.sort(array)));
    }

    @Test
    public void testPerformanceOne()
    {
		int[] array = generateRandomArray(454, 6 );
		long actual = EQSortAlgorithm.sortPerformance(array);
        long expected = array.length * array.length;
		assertThat(expected, greaterThanOrEqualTo(actual));
    }

    @Test
    public void testPerformanceTwo()
    {
		int[] array = generateRandomArray(2, 677 );
		long actual = EQSortAlgorithm.sortPerformance(array);
        long expected = array.length * array.length;
		assertThat(expected, greaterThanOrEqualTo(actual));
    }

    @Test
    public void testPerformanceThree()
    {
		int[] array = generateRandomArray(1, 45 );
		long actual = EQSortAlgorithm.sortPerformance(array);
        long expected = array.length * array.length;
		assertThat(expected, greaterThanOrEqualTo(actual));
    }

    @Test
    public void testPerformanceFour()
    {
		int[] array = generateRandomArray(14450, 5 );
		long actual = EQSortAlgorithm.sortPerformance(array);
        long expected = array.length * array.length;
		assertThat(expected, greaterThanOrEqualTo(actual));
    }

     @Test
    public void testPerformanceFive()
    {
		int[] array = generateRandomArray(8, 46 );
		long actual = EQSortAlgorithm.sortPerformance(array);
        long expected = array.length * array.length;
		assertThat(expected, greaterThanOrEqualTo(actual));
    }
     @Test
    public void testPerformanceSix()
    {
		int[] array = generateRandomArray(653, 4435 );
		long actual = EQSortAlgorithm.sortPerformance(array);
        long expected = array.length * array.length;
		assertThat(expected, greaterThanOrEqualTo(actual));
    }
	

}


