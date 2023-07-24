package longest_increasing_subsequence_300;

import java.util.TreeSet;

/**
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/description/?envType=study-plan-v2&envId=top-interview-150
 * Given an integer array nums, return the length of the longest strictly increasing
 * subsequence
 * A subsequence is an array that can be derived from another array
 * by deleting some or no elements without changing the order of the remaining elements.
 */
public class LongestIncreasingSubsequence {
  public int lengthOfLIS(int[] nums) {
    TreeSet<Integer> lis = new TreeSet<>();
    for(int num:nums){
      Integer ceiling = lis.ceiling(num);
      if(ceiling != null){
        lis.remove(ceiling);
      }
      lis.add(num);
    }
    return lis.size();

  }

  public static void main(String[] args) {
    LongestIncreasingSubsequence  subsequence = new LongestIncreasingSubsequence();
    System.out.println(subsequence.lengthOfLIS(new int []{10,9,2,5,3,7,101,18}));

  }
}
