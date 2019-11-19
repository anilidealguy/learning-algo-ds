package anil.learning.algorithms.search;

public class BinarySearchIterative implements Searching{

	public static void main(String[] args) {
		BinarySearchIterative bsi = new BinarySearchIterative();
		int[] arr = new int[] {2, 3, 4, 10, 40};
		int retVal = bsi.search(arr, arr.length,4);
		System.out.println(retVal);
	}
	
	@Override
	public int search(int[] arr, int n, int x) {
		int start = 0;
		int end = n - 1;
		
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] == x)	return mid;
			if (arr[mid] < x)	start = mid + 1;
			else	end = mid -1;
		}
		
		return -1;
	}

}
