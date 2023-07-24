package find_the_index_of_the_first_occurrence_in_a_string_28;

/**
 * 28. Find the Index of the First Occurrence in a String
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 *
 * Given two strings needle and haystack, return the index of the first
 * occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 *
 *
 * Example 1:
 *
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * Example 2:
 *
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 *
 *
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {
//  brute forse
//   * space - O(1)
// * time - O(mn)
  public int strStr(String haystack, String needle) {
    int m = needle.length();
    int n = haystack.length();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (haystack.charAt(i) != needle.charAt(j)){
          break;
        }
        i++;
        if(j == m-1){
          return i - m;
        }
      }
    }

    return -1;
  }

//  Knuth–Morris–Pratt Algorithm
//  time - O(n)
//  space - O(m)
  public int strStrKnuthMorrisPratt(String haystack, String needle) {
    int m = needle.length();
    int n = haystack.length();

    int[]arr = new int[m];
    int startWindow = 0;
    int pointer = 1;
    while(pointer<m){
      if (needle.charAt(startWindow) == needle.charAt(pointer)){
        startWindow++;
        arr[pointer] = startWindow;
        pointer++;
      }else{
        if (startWindow == 0){
          arr[pointer] = 0;
          pointer++;
        }else {
          startWindow = arr[startWindow-1];
        }
      }
    }

    int needlePointer = 0;
    int stackPointer = 0;
    while (stackPointer<n){
      if (haystack.charAt(stackPointer)==needle.charAt(needlePointer)){
        needlePointer++;
        stackPointer++;
        if (needlePointer == m){
          return stackPointer - m;
        }
      }else{
        if (needlePointer==0){
          stackPointer++;
        }else {
          needlePointer = arr[needlePointer-1];
        }

      }
    }
    return -1;

  }

  // Khnut-Morris-Pratt
  // time - O(n)
  // space - O(m)
  public int strStr2(String haystack, String needle) {
    int m = needle.length();
    int n = haystack.length();

    if(m>n){
      return -1;
    }

    // preprocess needle and find reapitable parts
    int[]lps = new int[m];
    int start = 0;

    for(int i = 1; i < m; i++){
      if(needle.charAt(start) ==needle.charAt(i)){
        start++;
        lps[i] = start;

      } else if(start !=0){
        start = lps[start-1];
        i--;

      }

    }

    int needlePointer = 0;
    int stackPointer = 0;
    while(stackPointer<n){
      if(needle.charAt(needlePointer) == haystack.charAt(stackPointer)){
        stackPointer++;
        needlePointer++;
        if(needlePointer == m){
          return stackPointer - m;
        }
      }else if(needlePointer == 0){
        stackPointer++;
      }else{
        needlePointer = lps[needlePointer-1];
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    FindTheIndexOfTheFirstOccurrenceInAString f = new FindTheIndexOfTheFirstOccurrenceInAString();
    System.out.println(f.strStr2("aabaaabaaac","aabaaac"));
  }
}
