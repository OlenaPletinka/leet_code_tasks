package coin_change_322;

import java.util.Arrays;

/**
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
  int[]dp;
  public int coinChange(int[] coins, int amount) {

    if(amount == 0){
      return 0;
    }

    int[]dp = new int[amount+1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for(int i = 1; i<=amount; i++){
      for(int cur : coins){
        if(i-cur >=0&& dp[i-cur] != Integer.MAX_VALUE){
          dp[i] = Math.min(dp[i], dp[i-cur]+1);
        }

      }
    }
    return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
  }

  public static void main(String[] args) {
    CoinChange change = new CoinChange();
    System.out.println(change.coinChange(new int[]{2}, 3));
  }
}
