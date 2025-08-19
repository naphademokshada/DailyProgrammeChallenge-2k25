import java.util.ArrayList;
import java.util.Collections;

public class day5 {

    public static ArrayList<Integer> findLeaders(int[] arr) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int n = arr.length;
        
        int maxFromRight = Integer.MIN_VALUE;

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                leaders.add(arr[i]);
                maxFromRight = arr[i];
            }
        }

        // Reverse the list to maintain the original order
        Collections.reverse(leaders);
        return leaders;
    }

    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        ArrayList<Integer> result = findLeaders(arr);
        System.out.println("Leaders: " + result);
    }
}
