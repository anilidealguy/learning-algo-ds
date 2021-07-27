package asked.ms;

public class Q2 {
    // abacefmadamg
    // abbadefcefec

    public static void main(String[] args) {
        Q2 obj = new Q2();
//        System.out.println(obj.longestPalindromicSubString("abacefmadamg"));
        System.out.println(obj.longestPalindromicSubString("madam"));
    }

    public String longestPalindromicSubString(String input) {
        // abacefmadamg
        // abacefmadam bacefmadamg
        // bacefmadam abacefmada

        if (input == null)
            return null;

        if (input.length() == 1)
            return input;

        return longestPalindromicSubString(input, 0, input.length()-1);
    }

    private String longestPalindromicSubString(String input, int start, int end) {

        // m ada m

        if (start == end)
            return input.substring(start, end+1);

        if(input.charAt(start) == input.charAt(end)) {
            String res = longestPalindromicSubString(input, start + 1, end - 1);
            if(res.length() == (end - start) - 1)
                return input.substring(start, end+1);
            return res;
        }

        String leftHalf = longestPalindromicSubString(input, start, end-1);
        String rightHalf = longestPalindromicSubString(input, start+1, end);

        return leftHalf.length() <= rightHalf.length() ? rightHalf : leftHalf;
    }
}
