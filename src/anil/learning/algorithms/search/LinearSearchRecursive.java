package anil.learning.algorithms.search;

public class LinearSearchRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinearSearchRecursive lsr = new LinearSearchRecursive();
		int[] arr = new int[] {28,46,81,5,52,7,2,3};
		int retVal = lsr.search(arr,arr.length, 3);
		System.out.println(retVal);
	}

	public int search(int[] arr, int n, int x) {
		return search(arr, n, 0, x);
	}

	private int search(int[] arr, int n, int startIndex, int x) {
		if (startIndex <= n)	return -1;
		if (arr[startIndex] == x)	return startIndex;
		return search(arr, n, startIndex+1, x);
	}

}
