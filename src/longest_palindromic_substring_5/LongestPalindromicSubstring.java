package longest_palindromic_substring_5;

/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * Given a string s, return the longest
 * palindromic
 *
 * substring
 *  in s.
 */
public class LongestPalindromicSubstring {
  // time - O(n^2)
  // space - O(1)
  public String longestPalindrome(String s) {
    String res = "";
    int resLen = 0;
    int len = s.length();
    int left;
    int right;
    for(int i  = 0; i < len; i++){
//cover odd cases
      left = i;
      right = i;
      while(left>=0 && right<len && s.charAt(left)==s.charAt(right)){
        if(right-left+1>resLen){
          res = s.substring(left, right+1);
          resLen = right-left+1;
        }
        left--;
        right++;
      }
//      cover even cases
      left = i;
      right = i+1;
      while(left>=0 && right<len && s.charAt(left)==s.charAt(right)){
        if(right-left+1>resLen){
          res = s.substring(left, right+1);
          resLen = right-left+1;
        }
        left--;
        right++;
      }
    }

    return res;
  }
  public static void main(String[] args) {
    LongestPalindromicSubstring substring = new LongestPalindromicSubstring();
    System.out.println(substring.longestPalindrome("baa"));
  }
}
