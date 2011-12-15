/*
 * @(#)EQSortAlgorithm.java	1.0 95/06/26 Jim Boritz
 *
 * Copyright (c) 1995 UBC Microsystems, Inc. All Rights Reserved.
 *
 * Permission to use, copy, modify, and distribute this software
 * and its documentation for NON-COMMERCIAL purposes and without
 * fee is hereby granted provided that this copyright notice
 * appears in all copies. Please refer to the file "copyright.html"
 * for further important copyright and licensing information.
 *
 * UBC MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. UBC SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

/**
 * An enhanced quick sort demonstration algorithm
 * SortAlgorithm.java, Thu Oct 27 10:32:35 1994
 *
 * @author Jim Boritz
 * @version 	1.0, 26 Jun 1995
 */
/**
 * 19 Feb 1996: Fixed to avoid infinite loop discoved by Paul Haberli.
 *              Misbehaviour expressed when the pivot element was not unique.
 *              -Jason Harrison
 *
 * 21 Jun 1996: Modified code based on comments from Paul Haeberli, and
 *              Peter Schweizer (Peter.Schweizer@mni.fh-giessen.de).  
 *              Used Daeron Meyer's (daeron@geom.umn.edu) code for the
 *              new pivoting code. - Jason Harrison
 *
 * 09 Jan 1998: Another set of bug fixes by Thomas Everth (everth@wave.co.nz)
 *              and John Brzustowski (jbrzusto@gpu.srv.ualberta.ca).
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


public class EQSortAlgorithm {
    public static void brute(int a[], int lo, int hi){
        if ((hi-lo) == 1) {
	    if (a[hi] < a[lo]) {
		int T = a[lo];
		a[lo] = a[hi];
		a[hi] = T;
		
	    }
	}
	if ((hi-lo) == 2) {
	    int pmin = a[lo] < a[lo+1] ? lo : lo+1;
	    pmin = a[pmin] < a[lo+2] ? pmin : lo+2;
	    if (pmin != lo) {
	        int T = a[lo];
		a[lo] = a[pmin];
		a[pmin] = T;
		
	    }
	    brute(a, lo+1, hi);
	}
	if ((hi-lo) == 3) {
	    int pmin = a[lo] < a[lo+1] ? lo : lo+1;
	    pmin = a[pmin] < a[lo+2] ? pmin : lo+2;
	    pmin = a[pmin] < a[lo+3] ? pmin : lo+3;
	    if (pmin != lo) {
                int T = a[lo];
	        a[lo] = a[pmin];
	        a[pmin] = T;
		
            }
	    int pmax = a[hi] > a[hi-1] ? hi : hi-1;
            pmax = a[pmax] > a[hi-2] ? pmax : hi-2;
	    if (pmax != hi) {
                int T = a[hi];
                a[hi] = a[pmax];
	        a[pmax] = T;
		
	    }
	    brute(a, lo+1, hi-1);
        }
    }
	 public static long sortPerformance(int a[]) //throws Exception
    {
        long count = 0;
        for (int i = 1; i < a.length; i++)
        {
            int j = i;
            int B = a[i];
            while ((j > 0) && (a[j-1] > B))
            {
                count++;
                //if (stopRequested)
                //{
                //	return;
                //}
                a[j] = a[j-1];
                j--;
                //pause(i,j);
            }
            a[j] = B;
            //pause(i,j);
        }

        return count;
    }

   public static void sort(int a[], int lo0, int hi0) {
	int lo = lo0;
	int hi = hi0;
	if ((hi-lo) <= 3) {
	    brute(a, lo, hi);
	    return;
	}

        /*
         *  Pick a pivot and move it out of the way
         */
	int pivot = a[(lo + hi) / 2];
        a[(lo + hi) / 2] = a[hi];
        a[hi] = pivot;

        while( lo < hi ) {
            /*
             *  Search forward from a[lo] until an element is found that
             *  is greater than the pivot or lo >= hi 
             */
            while (a[lo] <= pivot && lo < hi) {
		lo++;
	    }

            /*
             *  Search backward from a[hi] until element is found that
             *  is less than the pivot, or hi <= lo 
             */
	    while (pivot <= a[hi] && lo < hi ) {
		hi--;
	    }

            /*
             *  Swap elements a[lo] and a[hi]
             */
            if( lo < hi ) {
                int T = a[lo];
                a[lo] = a[hi];
                a[hi] = T;
           
            }
	}

        /*
         *  Put the median in the "center" of the list
         */
        a[hi0] = a[hi];
        a[hi] = pivot;

        /*
         *  Recursive calls, elements a[lo0] to a[lo-1] are less than or
         *  equal to pivot, elements a[hi+1] to a[hi0] are greater than
         *  pivot.
         */
	sort(a, lo0, lo-1);
	sort(a, hi+1, hi0);
    }

    public static int[] sort(int a[]){
	 sort(a, 0, a.length-1);
	return a;
}


	
}
