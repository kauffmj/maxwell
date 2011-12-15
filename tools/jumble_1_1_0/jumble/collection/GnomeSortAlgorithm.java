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


public class GnomeSortAlgorithm {//extends SortAlgorithm {

    public static int[] sort(int a[]){ //throws Exception {
		
		int i=0, temp;
		
		while(i < a.length) {
			
		    if(i == 0 || a[i-1] <= a[i])
			{
			    i++;
			}
			
			else{
			    
				
				temp = a[i];
				
				a[i] = a[i-1];
				
				a[--i] = temp;
				
			}
			
			//pause(i);
			
		}
		
		//pause(-1,-1);
		return a;
    }

    public static long sortPerformance(int[] a) /*throws Exception*/ {
	long comparisons = 0;

		int i=0, temp;
		
		while(i < a.length) {
			
		    if(i == 0 || a[i-1] <= a[i])
			{
			    i++;
			    if(a[i-1] <= a[i])
				comparisons++;
			}
			
			else{
			    
			    comparisons++;
				temp = a[i];
				
				a[i] = a[i-1];
				
				a[--i] = temp;
				
			}
			
			//pause(i);
			
		}
		
		//pause(-1,-1);
		return comparisons;
    }
    

}



/*
 
 for (int i = a.length; --i>=0; ) {
 boolean flipped = false;
 for (int j = 0; j<i; j++) {
 if (stopRequested) {
 return;
 }
 if (a[j] > a[j+1]) {
 int T = a[j];
 a[j] = a[j+1];
 a[j+1] = T;
 flipped = true;
 }
 pause(i,j);
 
 }
 if (!flipped) {
 return;
 }
 }
 
 */
