package three_sum_15;
// https://leetcode.com/problems/3sum/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.*;

/**
 * 15. 3Sum
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum {

  public static void main(String[] args) {
    ThreeSum threeSum = new ThreeSum();

    List<List<Integer>> lists = threeSum.threeSum(new int[]{-1, -3, 0, -5, 2, 4, 1, 3});
    System.out.println(lists.toString());
  }
  // time - O(n^2 log n)
  // space - O(n)
  public List<List<Integer>> threeSum(int[] nums) {
    int length = nums.length;
    Arrays.sort(nums);
    int sum = 0;
    int j = 0;
    int k = 0;
    Set<List<Integer>> set = new HashSet<>();
    for(int i = 0; i<length;i++){
      k = length - 1;
      j = i+1;
      while(k>j){
        sum = nums[i] + nums[j] + nums[k];
        if(sum == 0){
          set.add(Arrays.asList(nums[i], nums[j], nums[k]));
          j++;
          k--;
        }else if(sum>0){
          k--;
        }else{
          j++;
        }
      }
    }
    List<List<Integer>> result =  new ArrayList<>();
    result.addAll(set);
    return  result;
  }
}
