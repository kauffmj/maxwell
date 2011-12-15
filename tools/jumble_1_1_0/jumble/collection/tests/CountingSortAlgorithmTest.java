

import junit.framework.*;
import java.util.Random;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * CS290 Lab 3
 * CountingSortTest.java
 * Purpose: JUnit test suite for the Generator.java program
 *
 * @author Molly L Mattis
 * @author Eric Hildebrand
 * @author Travis Charlton
 * @version 1.0 9/26/11
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

public class CountingSortAlgorithmTest extends TestCase 
{
    CountingSortAlgorithm alg = new CountingSortAlgorithm();
    Random rng = new Random();	

    int repeatCount = 25;
    int maxArrayLength = 1000;
    int maxNum = 999;

    public CountingSortAlgorithmTest(String name) 
    {
	super(name);
    }
	
    public static Test suite() 
    {
	return new TestSuite(CountingSortAlgorithmTest.class);
    }
	
    /* Compares each value against the next value, and asserts that each one
     * is less than or equal to the value that comes after
     * 
     * @param array of integers
     */
    public void checkSorted(int[] array)
    {
	int pass = 0;
	for (int i=0; i<array.length-1; i++) {
	    pass = 0;
	    if (array[i] <= array[i+1])
		pass = 1;
	    assertEquals(1, pass);
	}
    }

    /* Compares the values of two arrays and asserts that they all match
     * 
     * @param array of integers
     * @param array of integers
     */
    public void checkMatching(int[] array1, int[] array2)
    {
	// Are they even the same length?
	assertEquals(array1.length,array2.length);
	// Do they match at all locations?
	for (int i=0; i<array1.length; i++)
	    {
		assertEquals(array1[i], array2[i]);
	    }
    }


