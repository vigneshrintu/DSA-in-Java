/*

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int result = coinChangeHelper(coins, amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int coinChangeHelper(int[] coins, int amount) {
        Base case: if amount is 0, no coins are needed
        if (amount == 0) {
            return 0;
        }
        Base case: if amount is negative, it's not possible to form the amount so return INTMAX
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        Initialize minCoins to a large value as it is always initialised while going into the stacks but for the first backtracking when base case hits and flow moves to upper stack there also minCoins is INTMAX but from there minCoins will be changing to the min of minCoins returned by the below stacks.
        And then this repeats till to the top.
        int minCoins = Integer.MAX_VALUE;
        Call the recursive function for each coin on the amount and store the minCoins for making amount
        for (int coin : coins) {
            int result = coinChangeHelper(coins, amount - coin);
            if (result != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, result + 1);
            }
        }
        This returned minCoins will be sent to the above stack's result variable and processed to find the min among all the results given by the below stack frames.
        return minCoins;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(solution.coinChange(coins, amount)); // Output: 3 (11 = 5 + 5 + 1)
    }
}



*/



/*




import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        Create a memoization map to store results of subproblems rather than the array since we use index as the amount and value in the index is the minCoins to make that amount.
        Map<Integer, Integer> memo = new HashMap<>();
        
        int result = coinChangeHelper(coins, amount, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int coinChangeHelper(int[] coins, int amount, Map<Integer, Integer> memo) {
        
        if (amount == 0) {
            return 0;
        }
        
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        Check if the result for the current amount is already in the memo
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        
        int minCoins = Integer.MAX_VALUE;
        
        for (int coin : coins) {
            int result = coinChangeHelper(coins, amount - coin, memo);
            if (result != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, result + 1);
            }
        }
        Store the result in the memo before returning
        memo.put(amount, minCoins);
        minCoins var in the top first stack will hold the minCoins required to make the first passed amount and this is returned directly to the leetcode when program comes from top to bottom and backtracks to top.
        return minCoins;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(solution.coinChange(coins, amount)); // Output: 3 (11 = 5 + 5 + 1)
    }
}







*/

//BACK TO BACK SWE MADE A VIDEO HELPS BUT ASK SIR HOW CAN WE COMEUP WITH THIS KIND OF DP APPROACH

public class CoinChangeMin {
    public int coinChange(int[] coins, int amount) {
        // Create a DP array to store the minimum number of coins for each amount
        int[] dp = new int[amount + 1];
        // Initialize the DP array with a large value (infinity) except for dp[0]
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        // Fill the DP array
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // Return the result for the target amount
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    
}
