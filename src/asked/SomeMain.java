package asked;

import java.util.HashMap;
import java.util.Map;

public class SomeMain {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("abc", 1);
        map.put("abc", 2);
        String s = "abc";
        s.intern();
        map.put(new String("abc"), 3);
        System.out.println(map.size());
        System.out.println(map.get("abc"));
    }
}
