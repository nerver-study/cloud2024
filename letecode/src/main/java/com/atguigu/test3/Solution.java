package com.atguigu.test3;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{ 1 , 2 , 3 , 4 , 5}));
    }
    public int maxProfit(int[] prices) {
        int dp [][]=new int[3][prices.length+1];



        return 0;
    }























    public int maxProfit2(int[] prices) {
        int[][] dp = new int[3][prices.length];
        //k是交易的次数，从1开始，如果是0表示没有交易，这个不需要计算
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j < prices.length; j++) {
                //k我理解表示的是第几天买入,k=0的话就说明没有买入
                for (int k = j - 1; k >= 0; k--) {
                    int max = 0;
                    if (k == 0) {
                        //递推公式的边界条件判断，k等于0表示在第一天买入，第j天卖出，这种情况下我们最多
                        //进行一次股票交易，所以不需要dp[i - 1][k - 1]。
                        max = Math.max(dp[i][j - 1], prices[j] - prices[k]);
                    } else {
                        //递推公式
                        //要么第j天不进行任何操作，要么第j天卖出一支股票。如果卖出股票我们需要找到卖出
                        //股票的最大利润（注意这里k不一定是买入股票最低价的那天，这里的最大利润还需要
                        //包含前面交易的利润，所以是prices[j] - prices[k] + dp[i - 1][k - 1]）
                        max = Math.max(dp[i][j - 1], prices[j] - prices[k] + dp[i - 1][k - 1]);
                    }
                    dp[i][j] = Math.max(dp[i][j], max);
                }
            }
        }
        return dp[2][prices.length - 1];
    }
}