/** Sati.java
*
*  SATI - Sorting Algorithm Testing Infrastructure
*  Contains an infrastructure to support the testing of Sorting Algorithms 
*  in Java. 
*
*  CS 290
*  Laboratory 4
*
*  ***Instructions***
*
*  The two main functions of Sati are in the methods generate() and shuffle().
*
*  generate(int length)
*  Generates a sorted array of random elements of specified length.
*  Call this with Sati.generate(int length) where length corresponds the 
*  array length.
*
*  shuffle(int[] a, int amount)
*  Shuffles an array a specified amount of times.
*  Call this with Sati.shuffle(int[] a, int amount) where a is the array to be
*  shuffled and amount is the amount of shuffles to perform.
*
*  ******************
* 
*  @author Zach Mendel
*  PLEDGE:
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

import java.util.Random;
import java.util.Arrays;

public class Sati {
	
	// Create an empty array of specified length
	public static int[] create(int length) {
		
		int[] a = new int[length];
		return a;
	}
	
	// Populates an empty array with random integers
	public static void populate(int[] a) {
		
			Random gen = new Random();
			
			for (int i = 0; i < a.length; i++) {
				a[i] = gen.nextInt(); // Populate with random integers
				Arrays.sort(a); // Sort the array to provide expected
			}
	}


	// Populates an empty array with random integers
    // Will not add negative integers.
	public static void populate(int[] a, int maxSize) {
		
			Random gen = new Random();
			
			for (int i = 0; i < a.length; i++) {
				a[i] = gen.nextInt(maxSize); // Populate with random integers
				Arrays.sort(a); // Sort the array to provide expected
			}
	}
	
	// Shuffles the array a specified amount of times
	public static int[] shuffle(int[] a, int amount) {
		
		int[] b = Arrays.copyOf(a, a.length); // Copy a so it is not modified
		
		Random gen = new Random();
		int temp;
		int len = b.length;
		
		for (int i = 0; i < amount; i++) {
			int index1 = gen.nextInt(len); // Choose two random indices
			int index2 = gen.nextInt(len);
			
			temp = b[index1]; // Swap the elements
			b[index1] = b[index2];
			b[index2] = temp;
		}
		return b;
	}

	// Generate an array of consecutive integers
	public static int[] generate(int length) {
		
		// Create the array
		int[] a = create(length);
		// Populate the array
		populate(a);
		// Return
		return a;
	}


	// Generate an array of consecutive integers
    // Will not add negative integers.
	public static int[] generate(int length, int maxSize) {
		
		// Create the array
		int[] a = create(length);
		// Populate the array
		populate(a, maxSize);
		// Return
		return a;
	}

	
	public static void main(String[] args) {
		
		
		// Example use.
		int[] a = generate(5);
    	//int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,-39295, 324314};
		int[] b = shuffle(a, 250);
		
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
		
		for(int i=0; i<b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println("");
	}
}
