package algorithms.binarysearch;

public class IsXaSquare {
    
    public boolean isSquare(int x) {
        int left = 0;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid*mid == x)
                return true;
            else if (mid*mid < x)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
}