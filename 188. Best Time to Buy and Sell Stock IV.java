import java.util.*;

class Solution {

    // 1) Recursion
    public int recursion(int index, int cap, int[] prices, int buy) {

        if (index == prices.length || cap == 0)
            return 0;

        if (buy == 1) {
            return Math.max(
                    recursion(index + 1, cap, prices, 0) - prices[index],
                    recursion(index + 1, cap, prices, 1)
            );
        } 
        else {
            return Math.max(
                    recursion(index + 1, cap - 1, prices, 1) + prices[index],
                    recursion(index + 1, cap, prices, 0)
            );
        }
    }



    // 2) Memoization
    int[][][] memo;

    public int memoization(int index, int cap, int[] prices, int buy) {

        if (index == prices.length || cap == 0)
            return 0;

        if (memo[index][cap][buy] != -1)
            return memo[index][cap][buy];


        if (buy == 1) {

            return memo[index][cap][buy] = Math.max(
                    memoization(index + 1, cap, prices, 0) - prices[index],
                    memoization(index + 1, cap, prices, 1)
            );

        } else {

            return memo[index][cap][buy] = Math.max(
                    memoization(index + 1, cap - 1, prices, 1) + prices[index],
                    memoization(index + 1, cap, prices, 0)
            );
        }
    }




    // 3) Tabulation without space optimization
    public int tabulation(int k, int[] prices) {

        int n = prices.length;

        int[][][] dp = new int[n + 1][k + 1][2];


        // Base case:
        // dp[n][...][...] = 0
        // dp[...][0][...] = 0


        for (int i = n - 1; i >= 0; i--) {

            for (int cap = 1; cap <= k; cap++) {


                // Buy state
                dp[i][cap][1] = Math.max(
                        dp[i + 1][cap][0] - prices[i],
                        dp[i + 1][cap][1]
                );


                // Sell state
                dp[i][cap][0] = Math.max(
                        dp[i + 1][cap - 1][1] + prices[i],
                        dp[i + 1][cap][0]
                );
            }
        }


        return dp[0][k][1];
    }





    // 4) Tabulation with space optimization
    public int tabulationOptimized(int k, int[] prices) {


        int[][] next = new int[k + 1][2];


        for (int i = prices.length - 1; i >= 0; i--) {


            int[][] curr = new int[k + 1][2];


            for (int cap = 1; cap <= k; cap++) {


                // Buy
                curr[cap][1] = Math.max(
                        next[cap][0] - prices[i],
                        next[cap][1]
                );


                // Sell
                curr[cap][0] = Math.max(
                        next[cap - 1][1] + prices[i],
                        next[cap][0]
                );
            }


            next = curr;
        }


        return next[k][1];
    }





    public int maxProfit(int k, int[] prices) {


        // 1) Recursion
        // return recursion(0, k, prices, 1);



        // 2) Memoization
        /*
        memo = new int[prices.length][k + 1][2];

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j <= k; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        return memoization(0, k, prices, 1);
        */



        // 3) Tabulation
        // return tabulation(k, prices);



        // 4) Space optimized tabulation
        return tabulationOptimized(k, prices);
    }
}
