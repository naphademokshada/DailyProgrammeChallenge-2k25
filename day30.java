import java.util.*;

public class day30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of coins array
        int n = sc.nextInt();
        int[] coins = new int[n];

        // Input coin denominations
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        // Input target amount
        int amount = sc.nextInt();

        // Calculate result
        int result = coinChange(coins, amount);

        // Output result
        System.out.println(result);
    }

    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1; // Use a large value for initialization
        int[] dp = new int[amount + 1];
        
        // Fill dp array with max
        Arrays.fill(dp, max);
        dp[0] = 0; // Base case: 0 coins needed to make amount 0

        // Build the DP array
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // If dp[amount] is still max, it means amount cannot be formed
        return dp[amount] == max ? -1 : dp[amount];
    }
}
