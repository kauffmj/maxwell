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



import junit.framework.*;
import java.util.Arrays;
import java.util.Random;
public class QuickSortTest extends TestCase
{
    public QuickSortTest(String name)
   {
   	super(name);
   }
   
    public static Test suite()
    {
   	return new TestSuite(QuickSortTest.class);
    }

	public void testOne()
   	{
		boolean expect = true;
		int[] a = Sati.generate(5);
		int[] b = Sati.shuffle(a, 20);
	
		QuickSort.sort(b);
		
		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
    	}

	public void testTwo()
	{
		boolean expect = true;
		int[] a = Sati.generate(10);
		int[] b = Sati.shuffle(a, 20);

		QuickSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}

	public void testThree()
	{
		boolean expect = true;
		int[] a = Sati.generate(100);
		int[] b = Sati.shuffle(a, 20);

		QuickSort.sort(b);
	
		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}

	public void testFour()
	{
		boolean expect = true;
		int[] a = Sati.generate(100);
		int[] b = Sati.shuffle(a, 300);

		QuickSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	
	public void testFive()
	{
		boolean expect = true;
		int[] a = Sati.generate(5000);
		int[] b = Sati.shuffle(a, 6000);

		QuickSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}

	public void testSix()
	{
		boolean expect = true;
		int[] a = Sati.generate(10000);
		int[] b = Sati.shuffle(a, 100);

		QuickSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}

	public void testSeven()
	{
		boolean expect = true;
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		int[] b = {10,9,8,7,6,5,4,3,2,1};

		QuickSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}

	public void testEight()
	{
		boolean expect = true;
		int[] a = {2,2,4,4,6,6,9,10};
		int[] b = {9,6,4,2,10,6,4,2};

		QuickSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}

	public void testNine()
	{
		boolean expect = true;
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int[] b = {15,14,13,12,1,2,3,4,11,10,9,8,5,6,7};

		QuickSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	
	public void testTen()
	{
		boolean expect = true;
		int[] a = Sati.generate(1123);
		int[] b = Sati.shuffle(a, 1321);

		QuickSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	public void testEleven() {
  		int[] a = {0};
  		int[] b = {0};
  		
  		QuickSort.sort(b);
  		
  		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}
  	
  	public void testTwelve() {
 		int[] a = Sati.generate(10);
 		int[] b = Sati.shuffle(a, 100);
 		
 		QuickSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}	

	public void testThirteen() {
 		int[] a = Sati.generate(150);
 		int[] b = Sati.shuffle(a, 789);
 		
 		QuickSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}
  	
  	public void testFourteen() {
  		int[] a = Sati.generate(13);
 		int[] b = Sati.shuffle(a, 1);
 		
 		QuickSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}
  	public void testFifteen() {
  		int[] a = Sati.generate(999);
 		int[] b = Sati.shuffle(a, 2);
 		
 		QuickSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}
  	public void testSixteen() {
  		int[] a = {2,4,6,8,10,12,14};
 		int[] b = {14,12,10,8,6,4,2};
 		
 		QuickSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}
  	public void testSeventeen() {
  		int[] a = {2,4,6,8,10,12,14};
 		int[] b = {2,4,6,8,10,12,14};
 		
 		QuickSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}
  	public void testEighteen() {
  		int[] a = {22,22,33,44,55,66,66,99,99,99};
 		int[] b = {55,66,99,44,22,33,22,99,66,99};
 		
 		QuickSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}
  	public void testNineteen() {
  		int[] a = Sati.generate(1234);
 		int[] b = Sati.shuffle(a, 6789);
 		
 		QuickSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}
  	public void testTwenty() {
  		int[] a = {-1048576,1,2,3,4,5,6,7,8,9};
 		int[] b = {3,2,6,7,1,4,5,9,-1048576,8};
 		
 		QuickSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}

	
	public int[] generateRandomSortedArray(int maxArraySize, int maxValue)
	{
		Random rand = new Random();
		int arraySize = 1+ rand.nextInt(maxArraySize);
		int[] randomArray= new int[arraySize];
		for(int i =0; i<arraySize; i++)
		{	
			randomArray[i]=rand.nextInt(maxValue);
		}
		Arrays.sort(randomArray);
		return randomArray;
	}
	
	public void testTwentyOne()
	{
		boolean expect= true;
		int[] a = {};
		int[] b = {};
		
		QuickSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	
	public void testTwentyTwo()
	{
		boolean expect = false;
		int[] a = {1,3,6,19,2098098};
		int[] b = {};

		QuickSort.sort(b);
	
		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}

	public void testTwentyThree()
	{
		boolean expect = false;
		int[] a = { 2, -1, 5 , 9, 10};
		int[] b = { 100,5};
	
		QuickSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}

	public void testTwentyFour()
	{
		boolean expect = true;
		int[] a = {-10022,-25,35,423623,553780,685485,783920,850392,902100};
		int[] b = {850392,-10022,423623,35,685485,902100,553780,783920,-25};

		QuickSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	public void testTwentyFive()
	{
		boolean expect = true;
		int[] a = {12345,23456,34596,46464,57989,954683496};
		int[] b = {12345,23456,34596,46464,57989,954683496};

		QuickSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	public void testTwentySix()
	{
		boolean expect = false;
		int[] a = Sati.shuffle(Sati.generate(1145), 465378);
		int[] b = Sati.shuffle(Sati.generate(1145), 13);

		QuickSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	public void testTwentySeven()
	{
		boolean expect = true;
		int[] a = generateRandomSortedArray(10000, 9);
		int[] b = Sati.shuffle(a,99875);
	
		QuickSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	public void testTwentyEight()
	{
		boolean expect = true;
 		int[] a = generateRandomSortedArray(6830, 12);
		int[] b = Sati.shuffle(a,16459);
		
		QuickSort.sort(b);
	
		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	public void testTwentyNine()
	{
		boolean expect = true;
		int[] a = generateRandomSortedArray(1234,19874);
		int[] b = Sati.shuffle(a,9990);

		QuickSort.sort(b);
		
		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);		
	}
	public void testThirty()
	{
		boolean expect = true;
 		int[] a = generateRandomSortedArray(9000, 900000);
		int[] b = Sati.shuffle(a,645);
		
		QuickSort.sort(b);
	
		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	public void performanceTestOne()
	{
		boolean expect = true;
 		int[] a = {5,4,3,2,1};
		int[] b = {1,2,3,4,5};
		
		int comparisons = QuickSortCount.sort(b);
		boolean actual;
		if(comparisons>25)
		{
			actual = false;
		}
		else
		{
			actual = true;
		}
		assertEquals(expect,actual);
	}
	public void performanceTestTwo()
	{
		boolean expect = true;
 		int[] a = {5,4,3,2,1,9,8,10};
		int[] b = {1,2,3,4,5,8,9,10};
		
		int comparisons = QuickSortCount.sort(b);
		boolean actual;
		if(comparisons>64)
		{
			actual = false;
		}
		else
		{
			actual = true;
		}
		assertEquals(expect,actual);
	}

	public void performanceTestThree()
	{
		boolean expect = true;
 		int[] a = {5,4,3};
		int[] b = {3,4,5};
		
		int comparisons = QuickSortCount.sort(b);
		boolean actual;
		if(comparisons>9)
		{
			actual = false;
		}
		else
		{
			actual = true;
		}
		assertEquals(expect,actual);
	}



}
