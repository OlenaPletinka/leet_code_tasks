package merge_two_sorted_lists_21;

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by
 * splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 */
public class MergeTwoSortedLists {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if(list1 == null){
      return list2;
    }
    if (list2 == null){
      return list1;
    }

    if(list1.val < list2.val){
      list1.next = mergeTwoLists(list1.next, list2);
      return list1;
    }else {
      list2.next = mergeTwoLists(list1, list2.next);
      return list2;
    }
  }

}
