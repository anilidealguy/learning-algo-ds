package anil.learning.algorithms.sorting;

public class InsertionSort implements Sorting {

	@Override
	public int[] sort(int[] arr, int n) {
		if (n < 1) return arr;
		
		for (int i=1; i<n; i++) {
			for (int j=i; j>0; j--) {
				if(arr[j] < arr[j-1])
					swap(arr, j, j-1);
			}
		}
		return arr;
	}

	private void swap(int[] arr, int source, int dest) {
		int temp = arr[dest];
		arr[dest] = arr [source];
		arr[source] = temp;
	}
	
	public static void main(String[] args) {
		Sorting s = new InsertionSort();
		int[] arr = new int[] {12, 11, 13, 5, 6 };
		arr = s.sort(arr, arr.length);
		for (int i : arr) {
			System.out.println(i);
		}
	}

}
