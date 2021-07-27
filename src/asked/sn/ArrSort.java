package asked.sn;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrSort {

    // Arrr1 - {2,1,2,5,7,1,9,3,6,8,8} - n
    // Arrr2 - {2,1,8,3} - no duplicates
    // res - {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8);
        performPositionBasedSorting(arr, Arrays.asList(2,1,8,3));
        System.out.println(arr.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    private static void performPositionBasedSorting(List<Integer> arr, List<Integer> ref) {
        AtomicInteger counter = new AtomicInteger();
        Function<Integer, Integer> loopCounter = x -> counter.getAndIncrement();

        Map<Integer, Integer> refMap = ref.stream().collect(Collectors.toMap(Function.identity(), loopCounter));

        arr.sort((a,b) -> compare(refMap, a, b));
    }

    private static int compare(Map<Integer, Integer> refMap, int a, int b) {
        Integer aPos = refMap.get(a);
        Integer bPos = refMap.get(b);

        if (aPos != null && bPos != null)
            return Integer.compare(aPos, bPos);
        else if (aPos != null)
            return Integer.compare(aPos, Integer.MAX_VALUE);
        else if (bPos != null)
            return Integer.compare(Integer.MAX_VALUE, bPos);
        else
            return Integer.compare(a, b);
    }
}
