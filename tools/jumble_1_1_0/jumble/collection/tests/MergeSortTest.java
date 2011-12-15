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

public class MergeSortTest extends TestCase {
  	
	public void testOne()
   	{
		boolean expect = true;
		int[] a = Sati.generate(5);
		int[] b = Sati.shuffle(a, 20);
	
		MergeSort.sort(b);
		
		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
    	}

	public void testTwo()
	{
		boolean expect = true;
		int[] a = Sati.generate(10);
		int[] b = Sati.shuffle(a, 20);

		MergeSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}

	public void testThree()
	{
		boolean expect = true;
		int[] a = Sati.generate(100);
		int[] b = Sati.shuffle(a, 20);

		MergeSort.sort(b);
	
		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}

	public void testFour()
	{
		boolean expect = true;
		int[] a = Sati.generate(100);
		int[] b = Sati.shuffle(a, 300);

		MergeSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	
	public void testFive()
	{
		boolean expect = true;
		int[] a = Sati.generate(5000);
		int[] b = Sati.shuffle(a, 600);

		MergeSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}

	public void testSix()
	{
		boolean expect = true;
		int[] a = Sati.generate(10000);
		int[] b = Sati.shuffle(a, 100);

		MergeSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}

	public void testSeven()
	{
		boolean expect = true;
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		int[] b = {10,9,8,7,6,5,4,3,2,1};

		MergeSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}

	public void testEight()
	{
		boolean expect = true;
		int[] a = {2,2,4,4,6,6,9,10};
		int[] b = {9,6,4,2,10,6,4,2};

		MergeSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}

	public void testNine()
	{
		boolean expect = true;
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int[] b = {15,14,13,12,1,2,3,4,11,10,9,8,5,6,7};

		MergeSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	
	public void testTen()
	{
		boolean expect = true;
		int[] a = Sati.generate(1123);
		int[] b = Sati.shuffle(a, 1321);

		MergeSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	public void testEleven() {
  		int[] a = {-1};
  		int[] b = {-1};
  		
  		MergeSort.sort(b);
  		
  		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}
  	
  	public void testTwelve() {
 		int[] a = Sati.generate(10);
 		int[] b = Sati.shuffle(a, 30);
 		
 		MergeSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}	

	public void testThirteen() {
 		int[] a = Sati.generate(876);
 		int[] b = Sati.shuffle(a, 99900);
 		
 		MergeSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}
  	
  	public void testFourteen() {
  		int[] a = Sati.generate(15);
 		int[] b = Sati.shuffle(a, 8);
 		
 		MergeSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}
  	public void testFifteen() 
	{
  		int[] a = Sati.generate(2);
 		int[] b = Sati.shuffle(a, 300);
 		
 		MergeSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}
  	public void testSixteen() {
  		int[] a = {1,3,5,7,9};
 		int[] b = {9,7,5,3,1};
 		
 		MergeSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}
  	public void testSeventeen() {
  		int[] a = {1,3,5,7,9};
 		int[] b = {1,3,5,7,9};
 		
 		MergeSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}
  	public void testEighteen(){
  		int[] a = {111,111,111,111,444,666,888,976,976};
 		int[] b = {976,111,444,888,666,111,111,976,111};
 		
 		MergeSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}
  	public void testNineteen() {
  		int[] a = Sati.generate(9999);
 		int[] b = Sati.shuffle(a, 12345);
	
		MergeSort.sort(b);

		boolean expected = true;
		boolean actual = Arrays.equals(a,b);
		assertEquals(expected,actual);
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
  	public void testTwenty() {
  		int[] a = {-1048576,2,3,4,5,6,7,8,9,1048576};
 		int[] b = {3,2,6,7,-1048576,4,5,9,1048576,8};
 		
 		MergeSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}
	public void testTwentyOne()
	{
		boolean expect= true;
		int[] a = {};
		int[] b = {};
		
		MergeSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	
	public void testTwentyTwo()
	{
		boolean expect = true;
		int[] a = {-10,6,19,20,30};
		int[] b = {20,6,19,-10,30};

		MergeSort.sort(b);
	
		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}

	public void testTwentyThree()
	{
		boolean expect = false;
		int[] a = { 20000, -10104, 5 , 291, 140};
		int[] b = { 5,291,140,20000,-10104};
	
		MergeSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}

	public void testTwentyFour()
	{
		boolean expect = true;
		int[] a = {-9000,-8123,-7546,-6352,-5424,-4789,-3100,1234};
		int[] b = {-8123,-7546,-5424,-9000,1234,-3100,-4789,-6352};

		MergeSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	public void testTwentyFive()
	{
		boolean expect = true;
		int[] a = {1,2,3,4,5,6,7,8,9,1230};
		int[] b = {1,2,3,4,5,6,7,8,9,1230};

		MergeSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	public void testTwentySix()
	{
		boolean expect = false;
		int[] a = Sati.shuffle(Sati.generate(1123), 353535);
		int[] b = Sati.shuffle(Sati.generate(1123), 9);

		MergeSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	public void testTwentySeven()
	{
		boolean expect = true;
		int[] a = generateRandomSortedArray(1000, 9);
		int[] b = Sati.shuffle(a,9999);
	
		MergeSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	public void testTwentyEight()
	{
		boolean expect = true;
 		int[] a = generateRandomSortedArray(456, 900000);
		int[] b = Sati.shuffle(a,100);
		
		MergeSort.sort(b);
	
		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	public void testTwentyNine()
	{
		boolean expect = true;
		int[] a = generateRandomSortedArray(100,19);
		int[] b = Sati.shuffle(a,999);

		MergeSort.sort(b);
		
		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);		
	}
	public void testThirty()
	{
		boolean expect = true;
 		int[] a = generateRandomSortedArray(2000, 1000);
		int[] b = Sati.shuffle(a,6500);
		
		MergeSort.sort(b);
	
		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	public void performanceTestOne()
	{
		boolean expect = true;
 		int[] a = {5,4,3};
		int[] b = {3,4,5};
		
		int comparisons = MergeSortComp.sort(b);
		boolean actual;
		if(comparisons>= 2)
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
 		int[] a = {1,2,3,4,5,6,7,8,9,10};
		int[] b = {1,2,3,4,5,6,7,8,9,10};
		
		int comparisons = MergeSortComp.sort(b);
		boolean actual;
		if(comparisons>= 10)
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
 		int[] a = {1,2,3,4,5,6};
		int[] b = {2,3,6,4,5,1};
		
		int comparisons = MergeSortComp.sort(b);
		boolean actual;
		if(comparisons>= 5)
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
