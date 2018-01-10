package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if(amount<1) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int coin : coins) {
            for (int i = 0; i < dp.length; i++) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }



    public static void main(String[] args) {

        int coins [] = new int[]{186,419,83,408};

        System.out.println(new CoinChange().coinChange(coins, 6249));
    }
}
