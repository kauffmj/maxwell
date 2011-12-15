/** FlashSortAlgorithm.java
 *
 * Implementation of the flash sort algorithm.
 *
 * Originally created by Jason Harrison, modified by:
 * 
 * Jonathan Miller Kauffman
 * PLEDGE:
 *
 * Tyler J. Abbott
 * PLEDGE:
 *
 * Cory Matthew Jones
 * PLEDGE:
 *
 */
package algorithms;
import java.util.Arrays;

public class FlashSortAlgorithm {

	/**
	 * @param a the input list to be sorted 
	 * 
	 * @return the output  array from least to greatest
	 * 
	 * This method calls other methods
	 * 
	 */
	public int[] sort(int[] a) {
		a = partialFlashSort(a);
		return insertionSort(a);
	}

	/**
	 * @param
	 * 
	 */
	public static int[] insertionSort(int[] a)  {
		
		int i, j, hold;

		for (i = a.length - 3; i >= 0; i--) {
			if (a[i + 1] < a[i]) {
				hold = a[i];
				j = i;

				while (a[j + 1] < hold) {
					a[j] = a[j + 1];
					j++;
					// pause();
				}

				a[j] = hold;
				// pause();
			}
		}

		return a;
	}

	/**
	 * Partial flash sort
	 */
	public static int[] partialFlashSort(int[] a){
		int n = a.length;
		int m = n / 20;
		int[] l = new int[m];

		int i = 0, j = 0, k = 0;
		int anmin = a[0];
		int nmax = 0;

		for (i = 1; i < n; i++) {
			if (a[i] < anmin)
				anmin = a[i];
			if (a[i] > a[nmax])
				nmax = i;
			// pause(i,n);
		}

		if (anmin == a[nmax])
			return a;

		double c1 = ((double) m - 1) / (a[nmax] - anmin);

		for (i = 0; i < n; i++) {
			k = (int) (c1 * (a[i] - anmin));
			l[k]++;
			// pause(i,n);
		}

		for (k = 1; k < m; k++) {
			l[k] += l[k - 1];
			// pause(k,m);
		}

		int hold = a[nmax];
		a[nmax] = a[0];
		a[0] = hold;

		int nmove = 0;
		int flash;
		j = 0;
		k = m - 1;

		while (nmove < n - 1) {
			while (j > (l[k] - 1)) {
				j++;
				k = (int) (c1 * (a[j] - anmin));
				// pause(nmove,n-1);
			}

			flash = a[j];

			while (!(j == l[k])) {
				k = (int) (c1 * (flash - anmin));

				hold = a[l[k] - 1];
				a[l[k] - 1] = flash;
				flash = hold;

				l[k]--;
				nmove++;
				// pause(j,k);
			}
		}

		return a;
	}
}
