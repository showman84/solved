package com.company.Misc;

import java.util.Arrays;

public class CountingStairs {

    public int climbStairs(int n) {

        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int result = 0;
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp [i - 1] + dp[ i - 2];
        }

        return dp[n];
    }


    public static void main(String[] args) {

        System.out.println(new CountingStairs().climbStairs(4));
    }
}
