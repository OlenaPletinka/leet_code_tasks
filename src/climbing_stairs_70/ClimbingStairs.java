package climbing_stairs_70;

/**
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/description/
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
  public int climbStairs(int n) {
    int step1 = 1;
    int step2 = 2;
    if(n==1){
      return step1;
    }
    if(n==2){
      return step2;
    }
    int result = 0;
    for (int i = 3; i <= n; i++) {
      result = step1 + step2;
      step1 = step2;
      step2 = result;

    }
    return result;
  }
}
