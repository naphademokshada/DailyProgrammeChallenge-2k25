import java.util.*;

public class day15 {
    public static int lengthOfLongestSubstring(String s) {
        // HashSet to store unique characters in the current window
        Set<Character> set = new HashSet<>();
        
        int left = 0, maxLength = 0;
        
        // Right pointer moves through the string
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            
            // If duplicate found, shrink window from the left
            while (set.contains(current)) {
                set.remove(s.charAt(left));
                left++;
            }
            
            // Add current character to the window
            set.add(current);
            
            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Input: " + s);
        int result = lengthOfLongestSubstring(s);
        System.out.println("Output: " + result);
    }
}
