package asked.sp;

import java.util.Arrays;
import java.util.List;

public class SortVersionNumbers {
    public static void main(String[] args) {
        SortVersionNumbers sortVersionNumbers = new SortVersionNumbers();
        sortVersionNumbers.sortVersionNumbers(Arrays.asList("0.10.1", "0.11.1", "0.20.1")).forEach(System.out::println);
    }

    public List<String> sortVersionNumbers(List<String> versionNumbers) {
        versionNumbers.sort(this::compare);
        return versionNumbers;
    }

    private int compare(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for(int i=0; i<3; i++) {
            int v1p = Integer.parseInt(v1[i]);
            int v2p = Integer.parseInt(v2[i]);
            if (v1p != v2p) {
                return Integer.compare(v1p, v2p);
            }
        }
        return 0;
    }
}
