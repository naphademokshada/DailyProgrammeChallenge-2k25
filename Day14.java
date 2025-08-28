import java.util.*;

public class Day14 {
    
    private static int atMostK(String s, int k) {
        int n = s.length();
        Map<Character, Integer> freq = new HashMap<>();
        int left = 0, result = 0;

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                left++;
            }
            
            result += (right - left + 1);
        }
        return result;
    }

    public static int substringsWithKDistinct(String s, int k) {
        return atMostK(s, k) - atMostK(s, k - 1);
    }

    public static void main(String[] args) {
        String s = "pqpqs";
        int k = 2;
        System.out.println(substringsWithKDistinct(s, k));
    }
}
