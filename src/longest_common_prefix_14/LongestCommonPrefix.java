package longest_common_prefix_14;

/**
 * 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 */

public class LongestCommonPrefix {
//  Horizontal scanning
// Time complexity - O(sum of all characters in th array)
//  Space complexity - O(1)
  public String longestCommonPrefixHorizontalScanning(String[] strs) {
    int length = strs.length;
    if (length == 0){
      return "";
    }
      String prefix = strs[0];
    for(int i = 1; i < length; i++){
      while (strs[i].indexOf(prefix) != 0){
        prefix = prefix.substring(0, prefix.length() - 1);
        if (prefix.isEmpty()){
          return "";
        }
      }
    }
    return prefix;

  }

//  Vertical scanning
// Time complexity - O(sum of all characters in th array)
//  Space complexity - O(1)
  public String longestCommonPrefixVerticalScanning(String[] strs) {
    if(strs == null || strs.length == 0){
      return "";
    }
    for (int i = 0; i < strs[0].length(); i++) {
      char ch = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (i >= strs[j].length() || ch != strs[j].charAt(i)){
          return strs[0].substring(0, i);
        }

      }
    }
    return strs[0];


  }

  public String findLongest(String[]strs){
    String result=strs[0];
    for (int i=1;i<strs.length;i++){
      while(strs[i].indexOf(result)!=0){
        result=result.substring(0,result.length()-1);
        if (result.isEmpty()){
          return "";
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    LongestCommonPrefix l  = new LongestCommonPrefix();
    System.out.println(l.findLongest(new String[]{"flower", "flowflower", "flightflower"}));
    System.out.println(l.longestCommonPrefixVerticalScanning(new String[]{"flower", "flowflower", "flightflower"}));
    System.out.println("   bbnn    k    as    ".trim());
  }
}
