package course_schedule_2_210;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 210. Course Schedule II
 * https://leetcode.com/problems/course-schedule-ii/description/?envType=study-plan-v2&envId=top-interview-150
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an
 * array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if
 * you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers,
 * return any of them. If it is impossible to finish all courses, return an empty array.
 */
public class CourseScheduleII {
  // Topological sort
  // posibble only if graph is DAG - directed ancycling graph
  // dfs
  // time - O(n + m) - vertices + edges
  // space - O(n+m)
  List<List<Integer>> graph = new ArrayList<>();
  Stack<Integer> sortReverse =  new Stack<>();

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    int [] result = new int[numCourses];
    // build graph
    for(int i = 0; i < numCourses; i++){
      graph.add(new ArrayList<>());
    }
    for(int[]ar:prerequisites){
      graph.get(ar[1]).add(ar[0]);
    }

    // dfs
    boolean[] inStack = new boolean[numCourses];
    boolean[] isVisited = new boolean[numCourses];

    Stack<Integer> s = new Stack<>();
    for(int i = 0; i < numCourses; i++){
      if(dfs(i, inStack, isVisited, s)){
        return new int[0];
      }
    }
    // reverse values from stack
    int size = s.size();
    for(int i = 0; i<size; i++){
      result[i] = s.pop();
    }
    return result;
  }

  private boolean dfs(int n, boolean[] inStack, boolean[] isVisited, Stack<Integer> s){
    if(inStack[n]){
      return true;
    }
    if(isVisited[n]){
      return false;
    }
    inStack[n] = true;
    isVisited[n] = true;

    for(int node : graph.get(n)){
      if(dfs(node, inStack, isVisited, s)){
        return true;
      }
    }
    inStack[n] = false;
    s.add(n);

    return false;
  }

  public static void main(String[] args) {
    CourseScheduleII scheduleII = new CourseScheduleII();
    int[] order = scheduleII.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
    System.out.println(order);

  }
}