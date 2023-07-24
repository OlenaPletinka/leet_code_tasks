package word_pattern_290;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/word-pattern/description/

public class WordPattern {
  public static void main(String[] args) {
    System.out.println(wordPattern("aba", "dog cat dog"));

  }
  public static boolean wordPattern(String pattern, String s) {
    String[]strs = s.split(" ");
    if(pattern.length()!=strs.length){
      return false;
    }
    Map<String, Character> map = new HashMap<>();
    int[]pat = new int[26];
    for(int i = 0; i<pattern.length(); i++){

      char charAt = pattern.charAt(i);
      int possition = charAt - 'a';
      if (pat[possition] == 0 && !map.containsKey(strs[i])){
        pat[possition]++;
        map.put(strs[i], charAt);
      }else if(!map.containsKey(strs[i]) || map.get(strs[i])!=charAt){
        return false;
      }
    }
    return true;

  }
}
