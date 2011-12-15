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

public class BubbleSortTest extends TestCase {
  	
  	public void testOne() {
  		int[] a = {1};
  		int[] b = {1};
  		
  		BubbleSort.sort(b);
  		
  		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}
  	
  	public void testTwo() {
 		int[] a = Sati.generate(5);
 		int[] b = Sati.shuffle(a, 20);
 		
 		BubbleSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}	

	public void testThree() {
 		int[] a = Sati.generate(300);
 		int[] b = Sati.shuffle(a, 10000);
 		
 		BubbleSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}
  	
  	public void testFour() {
  		int[] a = Sati.generate(20);
 		int[] b = Sati.shuffle(a, 3);
 		
 		BubbleSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}
  	public void testFive() 
	{
  		int[] a = Sati.generate(3);
 		int[] b = Sati.shuffle(a, 1999);
 		
 		BubbleSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}
  	public void testSix() {
  		int[] a = {0,1,2,3,4,5,6,7,8,9};
 		int[] b = {9,8,7,6,5,4,3,2,1,0};
 		Sati.generate(20);
 		BubbleSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}
  	public void testSeven() {
  		int[] a = {0,1,2,3,4,5,6,7,8,9};
 		int[] b = {0,1,2,3,4,5,6,7,8,9};
 		
 		BubbleSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}
  	public void testEight(){
  		int[] a = {1,1,1,2,4,4,8,9,9};
 		int[] b = {4,1,1,9,8,2,1,4,9};
 		
 		BubbleSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}
  	public void testNine() {
  		int[] a = Sati.generate(9999);
 		int[] b = Sati.shuffle(a, 12834);
	
		BubbleSort.sort(b);

		boolean expected = true;
		boolean actual = Arrays.equals(a,b);
		assertEquals(expected,actual);
	}

	
  	public void testTen() {
  		int[] a = {1,2,3,4,5,6,7,8,9,1048576};
 		int[] b = {3,2,6,7,1,4,5,9,1048576,8};
 		
 		BubbleSort.sort(b);
 		
 		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}  

	public void testEleven()
	{
		int[] a = {1,1,2,3,5,8,13,21,34,55};
		int[] b = {5,1,2,55,21,34,8,1,3,13};

		BubbleSort.sort(b);

		boolean expected = true;
		boolean actual = Arrays.equals(a,b);

		assertEquals(expected,actual);
	}

	public void testTwelve()
	{
		int[] a = Sati.generate(1123);
		int[] b = Sati.shuffle(a, 1321);

		BubbleSort.sort(b);

		boolean expected = true;
		boolean actual = Arrays.equals(a,b);
		
		assertEquals(expected,actual);
	}

	public void testThirteen()
	{
		int[] a = {1,3,4,134,143,314,341,413,431};
		int[] b = {413,4,134,431,341,3,314,143,1};

		BubbleSort.sort(b);

		boolean expected = true;
		boolean actual = Arrays.equals(a,b);

		assertEquals(expected,actual);
	}	  	

	public void testFourteen()
	{
		int[] a = Sati.generate(10100);
		int[] b = Sati.shuffle(a, 10101);

		BubbleSort.sort(b);

		boolean expected = true;
		boolean actual = Arrays.equals(a,b);

		assertEquals(expected,actual);
	}

	public void testFifteen()
	{
		boolean expect = true;
		int[] a = Sati.generate(5000);
		int[] b = Sati.shuffle(a, 600);

		BubbleSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}

	public void testSixteen()
	{
		boolean expect = true;
		int[] a = Sati.generate(10000);
		int[] b = Sati.shuffle(a, 100);

		BubbleSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}

	public void testSeventeen()
	{
		boolean expect = true;
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		int[] b = {10,9,8,7,6,5,4,3,2,1};

		BubbleSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}

	public void testEighteen()
	{
		boolean expect = true;
		int[] a = {2,2,4,4,6,6,9,10};
		int[] b = {9,6,4,2,10,6,4,2};

		BubbleSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}

	public void testNineteen()
	{
		boolean expect = true;
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int[] b = {15,14,13,12,1,2,3,4,11,10,9,8,5,6,7};

		BubbleSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	
	public void testTwenty()
	{
		boolean expect = true;
		int[] a = Sati.generate(1123);
		int[] b = Sati.shuffle(a, 1321);

		BubbleSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
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
		
		BubbleSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	
	public void testTwentyTwo()
	{
		boolean expect = true;
		int[] a = {1,3,6,19,2098098};
		int[] b = {2098098,6,19,1,3};

		BubbleSort.sort(b);
	
		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}

	public void testTwentyThree()
	{
		boolean expect = false;
		int[] a = { 2, -1, 5 , 9, 10};
		int[] b = { 5,9,10,2,-1};
	
		BubbleSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}

	public void testTwentyFour()
	{
		boolean expect = true;
		int[] a = {123152,235875,323485,423623,553780,685485,783920,850392,902100};
		int[] b = {850392,123152,423623,323485,685485,902100,553780,783920,235875};

		BubbleSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	public void testTwentyFive()
	{
		boolean expect = true;
		int[] a = {1,2,3,4,5,6,7,8,9,123456789};
		int[] b = {1,2,3,4,5,6,7,8,9,123456789};

		BubbleSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	public void testTwentySix()
	{
		boolean expect = false;
		int[] a = Sati.shuffle(Sati.generate(1123), 353535);
		int[] b = Sati.shuffle(Sati.generate(1123), 132134);

		BubbleSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	public void testTwentySeven()
	{
		boolean expect = true;
		int[] a = Sati.generate(123, 9);
		int[] b = Sati.shuffle(a,9985);
	
		BubbleSort.sort(b);

		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	public void testTwentyEight()
	{
		boolean expect = true;
 		int[] a = Sati.generate(300, 900000);
		int[] b = Sati.shuffle(a,1209);
		
		BubbleSort.sort(b);
	
		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}
	public void testTwentyNine()
	{
		boolean expect = true;
		int[] a = {1,3,5,7,9,11,123,54321};
		int[] b = {3,1,7,5,11,123,54321,9};

		int comps = BubbleSortCompCount.sort(b);
		boolean actual;
		if(comps <= 64)
		{
			actual = true;
		}
		else
		{
			actual=false;
		}
		
		assertEquals(expect,actual);		
	}
	public void testThirty()
	{
		boolean expect = true;
 		int[] a = Sati.generate(1000, 1000000);
		int[] b = Sati.shuffle(a,645);
		
		BubbleSort.sort(b);
	
		boolean actual = Arrays.equals(a,b);
		assertEquals(expect,actual);
	}

  	public void testThirtyOne() {
  		int[] a = {};
  		int[] b = {};
  		
  		BubbleSort.sort(b);
  		
  		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}

  	public void testThirtyTwo() {
  		int[] a = {1};
  		int[] b = {};
  		
  		BubbleSort.sort(b);
  		
  		boolean expected = false;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}

  	public void testThirtyThree() {
  		int[] a = {};
  		int[] b = {1};
  		
  		BubbleSort.sort(b);
  		
  		boolean expected = false;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}

  	public void testThirtyFour() {
  		int[] a = {-5,-4,-2,-2};
  		int[] b = {-5,-2,-4,-2};
  		
  		BubbleSort.sort(b);
  		
  		boolean expected = true;
  		boolean actual = Arrays.equals(a, b);
  		
  		assertEquals(expected, actual);
  	}
}
