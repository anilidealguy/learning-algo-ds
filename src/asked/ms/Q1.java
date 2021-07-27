package asked.ms;

import java.util.List;
import java.util.stream.Collectors;

public class Q1 {
    // {1,2,2,2,2,5,6,6}

    /*
    * {1,2,2,2,2,5,6,6}
    *
    * 1,2,2,2,2
    * 1,2,2
    * 2,2
    *
    *
    * */

    public int[] search(int[] arr, int target) {
        if (null == arr || arr.length == 0)
            return new int[]{-1,-1};

        int high = arr.length-1;
        int low = 0;

        int firstOccurrance = -1;
        int lastOccurrance = -1;

        int mid = -1;

        while (low < high) {
            mid = low + ((high - low)/2);
            if((mid == 0 && arr[mid] == target)
                    || (arr[mid] == target && mid-1 >=0 && arr[mid-1] < arr[mid])
            ) {
                firstOccurrance = mid;
                break;
            }

            if (arr[mid] < target)
                low = mid+1;
            else
                high = mid - 1;
        }

        if (mid != -1 && arr[mid] == target) {

        }

        return new int[]{-1,-1};
    }




    // List of strings - captailze first character in every string and return
    public List<String> captalize(List<String> strings) {
        return strings.stream().map(this::transform).collect(Collectors.toList());
    }

    private String transform(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(input.charAt(0)))
                .append(input.substring(1));
        return sb.toString();
    }

    /*
    *
    * */





}
