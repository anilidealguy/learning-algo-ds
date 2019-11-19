package anil.learning.algorithms.search;

public class LinearSearchIterative implements Searching{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinearSearchIterative lsi = new LinearSearchIterative();
		int[] arr = new int[] {12,5,67,23,74,5};
		int retVal = lsi.search(arr, arr.length, 5);
		System.out.println(retVal);
	}
	
	@Override
	public int search(int[] arr, int n, int x) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x) {
				return i;
			}
		}
		
		return -1;
	}

}
