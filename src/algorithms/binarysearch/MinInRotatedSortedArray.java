package algorithms.binarysearch;

public class MinInRotatedSortedArray {
    class Solution {
        public int findMin(int[] nums) {
            int start = 0;
            int end = nums.length - 1;

            while (start < end) {
                int mid = start + (end - start) / 2;

                if (nums[mid] > nums[end]) // Minimum must be in A[mid + 1, end]
                    start = mid + 1;
                else if (nums[mid] < nums[end]) // Minimum must be in A[start, mid]
                    end = mid;
                else // if(A[mid] == A[end]) // Skip duplicates
                    end--;
            }
            return nums[start]; // Loop ends when start == end
        }
    }
}