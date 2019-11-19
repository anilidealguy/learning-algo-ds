package anil.learning.algorithms.sorting;

public class BubbleSort implements Sorting {

	@Override
	public int[] sort(int[] arr, int n) {
		if (n <= 1) return arr;
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[j] < arr[j-1])	
					swap(arr, j-1, j);
			}
		}
		
		return arr;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
