// Travis Charlton, Molly Mattis, Eric Hildebrand
// Professor Kapfhammer
// CS290
// 24 September 2011

/* This is the test suite for the GnomeSortAlgorithm program.  It test to ensure that the
 * GnomeSort Algorithm is working correctly for many different inputs.  These include arrays of
 * small (0) and large (100000) length, sorted and unsorted arrays, arrays containing positive and
 * negative numbers, and randomly generated arrays.  The algorithm will only proess integers.
 * Thirty-seven tests in total have been written.
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

// @author    Travis Charlton, Molly Mattis, Eric Hildebrand
//  PLEDGE:



import junit.framework.*;
import java.util.*;

public class GnomeSortAlgorithmTest extends TestCase
{
    // An instance of the GnomeSortAlgorithm class that will help run the tests
    GnomeSortAlgorithm alg = new GnomeSortAlgorithm();

    // Constructor for the GnomeSortAlgorithm
    public GnomeSortAlgorithmTest(String name)
    {
	super(name);
    }

    // Method that establishes the test suite for the GnomeSortAlgorithm

    // @return    returns the the test suite
    public static Test suite()
    {
	return new TestSuite(GnomeSortAlgorithmTest.class);
    }


    // The first fifteen tests are "handwritten" tests while the second fifteen are
    // randomly generated with each run of the test suite.  Testing in the first fifteen tests
    // can be explicit (comparison between actual and expected values).  Testing in the second
    // fifteen tests must be done differently as the expected values cannot be known for
    // randomly generated arrays.  Instead, tests are considered to have passed if, when each
    // item in the array is compared to the item directly after it, the former is less than the
    // latter.  If this is true throughout the length of the array, the array is sorted and the
    // test has passed.  The final seven tests were added as part of the Lab 4 project, to
    // include boundary and random testing.
    

    // First test: A basic two item array - unsorted, positive numbers
    public void testOne()
    {
	int passed = 1;
	int[] input = {2, 1};
	int[] expected = {1, 2};
	try
	    {
	       
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(expected[i] != actual[i])
			    passed = 0;
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Second test: A basic two item array - sorted, positive numbers
    public void testTwo()
    {
	int passed = 1;
	int[] input = {1, 2};
	int[] expected = {1, 2};
	try
	    {
	       
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(expected[i] != actual[i])
			    passed = 0;
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Third test: A basic two item array - unsorted, positive and negative numbers
    public void testThree()
    {
	int passed = 1;
	int[] input = {1, -1};
	int[] expected = {-1, 1};
	try
	    {
	       
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(expected[i] != actual[i])
			    passed = 0;
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Fourth test: A basic 3 item array - unsorted, positive numbers
    public void testFour()
    {
	int passed = 1;
	int[] input = {2, 3, 1};
	int[] expected = {1, 2, 3};
	try
	    {
	       
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(expected[i] != actual[i])
			    passed = 0;
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Test five: An array of 5 items - sorted, positive numbers
    public void testFive()
    {
	int passed = 1;
	int[] input = {1, 2, 3, 4, 5};
	int[] expected = {1, 2, 3, 4, 5};
	try
	    {
	       
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(expected[i] != actual[i])
			    passed = 0;
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Test six:  An array of ten items - unsorted, positive numbers
    public void testSix()
    {
	int passed = 1;
	int[] input = {7, 3, 5, 2, 1, 6, 9, 10, 8, 4};
	int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	try
	    {
	       
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(expected[i] != actual[i])
			    passed = 0;
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Test seven: An array of 9 items - unsorted, positive and negative numbers (repeat values)
    public void testSeven()
    {
	int passed = 1;
	int[] input = {258, 0, 18, -47, 900, 0, 258, -13, 147};
	int[] expected = {-47, -13, 0, 0, 18, 147, 258, 258, 900};
	try
	    {
	       
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(expected[i] != actual[i])
			    passed = 0;
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Test eight: An array of 21 items - sorted, positive and negative numbers
    public void testEight()
    {
	int passed = 1;
	int[] input = {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1,
		       0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	int[] expected = {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1,
			  0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	try
	    {
	       
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(expected[i] != actual[i])
			    passed = 0;
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Test nine: An array of 16 items - sorted, positive numbers (repeat values)
    public void testNine()
    {
	int passed = 1;
	int[] input = {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
	int[] expected = {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
	try
	    {
	       
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(expected[i] != actual[i])
			    passed = 0;
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Test ten: An array of 10 items - unsorted (reverse order), positive numbers
    public void testTen()
    {
	int passed = 1;
	int[] input = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
	int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	try
	    {
	       
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(expected[i] != actual[i])
			    passed = 0;
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Test eleven: An array of 20 items - unsorted (reverse order), positive numbers
    public void testEleven()
    {
	int passed = 1;
	int[] input = {20, 19, 18, 17, 16, 15, 14, 13, 12, 11,
		       10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
	int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
			  11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
	try
	    {
	       
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(expected[i] != actual[i])
			    passed = 0;
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Test twelve: An array of 5 items - unsorted, negative numbers
    public void testTwelve()
    {
	int passed = 1;
	int[] input = {-2, -8, -14, -5, -3};
	int[] expected = {-14, -8, -5, -3, -2};
	try
	    {
	       
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(expected[i] != actual[i])
			    passed = 0;
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Test thirteen: An array of 10 items - unsorted, positive and negative numbers
    public void testThirteen()
    {
	int passed = 1;
	int[] input = {0, 7, 4, -2, -2, -5, -5, 4, 7, 0};
	int[] expected = {-5, -5, -2, -2, 0, 0, 4, 4, 7, 7};
	try
	    {
	       
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(expected[i] != actual[i])
			    passed = 0;
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Test fourteen: An array of 10 items - unsorted, positive numbers (repeat values)
    public void testFourteen()
    {
	int passed = 1;
	int[] input = {0, 1, 1, 0, 1, 0, 1, 0, 0, 1};
	int[] expected = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
	try
	    {
	       
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(expected[i] != actual[i])
			    passed = 0;
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Test fifteen: An array of 8 items - unsorted, positive and negative numbers
    public void testFifteen()
    {
	int passed = 1;
	int[] input = {3, -2, 0, 1, -0, -1, -3, 2};
	int[] expected = {-3, -2, -1, 0, 0, 1, 2, 3};
	try
	    {
	       
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(expected[i] != actual[i])
			    passed = 0;
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Array between lengths 2-10, item with values 0-99
    public void testSixteen()
    {
	Random gen = new Random();
	int passed = 1;
	int[] input = new int[(gen.nextInt(9) + 2)];
	for(int i = 0; i < input.length; i++)
	    {
		input[i] = gen.nextInt(100);
	    }
	try
	    {
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(i != 0)
			    {
				if(actual[i-1] > actual[i])
				    {
					passed = 0;
				    }
			    }
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Array between lengths 2-10, item with values 0-99
    public void testSeventeen()
    {
	Random gen = new Random();
	int passed = 1;
	int[] input = new int[(gen.nextInt(9) + 2)];
	for(int i = 0; i < input.length; i++)
	    {
		input[i] = gen.nextInt(100);
	    }
	try
	    {
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(i != 0)
			    {
				if(actual[i-1] > actual[i])
				    {
					passed = 0;
				    }
			    }
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Array between lengths 2-10, item with values 0-99
    public void testEighteen()
    {
	Random gen = new Random();
	int passed = 1;
	int[] input = new int[(gen.nextInt(9) + 2)];
	for(int i = 0; i < input.length; i++)
	    {
		input[i] = gen.nextInt(100);
	    }
	try
	    {
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(i != 0)
			    {
				if(actual[i-1] > actual[i])
				    {
					passed = 0;
				    }
			    }
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Array between lengths 2-100, item with values 0-999
    public void testNineteen()
    {
	Random gen = new Random();
	int passed = 1;
	int[] input = new int[(gen.nextInt(99) + 2)];
	for(int i = 0; i < input.length; i++)
	    {
		input[i] = gen.nextInt(1000);
	    }
	try
	    {
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(i != 0)
			    {
				if(actual[i-1] > actual[i])
				    {
					passed = 0;
				    }
			    }
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Array between lengths 2-100, item with values 0-999
    public void testTwenty()
    {
	Random gen = new Random();
	int passed = 1;
	int[] input = new int[(gen.nextInt(99) + 2)];
	for(int i = 0; i < input.length; i++)
	    {
		input[i] = gen.nextInt(1000);
	    }
	try
	    {
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(i != 0)
			    {
				if(actual[i-1] > actual[i])
				    {
					passed = 0;
				    }
			    }
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Array between lengths 2-100, item with values 0-999
    public void testTwentyOne()
    {
	Random gen = new Random();
	int passed = 1;
	int[] input = new int[(gen.nextInt(99) + 2)];
	for(int i = 0; i < input.length; i++)
	    {
		input[i] = gen.nextInt(1000);
	    }
	try
	    {
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(i != 0)
			    {
				if(actual[i-1] > actual[i])
				    {
					passed = 0;
				    }
			    }
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Array between lengths 2-100, item with values 0-(-999)
    public void testTwentyTwo()
    {
	Random gen = new Random();
	int passed = 1;
	int[] input = new int[(gen.nextInt(99) + 2)];
	for(int i = 0; i < input.length; i++)
	    {
		input[i] = (gen.nextInt(1000) * -1);
	    }
	try
	    {
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(i != 0)
			    {
				if(actual[i-1] > actual[i])
				    {
					passed = 0;
				    }
			    }
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Array between lengths 2-100, item with values 0-(-999)
    public void testTwentyThree()
    {
	Random gen = new Random();
	int passed = 1;
	int[] input = new int[(gen.nextInt(99) + 2)];
	for(int i = 0; i < input.length; i++)
	    {
		input[i] = (gen.nextInt(1000) * -1);
	    }
	try
	    {
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(i != 0)
			    {
				if(actual[i-1] > actual[i])
				    {
					passed = 0;
				    }
			    }
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Array between lengths 2-100, item with values 0-(-999)
    public void testTwentyFour()
    {
	Random gen = new Random();
	int passed = 1;
	int[] input = new int[(gen.nextInt(99) + 2)];
	for(int i = 0; i < input.length; i++)
	    {
		input[i] = (gen.nextInt(1000) * -1);
	    }
	try
	    {
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(i != 0)
			    {
				if(actual[i-1] > actual[i])
				    {
					passed = 0;
				    }
			    }
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Array between lengths 100000, item with values 0-999
    public void testTwentyFive()
    {
	Random gen = new Random();
	int passed = 1;
	int[] input = new int[100000];
	for(int i = 0; i < input.length; i++)
	    {
		input[i] = gen.nextInt(1000);
	    }
	try
	    {
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(i != 0)
			    {
				if(actual[i-1] > actual[i])
				    {
					passed = 0;
				    }
			    }
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Array between lengths 100000, item with values 0-999
    public void testTwentySix()
    {
	Random gen = new Random();
	int passed = 1;
	int[] input = new int[100000];
	for(int i = 0; i < input.length; i++)
	    {
		input[i] = gen.nextInt(1000);
	    }
	try
	    {
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(i != 0)
			    {
				if(actual[i-1] > actual[i])
				    {
					passed = 0;
				    }
			    }
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Array between lengths 100000, item with values 0-999
    public void testTwentySeven()
    {
	Random gen = new Random();
	int passed = 1;
	int[] input = new int[100000];
	for(int i = 0; i < input.length; i++)
	    {
		input[i] = gen.nextInt(1000);
	    }
	try
	    {
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(i != 0)
			    {
				if(actual[i-1] > actual[i])
				    {
					passed = 0;
				    }
			    }
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Array between lengths 100000, item with values (-999)-999
    public void testTwentyEight()
    {
	Random gen = new Random();
	int passed = 1;
	int[] input = new int[10000];
	for(int i = 0; i < input.length; i++)
	    {
		input[i] = gen.nextInt(1000) - 999;
	    }
	try
	    {
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(i != 0)
			    {
				if(actual[i-1] > actual[i])
				    {
					passed = 0;
				    }
			    }
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Array between lengths 100000, item with values (-999)-999
    public void testTwentyNine()
    {
	Random gen = new Random();
	int passed = 1;
	int[] input = new int[10000];
	for(int i = 0; i < input.length; i++)
	    {
		input[i] = gen.nextInt(1000) - 999;
	    }
	try
	    {
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(i != 0)
			    {
				if(actual[i-1] > actual[i])
				    {
					passed = 0;
				    }
			    }
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // Array between lengths 100000, item with values (-999)-999
    public void testThirty()
    {
	Random gen = new Random();
	int passed = 1;
	int[] input = new int[10000];
	for(int i = 0; i < input.length; i++)
	    {
		input[i] = gen.nextInt(1000) - 999;
	    }
	try
	    {
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(i != 0)
			    {
				if(actual[i-1] > actual[i])
				    {
					passed = 0;
				    }
			    }
		    }
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    // More Random and Boundary Tests (using SATI)
    public void testThirtyOne()
    {
	int passed = 1;
	int[] input = {};
	int[] expected = {};
	try
	    {
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(expected[i] != actual[i])
			    passed = 0;
		    }
		assertEquals (1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    public void testThirtyTwo()
    {
	int passed = 1;
	int[] input = {-6};
	int[] expected = {-6};
	try
	    {
		int[] actual = alg.sort(input);
		for(int i = 0; i < input.length; i++)
		    {
			if(expected[i] != actual[i])
			    passed = 0;
		    }
		assertEquals (1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    public void testThirtyThree()
    {
	int passed = 1;
	try 
	    {
		int[] input = Sati.generate(10);
		Sati.shuffle(input, 100);
		int[] actual = alg.sort(input);
		for(int i = 1; i < actual.length; i++)
		    {
			if(actual[i-1] > actual[i])
			    passed = 0;
		    }

		assertEquals(1, passed);
	    }

	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    public void testThirtyFour()
    {
	int passed = 1;	
	try 
	    {
		int[] input = Sati.generate(100);
		Sati.shuffle(input, 100);
		int[] actual = alg.sort(input);
		for(int i = 1; i < actual.length; i++)
		    {
			if(actual[i-1] > actual[i])
			    passed = 0;
		    }

		assertEquals(1, passed);
	    }

	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    public void testThirtyFive()
    {
	int passed = 1;	
	try 
	    {
		int[] input = Sati.generate(1000);
		Sati.shuffle(input, 500);
		int[] actual = alg.sort(input);
		for(int i = 1; i < actual.length; i++)
		    {
			if(actual[i-1] > actual[i])
			    passed = 0;
		    }

		assertEquals(1, passed);
	    }

	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    public void testThirtySix()
    {
	int passed = 1;	
	try 
	    {
		int[] input = Sati.generate(5000);
		Sati.shuffle(input, 500);
		int[] actual = alg.sort(input);
		for(int i = 1; i < actual.length; i++)
		    {
			if(actual[i-1] > actual[i])
			    passed = 0;
		    }

		assertEquals(1, passed);
	    }

	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    public void testThirtySeven()
    {
	int passed = 1;	
	try 
	    {
		int[] input = Sati.generate(10000);
		Sati.shuffle(input, 1000);
		int[] actual = alg.sort(input);
		for(int i = 1; i < actual.length; i++)
		    {
			if(actual[i-1] > actual[i])
			    passed = 0;
		    }

		assertEquals(1, passed);
	    }

	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }
    
    public void testThirtyEight()
    {
	int passed = 1;
	long expected = 10000;
	try
	    {
		int[] array = Sati.generate(100);
		Sati.shuffle(array, 100);
		long actual = alg.sortPerformance(array);
		if(expected < actual)
		    passed = 0;
		assertEquals(1, passed);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    public void testThirtyNine()
    {
	int passed = 1;
	long expected = 1000000;
	try
	    {
		int[] array = Sati.generate(1000);
		Sati.shuffle(array, 1000);
		long actual = alg.sortPerformance(array);
		if(expected < actual)
		    passed = 0;
		assertEquals(actual, expected);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }

    public void testForty()
    {
	int passed = 1;
	long expected = 250000;
	try
	    {
		int[] array = Sati.generate(500);
		Sati.shuffle(array, 1000);
		long actual = alg.sortPerformance(array);
		if(expected < actual)
		    passed = 0;
		assertEquals(actual, expected);
	    }
	catch (Exception e)
	    {
		e.printStackTrace();
	    }
    }
	
		

}
