package anil.learning.algorithms.sorting;


/*
 * Counting sort will be good in the cases where the range of the elements in the given array is known.
 * For simplicity purpose I am taking the elements are ranging from 0 - 1000.
 * */
public class CountingSort implements Sorting {

	@Override
	public int[] sort(int[] arr, int n) {
		//Initialize an array of size of the given range.
		int[] counts = new int[1000];
		
		for (int i=0; i<counts.length; i++)
			counts[i] = 0;
		
		for (int i : arr) {
			counts[i]++;
		}
		
		
		for(int i=0; i<n; i++) {
			int val = i;
			for (int c=0; c<counts[val]; c++, i++) {
				arr[i] = val;
			}
		}
		return arr;
	}

}
