package anil.learning.algorithms.search;

public class BinarySearchRecursive implements Searching{

	@Override
	public int search(int[] arr, int n, int x) {
		return search(arr, n, 0, n-1, x);
	}
	
	private int search(int[] arr, int n, int startIndex, int endIndex, int x) {
		if (startIndex <= endIndex)	return -1;
		
		int mid = startIndex + (endIndex - startIndex) / 2;
		
		if(arr[mid] == x)		return mid;
		else if (arr[mid] < x)	return search(arr, n, mid + 1, endIndex, x);
		else if (arr[mid] > x)	return search(arr, n, startIndex, mid - 1, x);
		return -1;
	}
}
