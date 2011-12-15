/*
* Source: http://en.wikibooks.org/wiki/Algorithm_Implementation/Sorting/Bubble_sort#Java
* Wikibooks Java Bubble Sort Implementation
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

public class BubbleSort{

	public static int[] sort(int[] numbers) {
    		boolean swapped = true;
		int comparisons = 0;
    		for(int i = numbers.length - 1; i > 0 && swapped; i--) {
        		swapped = false;
        		for (int j = 0; j < i; j++) {
            			if (numbers[j] > numbers[j+1]) {
					comparisons++;                			
					int temp = numbers[j];
                			numbers[j] = numbers[j+1];
                			numbers[j+1] = temp;
                			swapped = true;
            			}
        		}
    		}
    		return numbers;
	}

	public static int sortPerformance(int[] numbers) {
    		boolean swapped = true;
		int comparisons = 0;
    		for(int i = numbers.length - 1; i > 0 && swapped; i--) {
        		swapped = false;
        		for (int j = 0; j < i; j++) {
            			if (numbers[j] > numbers[j+1]) {
					comparisons++;                			
					int temp = numbers[j];
                			numbers[j] = numbers[j+1];
                			numbers[j+1] = temp;
                			swapped = true;
            			}
        		}
    		}
    		return comparisons;
	}
}
