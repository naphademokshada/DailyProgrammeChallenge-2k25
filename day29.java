import java.util.Scanner;

public class day29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input
        int n = sc.nextInt();

        // DP array to store Fibonacci numbers
        long[] dp = new long[n + 1];

        // Base cases
        dp[0] = 0;
        if (n > 0) {
            dp[1] = 1;
        }

        // Fill the array using bottom-up DP
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Output the n-th Fibonacci number
        System.out.println(dp[n]);
    }
}
