package triangle_120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * 120. Triangle
 * https://leetcode.com/problems/triangle/description/?envType=study-plan-v2&envId=top-interview-150
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index
 * i on the current row, you may move to either index i or index i + 1 on the next row.
 */
public class Triangle {
  public static void main(String[] args) {
    Triangle triangle = new Triangle();
    Integer[][] ints = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
    List<List<Integer>>list = new ArrayList<>();
    for (Integer[] array : ints) {

      list.add(Arrays.asList(array));
    }
    System.out.println(triangle.minimumTotal(list));
  }

  public int minimumTotal(List<List<Integer>> triangle) {
    int size = triangle.size();
    int [][] dp = new int[size + 1][size + 1];

    for(int level = size - 1; level >= 0; level--){
      for(int i = 0; i <= level; i++){
        dp[level][i] = triangle.get(level).get(i) + Math.min(dp[level + 1][i], dp[level + 1][i + 1]);
      }
    }

    return dp[0][0];



  }

}
