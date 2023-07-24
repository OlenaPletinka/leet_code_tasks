package kth_smallest_element_in_bst_230;

import populating_next_right_pointers_2.PopulatingNextRightPointersInEachNode2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 230. Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/?envType=study-plan-v2&envId=top-interview-150
 *
 * Given the root of a binary search tree, and an integer k,
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
public class KthSmallestElementInBST {
   static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
     public TreeNode(int val) { this.val = val; }
     public  TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
         this.left = left;
         this.right = right;
     }
 }
  List<Integer> list = new LinkedList<>();
  public int kthSmallest(TreeNode root, int k) {
    if(k<=0){
      return root.val;
    }
    getMin(root, k);
    return list.get(k-1);
  }

  private void getMin(TreeNode root, int k) {
    if(root == null || k == 0){
      return;
    }

    getMin(root.left, k);
    list.add(root.val);
    k--;

    getMin(root.right, k);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
    KthSmallestElementInBST bst = new KthSmallestElementInBST();
    int i = bst.kthSmallest(root, 2);
    System.out.println(i);

  }
}
