/*
* Source: http://en.wikibooks.org/wiki/Algorithm_Implementation/Sorting/Bubble_sort#Java
* Wikibooks Java Quick Sort Implementation
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


import java.util.Arrays;
import java.util.Random;
 
public class QuickSort {
    public static final Random RND = new Random();
 
    private static void swap (int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
 
    private static int partition(int[] array, int begin, int end) {
        int index = begin + RND.nextInt(end - begin + 1);
        int pivot = array[index];
        swap(array, index, end);
        for (int i = index = begin; i < end; ++i) {
            if (array[i] < pivot || array[i] == pivot) {
                swap(array, index++, i);
            }
        }
        swap(array, index, end);
        return index;
    }
 
    private static void qsort(int[] array, int begin, int end) {
        if (end > begin) {
            int index = partition(array, begin, end);
            qsort(array, begin, index - 1);
            qsort(array, index + 1, end);
        }
    }
 
    public static int[] sort(int[] array) {
        qsort(array, 0, array.length - 1);
	return array;
    }
}
