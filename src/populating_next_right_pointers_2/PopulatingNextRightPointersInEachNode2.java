package populating_next_right_pointers_2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 117. Populating Next Right Pointers in Each Node II
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 */
public class PopulatingNextRightPointersInEachNode2 {
  static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  };

  // Level order traversal
  // BFS

  public Node connect(Node root) {
    if(root == null){
      return root;
    }
    Queue<Node> q = new LinkedList<>();
    q.offer(root);
    Node curr = null;
    Node prev = null;
    while(!q.isEmpty()){

      int size = q.size();
      prev = q.poll();
      if(prev.left != null){
        q.add(prev.left);
      }
      if(prev.right != null){
        q.add(prev.right);
      }
      for(int i = 1; i <size; i++){
        curr = q.poll();
        Node left = curr.left;
        if(left != null){
          q.add(curr.left);
        }

        Node right = curr.right;
        if(right != null){
          q.add(curr.right);
        }
        prev.next = curr;
        prev = curr;
      }
    }

    return root;


  }

  public static void main(String[] args) {
    Node root = new Node(1, new Node(2, new Node(4), new Node(5), null), new Node(3, null, new Node(7), null), null);
    PopulatingNextRightPointersInEachNode2 pointers = new PopulatingNextRightPointersInEachNode2();
    Node result = pointers.connect(root);
    System.out.println(result);
  }
}
