package word_break_139;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 139. Word Break
 *
 * https://leetcode.com/problems/word-break/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * Given a string s and a dictionary of strings wordDict,
 * return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
public class WordBreak {
  public boolean wordBreak(String s, List<String> wordDict) {
    int length = s.length();
    boolean[]res = new boolean[length+1];
    res[length] = true;
    for(int i = length-1, j = length; i>=0 && j>=i; i--){
      String cur = s.substring(i,j);
      if(wordDict.contains(cur)){
        res[i] = res[j];
        j = i;
      }

    }
    return res[0];
  }

  public static void main(String[] args) {
    WordBreak aBreak = new WordBreak();
    System.out.println(aBreak.wordBreak("aaaaaaa", Arrays.asList("aaaa","aaa")));
  }
}
