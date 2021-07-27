package asked.sp;

import java.util.*;
import java.util.stream.Collectors;

public class SortWordsBasedOnFrequency {
    public static void main(String[] args) {
        System.out.println(String.join(", ", sortString("He'llo Hello Anil Kumar K#umar")));
    }

    private static List<String> sortString(String str) {
        if (str == null)
            return null;

        Map<String, Integer> freqs = new HashMap<>();
        List<String> result = new ArrayList<>();

        str = str.trim();

        String[] words = str.split(" ");
        for (String word : words) {
            String properWord = getProperWord(word);
            freqs.put(properWord, freqs.getOrDefault(properWord, 0) + 1);
            result.add(properWord);
        }

        result.sort((a,b) -> compare(freqs, a, b));
        return result;
    }

    private static int compare(Map<String, Integer> freqs, String a, String b) {
        int aFreq = freqs.get(a);
        int bFreq = freqs.get(b);

        if (aFreq != bFreq)
            return Integer.compare(bFreq, aFreq);

        return 1;
    }

    private static String getProperWord(String word) {
        word = word.trim();

        StringBuilder sb = new StringBuilder();

        for (char c: word.toCharArray()) {
            if (Character.isLetter(c))
                sb.append(c);
        }

        return sb.toString();
    }
}