    /**
     * Test the worse case scenario: the array is completely backwards
     * 
     * @Test
     */
    public void testWorstCase() 
    {
	int[] array = new int[]{5, 4, 3, 2, 1};

	int[] expected = new int[]{1,2,3,4,5};

	try {
	    int[] actual = alg.sort(array);
	    assertEquals(expected.length, actual.length);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
    } 

    /**
     * Test a simple small array 
     * 
     * @Test
     */
    public void testSimple() 
    {
	int[] array = new int[]{9, 5, 6, 3, 1};

	int[] expected = new int[]{1,3,5,6,9};

	try {
	    int[] actual = alg.sort(array);
	    assertEquals(expected.length, actual.length);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("fail1");
	}
    } 

    /**
     * Test an array of divisions, making sure they are integers 
     * 
     * @Test
     */
    public void testMath() 
    {
	int[] array = new int[]{6/2, 8/2, 16/2, 6/3, 12/2};

	int[] expected = new int[]{2,3,4,6,8};

	try {
	    int[] actual = alg.sort(array);
	    assertEquals(expected.length, actual.length);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
    } 

    /**
     * Tests the sort on an empty array
     * 
     * @Test
     */
    public void testEmptyList() 
    {
	int[] array = new int[]{};

	int[] expected = new int[]{};

	try {
	    int[] actual = alg.sort(array);
	    assertEquals(expected.length, actual.length);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
    }

    /**
     * Tests the sort when the array length is 1.
     * 
     * @Test
     */
    public void testLengthofOne() 
    {
	int[] array = new int[]{5};

	int[] expected = new int[]{5};

	try {
	    int[] actual = alg.sort(array);
	    assertEquals(expected.length, actual.length);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
    }


    /**
     * Tests the sort when the array length is 2.
     * 
     * @Test
     */
    public void testDouble()
    {
	int[] input = new int[] {2,1};
	int[] expected = new int[] {1,2};
	try {
	    int[] actual = alg.sort(input);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
    }

    /**
     * Tests the sort when the array length is 3.
     * 
     * @Test
     */
    public void testTriple()
    {
	int[] input = new int[] {2,3,1};
	int[] expected = new int[] {1,2,3};
	try {
	    int[] actual = alg.sort(input);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
    }

    /**
     * Tests the sort on an already partially sorted array. 
     * .
     * @Test
     */
    public void testPartiallySorted() 
    {
	int[] array = new int[]{1, 2, 4, 3, 5};

	int[] expected = new int[]{1, 2, 3, 4, 5};

	try {
	    int[] actual = alg.sort(array);
	    assertEquals(expected.length, actual.length);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("fail1");
	}
    }


    /**
     * Tests the sort on an already sorted array. 
     * .
     * @Test
     */
    public void testAlreadySorted() 
    {
	int[] array = new int[]{1, 2, 3, 4, 5};

	int[] expected = new int[]{1, 2, 3, 4, 5};

	try {
	    int[] actual = alg.sort(array);
	    assertEquals(expected.length, actual.length);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("fail1");
	}
    }

    /**
     * Tests an array this is filled with the same number
     * 
     * @Test
     */
    public void testSameNum() 
    {
	int[] array = new int[]{2, 2, 2, 2, 2, 2, 2, 2};

	int[] expected = new int[]{2, 2, 2, 2, 2, 2, 2, 2};

	try {
	    int[] actual = alg.sort(array);
	    assertEquals(expected.length, actual.length);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("fail1");
	}
    }

    /**
     * Tests an array with one different number. That different number must  
     * go to the end of the array when sorted.
     * @Test
     */
    public void testOneChangeEnd() 
    {
	int[] array = new int[]{2, 2, 2, 5, 2, 2, 2, 2};

	int[] expected = new int[]{2, 2, 2, 2, 2, 2, 2, 5};

	try {
	    int[] actual = alg.sort(array);
	    assertEquals(expected.length, actual.length);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("fail1");
	}
    }

    /**
     * Tests an array with one different number. That different number must  
     * go to the beginning of the array when sorted.
     * @Test
     */
    public void testOneChangeFront() 
    {
	int[] array = new int[]{2, 2, 2, 2, 2, 1, 2, 2};

	int[] expected = new int[]{1, 2, 2, 2, 2, 2, 2, 2};

	try {
	    int[] actual = alg.sort(array);
	    assertEquals(expected.length, actual.length);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("fail1");
	}
    }

    /**
     * Tests an array with two different numbers that must flip sides of 
     * the array in order to be sorted.
     *
     * @Test
     */
    public void testTwoChanges() 
    {
	int[] array = new int[]{2, 2, 6, 2, 2, 2, 1, 2};

	int[] expected = new int[]{1, 2, 2, 2, 2, 2, 2, 6};

	try {
	    int[] actual = alg.sort(array);
	    assertEquals(expected.length, actual.length);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("fail1");
	}
    }

    /**
     * Tests an array with three different numbers  
     *
     * @Test
     */
    public void testThreeChanges() 
    {
	int[] array = new int[]{2, 2, 6, 2, 4, 2, 1, 2};

	int[] expected = new int[]{1, 2, 2, 2, 2, 2, 4, 6};

	try {
	    int[] actual = alg.sort(array);
	    assertEquals(expected.length, actual.length);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("fail1");
	}
    }

    /**
     * Tests an array with all double digits
     *
     * @Test
     */
    public void testDoubleDigs() 
    {
	int[] array = new int[]{11, 15, 12, 16, 25, 85, 32, 55};

	int[] expected = new int[]{11, 12, 15, 16, 25, 32, 55, 85};

	try {
	    int[] actual = alg.sort(array);
	    assertEquals(expected.length, actual.length);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("fail1");
	}
    }


    /**
     * Tests an array with mixed double and single digits  
     *
     * @Test
     */
    public void testMixedDigs() 
    {
	int[] array = new int[]{11, 15, 12, 2, 25, 85, 7, 55};

	int[] expected = new int[]{2, 7, 11, 12, 15, 25, 55, 85};

	try {
	    int[] actual = alg.sort(array);
	    assertEquals(expected.length, actual.length);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("fail1");
	}
    }

    /**
     * Tests an array with all triple digit numbers
     *
     * @Test
     */
    public void testTripleDigs() 
    {
	int[] array = new int[]{102, 505, 565, 201, 656, 789, 100, 632};

	int[] expected = new int[]{100, 102, 201, 505, 565, 632, 656, 789};

	try {
	    int[] actual = alg.sort(array);
	    assertEquals(expected.length, actual.length);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("fail Triple Digs");
	}
    }

    /**
     * Tests an array with mixed triple, and double digit numbers
     *
     * @Test
     */
    public void testMixTripleDigs() 
    {
	int[] array = new int[]{69, 505, 565, 201, 656, 789, 55, 632};

	int[] expected = new int[]{55, 69, 201, 505, 565, 632, 656, 789};

	try {
	    int[] actual = alg.sort(array);
	    assertEquals(expected.length, actual.length);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("fail Mix Triple Digs");
	}
    }

    /**
     * Tests an array with mixed triple, double, and single digit numbers
     *
     * @Test
     */
    public void testMixDSTDigs() 
    {
	int[] array = new int[]{2, 1, 565, 55, 656, 789, 69, 632};

	int[] expected = new int[]{1, 2, 55, 69, 565, 632, 656, 789};

	try {
	    int[] actual = alg.sort(array);
	    assertEquals(expected.length, actual.length);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("fail1");
	}
    }


    /**
     * Tests an array where some numbers are negative and some are positive
     * 
     * @Test
     */
    public void testSome() 
    {
	int[] array = new int[]{2, 5, 6, 9, 7, 4, 1, 3};

	int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 9};

	try {
	    int[] actual = alg.sort(array);
	    assertEquals(expected.length, actual.length);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("fail1");
	}
    }

    /**
     * Tests sorting of an array of 10 random values 
     * 
     * @Test
     */
    public void testRandomValues()
    {
	int numberOfRuns = repeatCount;
	for (int runs = 0; runs<numberOfRuns; runs++) {
	    // generate a list of ten random numbers between 0 and 100
	    int[] input = new int[10];
	    for (int i=0; i<input.length; i++)
		input[i] = rng.nextInt(100);
	    try {
		int[] output = alg.sort(input);
		checkSorted(output);
	    }
	    catch (Exception e) {
		e.printStackTrace();
		System.out.println("fail1");
	    }
	}
    }

    /**
     * Tests sorting of an array of 20 random values 
     * 
     * @Test
     */
    public void testRandomValues20()
    {
	int numberOfRuns = repeatCount;
	for (int runs = 0; runs<numberOfRuns; runs++) {
	    // generate a list of twenty random numbers between 0 and 100
	    int[] input = new int[20];
	    for (int i=0; i<input.length; i++)
		input[i] = rng.nextInt(100);
	    try {
		int[] output = alg.sort(input);
		checkSorted(output);
	    }
	    catch (Exception e) {
		e.printStackTrace();
		System.out.println("fail1");
	    }
	}
    }

    /**
     * Tests sorting of an array of 25 random values 
     * 
     * @Test
     */
    public void testRandomValues25()
    {
	int numberOfRuns = repeatCount;
	for (int runs = 0; runs<numberOfRuns; runs++) {
	    // generate a list of twenty five random numbers between 0 and 100
	    int[] input = new int[25];
	    for (int i=0; i<input.length; i++)
		input[i] = rng.nextInt(100);
	    try {
		int[] output = alg.sort(input);
		checkSorted(output);
	    }
	    catch (Exception e) {
		e.printStackTrace();
		System.out.println("fail1");
	    }
	}
    }

    /**
     * Tests sorting of an array of 50 random values 
     * 
     * @Test
     */
    public void testRandomValues50()
    {
	int numberOfRuns = repeatCount;
	for (int runs = 0; runs<numberOfRuns; runs++) {
	    // generate a list of fifty random numbers between 0 and 100
	    int[] input = new int[50];
	    for (int i=0; i<input.length; i++)
		input[i] = rng.nextInt(100);
	    try {
		int[] output = alg.sort(input);
		checkSorted(output);
	    }
	    catch (Exception e) {
		e.printStackTrace();
		System.out.println("fail1");
	    }
	}
    }

    /**
     * Tests sorting of an array of 20 random values with more options
     * 
     * @Test
     */
    public void testRandomValues20long()
    {
	int numberOfRuns = repeatCount;
	for (int runs = 0; runs<numberOfRuns; runs++) {
	    // generate a list of twenty random numbers between 0 and 1000
	    int[] input = new int[20];
	    for (int i=0; i<input.length; i++)
		input[i] = rng.nextInt(1000);
	    try {
		int[] output = alg.sort(input);
		checkSorted(output);
	    }
	    catch (Exception e) {
		e.printStackTrace();
		System.out.println("fail1");
	    }
	}
    }
  

    /**
     * Tests sorting of an array with random length and random values
     * 
     * @Test
     */
    public void testRandomLengths()
    {
	int numberOfRuns = repeatCount;
        for (int runs = 0; runs<numberOfRuns; runs++) {
      	// we generate some list of up to maxArrayLength randoms
	    int[] input = new int[rng.nextInt(maxArrayLength)];
	    for (int i=0; i<input.length; i++)
		input[i] = rng.nextInt(maxNum);
	    try {
		int[] output = alg.sort(input);
		checkSorted(output);
	    }
	    catch (Exception e) {
		e.printStackTrace();
		System.out.println("fail1");
	    }
	}
    }
    
    /**
     * Tests sorting of an array with random length and all values equal
     * 
     * @Test
     */
    public void testRandomLengthsEqual()
    {
	int numberOfRuns = repeatCount;
	for (int runs = 0; runs<numberOfRuns; runs++) {
	    // we generate some list of up to maxArrayLength randoms
	    int[] input = new int[rng.nextInt(maxArrayLength)];
	    int value = rng.nextInt(maxNum);
	    for (int i=0; i<input.length; i++)
		input[i] = value;
	    try {
		int[] output = alg.sort(input);
		checkSorted(output);
	    }
	    catch (Exception e) {
		e.printStackTrace();
		System.out.println("fail");
	    }
	}
    }

    /**
     * Tests worst case performance
     * 
     * @Test
     */
    public void testPerformanceOne()
    {
        int actual = 100 + 50;
        int expected = alg.sortPerformance(Sati.shuffle(Sati.generate(100,50),5));
        assertThat(expected, greaterThanOrEqualTo(actual));
    }

    /**
     * Tests worst case performance
     * 
     * @Test
     */
    public void testPerformanceTwo()
    {
        int actual = 1000 + 50;
        int expected = alg.sortPerformance(Sati.shuffle(Sati.generate(1000,50),5));
        assertThat(expected, greaterThanOrEqualTo(actual));
    }
}
