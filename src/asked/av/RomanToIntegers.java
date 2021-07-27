package asked.av;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RomanToIntegers {
    private static Map<Character, Integer> map = new HashMap<>();

    static  {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);

    }
    public static void main(String[] args) {
        String[] romans = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L"};
        Arrays.stream(romans).map(RomanToIntegers::romanToInteger).forEach(System.out::println);
    }

    public static int romanToInteger(String roman) {
        int res = 0;

        if (roman.length() == 1)
            return map.get(roman.charAt(0));

        boolean usedCurrent = false;
        for (int i = 1; i < roman.length(); ) {
            int curr = map.get(roman.charAt(i));
            int prev = map.get(roman.charAt(i-1));

            if (curr > prev) {
                res = res + (curr - prev);
                i += 2;
                usedCurrent = true;
            } else {
                res = res + prev;
                i++;
                usedCurrent = false;
            }
        }

        if (!usedCurrent)
            res = res +  map.get(roman.charAt(roman.length() - 1));

        return res;
    }
}
