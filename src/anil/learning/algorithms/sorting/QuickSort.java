package anil.learning.algorithms.sorting;

public class QuickSort implements Sorting {

	@Override
	public int[] sort(int[] arr, int n) {
		sort(arr, n, 0, n-1);
		return arr;
	}
	
	private void sort(int[] arr, int n, int startIndex, int endIndex) {
		if (startIndex > endIndex)	return;
		
		int p = partition(arr, n, 0, n-1);
		sort(arr, n, 0, p);
		sort(arr, n, p+1, endIndex);
	}
	
	private int partition(int[] arr, int n, int startIndex, int endIndex) {
		int e = arr[n-1];
		int i = startIndex - 1;
		
		for (int j=startIndex; j <= endIndex; j++) {
			if (arr[j] <= e) {
				i++;
				swap(arr, i, j);
			}
		}
		
		swap(arr, i+1, endIndex);
		return i+1;
	}
	
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
