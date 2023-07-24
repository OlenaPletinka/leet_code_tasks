package isomorphic_string_205;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/isomorphic-strings/description/?envType=study-plan-v2&envId=top-interview-150
 * 205. Isomorphic Strings
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving
 * the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 */
public class IsomorphicStrings {
  // character mapping with dictionary
  // time - O(n)
  // space - O(1)
  public boolean isIsomorphic(String s, String t) {
    int[]convertStoT = new int[256];
    Arrays.fill(convertStoT, -1);

    int []convertTtoS = new int[256];
    Arrays.fill(convertTtoS, -1);

    for(int i = 0; i<s.length(); i++){
      char c1 = s.charAt(i);
      char c2 = t.charAt(i);
      if(convertStoT[c1] == -1 && convertTtoS[c2] == -1){
        convertStoT[c1] = c2;
        convertTtoS[c2] = c1;
      } else if (convertStoT[c1] != c2 && convertTtoS[c2] != c1) {
        return false;

      }

    }
    return true;
  }

  public static void main(String[] args) {
    IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
    System.out.println(isomorphicStrings.isIsomorphic("paper", "totio"));

    int []nums = new int[]{1,2,0,1};
    Arrays.sort(nums);
    int result = 1;
    int count = 1;
    for(int i = 0; i<nums.length-1; i++){
      if(nums[i] +1 == nums[i+1]){
        count++;
      }else if(nums[i]+1 != nums[i+1]&&nums[i]-1 != nums[i-1]){
        result = Math.max(result, count);
        count = 1;
      }
      result = Math.max(result, count);

    }
    System.out.println(result);
  }
}
