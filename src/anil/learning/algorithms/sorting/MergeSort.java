package anil.learning.algorithms.sorting;

public class MergeSort implements Sorting {

	@Override
	public int[] sort(int[] arr, int n) {
		sort(arr, 0, n-1);
		return arr;
	}
	
	private void sort(int[] arr, int startIndex, int endIndex) {
		if (startIndex >= endIndex)	return;
		
		int mid = startIndex + (endIndex - startIndex) / 2;
		sort(arr, startIndex, mid);
		sort(arr, mid + 1, endIndex);
		merge(arr, startIndex, mid, endIndex);
	}
	
	private void merge(int[] arr, int left, int mid, int right) {
		int m = mid - left + 1;	//left array size
		int n = right - mid;	//right array size
		
		int[] leftArray = new int[m];
		int[] rightArray = new int[n];
		
		//copy first half into a temporary array called left
		for (int i=0; i<m; i++) 
			leftArray[i] = arr[left+i];
		
		//copy first half into a temporary array called right
		for (int i=0; i<n; i++) 
			rightArray[i] = arr[mid + 1 + i];
		
		
		int l = 0; //First array iterator
		int r = 0; //Second array iterator
		int ma = left; //Merged array iterator
		
		while (l < m && r < n) {
			if (leftArray[l] <= rightArray[r]) {
				arr[ma] = leftArray[l];
				l++;
			} else {
				arr[ma] = rightArray[r];
				r++;
			}
			ma++;
		}
		
		while (l < m) {
			arr[ma] = leftArray[l];
			l++;
			ma++;
		}
		
		while (r < n) {
			arr[ma] = rightArray[r];
			r++;
			ma++;
		}
		
	}
	
	private int[] merge(int[] arr1, int[] arr2, int m, int n) {
		int[] mergedArray = new int[m+n];
		
		int a1 = 0; //First array iterator
		int a2 = 0; //Second array iterator
		int ma = 0; //Merged array iterator
		
		while (a1 < m && a2 < n) {
			if (arr1[a1] <= arr2[a2]) {
				mergedArray[ma] = arr1[a1];
				a1++;
			} else {
				mergedArray[ma] = arr2[a2];
				a2++;
			}
			ma++;
		}
		
		while (a1 < m) {
			mergedArray[ma] = arr1[a1];
			a1++;
			ma++;
		}
		
		while (a2 < n) {
			mergedArray[ma] = arr2[a2];
			a2++;
			ma++;
		}
		return mergedArray;
	}

}
