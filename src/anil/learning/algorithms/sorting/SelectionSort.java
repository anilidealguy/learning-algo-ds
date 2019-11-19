package anil.learning.algorithms.sorting;

public class SelectionSort implements Sorting {

	@Override
	public int[] sort(int[] arr, int n) {
		
		for (int i=0; i<n; i++) {
			int minVal = arr[i];
			int minIndex = i;
			for (int j=minIndex+1; i<n; j++) {
				if (arr[j] < minVal) {
					minIndex = j;
					minVal = arr[j];
				}
			}
			swap(arr, i, minIndex);
		}
		return arr;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	

}
