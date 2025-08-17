public class day3 {
    public static int findDuplicate(int[] arr) {
        // Phase 1: Finding the intersection point of two runners.
        int slow = arr[0];
        int fast = arr[0];

        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        // Phase 2: Find the entrance to the cycle.
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr = {3, 1, 3, 4, 2};
        int duplicate = findDuplicate(arr);
        System.out.println("Duplicate number: " + duplicate);
    }
}
