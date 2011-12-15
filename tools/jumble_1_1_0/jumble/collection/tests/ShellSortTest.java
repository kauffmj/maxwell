/**
 * Test suite for the ShellSort algorithm
 * Pledge:
 *
 *
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
 *
 *
 *
 */

import junit.framework.*;
import java.util.Random;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class ShellSortTest extends TestCase 
{

    ShellSortAlgorithm alg = new ShellSortAlgorithm();
    Random rng = new Random();

    /* Setup variables */
    // use this to perform verbose testing, with lots and lots of output
    int verbose = 0;
    // for repeating tests, use this to adjust how many runs they attempt
    int repeatCount = 10;
    // how much memory do you think you have?  not enough for tons of arrays
    // of length 2^31-1, that's for sure...  So pick a reasonable cap.
    int maxArrayLength = 1000000;
    // note: tested up to 100000000 so far (100 million)

    public ShellSortTest(String name) 
    {
	super(name);
    }
    
    public static Test suite() 
    {
	return new TestSuite(ShellSortTest.class);
    }
    

    /* **********************************************************************
       HELPER METHODS
    *************************************************************************/


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


    /* **********************************************************************
       TEST CASES
    *************************************************************************/
   

    /* sort a simple array {5,3,2,4,1} 
    *
    * @Test
    */
    public void testBasic() 
    {
	int[] input = new int[] {5, 3, 2, 4, 1};
	int[] expected = new int[] {1, 2, 3, 4, 5};
	try {
	    int[] actual = alg.sort(input);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /* what happens with an array of length 0?
    *
    * @Test
    */
    public void testNull()
    {
	int[] input = new int[] {};
	int[] expected = new int[] {};
	try {
	    int[] actual = alg.sort(input);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /* what happens with an array of length 1?
    *
    * @Test
    */
    public void testSingle()
    {
	int[] input = new int[] {0};
	int[] expected = new int[] {0};
	try {
	    int[] actual = alg.sort(input);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /* what happens with an array of length 2?
    *
    * @Test
    */
    public void testDouble()
    {
	int[] input = new int[] {2,-1};
	int[] expected = new int[] {-1,2};
	try {
	    int[] actual = alg.sort(input);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /* what happens with an array of length 3?
    *
    * @Test
    */
    public void testTriple()
    {
	int[] input = new int[] {2,-3,-1};
	int[] expected = new int[] {-3,-1,2};
	try {
	    int[] actual = alg.sort(input);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /* what happens with an array of length 3?
    *
    * @Test
    */
    public void testQuadruple()
    {
	int[] input = new int[] {-1,-3,17,-1000};
	int[] expected = new int[] {-1000,-3,-1,17};
	try {
	    int[] actual = alg.sort(input);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /* what happens with an array with an extremely high number?
    *
    * @Test
    */
    public void testBigNumbers1()
    {
	int[] input = new int[] {Integer.MAX_VALUE,Integer.MAX_VALUE-1,0};
	int[] expected = new int[] {0,Integer.MAX_VALUE-1,Integer.MAX_VALUE};
	try {
	    int[] actual = alg.sort(input);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /* what happens with an array with an extremely low number?
    *
    * @Test
    */
    public void testBigNumbers2()
    {
	int[] input = new int[] {Integer.MIN_VALUE+1,0,Integer.MIN_VALUE};
	int[] expected = new int[] {Integer.MIN_VALUE,Integer.MIN_VALUE+1,0};
	try {
	    int[] actual = alg.sort(input);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /* what happens with an array with extremely high/low numbers?
    *
    * @Test
    */
    public void testBigNumbers3()
    {
	int[] input = new int[] {Integer.MAX_VALUE,Integer.MIN_VALUE,0};
	int[] expected = new int[] {Integer.MIN_VALUE,0,Integer.MAX_VALUE};
	try {
	    int[] actual = alg.sort(input);
	    checkMatching(expected, actual);
	}
	catch (Exception e) {
	    e.printStackTrace();
	    fail();
	}
    }

    /* test sorting of an array of 10 random values
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
		if (verbose == 1) {
		    System.out.print("{");
		    for (int j=0; j<input.length-1; j++)
			System.out.print(input[j] + ",");
		    System.out.print(input[input.length-1] + "} --> {");
		}
		int[] output = alg.sort(input);
		checkSorted(output);
		if (verbose == 1) {
		    for (int j=0; j<output.length-1; j++)
			System.out.print(output[j] + ",");
		    System.out.print(output[output.length-1] + "}\n");
		}
	    }
	    catch (Exception e) {
		e.printStackTrace();
		fail();
	    }
	}
    }

    /* test sorting of an array of 10 random negative values */
    public void testRandomNegativeValues()
    {
	int numberOfRuns = repeatCount;
	for (int runs = 0; runs<numberOfRuns; runs++) {
	    // generate a list of ten random numbers between -100 and 0
	    int[] input = new int[10];
	    for (int i=0; i<input.length; i++)
		input[i] = 0-rng.nextInt(100);
	    try {
		if (verbose == 1) {
		    System.out.print("{");
		    for (int j=0; j<input.length-1; j++)
			System.out.print(input[j] + ",");
		    System.out.print(input[input.length-1] + "} --> {");
		}
		int[] output = alg.sort(input);
		checkSorted(output);
		if (verbose == 1) {
		    for (int j=0; j<output.length-1; j++)
			System.out.print(output[j] + ",");
		    System.out.print(output[output.length-1] + "}\n");
		}
	    }
	    catch (Exception e) {
		e.printStackTrace();
		fail();
	    }
	}
    }

    /* test sorting of an array of 10 random positive and negative values
    *
    * @Test
    */
    public void testRandomMixedValues()
    {
	int numberOfRuns = repeatCount;
	for (int runs = 0; runs<numberOfRuns; runs++) {
	    // generate a list of ten random numbers between -100 and 100
	    int[] input = new int[10];
	    for (int i=0; i<input.length; i++)
		input[i] = 100-rng.nextInt(200);
	    try {
		if (verbose == 1) {
		    System.out.print("{");
		    for (int j=0; j<input.length-1; j++)
			System.out.print(input[j] + ",");
		    System.out.print(input[input.length-1] + "} --> {");
		}
		int[] output = alg.sort(input);
		checkSorted(output);
		if (verbose == 1) {
		    for (int j=0; j<output.length-1; j++)
			System.out.print(output[j] + ",");
		    System.out.print(output[output.length-1] + "}\n");
		}
	    }
	    catch (Exception e) {
		e.printStackTrace();
		fail();
	    }
	}
    }

    /* test sorting of an array of random length and random values
    *
    * @Test
    */
    public void testRandomLengths()
    {
	int numberOfRuns = repeatCount;
	for (int runs = 0; runs<numberOfRuns; runs++) {
	    // we generate some list of up to maxArrayLength randoms
	    int[] input = new int[rng.nextInt(maxArrayLength)];
	    if (verbose == 1)
		System.out.println("Testing positive array of size "
				   + input.length);
	    for (int i=0; i<input.length; i++)
		input[i] = rng.nextInt();
	    try {
		int[] output = alg.sort(input);
		checkSorted(output);
	    }
	    catch (Exception e) {
		e.printStackTrace();
		fail();
	    }
	}
    }
    
    /* test sorting of an array of random length and random values
    *
    * @Test
    */
    public void testRandomLengthsNegatives()
    {
	int numberOfRuns = repeatCount;
	for (int runs = 0; runs<numberOfRuns; runs++) {
	    // we generate some list of up to maxArrayLength randoms
	    int[] input = new int[rng.nextInt(maxArrayLength)];
	    if (verbose == 1)
		System.out.println("Testing negative array of size " 
				   + input.length);
	    for (int i=0; i<input.length; i++)
		input[i] = -1*rng.nextInt();
	    try {
		int[] output = alg.sort(input);
		checkSorted(output);
	    }
	    catch (Exception e) {
		e.printStackTrace();
		fail();
	    }
	}
    }
    
    /* test sorting of an array of random length and random values
    *
    * @Test
    */
    public void testRandomLengthsMixed()
    {
	int numberOfRuns = repeatCount;
	for (int runs = 0; runs<numberOfRuns; runs++) {
	    // we generate some list of up to maxArrayLength randoms
	    int[] input = new int[rng.nextInt(maxArrayLength)];
	    if (verbose == 1)
		System.out.println("Testing mixed array of size "
				   + input.length);
	    for (int i=0; i<input.length; i++) {
		// Flip a coin, and use the results to decide the negativeness
		if (rng.nextInt(2) == 1)
		    input[i] = rng.nextInt();
		else
		    input[i] = -1*rng.nextInt();
	    }
	    try {
		int[] output = alg.sort(input);
		checkSorted(output);
	    }
	    catch (Exception e) {
		e.printStackTrace();
		fail();
	    }
	}
    }
    
    /* test sorting of an array of random length with all values the same
    *
    * @Test
    */
    public void testRandomLengthsEqual()
    {
	int numberOfRuns = repeatCount;
	for (int runs = 0; runs<numberOfRuns; runs++) {
	    // we generate some list of up to maxArrayLength randoms
	    int[] input = new int[rng.nextInt(maxArrayLength)];
	    int value = rng.nextInt();
	    if (verbose == 1)
		System.out.println("Testing boring array of size "
				   + input.length);
	    for (int i=0; i<input.length; i++)
		input[i] = value;
	    try {
		int[] output = alg.sort(input);
		checkSorted(output);
	    }
	    catch (Exception e) {
		e.printStackTrace();
		fail();
	    }
	}
    }
    
    /* test sorting of an array of random length with most values the same
    *
    * @Test
    */
    public void testRandomLengthsEqualish()
    {
	int numberOfRuns = repeatCount;
	for (int runs = 0; runs<numberOfRuns; runs++) {
	    // we generate some list of up to maxArrayLength randoms
	    int[] input = new int[rng.nextInt(maxArrayLength)];
	    int value = rng.nextInt();
	    if (verbose == 1)
		System.out.println("Testing semi-boring array of size "
				   + input.length);
	    for (int i=0; i<input.length; i++) {
		if (rng.nextInt(5) == 0)
		    input[i] = rng.nextInt();
		else
		    input[i] = value;
	    }
	    try {
		int[] output = alg.sort(input);
		checkSorted(output);
	    }
	    catch (Exception e) {
		e.printStackTrace();
		fail();
	    }
	}
    }
    
    /* test sorting of an array of random length made of just 1s and 0s
    *
    * @Test
    */
    public void testRandomLengthsBinary()
    {
	int numberOfRuns = repeatCount;
	for (int runs = 0; runs<numberOfRuns; runs++) {
	    // we generate some list of up to maxArrayLength randoms
	    int[] input = new int[rng.nextInt(maxArrayLength)];
	    if (verbose == 1)
		System.out.println("Testing binary array of size "
				   + input.length);
	    for (int i=0; i<input.length; i++)
		input[i] = rng.nextInt(2);
	    try {
		int[] output = alg.sort(input);
		checkSorted(output);
	    }
	    catch (Exception e) {
		e.printStackTrace();
		fail();
	    }
	}
    }
    
    /* test sorting of an array of random length with only two value choices
    *
    * @Test
    */
    public void testRandomLengthsPair()
    {
	int numberOfRuns = repeatCount;
	for (int runs = 0; runs<numberOfRuns; runs++) {
	    // we generate some list of up to maxArrayLength randoms
	    int[] input = new int[rng.nextInt(maxArrayLength)];
	    int value1 = rng.nextInt();
	    int value2 = rng.nextInt();
	    if (verbose == 1)
		System.out.println("Testing boring-pair array of size "
				   + input.length);
	    for (int i=0; i<input.length; i++) {
		if (rng.nextInt(2) == 0)
		    input[i] = value1;
		else
		    input[i] = value2;
	    }
	    try {
		int[] output = alg.sort(input);
		checkSorted(output);
	    }
	    catch (Exception e) {
		e.printStackTrace();
		fail();
	    }
	}
    }
    
    /* test sorting of an array of random length with only two value choices
    *
    * @Test
    */
    public void testRandomLengthsTrio()
    {
	int numberOfRuns = repeatCount;
	for (int runs = 0; runs<numberOfRuns; runs++) {
	    // we generate some list of up to maxArrayLength randoms
	    int[] input = new int[rng.nextInt(maxArrayLength)];
	    int value1 = rng.nextInt();
	    int value2 = rng.nextInt();
	    if (verbose == 1)
		System.out.println("Testing boring-trio array of size "
				   + input.length);
	    for (int i=0; i<input.length; i++)
		input[i] = rng.nextInt(3);
	    try {
		int[] output = alg.sort(input);
		checkSorted(output);
	    }
	    catch (Exception e) {
		e.printStackTrace();
		fail();
	    }
	}
    }

    // More Random Tests (using SATI)
    public void testExtraRandomOne()
    {
	int[] input = Sati.generate(10);
	Sati.shuffle(input, 100);
	checkSorted(input);
    }

    public void testExtraRandomTwo()
    {
	int[] input = Sati.generate(100);
	Sati.shuffle(input, 100);
	checkSorted(input);
    }

    public void testExtraRandomThree()
    {
	int[] input = Sati.generate(1000);
	Sati.shuffle(input, 500);
	checkSorted(input);
    }

    public void testExtraRandomFour()
    {
	int[] input = Sati.generate(5000);
	Sati.shuffle(input, 500);
	checkSorted(input);
    }

    public void testExtraRandomFive()
    {
	int[] input = Sati.generate(10000);
	Sati.shuffle(input, 1000);
	checkSorted(input);
    }

    public void testExtraRandomSix()
    {
	int[] input = Sati.generate(800);
	Sati.shuffle(input, 1000);
	checkSorted(input);
    }
    
    public void testExtraRandomSeven()
    {
	int[] input = Sati.generate(1000);
	Sati.shuffle(input, 50);
	checkSorted(input);
    }

    public void testExtraRandomEight()
    {
	int[] input = Sati.generate(20);
	Sati.shuffle(input, 10);
	checkSorted(input);
    }

    public void testExtraRandomNine()
    {
	int[] input = Sati.generate(100);
	Sati.shuffle(input, 1000);
	checkSorted(input);
    }
    
    public void testExtraRandomTen()
    {
	int[] input = Sati.generate(2000);
	Sati.shuffle(input, 4000);
	checkSorted(input);
    }

    /* test worst case performance
    *
    * @Test
    */
    public void testPerformanceOne()
    {
        int expected = (int)Math.pow(50,1.5);
        int actual = alg.sortPerformance(Sati.shuffle(Sati.generate(50),5));
		assertThat(expected, greaterThanOrEqualTo(actual));
    }

    /* test worst case performance
    *
    * @Test
    */
    public void testPerformanceTwo()
    {
        int expected = (int)Math.pow(100,1.5);
        int actual = alg.sortPerformance(Sati.shuffle(Sati.generate(100),5));
		assertThat(expected, greaterThanOrEqualTo(actual));
    }
    
    /* uncomment if you want to see what happens
     *
     * @Test
     */
    /*
    public void testHoldOnASecond()
    {
	int numberOfRuns = 1;
	for (int runs = 0; runs<numberOfRuns; runs++) {
	    // we generate some list of up to maxArrayLength randoms
	    int[] input = new int[Integer.MAX_VALUE];
	    if (verbose == 1)
		System.out.println("Testing mixed array of size "
				   + input.length);
	    for (int i=0; i<input.length; i++) {
		// Flip a coin, and use the results to decide the negativeness
		if (rng.nextInt(2) == 1)
		    input[i] = rng.nextInt();
		else
		    input[i] = -1*rng.nextInt();
	    }
	    try {
		int[] output = alg.sort(input);
		checkSorted(output);
	    }
	    catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
    */

}
