import climbing_stairs_70.ClimbingStairs;
import merge_sorted_array_88.MergeSortedArray;

public class Main {
  public static void main(String[] args) {

//  * 14. Longest Common Prefix
//    LongestCommonPrefix prefix = new LongestCommonPrefix();
//    String result = prefix.longestCommonPrefixHorizontalScanning(new String[]{"flower", "flow", "flight"});
//    String result2 = prefix.longestCommonPrefixVerticalScanning(new String[]{"flower", "flow", "flight"});
//    System.out.println(result2);

//     * 20. Valid Parentheses
//    ValidParentheses parentheses = new ValidParentheses();
//    boolean valid = parentheses.isValid("()");
//    System.out.println(valid);

//     * 21. Merge Two Sorted Lists
//    ListNode l1 = new ListNode(5, new ListNode(7, new ListNode(10, new ListNode(12))));
//    ListNode l2 = new ListNode(3, new ListNode(4, new ListNode(8, new ListNode(11, new ListNode(19)))));
//    MergeTwoSortedLists sortedLists = new MergeTwoSortedLists();
//    ListNode result = sortedLists.mergeTwoLists(l1, l2);
//    while (result != null) {
//      System.out.println(result.val);
//      result = result.next;
//    }

//     * 26. Remove Duplicates from Sorted Array
//    RemoveDuplicatesFromSortedArray duplicates = new RemoveDuplicatesFromSortedArray();
//    int result = duplicates.removeDuplicates(new int[]{1, 2, 2, 3, 4, 4, 4, 4, 5});
//    System.out.println(result);

//     * 28. Find the Index of the First Occurrence in a String
//    FindTheIndexOfTheFirstOccurrenceInAString index = new FindTheIndexOfTheFirstOccurrenceInAString();
//    System.out.println(index.strStrKnuthMorrisPratt("sadbutsad", "sad"));
//    System.out.println(index.strStrKnuthMorrisPratt("leetcode", "leeto"));
//    System.out.println(index.strStrKnuthMorrisPratt("leetcode", "code"));

//     * 69. Sqrt(x)
//    Sqrt sqrt = new Sqrt();
//    System.out.println(sqrt.mySqrt(81));

//     * 70. Climbing Stairs
//    ClimbingStairs climbingStairs = new ClimbingStairs();
//    System.out.println(climbingStairs.climbStairs(5));

//     * 88. Merge Sorted Array
    MergeSortedArray mergeSortedArray = new MergeSortedArray();
//    int[] merge = mergeSortedArray.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    int[] merge = mergeSortedArray.merge(new int[]{0}, 0, new int[]{1}, 1);
    System.out.println(merge);

    System.out.println("done");


  }




}